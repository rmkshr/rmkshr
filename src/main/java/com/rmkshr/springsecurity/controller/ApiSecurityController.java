package com.rmkshr.springsecurity.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmkshr.springsecurity.domain.ApiUser;
import com.rmkshr.springsecurity.domain.Role;
import com.rmkshr.springsecurity.service.UserService;
import com.rmkshr.springsecurity.utils.Constants;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


/**
 * API Spring Security Module Controller class.
 *
 * @author ramkishore
 */
@RestController
@RequestMapping("/apiv3")
@RequiredArgsConstructor
public class ApiSecurityController {

    private final UserService userService;

    /**
     * Get all user api.
     *
     * @return Response ok with all users.
     */
    @GetMapping("/getuser")
    public ResponseEntity getUser() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    /**
     * Save user api.
     *
     * @param user
     * @return save user response, with user data.
     */
    @PostMapping("/user/save")
    public ResponseEntity<ApiUser> saveUser(@RequestBody ApiUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    /**
     * Save role api.
     *
     * @param role
     * @return save role response, with role data.
     */
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    /**
     * Assign a role to a user.
     *
     * @param roleToUserform
     * @return response ok.
     */
    @PostMapping("/save/role/to/user")
    public ResponseEntity<?> saveRoleToUser(@RequestBody RoleToUserForm roleToUserform) {
        userService.addRoleToApiUser(roleToUserform.getUserName(), roleToUserform.getRoleName());
        return ResponseEntity.ok().build();
    }

    /**
     * Api to generate access token using the refresh token and return both.
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/refreshtoken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        if(authorizationHeader != null && authorizationHeader.startsWith(Constants.KEY_SPACE)){
        if (authorizationHeader != null) {
            try {
//                String refresh_token = authorizationHeader.substring(Constants.KEY_SPACE.length());
                String refresh_token = authorizationHeader;
                Algorithm algorithm = Algorithm.HMAC256(Constants.SECRET.getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
                String userName = decodedJWT.getSubject();
                ApiUser apiUser = userService.getUser(userName);
                String access_token = JWT.create()
                        .withSubject(apiUser.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim(Constants.ROLES, apiUser.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokenMap = new HashMap<>();
                tokenMap.put(Constants.ACCESS_TOKEN, access_token);
                tokenMap.put(Constants.REFRESH_TOKEN, refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokenMap);
            } catch (Exception exception) {
                response.setHeader(Constants.ERROR, exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put(Constants.ERROR_MESSAGE, exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException(Constants.TOKEN_MISSING_EXCEPTION);
        }
    }

}

@Data
class RoleToUserForm {
    private String userName;
    private String roleName;
}
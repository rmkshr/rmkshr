package com.spring.security.apisecurity.api;

import com.spring.security.apisecurity.domain.ApiUser;
import com.spring.security.apisecurity.domain.Role;
import com.spring.security.apisecurity.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/apiv3")
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @GetMapping("/getuser")
    public ResponseEntity getUser() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<ApiUser> saveUser(@RequestBody ApiUser user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/save/role/to/user")
    public ResponseEntity<?> saveRoleToUser(@RequestBody RoleToUserform roleToUserform) {
        userService.addRoleToApiUser(roleToUserform.getUserName(), roleToUserform.getRoleName());
        return ResponseEntity.ok().build();
    }

}
@Data
class RoleToUserform {
    private String userName;
    private String roleName;
}
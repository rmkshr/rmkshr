package com.spring.security.apisecurity.api;

import com.spring.security.apisecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiv3")
 @RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @GetMapping("/getuser")
    public ResponseEntity getUser() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

}

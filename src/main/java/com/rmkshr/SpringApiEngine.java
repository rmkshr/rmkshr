package com.rmkshr;

import com.rmkshr.springsecurity.domain.ApiUser;
import com.rmkshr.springsecurity.domain.Role;
import com.rmkshr.springsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.rmkshr.springsecurity.utils.Constants.ROLE_ADMIN;

/**
 * @author Ramkishore
 */
@SpringBootApplication
public class SpringApiEngine {

    public static void main(String[] args) {
        SpringApplication.run(SpringApiEngine.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveUser(new ApiUser(null, "Ramkishore", "rmkshr", "letmein", new ArrayList<Role>()));
            userService.addRoleToApiUser("rmkshr", ROLE_ADMIN);
        };
    }
}

package com.spring;

import com.spring.apisecurity.domain.ApiUser;
import com.spring.apisecurity.domain.Role;
import com.spring.apisecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

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
	CommandLineRunner run (UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveUser(new ApiUser(null, "Ramkishore", "rmkshr", "letmein", new ArrayList<Role>()));
			userService.addRoleToApiUser("rmkshr","ROLE_ADMIN");
		};
	}
}

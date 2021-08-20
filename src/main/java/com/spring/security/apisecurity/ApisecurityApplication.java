package com.spring.security.apisecurity;

import com.spring.security.apisecurity.domain.ApiUser;
import com.spring.security.apisecurity.domain.Role;
import com.spring.security.apisecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ApisecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (UserService userService) {
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_GUEST"));
			userService.saveRole(new Role(null, "ROLE_PROXY"));

			userService.saveUser(new ApiUser(null, "Ramkishore", "rmkshr", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "kishore", "kishore", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "vishnu", "vishnu", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "Linus", "linus", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "Suganya", "suganya", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "rootuser", "rootuser", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "denzel", "denzel", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "dave", "dave", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "jack", "jack", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "jill", "jill", "letmein", new ArrayList<Role>()));
			userService.saveUser(new ApiUser(null, "hello", "hello", "letmein", new ArrayList<Role>()));

			userService.addRoleToApiUser("rmkshr","ROLE_SUPER_ADMIN");
			userService.addRoleToApiUser("rmkshr","ROLE_GUEST");
			userService.addRoleToApiUser("rmkshr","ROLE_PROXY");
			userService.addRoleToApiUser("rmkshr","ROLE_ADMIN");
			userService.addRoleToApiUser("rmkshr","ROLE_USER");
			userService.addRoleToApiUser("rmkshr","ROLE_ADMIN");
			userService.addRoleToApiUser("rmkshr","ROLE_USER");
			userService.addRoleToApiUser("rmkshr","ROLE_PROXY");
			userService.addRoleToApiUser("rmkshr","ROLE_PROXY");
			userService.addRoleToApiUser("rmkshr","ROLE_PROXY");
			userService.addRoleToApiUser("rmkshr","ROLE_ADMIN");
		};
	}
}

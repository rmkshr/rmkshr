package org.srv;

import static org.srv.springsecurity.utils.Constants.ROLE_ADMIN;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.srv.springsecurity.domain.ApiUser;
import org.srv.springsecurity.domain.Role;
import org.srv.springsecurity.service.RoleService;
import org.srv.springsecurity.service.UserService;

/**
 * @author Ramkishore
 */
@SpringBootApplication
public class SpringApiEngine {

  public static final Logger logger = Logger.getLogger(SpringApiEngine.class.getName());

  public static void main(String[] args) {
    logger.info("APPLICATION STARTS");
    SpringApplication.run(SpringApiEngine.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  CommandLineRunner run(UserService userService, RoleService roleService) {
    return args -> {
      roleService.saveRole(new Role(null, "ROLE_ADMIN"));
      userService.saveUser(
          new ApiUser(null, "Ramkishore", "rmkshr", "letmein", new ArrayList<Role>()));
      userService.addRoleToApiUser("rmkshr", ROLE_ADMIN);
    };
  }
}

package com.spring.security.apisecurity.repo;

import com.spring.security.apisecurity.domain.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository to hold all the user details.
 */
public interface UserRepo  extends JpaRepository<ApiUser, Long> {
     ApiUser findByUserName(String userName);
}

package com.spring.apisecurity.repo;

import com.spring.apisecurity.domain.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository to hold all the user details.
 */
public interface UserRepository extends JpaRepository<ApiUser, Long> {
     ApiUser findByUserName(String userName);
}

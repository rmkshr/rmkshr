package com.spring.security.apisecurity.repo;

import com.spring.security.apisecurity.domain.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<ApiUser, Long> {
     ApiUser findByUserName(String userName);
}

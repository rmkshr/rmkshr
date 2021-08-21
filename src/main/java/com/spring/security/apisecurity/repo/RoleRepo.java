package com.spring.security.apisecurity.repo;

import com.spring.security.apisecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName (String name);
}

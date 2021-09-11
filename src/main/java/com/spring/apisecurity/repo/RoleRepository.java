package com.spring.apisecurity.repo;

import com.spring.apisecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository to hold all the roles of a user.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
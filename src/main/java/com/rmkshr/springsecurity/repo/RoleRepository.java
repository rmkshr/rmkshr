package com.rmkshr.springsecurity.repo;

import com.rmkshr.springsecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository to hold all the roles of a user.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

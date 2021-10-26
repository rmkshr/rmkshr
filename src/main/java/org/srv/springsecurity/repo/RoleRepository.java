package org.srv.springsecurity.repo;

import org.srv.springsecurity.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository to hold all the roles of a user.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

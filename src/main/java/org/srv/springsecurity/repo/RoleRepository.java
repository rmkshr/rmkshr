package org.srv.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srv.springsecurity.domain.Role;

/**
 * JPA Repository to hold all the roles of a user.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String name);
}

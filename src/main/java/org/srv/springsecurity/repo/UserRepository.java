package org.srv.springsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.srv.springsecurity.domain.ApiUser;

/**
 * JPA Repository to hold all the user details.
 */
public interface UserRepository extends JpaRepository<ApiUser, Long> {

  ApiUser findByUserName(String userName);
}

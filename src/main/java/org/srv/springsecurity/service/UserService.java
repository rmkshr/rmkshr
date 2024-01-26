package org.srv.springsecurity.service;

import java.util.List;
import org.srv.springsecurity.domain.ApiUser;
import org.srv.springsecurity.domain.Role;

/**
 * @author ramkishore
 */
public interface UserService {

  ApiUser saveUser(ApiUser user);

  List<Role> getUserRoles(String username);

  void addRoleToApiUser(String userName, String roleName);

  ApiUser getUser(String userName);

  List<ApiUser> getUsers();
}

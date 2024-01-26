package org.srv.springsecurity.service;

import java.util.List;
import org.srv.springsecurity.domain.Role;

/**
 * @author ramkishore
 */
public interface RoleService {

  List<Role> getRoles();

  Role saveRole(Role role);
}

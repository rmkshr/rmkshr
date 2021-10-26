package org.srv.springsecurity.service;

import org.srv.springsecurity.domain.Role;

import java.util.List;

/**
 * @author ramkishore
 */
public interface RoleService {

    List<Role> getRoles();

    Role saveRole(Role role);
}

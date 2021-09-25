package com.rmkshr.springsecurity.service;

import com.rmkshr.springsecurity.domain.Role;

import java.util.List;

/**
 * @author ramkishore
 */
public interface RoleService {

    List<Role> getRoles();

    Role saveRole(Role role);
}

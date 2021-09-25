package com.rmkshr.springsecurity.service;

import com.rmkshr.springsecurity.domain.ApiUser;
import com.rmkshr.springsecurity.domain.Role;

import java.util.List;

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

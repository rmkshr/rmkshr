package com.rmkshr.spring.apisecurity.service;

import com.rmkshr.spring.apisecurity.domain.ApiUser;
import com.rmkshr.spring.apisecurity.domain.Role;

import java.util.List;

/**
 * @author ramkishore
 */
public interface UserService {
    ApiUser saveUser(ApiUser user);

    Role saveRole(Role role);

    void addRoleToApiUser(String userName, String roleName);

    ApiUser getUser(String userName);

    List<ApiUser> getUsers();
}

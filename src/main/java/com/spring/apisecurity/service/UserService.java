package com.spring.apisecurity.service;

import com.spring.apisecurity.domain.ApiUser;
import com.spring.apisecurity.domain.Role;

import java.util.List;

/**
 * @author ramkishore
 */
public interface UserService {
    ApiUser saveUser (ApiUser user);
    Role saveRole (Role role);
    void addRoleToApiUser (String userName, String roleName);
    ApiUser getUser (String userName);
    List<ApiUser> getUsers();
}

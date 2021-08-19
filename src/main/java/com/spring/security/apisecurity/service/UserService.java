package com.spring.security.apisecurity.service;

import com.spring.security.apisecurity.domain.ApiUser;
import com.spring.security.apisecurity.domain.Role;

import java.util.List;

public interface UserService {
    ApiUser saveUser (ApiUser user);
    Role saveRole (Role role);
    void addRoleToApiUser (String userName, String roleName);
    ApiUser getUser (String userName);
    List<ApiUser> getUsers();
}

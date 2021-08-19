package com.spring.security.apisecurity.service;

import com.spring.security.apisecurity.domain.ApiUser;
import com.spring.security.apisecurity.domain.Role;
import com.spring.security.apisecurity.repo.RoleRepo;
import com.spring.security.apisecurity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public ApiUser saveUser(ApiUser user) {
        log.info("Saving new user {} to database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database", role.getName());
        return roleRepo.save(role );
    }

    @Override
    public void addRoleToApiUser(String userName, String roleName) {
    log.info("Saving new role {} to user {}", roleName, userName);
    ApiUser user = userRepo.findByUserName(userName);
    Role role = roleRepo.findByName(roleName);
    user.getRoles().add(role);
    }

    @Override
    public ApiUser getUser(String userName) {
    log.info("Fetching user {}", userName);
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<ApiUser> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}

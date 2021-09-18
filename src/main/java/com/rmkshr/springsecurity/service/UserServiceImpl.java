package com.rmkshr.springsecurity.service;

import com.rmkshr.springsecurity.domain.ApiUser;
import com.rmkshr.springsecurity.domain.Role;
import com.rmkshr.springsecurity.repo.RoleRepository;
import com.rmkshr.springsecurity.repo.UserRepository;
import com.rmkshr.springsecurity.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ramkishore.
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Save user method.
     *
     * @param user
     * @return
     */
    @Override
    public ApiUser saveUser(ApiUser user) {
        log.info(Constants.SAVE_USER_LOGGER, user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Save role method.
     *
     * @param role
     * @return
     */
    @Override
    public Role saveRole(Role role) {
        log.info(Constants.SAVE_ROLE_LOGGER, role.getName());
        return roleRepository.save(role);
    }

    /**
     * Add role to user method.
     *
     * @param userName
     * @param roleName
     */
    @Override
    public void addRoleToApiUser(String userName, String roleName) {
        log.info(Constants.SAVE_ROLE_TO_USER_LOGGER, roleName, userName);
        ApiUser user = userRepository.findByUserName(userName);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    /**
     * get user from database by username.
     *
     * @param userName
     * @return
     */
    @Override
    public ApiUser getUser(String userName) {
        log.info(Constants.FETCHING_USER_LOGGER, userName);
        return userRepository.findByUserName(userName);
    }

    /**
     * get list of all users from database.
     *
     * @return
     */
    @Override
    public List<ApiUser> getUsers() {
        log.info(Constants.FETCHING_ALL_USER_LOGGER);
        return userRepository.findAll();
    }

    /**
     * Load user using the user name.
     *
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        ApiUser apiUser = userRepository.findByUserName(userName);
        if (apiUser == null) {
            log.error(Constants.USER_NOT_FOUND_LOGGER);
            throw new UsernameNotFoundException(Constants.USER_NOT_FOUND_LOGGER);
        } else {
            log.info(Constants.USER_NOT_FOUND_PARAM_LOGGER, userName);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        apiUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(apiUser.getUserName(), apiUser.getPassword(), authorities);
    }

}

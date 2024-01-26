package org.srv.springsecurity.service;

import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.srv.springsecurity.domain.Role;
import org.srv.springsecurity.repo.RoleRepository;
import org.srv.springsecurity.utils.Constants;

/**
 * @author ramkishore
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  /**
   * Function to get all available roles.
   *
   * @return
   */
  @Override
  public List<Role> getRoles() {
    log.info(Constants.GET_ROLE_LOGGER);
    return roleRepository.findAll();
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

}

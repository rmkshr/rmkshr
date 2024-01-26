package org.srv.springsecurity.domain;

import static javax.persistence.GenerationType.AUTO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @author ramkishore
 * User entity class.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiUser {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;
  private String name;
  private String userName;
  private String password;
  @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id")
  private List<Role> roles = new ArrayList<>();
}

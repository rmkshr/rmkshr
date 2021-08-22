package com.spring.security.apisecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

/***
 * @author ramkishore
 * User entity class.
 */
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ApiUser {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}

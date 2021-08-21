package com.spring.security.apisecurity.security;

import com.spring.security.apisecurity.filter.CustomAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     CustomAuthFilter customAuthFilter = new CustomAuthFilter(authenticationManagerBean());
     customAuthFilter.setFilterProcessesUrl("/apiv3/login");
     http.csrf().disable();
     http.sessionManagement().sessionCreationPolicy(STATELESS);
     http.authorizeRequests().antMatchers("/apiv3/login/**").permitAll();
     http.authorizeRequests().antMatchers(GET, "/apiv3/**").hasAuthority("ROLE_SUPER_ADMIN");
     http.authorizeRequests().antMatchers(POST, "/apiv3/**").hasAuthority("ROLE_SUPER_ADMIN");
     http.authorizeRequests().anyRequest().authenticated();
     http.addFilter(customAuthFilter);
   //  http.addFilter(new CustomAuthFilter(authenticationManagerBean()));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

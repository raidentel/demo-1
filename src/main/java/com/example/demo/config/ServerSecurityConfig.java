package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.sql.DataSource;

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home**", "/register").permitAll()
                .antMatchers("/user/username/**").permitAll()
                .antMatchers("**/admin/**").hasAnyRole("ADMIN")
                .antMatchers("**/user/**", "/home/user/dashboard/**").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }

    @Bean(name = "encoder")
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RequestCache requestCache() {
        RequestCache requestCache = new HttpSessionRequestCache();
        return requestCache;
    }
}

package com.grupoG33.reto3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected  void  configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/error","/webjars/**").permitAll()
                .anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
        http.oauth2Login();
        http.logout().logoutSuccessUrl("/").permitAll();

        http.cors().and().csrf().disable();
    }
}

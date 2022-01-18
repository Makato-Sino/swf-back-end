package com.sysu.swfbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ActivitiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 页面登录
                .formLogin()
                // 登录方法
                .loginPage("/login")
                .loginProcessingUrl("/login")
                // 登录成功
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable();

        //SpringSecurity配置跨域请求
        http.cors();
    }
}

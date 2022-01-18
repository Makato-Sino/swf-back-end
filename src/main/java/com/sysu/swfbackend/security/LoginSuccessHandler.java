package com.sysu.swfbackend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysu.swfbackend.bean.UserInfoBean;
import com.sysu.swfbackend.dao.UserInfoBeanMapper;
import com.sysu.swfbackend.util.AjaxResponse;
import com.sysu.swfbackend.util.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("loginSuccessHandler")
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserInfoBeanMapper userInfoBeanMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write("登录成功!" + authentication.getName());

        response.getWriter().write(
                objectMapper.writeValueAsString(AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(),
                                                GlobalConfig.ResponseCode.SUCCESS.getDesc(),
                                                userInfoBeanMapper.selectByUsername(authentication.getName())))
        );
    }
}

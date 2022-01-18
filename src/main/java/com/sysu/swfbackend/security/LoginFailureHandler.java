package com.sysu.swfbackend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysu.swfbackend.util.AjaxResponse;
import com.sysu.swfbackend.util.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("LoginFailureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write("登录失败! 原因: " + exception.getMessage());
        response.getWriter().write(
                objectMapper.writeValueAsString(AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(),
                        GlobalConfig.ResponseCode.ERROR.getDesc(),
                        "登录失败! 原因: " + exception.getMessage()))
        );
    }
}

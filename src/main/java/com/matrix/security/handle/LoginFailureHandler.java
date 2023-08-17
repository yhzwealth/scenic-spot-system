package com.matrix.security.handle;

import com.matrix.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        String str;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            str = "账户名或者密码输入错误!";
        } else if (e instanceof LockedException) {
            str = "账户被锁定，请联系管理员!";
        } else if (e instanceof CredentialsExpiredException) {
            str = "密码过期，请联系管理员!";
        } else if (e instanceof AccountExpiredException) {
            str = "账户过期，请联系管理员!";
        } else if (e instanceof DisabledException) {
            str = "账户被禁用，请联系管理员!";
        } else {
            str = "登录失败!";
        }
        writer.write(str);
        writer.flush();
        writer.close();
    }
}
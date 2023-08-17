package com.matrix.utils;

import com.matrix.security.SimpleGrantedAuthority;
import com.matrix.security.UserLogin;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;

/**
 * SpringSecurity 工具类
 */
public class SecurityUtils {

    /**
     * 获取当前用户认证信息
     * @return 认证对象
     */
    private static Authentication getUserAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取当前用户信息
     * @return 用户对象
     */
    public static UserLogin getCurrentPrincipal(){
        return (UserLogin) getUserAuthentication().getPrincipal();
    }

    public static Integer getCurrentId(){
        return getCurrentPrincipal().getId();
    }
    public static String getCurrentUsername(){
        return getCurrentPrincipal().getUsername();
    }
    public static Set<SimpleGrantedAuthority> getCurrentPermissions(){
        return getCurrentPrincipal().getPermissions();
    }
}

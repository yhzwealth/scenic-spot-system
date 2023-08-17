package com.matrix.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.matrix.entity.Userinfo;
import com.matrix.mapper.UserinfoMapper;
import com.matrix.security.SimpleGrantedAuthority;
import com.matrix.security.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author iamYBG
 * @since 2021-07-04
 */
@Service
public class SecurityUserServiceImpl implements UserDetailsService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserLogin user = new UserLogin();
        user.setUsername(s);
        Userinfo u = userinfoMapper.selectOne(new LambdaQueryWrapper<Userinfo>().eq(Userinfo::getUserName,s));
        if(u == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        user.setId(u.getUserId());
        user.setPassword(u.getPassword());

        Set<SimpleGrantedAuthority> permissions = new HashSet<>();
        switch (u.getRoleName()) {
            case "visitor":
                permissions.add(new SimpleGrantedAuthority("visitor"));
                break;
            case "gard":
                permissions.add(new SimpleGrantedAuthority("info"));
                permissions.add(new SimpleGrantedAuthority("gard"));
                break;
            case "manager":
                permissions.add(new SimpleGrantedAuthority("info"));
                permissions.add(new SimpleGrantedAuthority("manager"));
                break;
        }
        System.out.println(permissions);
        user.setPermissions(permissions);
        return user;
    }
}
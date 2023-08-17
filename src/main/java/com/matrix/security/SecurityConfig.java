package com.matrix.security;

import com.matrix.security.handle.LoginFailureHandler;
import com.matrix.security.handle.LoginSuccessHandler;
import com.matrix.security.handle.MyAccessDeniedHandler;
import com.matrix.security.handle.MyLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("securityUserServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Autowired
    private LoginFailureHandler loginFailureHandler;

    @Autowired
    private MyLogoutHandler logoutHandler;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().requestMatchers(CorsUtils::isPreFlightRequest).permitAll();

        http.cors();
        http.csrf().disable();

        http.formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                // 登录成功
                .successHandler(loginSuccessHandler)
                // 登录失败
                .failureHandler(loginFailureHandler).permitAll()
                .and()
                // 注销成功
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(logoutHandler)
                .deleteCookies("JSESSIONID")
                .and()
                // 未登录请求资源
                .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
                .accessDeniedHandler(myAccessDeniedHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers("/userinfo/**").hasAuthority("info")
//                .antMatchers("/usergate/**","/codeingardinfo/codeIn","/codeingardinfo/gardQuery").hasAuthority("gard")
//                .antMatchers("/codeingardinfo/managerQuery").hasAuthority("manager")
                .anyRequest().authenticated();
    }
}
package com.challenge.config;

import com.challenge.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    //  Gets the AuthenticationManager to use. The default strategy is if configure(AuthenticationManagerBuilder)
    //  method is overridden to use the AuthenticationManagerBuilder that was passed in. Otherwise,
    //  autowire the AuthenticationManager by type.
    // ( https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/
    // config/annotation/web/configuration/WebSecurityConfigurerAdapter.html )

    @Override
    public void configure(WebSecurity web) throws java.lang.Exception{
    web.ignoring().antMatchers("/user");
    }

    // Override this method to configure WebSecurity. For example, if you wish to
    // ignore certain requests. Endpoints specified in this method will be ignored by Spring
    // Security, meaning it will not protect them from CSRF, XSS, Clickjacking, and so on.
    // Instead, if you want to protect endpoints against common vulnerabilities, then see
    // configure(HttpSecurity) and the HttpSecurity.authorizeRequests() configuration method.
    // ( https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/
    // config/annotation/web/configuration/WebSecurityConfigurerAdapter.html )

    // Using ignoring and antMatchers (httpsecurity-vs-websecurity)
    // https://newbedev.com/spring-security-configuration-httpsecurity-vs-websecurity


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("bruno@gmail.com")
//                .password("123456")
//                .roles("ADMIN");
//    }

    // Used by the default implementation of authenticationManager() to attempt to obtain an
    // AuthenticationManager. If overridden, the AuthenticationManagerBuilder should be used to specify
    // the AuthenticationManager.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //    protected void configure(HttpSecurity http) throws java.lang.Exception {
    //        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
    //    }

}


// Sobre a diferença das classes WebSecurityConfigurerAdapter e AuthorizationServerConfigurerAdapter
// ( https://www.ti-enxame.com/pt/java/diferenca-entre-
//  authorizationserverconfigureradapter-vs-websecurityconfigureradapter/838118280/ )
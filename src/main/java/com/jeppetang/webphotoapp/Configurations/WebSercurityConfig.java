package com.jeppetang.webphotoapp.Configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSercurityConfig extends WebSecurityConfigurerAdapter {

    private static final String ADMIN = "ADMIN";

    @Autowired
    private DataSource dataSource;

    //Hash kryptering af koder
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Henter og validere username & password fra mysql database via jdbc
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
    }

    //Bestemmer hvilke roler der kan tilgå hvilke html sider
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/createUser","/admin","/answer","/beskeder","/createAD","/createAV","/editAD","editAV","/deleteAD/*","/deleteAV/*").hasRole(ADMIN)
                .antMatchers("/", "/home").permitAll()
                .and()
                .logout()
                .and()
                .formLogin();


    }
}

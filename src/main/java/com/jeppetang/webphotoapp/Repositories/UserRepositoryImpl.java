package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int saveUser(User user) {

        return jdbcTemplate.update(
                "insert into users(username, password, enabled) value (?,?,?)",
                user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),1);

    }

    @Override
    public int saveUserRole(User user) {
        return jdbcTemplate.update(
                "insert into authorities(username, authority) value (?,?)",
                user.getUsername(), "ROLE_ADMIN");
    }

    @Override
    public int updatePassword(User user) {
        return jdbcTemplate.update(
                "update users set password = ? where username = ?",
                bCryptPasswordEncoder.encode(user.getPassword()), user.getUsername());
    }

    @Override
    public int deleteUser(String username){
        return jdbcTemplate.update(
                "delete from users where username = ?", username);
    }
}

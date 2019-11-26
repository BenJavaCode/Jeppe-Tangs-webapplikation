package com.jeppetang.webphotoapp.Repositories;

import com.jeppetang.webphotoapp.Models.User;
import java.util.List;

public interface UserRepository {

    int saveUser(User user);

    int saveUserRole(User user);

    int updatePassword(User user);

    int deleteUser(String username);
}


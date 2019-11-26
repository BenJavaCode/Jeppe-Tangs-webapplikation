package com.jeppetang.webphotoapp.Services;


import com.jeppetang.webphotoapp.Models.User;

public interface UserServices {

    void addUser(User user);
    void changePassword(User user);
    void deleteUser(String username);



}

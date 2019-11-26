package com.jeppetang.webphotoapp.Services;

import com.jeppetang.webphotoapp.Models.User;
import com.jeppetang.webphotoapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.saveUser(user);
        userRepository.saveUserRole(user);
    }

    @Override
    public void changePassword(User user) {
        userRepository.updatePassword(user);

    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }
}

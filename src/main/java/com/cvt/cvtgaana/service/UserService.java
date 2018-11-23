package com.cvt.cvtgaana.service;

import com.cvt.cvtgaana.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(String userId);
    void saveUser(User user);
    void updateUserById(String userId, User user);
    void deleteUser(String userId);
}

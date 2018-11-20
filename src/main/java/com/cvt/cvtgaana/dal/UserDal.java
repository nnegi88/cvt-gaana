package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.User;

import java.util.List;

public interface UserDal {
    List<User> getAllUser();
    User getUserById(String userId);
    void saveUser(User user);
    void deleteUser(String userId);
}
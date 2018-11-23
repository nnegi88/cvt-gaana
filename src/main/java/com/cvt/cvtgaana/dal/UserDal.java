package com.cvt.cvtgaana.dal;

import com.cvt.cvtgaana.model.User;
import com.cvt.cvtgaana.model.UserNotFoundException;

import java.util.List;

public interface UserDal {
    List<User> getAllUser();
    User getUserById(String userId) throws UserNotFoundException;
    void saveUser(User user);
    void updateUserById(String userId, User user);
    void deleteUser(String userId);
}
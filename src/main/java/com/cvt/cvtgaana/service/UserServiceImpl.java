package com.cvt.cvtgaana.service;

import com.cvt.cvtgaana.dal.UserDal;
import com.cvt.cvtgaana.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDal userDal;

    @Override
    public List<User> getAllUser(){
        return userDal.getAllUser();
    }

    @Override
    public User getUserById(String userId){
        return userDal.getUserById(userId);
    }

    @Override
    public void saveUser(User user){
        userDal.saveUser(user);
    }

    @Override
    public void updateUserById(String userId, User user) {
        userDal.updateUserById(userId, user);
    }

    @Override
    public void deleteUser(String userId){
        userDal.deleteUser(userId);
    }
}
package com.cvt.cvtgaana.service;

import com.cvt.cvtgaana.dal.UserDal;
import com.cvt.cvtgaana.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDal userDal;

    public List<User> getAllUser(){
        return userDal.getAllUser();
    }

    public User getUserById(String userId){
        return userDal.getUserById(userId);
    }

    public void saveUser(User user){
        userDal.saveUser(user);
    }

    public void deleteUser(String userId){
        userDal.deleteUser(userId);
    }
}

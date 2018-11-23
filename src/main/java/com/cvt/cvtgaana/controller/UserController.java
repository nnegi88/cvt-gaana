package com.cvt.cvtgaana.controller;

import com.cvt.cvtgaana.model.User;
import com.cvt.cvtgaana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
        userService.saveUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getUserId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{userId}")
    public void updateUser(@PathVariable String userId, @Valid @RequestBody User user){
        userService.updateUserById(userId, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{userId}")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}

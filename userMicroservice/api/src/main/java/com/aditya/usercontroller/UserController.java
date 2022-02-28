package com.aditya.usercontroller;

import com.aditya.user_entities.UserValue;
import com.aditya.userservice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //build create user REST api
    @PostMapping
    public ResponseEntity<UserValue> saveUser(@RequestBody UserValue userValue) {
        return new ResponseEntity<UserValue>(userService.saveUser(userValue), HttpStatus.CREATED);
    }

    //build get all user REST api
    @GetMapping
    public List<UserValue> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserValue> getUserById(@PathVariable("id") long id) {
        return new ResponseEntity<UserValue>(userService.getUserById(id), HttpStatus.OK);
    }

    //build update user REST api
    @PutMapping("{id}")
    public ResponseEntity<UserValue> updateUser(@PathVariable("id") long id, @RequestBody UserValue userValue) {
        return new ResponseEntity<UserValue>(userService.updateUser(userValue, id), HttpStatus.OK);
    }

    //build delete user REST api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("user deleted", HttpStatus.OK);
    }
}

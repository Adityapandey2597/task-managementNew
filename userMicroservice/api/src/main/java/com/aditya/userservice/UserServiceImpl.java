package com.aditya.userservice;


import com.aditya.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.aditya.repository.UserRepository;
import com.aditya.user_entities.UserValue;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserValue saveUser(UserValue userValue) {
        return userRepository.save(userValue);
    }

    @Override
    public List<UserValue> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserValue getUserById(long id) {
        Optional<UserValue> userValue = userRepository.findById(id);
        if (userValue.isPresent()){
            return userValue.get();
        } else {
            throw new ResourceNotFoundException("UserValue","Id",id);
        }
    }


    @Override
    public UserValue updateUser(UserValue userValue, long id) {
        //check weather user exist
        UserValue existingUser = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("UserValue","Id",id));

        existingUser.setFirstName(userValue.getFirstName());
        existingUser.setLastName(userValue.getLastName());

        //save
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
        //check exist user
        userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("UserValue","Id",id));

        userRepository.deleteById(id);
    }
}

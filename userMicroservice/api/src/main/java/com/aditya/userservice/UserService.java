package com.aditya.userservice;

import com.aditya.user_entities.UserValue;

import java.util.List;

public interface UserService {

    UserValue saveUser(UserValue userValue);

    List<UserValue> getAllUser();

    UserValue getUserById(long id);

    UserValue updateUser(UserValue userValue, long id);

    void deleteUser(long id);
}

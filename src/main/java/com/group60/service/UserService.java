package com.group60.service;

import com.group60.entity.User;

public interface UserService {
    User login(String email_address, String password);

    void register(User user);
}

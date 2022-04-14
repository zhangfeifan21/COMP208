package com.group60.dao;

import com.group60.entity.User;
import org.springframework.stereotype.Component;

public interface UserDao {
    User findByEmail(String email_address);
    void save(User user);
}

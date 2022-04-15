package com.group60.dao;

import com.group60.entity.Party;
import com.group60.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
    User findByEmail(String email_address);
    void save(User user);
    List<Party> lists();
}

package com.group60.service.impl;

import com.group60.dao.UserDao;
import com.group60.entity.User;
import com.group60.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String email_address, String password) {
        User user = userDao.findByEmail(email_address);
        if(ObjectUtils.isEmpty(user)) throw new RuntimeException("email doesn't exists");
        if(!user.getPassword().equals(password)) throw new RuntimeException("wrong password");
        return user;
    }

    @Override
    public void register(User user) {
        User userDb = userDao.findByEmail(user.getEmail_address());
        if(!ObjectUtils.isEmpty(userDb)) throw new RuntimeException("email already exists");
        userDao.save(user);
    }
}

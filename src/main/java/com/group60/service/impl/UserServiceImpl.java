package com.group60.service.impl;

import com.group60.controller.UserController;
import com.group60.dao.UserDao;
import com.group60.entity.*;
import com.group60.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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
        userDao.saveUser(user);
    }

    @Override
    public List<Party> lists() {
        return userDao.lists();
    }

    @Override
    public void saveParty(Party party, Integer user_id) {
        userDao.saveParty(party, user_id);
    }

    @Override
    public List<Party> myParty(Integer user_id) {
        return userDao.myParty(user_id);
    }

    @Override
    public void joinParty(Integer user_id, Integer party_id) {
        Pair pairDB = userDao.findPair(user_id, party_id);
        if (!ObjectUtils.isEmpty(pairDB)) throw new RuntimeException("already joined that party");
        CheckMember checkMember = userDao.checkParty(party_id);
        log.debug("cur:{}, max{}",checkMember.getCurrent_member(),checkMember.getMax_member());
        if (checkMember.getCurrent_member()==checkMember.getMax_member()) throw new RuntimeException("party is full");
        userDao.addMember(party_id);
        userDao.joinParty(user_id, party_id);
    }

    @Override
    public void quitParty(Integer user_id, Integer party_id) {
        Pair pairDB = userDao.findPair(user_id, party_id);
        if (ObjectUtils.isEmpty(pairDB)) throw new RuntimeException("haven't join that party");
        userDao.deleteMember(party_id);
        userDao.quitParty(user_id, party_id);
    }

    @Override
    public void dismissParty(Integer party_id) {
        userDao.emptyMember(party_id);
        userDao.dismissParty(party_id);
    }

    @Override
    public void saveDetail(Integer user_id, Detail detail) {
        userDao.saveDetail(user_id, detail);
    }

    @Override
    public Detail getDetail(Integer user_id) {
        return userDao.getDetail(user_id);
    }
}

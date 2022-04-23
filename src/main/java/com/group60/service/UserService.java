package com.group60.service;

import com.group60.entity.Party;
import com.group60.entity.User;

import java.util.List;

public interface UserService {
    User login(String email_address, String password);
    void register(User user);
    List<Party> lists();
    void saveParty(Party party, int user_id);
    List<Party> listParty(int user_id);
}

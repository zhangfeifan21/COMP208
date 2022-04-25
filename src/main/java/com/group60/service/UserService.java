package com.group60.service;

import com.group60.entity.Detail;
import com.group60.entity.Party;
import com.group60.entity.User;

import java.util.List;

public interface UserService {
    User login(String email_address, String password);
    void register(User user);
    List<Party> lists();
    void saveParty(Party party, Integer user_id);
    List<Party> myParty(Integer user_id);
    void joinParty(Integer user_id, Integer party_id);
    void quitParty(Integer user_id, Integer party_id);
    void dismissParty(Integer party_id);
    void saveDetail(Integer user_id, Detail detail);
    Detail getDetail(Integer user_id);
    void setCode(String email_address, String code);
    String getCode(String email_address);
}

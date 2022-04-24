package com.group60.dao;

import com.group60.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findByEmail(String email_address);
    void saveUser(User user);
    List<Party> lists();
    void saveParty(@Param("party") Party party,@Param("user_id") int user_id);
    List<Party> myParty(Integer user_id);
    void joinParty(@Param("user_id") Integer user_id, @Param("party_id") Integer party_id);
    void quitParty(@Param("user_id") Integer user_id, @Param("party_id") Integer party_id);
    Pair findPair(@Param("user_id") Integer user_id, @Param("party_id") Integer party_id);
    void addMember(Integer party_id);
    void deleteMember(Integer party_id);
    CheckMember checkParty(Integer party_id);
    void emptyMember(Integer party_id);
    void dismissParty(Integer party_id);
    void saveDetail(@Param("user_id") Integer user_id, @Param("detail") Detail detail);
    Detail getDetail(Integer user_id);
}

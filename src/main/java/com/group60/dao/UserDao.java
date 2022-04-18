package com.group60.dao;

import com.group60.entity.Party;
import com.group60.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface UserDao {
    User findByEmail(String email_address);
    void saveUser(User user);
    List<Party> lists();
    void saveParty(@Param("party") Party party,@Param("user_id") int user_id);
}

package com.group60.controller;

import com.group60.entity.Detail;
import com.group60.entity.Party;
import com.group60.entity.User;
import com.group60.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("savedetail")
    public String saveDetail(Detail detail, HttpSession session){
        User user = (User) session.getAttribute("user");
        int user_id = user.getUser_id();
        log.debug("user_id: {} Got for save",user_id);
        log.debug("updating details...");
        userService.saveDetail(user_id, detail);
        session.setAttribute("detail",detail);
        return "redirect:/user/partylist";
    }
    @RequestMapping("viewholder")
    public String viewHolder(){
        return "personDetail";
    }

    @RequestMapping("dismissparty")
    public String dismissParty(Integer partyId){
        log.debug("dismissing party...party_id={}",partyId);
        userService.dismissParty(partyId);
        return "redirect:/user/myparty";
    }
    @RequestMapping("quitparty")
    public String quitParty(HttpSession session, Integer partyId){
        log.debug("quiting party");
        User user = (User) session.getAttribute("user");
        log.debug("user={}, partyid={}",user,partyId);
        try {
            userService.quitParty(user.getUser_id(), partyId);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return "redirect:/user/mylist";
        }
        return "redirect:/user/myparty";
    }

    @RequestMapping("joinparty")
    public String joinParty(HttpSession session, Integer partyId){
        log.debug("joining party...");
        User user = (User) session.getAttribute("user");
        log.debug("user={}, partyid={}",user,partyId);
        try {
            userService.joinParty(user.getUser_id(), partyId);
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return "redirect:/user/partylist";
        }
        return "redirect:/user/partylist";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
//        session.setAttribute("user", null);
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("myparty")
    public String myParty(Model model, HttpSession session){
        log.debug("listing myparty...");
        User user = (User) session.getAttribute("user");
        log.debug("printing my party list... with user: {}", user);
        List<Party> myParties = userService.myParty(user.getUser_id());
        model.addAttribute("myparties", myParties);
        log.debug("added successfully");
        return "myParty";
    }

    @RequestMapping("saveparty")
    public String saveParty(Party party, HttpSession session){
        User user = (User) session.getAttribute("user");
        int user_id = user.getUser_id();
        log.debug("user_id: {} Got for save",user_id);
        log.debug("saving party...");
        try {
            if (party.getTitle().isEmpty()) throw new RuntimeException("title cannot be null");
            if (party.getDescription().isEmpty()) throw new RuntimeException("description cannot be null");
            if (party.getMax_member()==0) throw new RuntimeException("max members cannot be null");
//            if (party.getStart_time().toString().isEmpty()) throw new RuntimeException("start time cannot be null");
            if (party.getPlace().isEmpty()) throw new RuntimeException("place cannot be null");
            userService.saveParty(party, user_id);
        } catch (RuntimeException e){
            e.printStackTrace();
            return "redirect:/saveparty";
        }
        return "redirect:/user/partylist";
    }
    @RequestMapping("partylist")
    public String list(Model model){
        log.debug("listing...");
        List<Party> partyList = userService.lists();
        model.addAttribute("parties", partyList);
        return "list";
    }

    @RequestMapping("login")
    public String login(String email_address, String password, HttpSession session){
        log.debug("email_address: {}, password: {} Got for login",email_address,password);
        try {
            User user = userService.login(email_address, password);
            session.setAttribute("user",user);
            Detail detail = userService.getDetail(user.getUser_id());
            session.setAttribute("detail",detail);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register";
        }
        return "redirect:/user/partylist";
    }

    @RequestMapping("register")
    public String register(User user, String confirmPwd){
        log.debug("email_address: {},password: {}",user.getEmail_address(),user.getPassword());
        log.debug("confirmPwd: {}",confirmPwd);
        try {
            if(user.getPassword().isEmpty()) throw new RuntimeException("please enter password");
            if(!user.getPassword().equals(confirmPwd)) throw new RuntimeException("password mismatched");
            userService.register(user);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return "redirect:/register";
        }
        return "redirect:/login";
    }
}

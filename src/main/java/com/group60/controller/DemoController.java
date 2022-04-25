package com.group60.controller;

import com.group60.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class DemoController {

    private MailService mailService;

    @Autowired
    public DemoController(MailService mailService){
        this.mailService = mailService;
    }
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("demo")
    public String demo(Model model){
        log.debug("demo ok");
        model.addAttribute("msg","hello thymeleaf");
        return "demo";
    }
    @RequestMapping("mail")
    public void mailTest(){
        mailService.sendEmail("1426107672@qq.com","test");
    }
}

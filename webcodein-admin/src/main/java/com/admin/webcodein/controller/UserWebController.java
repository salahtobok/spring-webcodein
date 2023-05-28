package com.admin.webcodein.controller;


import com.admin.webcodein.service.UserDbService;
import com.admin.webcodein.domain.User;
import com.admin.webcodein.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserWebController {
    private final UserDbService userDbService;

    @Autowired
    public UserWebController(UserDbService userDbService){
        this.userDbService = userDbService;
    }



    @GetMapping
    public String getUsers(@RequestParam(value = "date",required = false) String dateString , Model model){
        Date date = DateUtils.createDateFromDateString(dateString);
        List<User> userList = this.userDbService.getUserList();
        model.addAttribute("users",userList);
        return "users";
    }


}

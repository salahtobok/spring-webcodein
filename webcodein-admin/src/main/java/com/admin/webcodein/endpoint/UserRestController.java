package com.admin.webcodein.endpoint;


import com.admin.webcodein.domain.User;
import com.admin.webcodein.service.UserDbService;
import com.admin.webcodein.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserDbService userDbService;


    @Autowired
    public UserRestController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(name = "date" , required = false) String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.userDbService.getUserList();
    }
}

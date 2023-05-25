package com.admin.webcodein.business.webservicecontroller;


import com.admin.webcodein.business.service.UserDbService;
import com.admin.webcodein.data.entity.User;
import com.admin.webcodein.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController("api/users")
public class UserWebServiceController {

    private final UserDbService userDbService;


    @Autowired
    public UserWebServiceController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(name = "date" , required = false) String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.userDbService.getUserList();
    }
}

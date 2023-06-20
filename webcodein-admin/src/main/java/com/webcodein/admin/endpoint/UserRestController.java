package com.webcodein.admin.endpoint;


import com.webcodein.admin.entity.User;
import com.webcodein.admin.service.UserDbService;
import com.webcodein.admin.util.DateUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Slf4j
@Path("/users")
public class UserRestController {

    private final UserDbService userDbService;


    @Autowired
    public UserRestController(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public List<User> getUsers(@RequestParam(name = "date" , required = false) String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return this.userDbService.getUserList();
    }
}

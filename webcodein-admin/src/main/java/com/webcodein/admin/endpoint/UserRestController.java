package com.webcodein.admin.endpoint;


import com.webcodein.admin.entity.User;
import com.webcodein.admin.service.UserDbService;
import com.webcodein.admin.util.DateUtils;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getUsers(){
        System.out.println("\"Get Users Functions loaded\"");
        return Response.ok(this.userDbService.getUserList(), MediaType.APPLICATION_JSON).build();
    }
}

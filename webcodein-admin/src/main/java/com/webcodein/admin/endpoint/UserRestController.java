package com.webcodein.admin.endpoint;


import com.webcodein.admin.dto.UserDto;
import com.webcodein.admin.service.UserDbService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getAll(){
        return Response.ok(this.userDbService.getUserList(), MediaType.APPLICATION_JSON).build();
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid UserDto userDto) throws Exception {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "REST request to save the user : {}", userDto);
        UserDto resultedUserDto = userDbService.create(userDto);
        return Response.ok(resultedUserDto, MediaType.APPLICATION_JSON).build();
    }
}

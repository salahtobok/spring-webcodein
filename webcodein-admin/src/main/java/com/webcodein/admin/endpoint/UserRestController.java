package com.webcodein.admin.endpoint;


import com.webcodein.admin.dto.RestResponse;
import com.webcodein.admin.dto.UserDto;
import com.webcodein.admin.enums.RestResponseMessage;
import com.webcodein.admin.service.UserDbService;
import com.webcodein.admin.util.ExceptionUtils;
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
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok(this.userDbService.getUserList(), MediaType.APPLICATION_JSON).build();
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@Valid UserDto userDto) throws Exception {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "REST request to save the user");
        UserDto resultedUserDto = userDbService.create(userDto);
        return Response.ok(resultedUserDto, MediaType.APPLICATION_JSON).build();
    }


    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@Valid UserDto userDto) throws Exception {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "REST request to update the user");
        UserDto resultedUserDto = userDbService.update(userDto);
        System.out.println("resultedUserDto = " + resultedUserDto);
        return Response.ok(resultedUserDto, MediaType.APPLICATION_JSON).build();
    }


    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@Valid UserDto userDto) throws Exception {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "REST request to delete the user");
        try {
            userDbService.delete(userDto);
            return Response.ok().build();
        } catch (Throwable throwable) {
            return Response.ok(new RestResponse(RestResponseMessage.ERROR_WHILE_DELETING_USER.name(),
                    ExceptionUtils.getRootCause(throwable).getMessage()), MediaType.APPLICATION_JSON).build();
        }
    }
}

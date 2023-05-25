package com.admin.webcodein;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.admin.webcodein.business.controller.UserWebController;
import com.admin.webcodein.business.service.UserDbService;
import com.admin.webcodein.data.entity.User;
import com.admin.webcodein.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserWebController.class)
public class UserWebControllerTest {

    @MockBean
    private UserDbService userDbService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUsers() throws Exception {
        String dateString = "2020-01-01";

        Date date = DateUtils.createDateFromDateString(dateString);
        List<User> users = new ArrayList<>();

        User user = new User();
        users.add(user);

        given(userDbService.getUserList()).willReturn(users);
        this.mockMvc.perform(get("/users?date=2020-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit, Junit")));

    }

}
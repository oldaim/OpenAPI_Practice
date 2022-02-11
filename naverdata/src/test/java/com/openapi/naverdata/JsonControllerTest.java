package com.openapi.naverdata;


import com.openapi.naverdata.controller.JsonController;
import com.openapi.naverdata.dto.SearchData;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JsonController.class)
@WebMvcTest(JsonController.class)
public class JsonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JsonController jsonController;

    @Test
    public String callApiTest() throws Exception {
        return "hello";
    }

}
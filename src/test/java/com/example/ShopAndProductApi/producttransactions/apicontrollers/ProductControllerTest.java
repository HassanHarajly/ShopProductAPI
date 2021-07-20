package com.example.ShopAndProductApi.producttransactions.apicontrollers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    void getAllProducts() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/api/v1/getAllShops")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].shop_name").exists());
    }
}
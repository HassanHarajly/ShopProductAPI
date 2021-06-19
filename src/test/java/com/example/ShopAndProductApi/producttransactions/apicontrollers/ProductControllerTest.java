package com.example.ShopAndProductApi.producttransactions.apicontrollers;

import com.example.ShopAndProductApi.ModelsAndEntities.Shop;
import com.example.ShopAndProductApi.ModelsAndEntities.shopWithoutDistance;
import com.example.ShopAndProductApi.shoptransactions.apicontrollers.ShopController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

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
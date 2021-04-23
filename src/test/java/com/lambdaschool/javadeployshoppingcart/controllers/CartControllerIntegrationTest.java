package com.lambdaschool.javadeployshoppingcart.controllers;


import com.lambdaschool.javadeployshoppingcart.JavaDeployshoppingcartApplication;
import com.lambdaschool.javadeployshoppingcart.models.CartItem;
import com.lambdaschool.javadeployshoppingcart.services.CartItemService;
import com.lambdaschool.javadeployshoppingcart.services.ProductService;
import com.lambdaschool.javadeployshoppingcart.services.RoleService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = JavaDeployshoppingcartApplication.class)
@AutoConfigureMockMvc
@WithUserDetails(value = "barnbarn")
public class CartControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listCartItemsByUserId() {
        given().when()
                .get("/carts/user")
                .then()
                .body(containsString("barnbarn"));
    }

    @Test
    public void addToCart() {
        given().when()
                .put("/carts/add/product/6")
                .then()
                .body(containsString("5"));
    }

    @Test
    public void removeFromCart() {
    }
}
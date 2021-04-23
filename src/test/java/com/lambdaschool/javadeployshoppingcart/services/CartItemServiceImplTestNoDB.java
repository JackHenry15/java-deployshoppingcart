package com.lambdaschool.javadeployshoppingcart.services;

import com.lambdaschool.javadeployshoppingcart.JavaDeployshoppingcartApplication;
import com.lambdaschool.javadeployshoppingcart.models.Product;
import com.lambdaschool.javadeployshoppingcart.models.User;
import com.lambdaschool.javadeployshoppingcart.repository.CartItemRepository;
import com.lambdaschool.javadeployshoppingcart.repository.ProductRepository;
import com.lambdaschool.javadeployshoppingcart.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaDeployshoppingcartApplication.class,
properties = {"command.line.runner.enabled=false"})
public class CartItemServiceImplTestNoDB {
    private List<User> userList = new ArrayList<>();
    private List<Product> prodList = new ArrayList<>();

    @Autowired
    CartItemService cartItemService;

    @MockBean
    private UserRepository userrepos;

    @MockBean
    private ProductRepository prodrepos;

    @MockBean
    private CartItemRepository cartitemrepos;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addToCart() {
    }

    @Test
    public void removeFromCart() {
    }
}
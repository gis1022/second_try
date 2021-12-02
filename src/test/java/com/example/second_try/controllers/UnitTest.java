package com.example.second_try.controllers;

import com.example.second_try.entity.ClientEntity;
import com.example.second_try.entity.TransactionEntity;
import com.example.second_try.repository.ClientRepo;
import com.example.second_try.services.TransactionsService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class UnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TransactionController controller;
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void testController(){
        assertThat(controller).isNotNull();
    }
    @Test
    public void testRepo(){
        assertThat(clientRepo).isNotNull();
    }

    @Test
    public void testTransactionController2() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().is2xxSuccessful());
    }

}

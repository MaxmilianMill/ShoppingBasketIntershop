package com.example.shoppingbasket.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Autowired
    private MockMvc mvc;

    @MockBean
    ItemService itemService;

    private final ItemController itemController = new ItemController();

    // check if we get all items from the database
    @Test
    void getItems() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/allItems")
                .accept("application/json;charset=UTF-8");

        MvcResult result = mvc.perform(request).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("GET Request Successful! Status: " + status);

    }

    @Test
    void addNewItem() throws Exception {
        Item item = new Item();
        item.setItemID(1);
        item.setItemName("Sneakers");
        item.setItemPrice(100);
        item.setAmount(2);

        String input = mapToJson(item);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/addItem")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(input)).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("POST Request Successful! Status: " + status);

    }

    @Test
    void deleteItem() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.delete("/deleteItem/1")).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("DELETE Request Successful! Status: " + status);
    }

    @Test
    void updateItem() throws Exception {

        Item item = new Item();
        item.setAmount(10);

        String input = mapToJson(item);

        MvcResult result = mvc.perform(MockMvcRequestBuilders.put("/updateItem/1").contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("PUT Request Successful! Status: " + status);
    }
}
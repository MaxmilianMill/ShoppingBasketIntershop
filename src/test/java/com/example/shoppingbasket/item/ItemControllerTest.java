package com.example.shoppingbasket.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    // function to convert object to string
    protected String mapToJson(Object obj) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    // inject MockMvc
    @Autowired
    private MockMvc mvc;

    // Mock Service Layer functions
    @MockBean
    ItemService itemService;

    // check if we get all items from the database
    @Test
    void getItems() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/allItems")
                .accept("application/json;charset=UTF-8");

        MvcResult result = mvc.perform(request).andReturn();

        // check status of the request
        int status = result.getResponse().getStatus();
        // if status equals 200 --> request was successful
        assertEquals(200, status);

        System.out.println("GET Request Successful! Status: " + status);

    }

    // check if we can add a new item to the database
    @Test
    void addNewItem() throws Exception {
        // new item
        Item item = new Item();
        item.setItemID(1);
        item.setItemName("Sneakers");
        item.setItemPrice(100);
        item.setAmount(2);

        // convert item into string that can be used for request
        String input = mapToJson(item);

        // send request
        RequestBuilder request = MockMvcRequestBuilders.post("/addItem")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(input);

        // get response
        MvcResult result = mvc.perform(request).andReturn();

        // check request status --> 200 = successful
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("POST Request Successful! Status: " + status);

    }

    // check if we can delete an item
    @Test
    void deleteItem() throws Exception{

        // send request
        RequestBuilder request = MockMvcRequestBuilders.delete("/deleteItem/1");

        // get response
        MvcResult result = mvc.perform(request).andReturn();

        // check status if its 200
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("DELETE Request Successful! Status: " + status);
    }

    // check if we can update and existing item
    @Test
    void updateItem() throws Exception {

        Item item = new Item();
        item.setAmount(10);

        // convert item data into string for http request
        String input = mapToJson(item);

        // send request to update item 1
        RequestBuilder request = MockMvcRequestBuilders.put("/updateItem/1")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(input);

        // get the response
        MvcResult result = mvc.perform(request).andReturn();

        // check if the response was successful
        int status = result.getResponse().getStatus();
        assertEquals(200, status);

        System.out.println("PUT Request Successful! Status: " + status);
    }
}
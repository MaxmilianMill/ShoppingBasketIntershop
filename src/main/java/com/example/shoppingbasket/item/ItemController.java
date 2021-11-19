package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "api/v1/item")
@RestController
public class ItemController {

    private final ItemApplication itemApplication;

    @Autowired
    public ItemController(ItemApplication itemApplication) {
        this.itemApplication = itemApplication;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemApplication.getItems();
    }
}

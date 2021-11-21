package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public Iterable<Item> getItems() {
        return itemService.findAll();
    }
}

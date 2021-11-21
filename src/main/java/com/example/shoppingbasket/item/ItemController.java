package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/v1")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/item")
    public Iterable<Item> getItems() {
        return itemService.findAll();
    }

    @PostMapping
    public void addNewItem(@RequestBody Item item) {
        itemService.addItem(item);
    }
}

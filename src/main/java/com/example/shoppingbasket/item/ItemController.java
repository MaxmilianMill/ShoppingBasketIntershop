package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "api/v1")
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public Iterable<Item> getItems() {
        return itemService.findAll();
    }

    @PostMapping
    public void addNewItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @DeleteMapping(path = "{itemID}")
    public void deleteItem(@PathVariable("itemID") Integer itemID) {
        itemService.deleteItem(itemID);
    }

    @PutMapping(path = "{itemID}")
    public void updateItem(@PathVariable("itemID") Integer itemID,
                           @RequestParam(required = false) Integer amount) {

        itemService.updateItem(itemID, amount);
    }
}

package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/allItems")
    public Iterable<Item> getItems() {
        return itemService.findAll();
    }

    @PostMapping("/addItem")
    public void addNewItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @DeleteMapping(path = "/deleteItem/{itemID}")
    public void deleteItem(@PathVariable("itemID") Integer itemID) {

        itemService.deleteItem(itemID);
    }

    @PutMapping(path = "/updateItem/{itemID}")
    public void updateItem(@PathVariable("itemID") Integer itemID,
                           @RequestParam(required = false) Integer amount) {

        itemService.updateItem(itemID, amount);
    }
}

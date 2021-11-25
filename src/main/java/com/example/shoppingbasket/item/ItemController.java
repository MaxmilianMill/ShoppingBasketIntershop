package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Controller for REST calls
@RequestMapping
@RestController
public class ItemController {

    // inject Service layer functionality
    @Autowired
    ItemService itemService;

    // GET request
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/allItems")
    public Iterable<Item> getItems() {
        // display all items in the database
        return itemService.findAll();
    }

    // POST request
    @PostMapping("/addItem")
    public void addNewItem(@RequestBody Item item) {
        // add item inside the http request into database
        itemService.addItem(item);
    }

    // DELETE request
    @DeleteMapping(path = "/deleteItem/{itemID}")
    public void deleteItem(@PathVariable("itemID") Integer itemID) {

        itemService.deleteItem(itemID);
    }

    // PUT request
    @PutMapping(path = "/updateItem/{itemID}")
    public void updateItem(@PathVariable("itemID") Integer itemID,
                           @RequestParam(required = false) Integer amount) {

        // change amount of item
        itemService.updateItem(itemID, amount);
    }
}

package com.example.shoppingbasket.item;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemApplication {

    public List<Item> getItems() {

        return List.of(new Item(1,
                "Black Jeans",
                59.99F,
                2));
    }
}

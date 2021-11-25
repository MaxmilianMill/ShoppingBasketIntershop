package com.example.shoppingbasket.item;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;
import java.util.Optional;

// test service layer
@ExtendWith(SpringExtension.class)
class ItemServiceTest {

    // mock Repository functions into Service layer
    @MockBean
    ItemRepository itemRepository;

    // test save call --> create new item and save it into database
    @Test
    void save() {

        Item item = new Item("T-Shirt", 20, 1);

        itemRepository.save(item);

    }

    // test addItem call --> create item check if the id is already in the database otherwise save the item
    @Test
    void addItem() {

        Item item = new Item("Black Pants", 50, 2);

        Optional<Item> itemOptional = itemRepository.findById(item.getItemID());

        if (itemOptional.isPresent()) {
            throw new IllegalStateException("Item has already been added");
        }

        itemRepository.save(item);
    }

    // test deleteItem call --> check if ID exists and delete it
    @Test
    void deleteItem() {

        int itemID = 10;
        boolean itemExists = itemRepository.existsById(itemID);

        // check if it does not exist
        if (itemExists) {
            throw new IllegalStateException("Item with ID " + itemID + " does not exist");
        }

        itemRepository.deleteById(itemID);
    }

    // test updateItem call --> create new item and check if the amount is different from the default
    @Test
    void updateItem() {

        Item item = new Item("Cap", 50, 3);
        int amount = 5;

        if (amount != 0 && amount > 0 && !Objects.equals(item.getAmount(), amount)) {

            item.setAmount(amount);
    }
}}
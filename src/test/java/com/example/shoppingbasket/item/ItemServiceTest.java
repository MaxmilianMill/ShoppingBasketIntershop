package com.example.shoppingbasket.item;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ItemServiceTest {

    @InjectMocks
    ItemService itemService;

    @MockBean
    ItemRepository itemRepository;

    @Test
    void save() {

        Item item = new Item("T-Shirt", 20, 1);

        itemRepository.save(item);

    }

    @Test
    void addItem() {

        Item item = new Item("Black Pants", 50, 2);

        Optional<Item> itemOptional = itemRepository.findById(item.getItemID());

        if (itemOptional.isPresent()) {
            throw new IllegalStateException("Item has already been added");
        }

        itemRepository.save(item);
    }

    @Test
    void deleteItem() {

        int itemID = 10;
        boolean itemExists = itemRepository.existsById(itemID);

        if (itemExists) {

            throw new IllegalStateException("Item with ID " + itemID + " already exists");
        }

        itemRepository.deleteById(itemID);
    }

    @Test
    void updateItem() {

        Item item = new Item("Cap", 50, 3);
        int amount = 5;

        if (amount != 0 && amount > 0 && !Objects.equals(item.getAmount(), amount)) {

            item.setAmount(amount);
    }
}}
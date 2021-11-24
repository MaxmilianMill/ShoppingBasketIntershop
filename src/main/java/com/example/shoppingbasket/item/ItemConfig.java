package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class ItemConfig {

    @Autowired
    ItemService itemService;

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository itemRepository) {
        return args -> {
            insertItem("Jacket", (float) 129.99, 1);
            insertItem("Sneakers", 90, 2);
            insertItem("Pants", 65, 1);
            insertItem("Gloves", (float) 19.99, 3);
            insertItem("Beanie", 20, 2);
        };
    }

    private void insertItem(String name, float price, int amount) {

        itemService.addItem(new Item(
                name,
                price,
                amount
        ));
    }
}

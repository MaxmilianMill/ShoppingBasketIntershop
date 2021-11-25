package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
public class ItemConfig {

    // inject Service layer functions
    @Autowired
    ItemService itemService;

    // create bean that runs when application starts
    @Bean
    CommandLineRunner commandLineRunner(ItemRepository itemRepository) {
        return args -> {
            // insert some sample items into shopping basket
            insertItem("Jacket", (float) 129.99, 1);
            insertItem("Sneakers", 90, 2);
            insertItem("Pants", 65, 1);
            insertItem("Gloves", (float) 19.99, 3);
            insertItem("Beanie", 20, 2);
        };
    }

    // function to add items into the database
    private void insertItem(String name, float price, int amount) {

        itemService.addItem(new Item(
                name,
                price,
                amount
        ));
    }
}

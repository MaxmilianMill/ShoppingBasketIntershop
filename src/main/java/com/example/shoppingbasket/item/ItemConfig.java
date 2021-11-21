package com.example.shoppingbasket.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository itemRepository) {
        return args -> {
            Item jeans = new Item(
                    1,
                    "Jeans",
                    49,
                    2
            );

            itemRepository.save(jeans);
        };
    }
}

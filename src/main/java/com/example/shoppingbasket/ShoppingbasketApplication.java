package com.example.shoppingbasket;

import com.example.shoppingbasket.item.Item;
import com.example.shoppingbasket.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.InputStream;

@SpringBootApplication
public class ShoppingbasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingbasketApplication.class, args);

	}

}

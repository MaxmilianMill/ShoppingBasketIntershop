package com.example.shoppingbasket;

import com.example.shoppingbasket.item.Item;
import com.example.shoppingbasket.item.ItemConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
public class ShoppingbasketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingbasketApplication.class, args);

	}

}

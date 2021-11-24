package com.example.shoppingbasket.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories(basePackages = {"pl.springBootStarter.app"})
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

}

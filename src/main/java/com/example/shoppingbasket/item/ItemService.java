package com.example.shoppingbasket.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService implements ItemRepository{

    @Autowired
    ItemRepository itemRepository;

    public <S extends Item> S save(S entity) { return itemRepository.save(entity); }

    public <S extends Item> Iterable<S> saveAll(Iterable<S> entities) {
        return itemRepository.saveAll(entities);
    }

    public Optional<Item> findById(Integer integer) {
        return itemRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return itemRepository.existsById(integer);
    }

    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    public Iterable<Item> findAllById(Iterable<Integer> integers) {
        return itemRepository.findAllById(integers);
    }

    public long count() {
        return itemRepository.count();
    }

    public void deleteById(Integer integer) {
        itemRepository.deleteById(integer);
    }

    public void delete(Item entity) {
        itemRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        itemRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Item> entities) {
        itemRepository.deleteAll(entities);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }

    public void addItem(Item item) {
        Optional<Item> itemOptional = itemRepository.findById(item.getItemID());

        if (itemOptional.isPresent()) {
            throw new IllegalStateException("Item has already been added");
        }

        itemRepository.save(item);
    }

    public void deleteItem(Integer itemID) {
        boolean itemExists = itemRepository.existsById(itemID);

        if (!itemExists) {

            throw new IllegalStateException("Item with ID " + itemID + " does not exist");
        }

        itemRepository.deleteById(itemID);
    }

    @Transactional
    public void updateItem(Integer itemID, Integer amount) {

        Item item = itemRepository.findById(itemID)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with ID " + itemID + " does not exist"
                ));

        if (amount != null && amount > 0 && !Objects.equals(item.getAmount(), amount)) {

            item.setAmount(amount);
        }
    }
}

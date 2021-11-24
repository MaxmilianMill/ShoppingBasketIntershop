package com.example.shoppingbasket.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private int itemID;

    private String itemName;
    private float itemPrice;
    private int amount;
    private float sum;

    public Item() {

    }

    // constructor class for item
    protected Item(String itemName, float itemPrice, int amount) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.amount = amount;
        this.sum = (long) (this.itemPrice * this.amount);
    }

    // Following will be all Getter and Setter methods for the variables assigned in the constructor method
    public int getItemID() { return itemID; }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;

        setSum(amount * getItemPrice());
    }

    public float getSum() { return sum; }

    public void setSum(float sum) { this.sum = sum; }
}

package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public abstract class Product {


    // Variables
    public String name;
    public BigDecimal price;
    private int inStockItems;


    // Constructors
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.inStockItems = 5;
    }

    public Product() {

    }

    public abstract String getMessage();

    // Override Method
    @Override
    public String toString() {
        String result = name + " " + price;
        return result;
    }


    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public int getInStockItems() {
//        int i;
//        for (i = 5; i > 0; i--) {
//        }
        return inStockItems;
    }

    public int decrementInStockItems(){
        inStockItems = inStockItems - 1;
        return inStockItems;
    }

    public void setInStockItems(int inStockItems) {
        this.inStockItems = inStockItems;
    }

    public String getPriceAsString() {
        return String.valueOf(price);
    }

    public abstract Product get(int i);
}



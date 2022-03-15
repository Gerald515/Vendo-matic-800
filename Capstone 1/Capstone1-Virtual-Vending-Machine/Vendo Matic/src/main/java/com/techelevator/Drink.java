package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Product {
    //Constructor
    public Drink(String name, BigDecimal price) {
        super(name, price);

    }

    // Method
    public String getMessage() {

        return "Glug Glug, Yum!";
    }

    @Override
    public Product get(int i) {
        return null;
    }

}


package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Product  {
    // Constructor
        public Candy(String name, BigDecimal price) {
            super(name, price);

        }
        // Method to get a message if selected
        public String getMessage() {

            return "Munch Munch, Yum";
        }

    @Override
    public Product get(int i) {
        return null;
    }

}


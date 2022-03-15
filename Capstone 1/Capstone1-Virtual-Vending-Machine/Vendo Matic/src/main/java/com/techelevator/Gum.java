package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Product {

    // Constructor
        public Gum(String name, BigDecimal price) {
            super(name, price);
        }
// getMessage Method
        @Override
        public String getMessage() {

            return "Chew Chew, Yum!";
        }

    @Override
    public Product get(int i) {
        return null;
    }


}




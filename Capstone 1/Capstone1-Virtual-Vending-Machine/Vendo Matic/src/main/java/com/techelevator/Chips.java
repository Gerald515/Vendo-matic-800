package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Product{

    public Chips(String name, BigDecimal bigDecimal) {
        super(name, bigDecimal);
    }


    @Override
    public String getMessage() {

        return "Crunch Crunch, Yum!";
    }

    @Override
    public Product get(int i) {
        return null;
    }

}


package com.techelevator;


import java.math.BigDecimal;

public class ChangeBack {

    private double balance1;
    private int quarters;
    private int dimes;
    private int nickels;

    public BigDecimal giveChange(BigDecimal balance) {

      //  balance = BigDecimal.valueOf(0.0);

        balance1 = (balance.doubleValue() * 100);
        quarters = ((int) balance1 / 25);
        balance1 = (balance1 - (quarters * 25));
        dimes = ((int) balance1 / 10);
        balance1 = (balance1 - (dimes * 10));
        nickels = ((int) balance1 / 5);

        System.out.println("              ");
        System.out.println(
                "Your change is " + quarters + " quarters and " + dimes + " dimes and " + nickels + " nickels. ");
        return balance;
    }

        // constructor
    public ChangeBack() {

        }
    }


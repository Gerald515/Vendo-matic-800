package com.techelevator;

import java.io.FileNotFoundException;

public interface VendingMachine {

    void feedMoney(int i);

    void purchase(String guestSelection);

    void completeTransaction();

    void selectProducts();

    void displayInventory();
}

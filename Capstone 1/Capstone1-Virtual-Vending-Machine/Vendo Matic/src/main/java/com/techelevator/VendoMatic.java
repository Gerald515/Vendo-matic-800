package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

// actual machine
// logic for function in vending machine interface

public class VendoMatic implements VendingMachine {

    BigDecimal balance = new BigDecimal(0.00).setScale(2);
    List<Product> purchaseList = new ArrayList<>();
    Map<String, Product> inventory = new TreeMap<>();
    LogWriter writer = new LogWriter();

    public VendoMatic(Map<String, Product> inventory) {
        this.inventory = inventory;
    }


    public void feedMoney(int addMoney) {
        String typeOfTransaction = "FEED MONEY:";
        if (addMoney == 1) {
            balance = balance.add(new BigDecimal(1.00));
            writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

        } else if (addMoney == 2) {
            balance = balance.add(new BigDecimal(2.00));
            writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);
        } else if (addMoney == 3) {
            balance = balance.add(new BigDecimal(5.00));
            writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);
        } else if (addMoney == 4) {
            balance = balance.add(new BigDecimal(10.00));
            writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);
        }
        System.out.println("Your balance is " + balance);
    }

    public void completeTransaction() {
        ChangeBack thisChange = new ChangeBack();
        System.out.println("       ");
        System.out.println("Enjoy!");
        writer.writer("GIVE CHANGE:", balance, new BigDecimal(0.00).setScale(2));
        while (purchaseList.size() > 0) {
            Product purchases = purchaseList.remove(0);
            System.out.println(purchases.getMessage());
        }
        thisChange.giveChange(balance);
    }

    @Override
    public void selectProducts() {
        System.out.println("Please Select Product");
        Scanner in = new Scanner(System.in);
        String userSelection = in.nextLine();
        purchase(userSelection);
        System.out.println();
    }

    @Override
    public void displayInventory() {

        for (Map.Entry<String, Product> entry : this.inventory.entrySet()) {
            Product item = entry.getValue();
            String formattedString = String.format("%-5s %-22s %-5s %-10s", entry.getKey(), item.getName(),
                    item.getPriceAsString(), item.getInStockItems() > 0 ? item.getInStockItems() : "Sold Out");

            System.out.println(formattedString);
        }
    }

    private String displayCurrentBalance() {
        return "Your Current Balance is: " + balance;
    }


    public void purchase(String guestSelection) {

        if (!inventory.containsKey(guestSelection)) { // if the inventory doesnt contin the key in the file from the user input then display this
            System.out.println("Sorry that product does not exist, please choose a valid product");
        }
        if (inventory.containsKey(guestSelection)) { // if the items in inventory but the inventory equals zero the sau sold out
            if (inventory.get(guestSelection).getInStockItems() == 0) {
                System.out.println("Sorry out of stock");
            }
            if (inventory.get(guestSelection).getInStockItems() >= 1) {
                if (balance.compareTo(inventory.get(guestSelection).price) >= 0) {
                    balance = balance.subtract(inventory.get(guestSelection).price);
                    Product product = inventory.get(guestSelection);
                    product.decrementInStockItems();
                    purchaseList.add(product);
                    System.out.println(product.getMessage());
// I need to lower inventory everytime you make a purchase
                    BigDecimal costOne = product.price;
                    String productOne = product.getName() + " " + guestSelection;
                    writer.writer(productOne, costOne, balance);
                } else {
                    System.out.println("                                      ");
                    System.out.println("Insufficient Funds! Join Merit America Now!");
                }
            }
        }
        System.out.println("                          ");
        System.out.println("Your balance is " + balance);

    }
}


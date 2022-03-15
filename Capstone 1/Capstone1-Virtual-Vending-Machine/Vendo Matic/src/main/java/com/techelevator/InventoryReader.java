package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class InventoryReader {

    public Map<String, Product> fileImporter(String guestSelection) {
        File inventoryFile = new File("/Users/sandee/Desktop/Repos/Capstone/capstone/vendingmachine.csv");

        Map<String, Product> vendingMachineInventory = new TreeMap<>();

        try (Scanner stockImporter = new Scanner(inventoryFile)) {
            while (stockImporter.hasNextLine()) {
                String line = stockImporter.nextLine();
                if (!line.isEmpty()) {
                    String[] stockImporterArray = line.split("\\|");
                    BigDecimal price = new BigDecimal(stockImporterArray[2]);

                    if (stockImporterArray[0].contains("A")) {
                        Chips bagOfChips = new Chips(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], bagOfChips);

                    } else if (stockImporterArray[0].contains("B")) {
                        Candy candyBar = new Candy(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], candyBar);

                    } else if (stockImporterArray[0].contains("C")) {
                        Drink soda = new Drink(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], soda);

                    } else if (stockImporterArray[0].contains("D")) {
                        Gum packOfGum = new Gum(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], packOfGum);
                    }
                }
            }
            return vendingMachineInventory;

        } catch (FileNotFoundException e) {
            System.out.println("Your file does not exist");
            System.exit(1);
            return vendingMachineInventory;
        }
    }

    public Map<String, Product> fileImporter() {
        File inventoryFile = new File("/Users/sandee/Desktop/Repos/Capstone/capstone/vendingmachine.csv");

        Map<String, Product> vendingMachineInventory = new TreeMap<>();

        try (Scanner stockImporter = new Scanner(inventoryFile)) {
            while (stockImporter.hasNextLine()) {
                String line = stockImporter.nextLine();
                if (!line.isEmpty()) {
                    String[] stockImporterArray = line.split("\\|");
                    BigDecimal price = new BigDecimal(stockImporterArray[2]);

                    if (stockImporterArray[0].contains("A")) {
                        Chips bagOfChips = new Chips(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], bagOfChips);

                    } else if (stockImporterArray[0].contains("B")) {
                        Candy candyBar = new Candy(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], candyBar);

                    } else if (stockImporterArray[0].contains("C")) {
                        Drink soda = new Drink(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], soda);

                    } else if (stockImporterArray[0].contains("D")) {
                        Gum packOfGum = new Gum(stockImporterArray[1], price);
                        vendingMachineInventory.put(stockImporterArray[0], packOfGum);
                    }
                }
            }
            return vendingMachineInventory;

        } catch (FileNotFoundException e) {
            System.out.println("Your file does not exist");
            System.exit(1);
            return vendingMachineInventory;

        }
    }
}





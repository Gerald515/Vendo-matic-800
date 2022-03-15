package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

    // Constant Variables

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items"; // given
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase"; // given
    private static final String EXIT_THE_SCREEN = "Exit";  // Added another static  variable to add to the menu
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_THE_SCREEN}; //main menu list options
    // added a sub menu for the MAIN_MENU_OPTION_PURCHASE so user can enter money and select their product
    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed money";
    private static final String SUB_MENU_OPTION_SELECTPRODUCT = "Select Product";
    private static final String SUB_MENU_OPTION_END = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECTPRODUCT,
            SUB_MENU_OPTION_END}; // Array of sub menu
    // variables for money menu
    private static final String MONEY_MENU_OPTION_ONE = "Feed 1 dollar";
    private static final String MONEY_MENU_OPTION_TWO = "Feed 2 dollars";
    private static final String MONEY_MENU_OPTION_FIVE = "Feed 5 dollars";
    private static final String MONEY_MENU_OPTION_TEN = "Feed 10 dollars";
    private static final String[] MONEY_MENU_OPTIONS = {MONEY_MENU_OPTION_ONE, MONEY_MENU_OPTION_TWO,
            MONEY_MENU_OPTION_FIVE, MONEY_MENU_OPTION_TEN}; // money menu array

    private Menu menu;
    private Map<String, Product> inventoryMap;
    VendingMachine vendingMachine;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }


    // runs the vending machine and takes in user input?
    public void run() throws IOException {
        InventoryReader inventoryReader = new InventoryReader();
        inventoryMap = inventoryReader.fileImporter();
        vendingMachine = new VendoMatic(inventoryMap);

        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                System.out.println("******************************************");
                System.out.println("      WELCOME TO THE VENDING MACHINE      ");
                System.out.println("******************************************");

                System.out.println("            Products Available:           ");
                System.out.println("                                          ");
                vendingMachine.displayInventory(); // displays products from new vending machine

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                while (true) {
                    String submenuChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
                    if (submenuChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
                        String moneyMenuChoice = (String) menu.getChoiceFromOptions(MONEY_MENU_OPTIONS);

                        if (moneyMenuChoice.equals(MONEY_MENU_OPTION_ONE)) {
                            vendingMachine.feedMoney(1);
                        } else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TWO)) {
                            vendingMachine.feedMoney(2);
                        } else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_FIVE)) {
                            vendingMachine.feedMoney(3);
                        } else if (moneyMenuChoice.equals(MONEY_MENU_OPTION_TEN)) {
                            vendingMachine.feedMoney(4);
                        }


                    } else if (submenuChoice.equals(SUB_MENU_OPTION_SELECTPRODUCT)) {
                        System.out.println("******************************************");
                        System.out.println("      WELCOME TO THE VENDING MACHINE      ");
                        System.out.println("******************************************");

                        System.out.println("            Products Available:           ");
                        System.out.println("                                          ");
                        vendingMachine.displayInventory();
                        vendingMachine.selectProducts();

                    } else if (submenuChoice.equals(SUB_MENU_OPTION_END)) {
                        vendingMachine.completeTransaction();
                        break;
                        // do purchase
            } else if (choice.equals(EXIT_THE_SCREEN)) { // exit screen display message
                        System.out.println("Thank You For Visiting The VENDO-MATIC!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(System.in, System.out); // create a new menu users can select from
        VendingMachineCLI cli = new VendingMachineCLI(menu); // create a vending machine open with a menu
        InventoryReader inventoryReader = new InventoryReader();
        cli.run(); // tell vending machine to run

    }

}



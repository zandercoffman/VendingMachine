import java.util.Scanner;
/**
 * This file is the main class that impliments the Vending Machine class. 
 * At first it asks for the amount of money that the user inputs with coins.
 * 
 * Then it asks for input on what command the user wants to put next.
 * The choices can either be "add item\", "buy item", "view items", "amount of items", "view inventory", "add money", "view money", or "quit".
 * Each choice leads to its specific function that calculcates the given input based on four placeholder variables
 * listed in the main method below. The functions depend on a boolean called run which dictates whether the rest of the code can run.
 * @author s26600042 (Zander Coffman)
 */
public class VendingMachineTester 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int input_1 = 0; //placeholder for input(s)
        int input_2 = 0; //placeholder for input(s)
        double input_3 = 0; //placeholder for input(s)
        String input_4 = ""; //placeholder for input(s)
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("How many pennies would you like to insert in the vending machine?");
        int pennies = scan.nextInt();
        System.out.println("How many quarters would you like to insert in the vending machine?");
        int quarters = scan.nextInt();
        System.out.println("How many dimes would you like to insert in the vending machine?");
        int dimes = scan.nextInt();
        System.out.println("How many nickels would you like to insert in the vending machine?");
        int nickels = scan.nextInt();
        VendingMachine machine = new VendingMachine(pennies, nickels, dimes, quarters);
        while (run)
        {
            System.out.println("What would you like to do next?");
            System.out.println();
            System.out.println("Commands:\n\"add item\"\n\"add cans\"\n\"buy item\"\n\"view items\"\n\"amount of items\"\n\"view inventory\"\n\"add money\"\n\"view money\"\n\"quit\"");
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String option = scan.nextLine();

            if (option.equalsIgnoreCase("buy item"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                if (machine.getAmountOfItems() < 1)
                {
                    System.out.println("Error! Not enough items.");
                }
                else
                {
                    System.out.println();
                    System.out.println("What is the index of the product you want to buy?");
                    input_1 = scan.nextInt();
                    System.out.println("How much of these would you like to buy?");
                    input_2 = scan.nextInt();
                    System.out.println();

                    if (input_2 <= 0)
                    {
                        System.out.println("Not a valid response.");
                    }
                    else
                    {
                        System.out.println(machine.buyItem(input_1, input_2));
                    }
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("add item"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("What is the name of the item you want to add?");
                input_4 = scan.nextLine();
                System.out.println();
                System.out.println("What shall be the price of this item?");
                input_3 = scan.nextDouble();
                System.out.println();
                System.out.println("How many of these do you want to sell?");
                input_2 = scan.nextInt();
                System.out.println();

                System.out.println(machine.addItem(input_4, input_3, input_2));
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("add cans"))
            {
            	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            	System.out.println("What is the index you would like to add cans to?");
            	input_1 = scan.nextInt();
            	System.out.println("How many cans would you like to add?");
            	input_2 = scan.nextInt();
            	System.out.println();
            	System.out.println(machine.addCans(input_1, input_2));
            	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("view items"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                System.out.println("What is the index of the item you would like to look at?");
                System.out.println("Or type \"all\" to view all items.");

                input_4 = scan.nextLine();
                if (input_4.equalsIgnoreCase("all"))
                {
                    System.out.println();
                    System.out.println(machine.returnAll());
                    System.out.println();
                }
                else
                {
                    System.out.println();
                    int input = Integer.parseInt(input_4);
                    System.out.println(machine.returnItem(input));
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("view inventory"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                //if nothing is in the inventory variable
                if (machine.getInventory().length < 1)
                {
                    System.out.println("There is nothing in your inventory!");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
                else
                {
                    for (String selection : machine.getInventory())
                    {
                        System.out.println(selection + " ,");
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                }
            }
            else if (option.equalsIgnoreCase("add money"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                System.out.println("What would you like to add?");
                System.out.println("\n\"quarter\"\n\"penny\"\n\"dime\"\n\"nickel\"\n");
                System.out.println();
                input_4 = scan.nextLine();
                System.out.println("How many " + input_4 + " would you like to add?");
                System.out.println();
                input_1 = scan.nextInt();

                switch (input_4)
                {
                    default:
                        System.out.println("Not a valid response! (Lowercase does matter)");
                        System.out.println();
                    case ("quarter"):
                        machine.addQuarters(input_1);
                        System.out.println("Successfully added " + input_1 + " " + input_4 + "(s) in the machine.");
                    case ("penny"):
                        machine.addPennies(input_1);
                        System.out.println("Successfully added " + input_1 + " " + input_4 + "(s) in the machine.");
                    case ("dime"):
                        machine.addDimes(input_1);
                        System.out.println("Successfully added " + input_1 + " " + input_4 + "(s) in the machine.");
                    case ("nickel"):
                        machine.addNickels(input_1);
                        System.out.println("Successfully added " + input_1 + " " + input_4 + "(s) in the machine.");
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("view money"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("$" + machine.getMoney() + "\nQuarters: " + machine.getQuarters() + "\nPennies: " + machine.getPennies()
                + "\nDimes: " + machine.getDimes() + "\nNickels: " + machine.getNickels());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("amount of items"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(machine.getAmountOfItems() + " items(s) are in the machine.");
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            else if (option.equalsIgnoreCase("quit"))
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
                run = false;
            }
        }
        scan.close();
    }
}
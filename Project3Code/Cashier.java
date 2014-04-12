import java.util.Scanner;
import java.text.*;      
import java.util.*;

/**
 * In this project, we simulate a small stand-alone
 * convenience store operation.
 *
 * @author Pratik Patel
 * @version Project 3 04/05/2014
 */

public class Cashier   {
    public static void main(String args[]) {
        final int MAXITEMS = 5;
        Scanner keyboard = new Scanner(System.in);
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Welcome to CS 140 Store Express Line");
        System.out.println("This line serves customers with " + MAXITEMS + " or fewer items");
        System.out.println("------------------------------------------------\n");

        Invoice invoice = new Invoice();
        do {
            System.out.println("\t1. Buy an item");
            System.out.println("\t2. Modify the quantity of an item");
            System.out.println("\t3. Show the items purchased so far");
            System.out.println("\t4. Done");
            System.out.println("\nYour choice: ");
            int choice = Integer.parseInt(keyboard.nextLine());
            switch(choice) {
                case 1:
                   if (invoice.getNumItems() < MAXITEMS) {
                       System.out.print("Enter the product name: ");
                       String name = keyboard.nextLine();

                       System.out.print("Enter the price: ");
                       double price = Double.parseDouble(keyboard.nextLine() );

                       System.out.print("How many of " + name + " did you buy? Please enter the quantity: ");
                       int quantity = Integer.parseInt(keyboard.nextLine() );
                       LineItem item = new LineItem(new Product(name, price), quantity);
                       invoice.addToInvoice(item);
                   }
                   else
                       System.out.println("This line is customers for <= " + MAXITEMS + " items only");
                   break;

                case 2:
                   System.out.println("Enter the name of the product");
                   String name = keyboard.nextLine();
                   System.out.println("Enter the new quantity: ");
                   int quantity = Integer.parseInt(keyboard.nextLine() );
                   invoice.update(name, quantity);
                   break;

                case 3:
                   invoice.print();
                   break;

                case 4:
                   System.out.println("Thanks for using CS 140 store");
                   System.out.println("Here is your invoice information");
                   System.out.println("--------------------------------");
                   invoice.print();
                   System.out.println("\nPlease come back again.  Have a nice day!");
                   System.exit(0);

                default:
                   System.out.println("Wrong choice.  Choose a valid option");
            }    // end of switch
        }  while (true);  // end of do - while loop
    }     // end of main method
}   // end of Cashier class

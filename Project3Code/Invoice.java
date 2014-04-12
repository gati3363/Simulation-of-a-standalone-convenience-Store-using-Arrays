import java.text.*;     
import java.util.*; 
/**
 * This class Creates an Invoice for a store
 * Collects the Products purchased by a customer.
 *
 * 
 * @author Pratik Patel
 * @version Project 3 04/05/2014
 */

public class Invoice
{
    LineItem [] products = new LineItem [10];
    private int count;
    
    
    /**
     * Adds a line item to this invoice.
     * 
     * @param anItem - Line Item added to the invoice.
     */
    public void addToInvoice (LineItem anItem)
    {
        products[count++] = anItem;
    }
    
    /**
     * Returns the number of line items in this invoice
     * 
     * @returns the number of LineItems in this invoice
     */
    public int getNumItems ()
    {
        return count;
    }
        
    /**
     * Returns the current running total.
     * 
     * @returns the current amount owed by the customer.
     */
    public double getRunningTotal ()
    {
        double total = 0;
        for (int i = 0; i < count; i++)
        {
            total += products[i].getQuantity()*products[i].getProduct().getPrice();
        }
        return total;
    }
    
   
    /**
     * This method Updates the quantity for a line item.
     * 
     * @param name - Name of the product
     * @param quantity - quantity
     */
    public void update (String name, int quantity)
    {
        for (int i = 0; i < count; i++)
        {
            if (products[i].getProduct().getName().contains(name)) 
            {
                if (quantity == 0) 
                {
                    removeFromInvoice(i);
                } 
                else 
                {
                    products[i].setQuantity(quantity);
                }
            }
        }
    }
    
     /**
     * Removes the previously added product.
     *
     */
    public void removeFromInvoice(int index) 
    {
        products[index] = products[count];
        count--;
    }
    
    /**
     * Prints invoice to the screen using the toString met.
     */
    
    public void print()
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < count ;i++)
        {
            result.append("\n");
			result.append("Product: " + this.products[i].getProduct().getName()+"\t\tPrice: $"+ this.products[i].getProduct().getPrice()+ "\t\tQuantity: "+ this.products[i].getQuantity());
        }
        System.out.print(result.toString());
		System.out.println("\n\t\t\tRunning Total: $" + getRunningTotal());
    }
    
}



/**
 * This class represents a line item in an Invoice which is receipt as well
 * 
 * 
 * @author Pratik Patel
 * @version Project 3 04/05/2014
 */

public class LineItem {

    Product product;
    int quantity;
    
    public LineItem() {
    }
    
     /**
     * Constructor - constructs which construct a new LineItem
     * 
     * @param Product -- Product for this line intem
     * @param quantity -- quantity of this product
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    
     /**
     * Returns the cusomter's amount for this line item.
     * 
     * @return Returns the amount owed by the customer. 
     */
    double getAmount()
    {
        return this.quantity * product.getPrice();
    }
    
    
    /**
     * Gets the Product of this line item.
     * 
     * @return Returns the Product of this line item.
     */
    Product getProduct()
    {
        return this.product;
    }
    

     /**
     * Gets the quantity for this line item.
     * 
     * @return Returns the quantity for this line item.
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Sets the quantity for this line item.
     * 
     * @param Sets the new quantity for this line item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Returns a string of this line item.
     * 
     * @overrides toString in Object
     * 
     * @return Returns a String representation of this line item.
     */
    @Override
    public String toString()
    {
        return "\nProduct Name = " + this.getProduct().getName() + " Price = " + this.getProduct().getPrice() + " Ordered Quantity = " + this.getQuantity() + " Total Ordered Amount(quantity * product price) = " + this.product.getPrice() * this.getQuantity();
    }
    
    
    
    
}

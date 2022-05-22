package supermarket.domain;

import java.util.Date;
import java.util.List;

/**
 * A class that represents an order.
 */
public class Order {

    // Declaring the variables that will be used in the class.
    private String id;
    private String date;
    private List<Product> productList;
    private float price;

    // This is a constructor. It is a special method that is called when an object
    // is created.
    public Order() {
        this.id = "22";
        this.date = "";
        this.price = 0;
    }

    // This is a constructor. It is a special method that is called when an object
    // is created.
    public Order(String date, List<Product> productList, float price) {
        this.date = date;
        this.productList = productList;
        this.price = price;
    }

    /**
     * > This function returns the id of the current object
     * 
     * @return The id of the object.
     */
    public String getId() {
        return this.id;
    }

    /**
     * This function sets the id of the object to the id passed in as a parameter
     * 
     * @param id The id of the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This function returns the date of the event
     * 
     * @return The date of the event.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * This function sets the date of the object.
     * 
     * @param date The date of the event.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This function returns a list of products.
     * 
     * @return A list of products.
     */
    public List<Product> getProductList() {
        return this.productList;
    }

    /**
     * The function takes a list of products and sets the productList variable to
     * that list
     * 
     * @param productList This is the list of products that will be displayed in the
     *                    table.
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * This function returns the price of the item.
     * 
     * @return The price of the item.
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * This function sets the price of the item.
     * 
     * @param price The price of the item.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * The toString() method returns a string representation of the object
     * 
     * @return The toString() method is being returned.
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", date='" + getDate() + "'" +
                ", productList='" + getProductList() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}

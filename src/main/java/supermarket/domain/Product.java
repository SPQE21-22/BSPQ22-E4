package supermarket.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 * It's a class that represents a product
 */
public class Product {

    // It's a class that represents a product
    private String id;
    private String category;
    private String name;
    private String brand;
    private int stock;
    private String expirationDate;
    private double discountPercentage;
    private double price;

    // It's a constructor.
    public Product(String category, String name, String brand, int stock, String expirationDate,
            double discountPercentage, double price) {
        this.category = category;
        this.name = name;
        this.brand = brand;
        this.stock = stock;
        this.expirationDate = expirationDate;
        this.discountPercentage = discountPercentage;
        this.price = price;
    }

    // It's a constructor.
    public Product() {
        this.id = "5";
        this.category = "category";
        this.name = "name";
        this.brand = "brand";
        this.stock = 10;
        this.expirationDate = "expirationDate";
        this.discountPercentage = 20;
        this.price = 20;
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
     * This function returns the category of the product
     * 
     * @return The category of the book.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * This function sets the category of the book
     * 
     * @param category The category of the product.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * This function returns the name of the person.
     * 
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This function sets the name of the object to the value of the parameter.
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function returns the brand of the car
     * 
     * @return The brand of the car.
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * This function sets the brand of the car.
     * 
     * @param brand The brand of the car.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This function returns the value of the stock variable.
     * 
     * @return The stock of the item.
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * This function sets the stock of the product to the value of the parameter.
     * 
     * @param stock The number of items in stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * This function returns the expiration date of the credit card
     * 
     * @return The expiration date of the credit card.
     */
    public String getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * This function sets the expiration date of the credit card
     * 
     * @param expirationDate The date the card expires.
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * This function returns the discount percentage of the current object.
     * 
     * @return The discount percentage.
     */
    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    /**
     * This function sets the discount percentage of the product.
     * 
     * @param discountPercentage The percentage of the discount.
     */
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    /**
     * This function returns the price of the item.
     * 
     * @return The price of the item.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This function sets the price of the item.
     * 
     * @param price The price of the item.
     */
    public void setPrice(double price) {
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
                ", category='" + getCategory() + "'" +
                ", name='" + getName() + "'" +
                ", brand='" + getBrand() + "'" +
                ", stock='" + getStock() + "'" +
                ", expirationDate='" + getExpirationDate() + "'" +
                ", discountPercentage='" + getDiscountPercentage() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

    /**
     * It returns a string that contains the name of the product, a dash, the price
     * of the product, and
     * the word "EUR"
     * 
     * @return The name of the product and the price.
     */
    public String toText() {
        return getName() + " - " + getPrice() + " EUR";
    }
}

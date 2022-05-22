/**
 * A User is a person who can buy products from the supermarket
 */
package supermarket.domain;

import java.util.List;

/**
 * The User class is a class that represents a user of the application
 */
public class User {
    private String id;
    private String email;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private String cardNumber;
    private String phoneNumber;
    private List<Order> orderList;

    // A constructor that takes in all the parameters of the class and sets them to
    // the class
    // variables.
    public User(String email, String username, String password, String name, String lastName, String address,
            String cardNumber, String phoneNumber, List<Order> orderList) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.cardNumber = cardNumber;
        this.phoneNumber = phoneNumber;
        this.orderList = orderList;
    }

    // A constructor that takes no parameters.
    public User() {

    }

    // This is a constructor that takes in two parameters and sets them to the class
    // variables.
    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
     * This function returns the email of the user
     * 
     * @return The email address of the user.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * This function sets the email of the user
     * 
     * @param email The email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This function returns the username of the user
     * 
     * @return The username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This function sets the username to the value of the parameter username.
     * 
     * @param username The username of the user to be created.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * > This function returns the password of the user
     * 
     * @return The password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * This function sets the password of the user.
     * 
     * @param password The password to use for the connection.
     */
    public void setPassword(String password) {
        this.password = password;
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
     * This function returns the last name of the person.
     * 
     * @return The last name of the person.
     */
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", email='" + getEmail() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", name='" + getName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", address='" + getAddress() + "'" +
                ", cardNumber='" + getCardNumber() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", orderList='" + getOrderList() + "'" +
                "}";
    }
}

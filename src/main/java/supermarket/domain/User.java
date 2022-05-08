package supermarket.domain;

import java.util.List;

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

    public User(String email, String username, String password, String name, String lastName, String address, String cardNumber, String phoneNumber, List<Order> orderList) {
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

    public User() {
        
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

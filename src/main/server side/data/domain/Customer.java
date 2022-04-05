public class Customer extends User{
    
    private String address;
    private String creditCard;
    private String phoneNumber;
    private List<Order> orderList;

    public Customer(String email, String username, String password, String address, String creditCard,
            String phoneNumber) {
        super(email, username, password);
        this.address = address;
        this.creditCard = creditCard;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCard() {
        return this.creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer address(String address) {
        setAddress(address);
        return this;
    }

    public Customer creditCard(String creditCard) {
        setCreditCard(creditCard);
        return this;
    }

    public Customer phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", email='" + getEmail() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            " address='" + getAddress() + "'" +
            ", creditCard='" + getCreditCard() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            "}";
    }
}

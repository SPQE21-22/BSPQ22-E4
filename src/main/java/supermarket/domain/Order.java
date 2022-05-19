package supermarket.domain;

import java.util.Date;
import java.util.List;

public class Order {
    
    private String id;
    private String date;
    private List<Product> productList;
    private float price;

    public Order() {
        this.id="22";
        this.date = "";
        this.price = 0;
    }

    public Order(String date, List<Product> productList, float price) {
        this.date = date;
        this.productList = productList;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

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

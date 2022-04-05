public class Order {
    
    private String code;
    private List<Product> productList;

    public Order() {
    }

    public Order(String code, List<Product> productList) {
        this.code = code;
        this.productList = productList;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", productList='" + getProductList() + "'" +
            "}";
    }
}

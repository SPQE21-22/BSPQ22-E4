import org.junit.Test;

import supermarket.db.Db;
import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

public class DbTest {
    private Db db = new Db();
    private List<User> userList;
    private List<Product> productList;
    private User user;
    private User userTemp2;
    private Product productTemp;
    private Order order;

    
    @Test
    public void testGetUser() {
        db.connect();
        user = new User("user1@mail.com", "juan", "pass123", "juan", "gil", "love st,123", "123456",
        "112233", null);
        User user2 = db.getUser(user.getUsername());

        assertEquals(user.getPassword(), user2.getPassword());
        db.disconnect();
    }
    
    @Test
    public void testGetAllUsers() {
        db.connect();
        user = new User("user1@mail.com", "juan", "pass123", "juan", "gil", "love st,123", "123456",
        "112233", null);
        System.out.println(user.toString());
        userList = new ArrayList<User>(db.getAllUsers());

        for (User user2 : userList) {
            System.out.println(user2.toString());
            if (user2.getUsername().equals(user.getUsername())) {
                assertEquals(user2.getPassword(), user.getPassword());
            }
        }
        db.disconnect();
    }
    
    @Test
    public void testAddUser() {
        db.connect();
        User userTemp = new User("user3@mail.com", "pablo", "root", "pablo", "sagredo", "rial st 122", "123456",
                "112233", null);
        db.addUser(userTemp);
        userTemp2 = db.getUser(userTemp.getUsername());
        assertEquals(userTemp.getPassword(), userTemp2.getPassword());
        db.disconnect();
    }

    @Test
    public void testGetProductList() {
        db.connect();
        productList = new ArrayList<Product>(db.getProductList());
        productTemp = new Product("category", "name", "brand", 33, "", 22, 11);

        for (Product product : productList) {
            if (product.getName().equals(productTemp.getName())) {
                assertEquals(product.getName(), productTemp.getName());
            }
        }
        db.disconnect();
    }

    @Test
    public void testAddOrder() {
        db.connect();
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("category", "chocokrispies", "brand", 33, "", 22, 11));
        user = db.getUser("sergio");
        order = new Order("2020/04/10", products, 3);
        db.addOrder(user.getId(), order);
        
        List<Order> orderList = new ArrayList<Order>(user.getOrderList());

        for (Order orderTemp2 : orderList) {
            if (orderTemp2.getDate() == order.getDate() && orderTemp2.getPrice() == order.getPrice()) {
                assertEquals(Float.valueOf(orderTemp2.getPrice()), Float.valueOf(order.getPrice()));
            }
        }
        db.disconnect();
    }

}

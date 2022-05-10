import org.junit.Test;

import supermarket.db.Db;
import supermarket.domain.Product;
import supermarket.domain.User;

import static org.junit.Assert.assertEquals;

import javax.xml.namespace.QName;

public class DbTest {
    private Db db;
    private List<User> userList;
    private List<Product> productList;
    private User user;
    private Product product;
    private Order order;

    @Test
    public void testGetUser() {
        db = Db.getInstance();
        user = new User("user2@mail.com", "sergio", "root", "sergio", "perez", "rial st 122", "123456",
        "112233");
        user2 = db.getUser(user.getUsername());

        assertEquals(user.getPassword(), user2.getPassword());
    }

    @Test
    public void testGetAllUsers() {
        db = Db.getInstance();
        userList = new ArrayList<User>(db.getAllUsers());

        for (User user2 : userList) {
            if (user2.getUsername().equals(user.getUsername())) {
                assertEquals(user2.getPassword(), user.getPassword());
            }
        }
    }
    
    @Test
    public void testAddUser() {
        db = Db.getInstance();
        User userTemp = new User("user3@mail.com", "pablo", "root", "pablo", "sagredo", "rial st 122", "123456",
                "112233");
        User userTemp2;
        db.addUser(userTemp);
        userTemp2 = db.getUser(userTemp.getUsername());
        assertEquals(userTemp.getPassword(), userTemp2.getPassword());
    }

    @Test
    public void testGetProductList() {
        db = Db.getInstance();
        productList = new ArrayList<Product>(db.getProductList());
        productTemp = new Product("category", "name", "brand", 33, new Date(), 22, 11);

        for (Product product : productList) {
            if (product.getName().equals(productTemp.getName())) {
                assertEquals(product.getName(), productTemp.getName());
            }
        }
    }

    @Test
    public void testAddOrder() {
        db = Db.getInstance();
        product = new Product("category", "chocokrispies", "brand", 33, new Date(), 22, 11);
        order = new Order(new Date(), new ArrayList<Product>(product), 22);

        db.addOrder("2", order);
        User userTemp = db.getUser("sergio");
        List orderList = new ArrayList<Order>(userTemp.getOrderList());

        for (Order orderTemp2 : orderList) {
            if (orderTemp2.getDate() == orderTemp.getDate() && orderTemp2.getPrice() == orderTemp.getPrice()) {
                assertEquals(orderTemp2.getPrice(), orderTemp.getPrice());
            }
        }
    }

}

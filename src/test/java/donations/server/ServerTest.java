package donations.server;

import org.junit.Test;
import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.server.SupermarketServer;

import org.junit.Before;
import supermarket.server.SupermarketService;

import static org.junit.Assert.assertEquals;


public class ServerTest {
    SupermarketServer supermarketServer;
    SupermarketService supermarketService;
    User user;
    Product product;
    Order order;

    @Before
    public void setUp() {
        supermarketServer = new SupermarketServer();
        supermarketService = new SupermarketService();
        user = new User("email", "username", "pass", "name", "lastName", "address", "cardNumber", "phoneNumber", null);
        product = new Product("category", "name", "brand", 1, null, 0, 0);
        order = new Order(null, null, 0);
    }

    @Test
    public void testUser() {
        assertEquals(new User("email", "username", "pass", "name", "lastName", "address", "cardNumber", "phoneNumber", null),user);
    }

    @Test
    public void testProduct() {
        assertEquals(new Product("category", "name", "brand", 1, null, 0, 0),product);
    }

    @Test
    public void testOrder() {
        assertEquals(new Order(null, null, 0),order);
    }
}
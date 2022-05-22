package donations.server;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import supermarket.client.Login;
import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.server.SupermarketServer;

import org.junit.Before;
import supermarket.server.SupermarketService;

import static org.junit.Assert.assertEquals;

public class ServerTest {
    private static final Logger logger = LogManager.getLogger(ServerTest.class);

    SupermarketServer supermarketServer;
    SupermarketService supermarketService;
    User user;
    Product product;
    Order order;

    @Before
    public void setUp() {
        BasicConfigurator.configure();
        supermarketServer = new SupermarketServer();
        supermarketService = new SupermarketService();
        user = new User("email", "username", "pass", "name", "lastName", "address", "cardNumber", "phoneNumber", null);
        product = new Product("category", "name", "brand", 1, null, 0, 0);
        order = new Order(null, null, 0);
    }
    /*
     * @Test
     * public void testUser() {
     * assertEquals(new User("email", "username", "pass", "name", "lastName",
     * "address", "cardNumber", "phoneNumber", null),user);
     * }
     * 
     * @Test
     * public void testProduct() {
     * assertEquals(new Product("category", "name", "brand", 1, null, 0,
     * 0),product);
     * }
     * 
     * @Test
     * public void testOrder() {
     * assertEquals(new Order(null, null, 0),order);
     * }
     */
}
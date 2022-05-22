package serverTest;

import DomainTest.userTest;
import connectionTest.LoginTest;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.server.SupermarketService;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {

    SupermarketService service;
    String username = "sergio";
    String password = "root";

    private Client client;
    private WebTarget webTarget;
    private Thread thread;

    private static final Logger logger = LogManager.getLogger(LoginTest.class);


    @Before
    public void setUp() throws Exception {
        BasicConfigurator.configure();
        service = new SupermarketService();

    }

    @Test
    public void userTest() {

        logger.info("Starting user login testing");

        User user = new User(username, password);
        Response response = service.login(user);

        Assert.assertTrue(response.getStatus() ==
                Response.Status.OK.getStatusCode());

        logger.info("Finishing user login testing");

    }

    @Test
    public void registerTest() {

        logger.info("Starting user register testing");

        User user = new User("kostas@gmail.com","kostas", "12345","kostas", "ntanas",
                "smirnis",
                "1234567890","6949999999", null);
        Response response = service.register(user);

        Assert.assertTrue(response.getStatus() ==
                Response.Status.OK.getStatusCode());

        logger.info("Finishing user register testing");

    }

    @Test
    public void getUserTest() {

        logger.info("Starting user getter testing");


        User user = service.getUser("sergio");

        Assert.assertNotNull(user);
        Assert.assertTrue(user.getUsername().equals(username));
        Assert.assertTrue(user.getPassword().equals(password));

        logger.info("Finishing user getter testing");

    }

    @Test
    public void addOrderTest() {

        logger.info("Starting add order testing");


        User user = service.getUser("sergio");
        Response response = service.addOrder(user);

        Assert.assertTrue(response.getStatus() ==
                Response.Status.OK.getStatusCode());

        logger.info("Finishing user getter testing");

    }

    @Test
    public void getProductListTest() {

        logger.info("Starting product list getter testing");


        Response response = service.getProductList(true);

        Assert.assertTrue(response.getStatus() ==
                Response.Status.OK.getStatusCode());

        logger.info("Finishing user getter testing");

    }

    //List<Product> productList = new ArrayList<Product>();
    //productList = response.readEntity( new GenericType<List<Product>>() {});
}
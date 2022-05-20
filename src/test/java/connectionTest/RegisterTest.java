package connectionTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.Order;
import supermarket.domain.Product;
import supermarket.domain.User;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RegisterTest {

    private Client client;
    private WebTarget webTarget;
    List<Order> ordersList;

    private static final Logger logger = LogManager.getLogger(RegisterTest.class);

    @Before
    public void setUp() throws Exception {

        BasicConfigurator.configure();

        logger.info("Starting the Set up before Testing");

        String hostname = "127.0.0.1";
        String port = "8080";
        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", "127.0.0.1", "8080"));

        //helpers for user acc
        Product product1 = new Product("vegetables", "tomatoes", "carefour", 100,
                "24,07,2022", 0.05, 1.5);
        Product product2 = new Product("vegetables", "potatoes", "carefour", 100,
                "25,07,2022", 0.08, 1.7);

        List<Product> orderList = new ArrayList<Product>();
        orderList.add(product1);
        orderList.add(product2);
        Order order1 = new Order("17,06,2022", orderList, (float) 2.7);

        List <Order> ordersList = new ArrayList<Order>();
        ordersList.add(order1);

        logger.info("Leaving setUp");
    }

    @Test
    public void registerTest() {

        logger.info("Starting register testing");

        WebTarget supermarketWebTarget = webTarget.path("server/register");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);
        User user = new User("kostas@gmail.com","kostas", "12345","kostas", "ntanas", "smirnis",
                "1234567890","6949999999", ordersList);
        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());

        //check if the login works with the register data
        Assert.assertTrue(loginTest("kostas", "12345"));

        logger.info("(\"Finishing register testing");

    }

    //helepr function for checking if the register data work on log in
    public boolean loginTest(String username, String password) {

        logger.info("Starting login check");

        WebTarget supermarketWebTarget = webTarget.path("server/user");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

        logger.info("(\"Finishing login check");

        return (response.getStatus() == Response.Status.OK.getStatusCode());

    }

}

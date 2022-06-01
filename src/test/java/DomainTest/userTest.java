package DomainTest;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.domain.Order;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

/**
 * A class that is used to test the user class.
 */
@PerfTest(invocations = 10)
@Required(max = 1200, average = 250)
public class userTest {

    // It creates a user and a logger.
    User user;
    private static final Logger logger = LogManager.getLogger(userTest.class);
    @Rule public ContiPerfRule rule = new ContiPerfRule();

    /**
     * It creates a user with a list of orders and a list of products
     */
    @Before
    public void SetUp() {

        BasicConfigurator.configure();

        logger.info("Starting the Set up before Testing");

        Product product1 = new Product("vegetables", "tomatoes", "carefour", 100,
                "24,07,2022", 0.05, 1.5);
        Product product2 = new Product("vegetables", "potatoes", "carefour", 100,
                "25,07,2022", 0.08, 1.7);

        List<Product> orderList = new ArrayList<Product>();
        orderList.add(product1);
        orderList.add(product2);
        Order order1 = new Order("17,06,2022", orderList, (float) 2.7);

        List<Order> ordersList = new ArrayList<Order>();
        ordersList.add(order1);

        user = new User("kostas@gmail.com", "kostas", "12345", "kostas", "ntanas", "smirnis",
                "1234567890", "6949999999", ordersList);

        logger.info("Leaving setUp");
    }

    /**
     * > This function tests the setId function of the User class
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setIdTest() {
        logger.info("Starting setId testing");

        user.setId("123");

        Assert.assertNotNull(user.getId());
        Assert.assertTrue(user.getId().equals("123"));

        logger.info("(\"Finishing setId testing");
    }

    /**
     * It tests the setEmail function of the User class.
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setEmailTest() {
        logger.info("Starting setEmail testing");

        user.setEmail("dinos@gmail.com");

        Assert.assertFalse(user.getEmail().equals("kostas@gmail.com"));
        Assert.assertTrue(user.getEmail().equals("dinos@gmail.com"));

        logger.info("Finishing setEmail testing");

    }

    /**
     * It tests the setUsername function of the User class.
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setUsernameTest() {
        logger.info("Starting setUsername testing");

        user.setUsername("dinos");

        Assert.assertFalse(user.getUsername().equals("kostas"));
        Assert.assertTrue(user.getUsername().equals("dinos"));

        logger.info("Finishing setUsername testing");
    }

    /**
     * This function tests the setPassword function of the User class.
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setPasswordTest() {
        logger.info("Starting setPassword testing");

        user.setPassword("54321");

        Assert.assertFalse(user.getPassword().equals("12345"));
        Assert.assertTrue(user.getPassword().equals("54321"));

        logger.info("Finishing setPassword testing");
    }

    /**
     * It tests the setName function of the User class.
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setNameTest() {
        logger.info("Starting setPassword testing");

        user.setName("dinos");

        Assert.assertFalse(user.getName().equals("kostas"));
        Assert.assertTrue(user.getName().equals("dinos"));

        logger.info("Finishing setPassword testing");
    }

    /**
     * > This function tests the setLastName function of the User class
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setLastNameTest() {
        logger.info("Starting setLastName testing");

        user.setLastName("ntonas");

        Assert.assertFalse(user.getLastName().equals("ntanas"));
        Assert.assertTrue(user.getLastName().equals("ntonas"));

        logger.info("Finishing setLastName testing");
    }

    /**
     * It tests the setAddress function of the User class
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    //@Required(max = 120000, average = 1000)
    public void setAddressTest() {
        logger.info("Starting setAddress testing");

        user.setAddress("xrisoupol");

        Assert.assertFalse(user.getAddress().equals("smirnis"));
        Assert.assertTrue(user.getAddress().equals("xrisoupol"));

        logger.info("Finishing setAddress testing");
    }

    /**
     * This function tests the setCardNumber function in the User class
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setCardNumberTest() {
        logger.info("Starting setCardNumber testing");

        user.setCardNumber("6959999999");

        Assert.assertFalse(user.getCardNumber().equals("6949999999"));
        Assert.assertTrue(user.getCardNumber().equals("6959999999"));

        logger.info("Finishing setCardNumber testing");
    }

    /**
     * This function tests the setPhoneNumber function in the User class
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void setPhoneNumberTest() {
        logger.info("Starting setPhoneNumber testing");

        user.setPhoneNumber("0987654321");

        Assert.assertFalse(user.getPhoneNumber().equals("1234567890"));
        Assert.assertTrue(user.getPhoneNumber().equals("0987654321"));

        logger.info("Finishing setCardNumber testing");
    }

    /**
     * This function tests the getOrderList() function in the User class
     */
    @Test
    @PerfTest(invocations = 1000, threads = 5)
    @Required(max = 120000, average = 1000)
    public void getOrderListTest() {

        logger.info("Starting getOrderList testing");

        Assert.assertEquals(1, user.getOrderList().size());

        logger.info("Finishing getOrderList testing");
    }

}
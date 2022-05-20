package DomainTest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.domain.Order;

import java.util.ArrayList;
import java.util.List;


public class orderTest {

    Order order;
    private static final Logger logger = LogManager.getLogger(userTest.class);


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
        order = new Order("17,06,2022", orderList, (float) 2.7);

        logger.info("Leaving setUp");
    }

    @Test
    public void setEmailTest() {

        logger.info("Starting setEmail testing");

        order.setId("123");

        Assert.assertNotNull(order.getId());
        Assert.assertTrue(order.getId().equals("123"));

        logger.info("(\"Finishing setEmail testing");

    }

    @Test
    public void setDateTest() {

        logger.info("Starting setDate testing");

        order.setDate("18,06,2022");

        Assert.assertFalse(order.getDate().equals("17,06,2022"));
        Assert.assertTrue(order.getDate().equals("18,06,2022"));

        logger.info("Finishing setDate testing");
    }

    @Test
    public void setProductListTest() {

        logger.info("Starting setProductList testing");

        Product product1 = new Product("vegetables", "cucumber", "carefour", 100,
                "30,07,2022", 0.09, 0.5);
        Product product2 = new Product("vegetables", "eggplants", "carefour", 100,
                "14,08,2022", 0.02, 0.7);

        List<Product> orderList = new ArrayList<Product>();
        orderList.add(product1);
        orderList.add(product2);

        order.setProductList(orderList);

        Assert.assertEquals(2,order.getProductList().size());
        Assert.assertTrue(order.getProductList().get(0).getName().equals("cucumber"));
        Assert.assertTrue(order.getProductList().get(1).getName().equals("eggplants"));

        logger.info("Finishing setProductList testing");
    }

    @Test
    public void setPriceTest() {

        logger.info("Starting setPrice testing");

        order.setPrice((float) 3.5);

        Assert.assertNotEquals((float) 2.7, order.getPrice());
        Assert.assertTrue((float) 3.5 == order.getPrice() );

        logger.info("Finishing setPrice testing");
    }

}

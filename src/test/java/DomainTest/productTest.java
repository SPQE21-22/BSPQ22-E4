package DomainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import supermarket.domain.Product;

/**
 * A class that tests the product class.
 */
public class productTest {

    // Creating a new product and a logger.
    Product product;
    private static final Logger logger = LogManager.getLogger(productTest.class);

    /**
     * The function SetUp() is used to set up the environment before testing
     */
    @Before
    public void SetUp() {

        BasicConfigurator.configure();

        logger.info("Starting the Set up before Testing");

        product = new Product("vegetables", "tomatoes", "carefour", 100,
                "24,07,2022", 0.05, 1.5);

        logger.info("Leaving setUp");
    }

    /**
     * > This function tests the setId function of the Product class
     */
    @Test
    public void setIdTest() {

        logger.info("Starting setId testing");

        product.setId("123");

        Assert.assertNotNull(product.getId());
        Assert.assertTrue(product.getId().equals("123"));

        logger.info("(\"Finishing setId testing");
    }

    /**
     * The function tests the setCategory function of the Product class
     */
    @Test
    public void setCategoryTest() {

        logger.info("Starting setCategory testing");

        product.setCategory("fruits");

        Assert.assertFalse(product.getCategory().equals("vegetables"));
        Assert.assertTrue(product.getCategory().equals("fruits"));

        logger.info("Finishing setCategory testing");
    }

    /**
     * This function tests the setName function of the Product class
     */
    /**
     * This function tests the setName function of the Product class
     */
    @Test
    public void setNameTest() {

        logger.info("Starting setName testing");

        product.setName("potatoes");

        Assert.assertFalse(product.getName().equals("tomatoes"));
        Assert.assertTrue(product.getName().equals("potatoes"));

        logger.info("Finishing setName testing");
    }

    /**
     * The function tests the setBrand method of the Product class
     */
    @Test
    public void setBrandTest() {

        logger.info("Starting setBrand testing");

        product.setBrand("lidl");

        Assert.assertFalse(product.getBrand().equals("carefour"));
        Assert.assertTrue(product.getBrand().equals("lidl"));

        logger.info("Finishing setBrand testing");
    }

    /**
     * This function tests the setStock function of the Product class
     */
    @Test
    public void setStockTest() {

        logger.info("Starting setStock testing");

        product.setStock(150);

        Assert.assertFalse(product.getStock() == 100);
        Assert.assertTrue(product.getStock() == 150);

        logger.info("Finishing setStock testing");
    }

    /**
     * This function tests the setExpirationDate function of the Product class
     */
    @Test
    public void setExpirationDateTest() {

        logger.info("Starting setExpirationDate testing");

        product.setExpirationDate("25,07,2022");

        Assert.assertFalse(product.getExpirationDate().equals("24,07,2022"));
        Assert.assertTrue(product.getExpirationDate().equals("25,07,2022"));

        logger.info("Finishing setExpirationDate testing");
    }

    /**
     * This function tests the setDiscountPercentage function in the Product class
     */
    @Test
    public void setDiscountPercentageTest() {

        logger.info("Starting setDiscountPercentage testing");

        product.setDiscountPercentage(0.08);

        Assert.assertFalse(product.getDiscountPercentage() == 0.05);
        Assert.assertTrue(product.getDiscountPercentage() == 0.08);

        logger.info("Finishing setDiscountPercentage testing");
    }

    /**
     * The function tests the setPrice function of the Product class
     */
    @Test
    public void setPriceTest() {

        logger.info("Starting setPrice testing");

        product.setPrice(1.7);

        Assert.assertFalse(product.getPrice() == 1.5);
        Assert.assertTrue(product.getPrice() == 1.7);

        logger.info("Finishing setPrice testing");
    }
}
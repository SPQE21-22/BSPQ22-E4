package DomainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.Product;

public class productTest {
    Product product;
    @Before
    public void SetUp() {
        product = new Product("vegetables", "tomatoes", "carefour", 100,
                "24,07,2022", 0.05, 1.5);
    }

    @Test
    public void setIdTest() {
        product.setId("123");

        Assert.assertNotNull(product.getId());
        Assert.assertTrue(product.getId().equals("123"));
    }

    @Test
    public void setCategoryTest() {
        product.setCategory("fruits");

        Assert.assertFalse(product.getCategory().equals("vegetables"));
        Assert.assertTrue(product.getCategory().equals("fruits"));
    }

    @Test
    public void setNameTest() {
        product.setName("potatoes");

        Assert.assertFalse(product.getName().equals("tomatoes"));
        Assert.assertTrue(product.getName().equals("potatoes"));
    }

    @Test
    public void setBrandTest() {
        product.setBrand("lidl");

        Assert.assertFalse(product.getBrand().equals("carefour"));
        Assert.assertTrue(product.getBrand().equals("lidl"));
    }

    @Test
    public void setStockTest() {
        product.setStock(150);

        Assert.assertFalse(product.getStock() == 100);
        Assert.assertTrue(product.getStock() == 150);
    }

    @Test
    public void setExpirationDateTest() {
        product.setExpirationDate("25,07,2022");

        Assert.assertFalse(product.getExpirationDate().equals("24,07,2022"));
        Assert.assertTrue(product.getExpirationDate().equals("25,07,2022"));
    }

    @Test
    public void setDiscountPercentageTest() {
        product.setDiscountPercentage(0.08);

        Assert.assertFalse(product.getDiscountPercentage() == 0.05);
        Assert.assertTrue(product.getDiscountPercentage() == 0.08);
    }

    @Test
    public void setPriceTest() {
        product.setPrice(1.7);

        Assert.assertFalse(product.getPrice() == 1.5);
        Assert.assertTrue(product.getPrice() == 1.7);
    }
}
package DomainTest;

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

    @Before
    public void SetUp() {

        Product product1 = new Product("vegetables", "tomatoes", "carefour", 100,
                "24,07,2022", 0.05, 1.5);
        Product product2 = new Product("vegetables", "potatoes", "carefour", 100,
                "25,07,2022", 0.08, 1.7);

        List<Product> orderList = new ArrayList<Product>();
        orderList.add(product1);
        orderList.add(product2);
        order = new Order("17,06,2022", orderList, (float) 2.7);

    }

    @Test
    public void setEmailTest() {
        order.setId("123");

        Assert.assertNotNull(order.getId());
        Assert.assertTrue(order.getId().equals("123"));
    }

    @Test
    public void setDateTest() {
        order.setDate("18,06,2022");

        Assert.assertFalse(order.getDate().equals("17,06,2022"));
        Assert.assertTrue(order.getDate().equals("18,06,2022"));
    }

    @Test
    public void setProductListTest() {
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
    }

    @Test
    public void setPriceTest() {
        order.setPrice((float) 3.5);

        Assert.assertNotEquals((float) 2.7, order.getPrice());
        Assert.assertTrue((float) 3.5 == order.getPrice() );
    }

}

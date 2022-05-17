package DomainTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.Product;
import supermarket.domain.User;
import supermarket.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class userTest {

    User user;

    @Before
    public void SetUp() {

        Product product1 = new Product("vegetables", "tomatoes", "carefour", 100,
                "24,07,2022", 0.05, 1.5);
        Product product2 = new Product("vegetables", "potatoes", "carefour", 100,
                "25,07,2022", 0.08, 1.7);

        List <Product> orderList = new ArrayList<Product>();
        orderList.add(product1);
        orderList.add(product2);
        Order order1 = new Order("17,06,2022", orderList, (float) 2.7);

        List <Order> ordersList = new ArrayList<Order>();
        ordersList.add(order1);

        user = new User("kostas@gmail.com","kostas", "12345","kostas", "ntanas", "smirnis",
               "1234567890","6949999999", ordersList);
    }

    @Test
    public void setIdTest() {
        user.setId("123");

        Assert.assertNotNull(user.getId());
        Assert.assertTrue(user.getId().equals("123"));
    }


    @Test
    public void setEmailTest() {
        user.setEmail("dinos@gmail.com");

        Assert.assertFalse(user.getEmail().equals("kostas@gmail.com"));
        Assert.assertTrue(user.getEmail().equals("dinos@gmail.com"));
    }

    @Test
    public void setUsernameTest() {
        user.setUsername("dinos");

        Assert.assertFalse(user.getUsername().equals("kostas"));
        Assert.assertTrue(user.getUsername().equals("dinos"));
    }

    @Test
    public void setPasswordTest() {
        user.setPassword("54321");

        Assert.assertFalse(user.getPassword().equals("12345"));
        Assert.assertTrue(user.getPassword().equals("54321"));
    }

    @Test
    public void setNameTest() {
        user.setName("dinos");

        Assert.assertFalse(user.getName().equals("kostas"));
        Assert.assertTrue(user.getName().equals("dinos"));
    }

    @Test
    public void setLastNameTest() {
        user.setLastName("ntonas");

        Assert.assertFalse(user.getLastName().equals("ntanas"));
        Assert.assertTrue(user.getLastName().equals("ntonas"));
    }

    @Test
    public void setAddressTest() {
        user.setAddress("xrisoupol");

        Assert.assertFalse(user.getAddress().equals("smirnis"));
        Assert.assertTrue(user.getAddress().equals("xrisoupol"));
    }

    @Test
    public void setCardNumberTest() {
        user.setCardNumber("6959999999");

        Assert.assertFalse(user.getCardNumber().equals("6949999999"));
        Assert.assertTrue(user.getCardNumber().equals("6959999999"));
    }

    @Test
    public void setPhoneNumberTest() {
        user.setPhoneNumber("0987654321");

        Assert.assertFalse(user.getPhoneNumber().equals("1234567890"));
        Assert.assertTrue(user.getPhoneNumber().equals("0987654321"));
    }

    //Assert.assertEquals(1,customer1.getLoans().size());

    @Test
    public void getOrderListTest() {
        Assert.assertEquals(1, user.getOrderList().size());
    }
}

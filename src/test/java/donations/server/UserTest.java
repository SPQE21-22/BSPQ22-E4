package donations.server;

import org.junit.Test;

import supermarket.domain.User;
import supermarket.server.SupermarketServer;

import org.junit.Before;
import static org.junit.Assert.assertEquals;


public class UserTest {

    private SupermarketServer supermarketServer;
    private User user;

    @Before
    public void setUp() {

        supermarketServer = new SupermarketServer();
        user =new User();
    }

    @Test
    public void testEmptyDonation() {
        User user=supermarketServer.getUserInfo();
        assertEquals("",user.getUsername());
        assertEquals("",user.getPassword());
    }
}
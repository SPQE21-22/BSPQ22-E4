package connectionTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.User;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LoginTest {

    private Client client;
    private WebTarget webTarget;
    private Thread thread;
    String username = "sergio";
    String password = "root";

    @Before
    public void setUp() throws Exception {
        String hostname = "127.0.0.1";
        String port = "8080";
        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

    }

    @Test
    public void loginTest() {
        WebTarget supermarketWebTarget = webTarget.path("server/user");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));

        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
    }

    @Test
    public void getUserTest() {
        WebTarget supermarketWebTarget = webTarget.path("server/getUser");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setUsername(username);

        Response response = invocationBuilder.post(Entity.entity(username, MediaType.APPLICATION_JSON));
        User u = response.readEntity(User.class);

        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(u.getPassword().equals(password));

    }
}

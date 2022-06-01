package connectionTest;

import DomainTest.userTest;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import supermarket.domain.User;

import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * > This class tests the login functionality of the application
 */
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class LoginTest {

    // Setting up the variables that are used to make the REST calls in the test
    private Client client;
    private WebTarget webTarget;
    private Thread thread;
    String username = "sergio";
    String password = "root";

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Rule public ContiPerfRule rule = new ContiPerfRule();

    /**
     * This function is called before each test case is run. It sets up the client
     * and webTarget
     * variables that are used to make the REST calls
     */
    @Before
    public void setUp() throws Exception {

        BasicConfigurator.configure();

        logger.info("Starting the Set up before Testing");

        String hostname = "127.0.0.1";
        String port = "8080";
        client = ClientBuilder.newClient();
        webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

        logger.info("Leaving setUp");

    }

    /**
     * It creates a new user, and then tries to login with the same user
     */
    @Test
    @PerfTest(invocations = 1000, threads = 10)
    @Required(max = 120000, average = 2000)
    public void loginTest() {

        logger.info("Starting login testing");

        WebTarget supermarketWebTarget = webTarget.path("server/user");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Response response = invocationBuilder.post(Entity.entity(user,
                MediaType.APPLICATION_JSON));

        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());

        logger.info("(\"Finishing login testing");

    }

    /**
     * It tests the getUser function by sending a username to the server, and then
     * checking if the
     * server returns the correct password for that username
     */
    @Test
    @PerfTest(invocations = 1000, threads = 10)
    @Required(max = 120000, average = 2000)
    public void getUserTest() {

        logger.info("Starting getUser testing");

        WebTarget supermarketWebTarget = webTarget.path("server/getUser");
        Invocation.Builder invocationBuilder = supermarketWebTarget.request(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setUsername(username);

        Response response = invocationBuilder.post(Entity.entity(username,
                MediaType.APPLICATION_JSON));
        User u = response.readEntity(User.class);

        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
        Assert.assertTrue(u.getPassword().equals(password));

        logger.info("(\"Finishing getUser testing");

    }

}

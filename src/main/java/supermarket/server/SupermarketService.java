package supermarket.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import supermarket.domain.User;


@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class SupermarketService {

	private SupermarketServer supermarketServer;

	public SupermarketService() {

		supermarketServer = new SupermarketServer();
	}

	@POST
	@Path("/user")
	public Response login(User user) {
		boolean checkLogin = false;
		//se lanza login en Server
		checkLogin = supermarketServer.login(user.getUsername(), user.getPassword());
		System.out.println("Received login: " + user.getUsername() + " booleano de login " + checkLogin);
		return Response.ok(checkLogin).build();
	}
	
	@POST
    @Path("/user")
    public Response register(User user){
        boolean checkRegister=false;
		checkRegister = supermarketServer.register(user);
        return Response.ok(checkRegister).build();
    }

	@GET
	@Path("/user")
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		userList = supermarketServer.getUserList();
		return userList;
	}
}
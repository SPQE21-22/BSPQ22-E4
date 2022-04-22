package supermarket.server;

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
	@Path("/supermarket")
	public Response login(User user){
		boolean checkLogin=false;
		//se lanza login en Server
		checkLogin = supermarketServer.login(user.getUsername(),user.getPassword());
		System.out.println("Received login: " + user.getUsername() +" booleano de login " +checkLogin);
		return Response.ok(checkLogin).build();
	}

	@GET
	@Path("/supermarket")
	public Response getUserInfo() {
		User user = supermarketServer.getUserInfo();
		System.out.println("Prueba donor server login " +user.getUsername() +" password "+ user.getPassword());
		return Response.ok(user).build();

	}
}
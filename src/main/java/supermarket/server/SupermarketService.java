package supermarket.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import supermarket.domain.Product;
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
		return Response.ok(checkLogin).build();

	}


	@POST
    @Path("/register")
    public Response register(User user){
        boolean checkRegister=false;
		checkRegister = supermarketServer.register(user);
        return Response.ok(checkRegister).build();
    }

	@POST
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(String username) {
		User user = new User();
		user = supermarketServer.getUser(username);
		return user;
	}


	@POST
	@Path("/order")
	public Response addOrder(User user) {
		boolean checkOrder = false;
		checkOrder = supermarketServer.addOrder(user);
		return Response.ok(checkOrder).build();
	}

	@POST
	@Path("/product")
	public Response getProductList(Boolean bool) {
		List<Product> productList = new ArrayList<Product>();
		productList = supermarketServer.getProductList();
		return Response.ok(productList).build();
	}

	@POST
	@Path("/productByCategory")
	public Response getProductListByCategory(String category) {
		List<Product> productList = new ArrayList<Product>();
		productList = supermarketServer.getProductListByCategory(category);
		return Response.ok(productList).build();
	}


}
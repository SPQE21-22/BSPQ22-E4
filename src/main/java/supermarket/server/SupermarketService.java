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

/**
 * It's a JAX-RS resource class that exposes a REST API for the
 * SupermarketServer class
 */
@Path("/server")
@Produces(MediaType.APPLICATION_JSON)
public class SupermarketService {

	// It's a private variable that will be used to store the instance of the
	// SupermarketServer class.
	private SupermarketServer supermarketServer;

	// It's a constructor that creates a new instance of the SupermarketServer
	// class.
	public SupermarketService() {

		supermarketServer = new SupermarketServer();
	}

	/**
	 * It checks if the user is registered in the supermarket server.
	 * 
	 * @param user The user object that contains the username and password.
	 * @return A boolean value.
	 */
	@POST
	@Path("/user")
	public Response login(User user) {
		boolean checkLogin = false;
		// se lanza login en Server
		checkLogin = supermarketServer.login(user.getUsername(), user.getPassword());
		return Response.ok(checkLogin).build();

	}

	/**
	 * It registers a user.
	 * 
	 * @param user the user object that contains the user's information.
	 * @return A boolean value.
	 */

	@POST
	@Path("/register")
	public Response register(User user) {
		boolean checkRegister = false;
		checkRegister = supermarketServer.register(user);
		return Response.ok(checkRegister).build();
	}

	/**
	 * The function takes a string as input, and returns a user object
	 * 
	 * @param username The username of the user you want to get.
	 * @return A user object.
	 */
	@POST
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(String username) {
		User user = new User();
		user = supermarketServer.getUser(username);
		return user;
	}

	/**
	 * The function takes a user object as a parameter and returns a boolean value
	 * 
	 * @param user The user object that contains the order details.
	 * @return A boolean value.
	 */
	@POST
	@Path("/order")
	public Response addOrder(User user) {
		boolean checkOrder = false;
		checkOrder = supermarketServer.addOrder(user);
		return Response.ok(checkOrder).build();
	}

	/**
	 * The function is a POST request to the path "/product" and returns a list of
	 * products
	 * 
	 * @param bool This is a boolean value that is used to determine whether the
	 *             product list should be
	 *             sorted by price or not.
	 * @return A list of products.
	 */
	@POST
	@Path("/product")
	public Response getProductList(Boolean bool) {
		List<Product> productList = new ArrayList<Product>();
		productList = supermarketServer.getProductList();
		return Response.ok(productList).build();
	}

	/**
	 * This function is used to get the list of products by category
	 * 
	 * @param category The category of the product.
	 * @return A list of products.
	 */
	@POST
	@Path("/productByCategory")
	public Response getProductListByCategory(String category) {
		List<Product> productList = new ArrayList<Product>();
		productList = supermarketServer.getProductListByCategory(category);
		return Response.ok(productList).build();
	}

}
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/orders")
public class Order {
    
    private static List<Order> orderList = OrderDAO.getProducts();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders() {
        return Response.ok(orderList).build();
    }

    @GET
    @Path("/{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderByCode(@PathParam("code") String code) {
        Order found = null;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCode().equalsIgnoreCase(code)) {
                found = orderList.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Order not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
 
    @POST
    @Path("/createOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(Order orderRequest) {
 
        this.orderList.add(orderRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(orderList).build();
 
    }
 
    @PUT
    @Path("/updateOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(Order orderUpdate) {
        Order found = null;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCOde().equalsIgnoreCase(orderUpdate.getCode())) {
                found = orderList.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Order not found").build();
        } else {
            found.setOrdername(orderUpdate.getOrdername());
            return Response.ok(found).build();
        }
    }
 
    @DELETE
    @Path("/deleteOrder/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("code") String code) {
        Order found = null;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getCode().equalsIgnoreCase(code)) {
                found = orderList.get(i);
                orderList.remove(found);
            }
        }

        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Order not found").build();
        } else {
            return Response.ok(orderList).build();
        }
    }
}

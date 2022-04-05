import java.util.LocalDate;
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

@Path("/customerService")
public class CustomerService {

    private static List<Customer> customerList = CustomerDAO.getCustomers();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
        return Response.ok(customerList).build();
    }
 
    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByName(@PathParam("name") String name) {
        Customer found = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equalsIgnoreCase(name)) {
                found = customerList.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Customer not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
 
    @POST
    @Path("/createCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customerRequest) {
 
        this.customerList.add(customerRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(customerList).build();
 
    }
 
    @PUT
    @Path("/updateCustomer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer customerUpdate) {
        Customer found = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equalsIgnoreCase(customerUpdate.getName())) {
                found = customerList.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Customer not found").build();
        } else {
            found.setCustomername(customerUpdate.getCustomername());
            return Response.ok(found).build();
        }
    }
 
    @DELETE
    @Path("/deleteCustomer/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam("name") String name) {
        Customer found = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equalsIgnoreCase(name)) {
                found = customerList.get(i);
                customerList.remove(found);
            }
        }

        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Customer not found").build();
        } else {
            return Response.ok(customerList).build();
        }
    }
}

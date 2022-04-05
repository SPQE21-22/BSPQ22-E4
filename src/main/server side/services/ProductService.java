import java.util.List;
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

@Path("/productService")
public class ProductService {

    private static List<Product> productList = ProductDAO.getProducts();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok(productList).build();
    }
 
    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductByName(@PathParam("name") String name) {
        Product found = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(name)) {
                found = productList.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Product not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
 
    @POST
    @Path("/createProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product productRequest) {
 
        this.productList.add(productRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(productList).build();
 
    }
 
    @PUT
    @Path("/updateProduct")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product productUpdate) {
        Product found = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(productUpdate.getName())) {
                found = productList.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Product not found").build();
        } else {
            found.setProductname(productUpdate.getProductname());
            return Response.ok(found).build();
        }
    }
 
    @DELETE
    @Path("/deleteProduct/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("name") String name) {
        Product found = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(name)) {
                found = productList.get(i);
                productList.remove(found);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Product not found").build();
        } else {
            return Response.ok(productList).build();
        }
    }
}

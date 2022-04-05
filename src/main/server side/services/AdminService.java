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

@Path("/adminService")
public class AdminService {
    
    private static List<Admin> adminList = AdminDAO.getAdmins();
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdmins() {
        return Response.ok(adminList).build();
    }
    
    @GET
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminByName(@PathParam("name") String name) {
        Admin found = null;
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getName().equalsIgnoreCase(name)) {
                found = adminList.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Admin not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
 
    @POST
    @Path("/createAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAdmin(Admin adminRequest) {
 
        this.adminList.add(adminRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(adminList).build();
 
    }
 
    @PUT
    @Path("/updateAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdmin(Admin adminUpdate) {
        Admin found = null;
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getName().equalsIgnoreCase(adminUpdate.getName())) {
                found = adminList.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Admin not found").build();
        } else {
            found.setAdminname(adminUpdate.getAdminname());
            return Response.ok(found).build();
        }
    }
 
    @DELETE
    @Path("/deleteAdmin/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAdmin(@PathParam("name") String name) {
        Admin found = null;
        for (int i = 0; i < adminList.size(); i++) {
            if (adminList.get(i).getName().equalsIgnoreCase(name)) {
                found = adminList.get(i);
                adminList.remove(found);
            }
        }

        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Admin not found").build();
        } else {
            return Response.ok(adminList).build();
        }
    }
}
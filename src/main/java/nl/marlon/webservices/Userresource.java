package nl.marlon.webservices;

import nl.marlon.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/users")
public class Userresource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(){
		ArrayList allUsers = User.getAllUsers();
		return Response.ok(allUsers).build();
	}
}

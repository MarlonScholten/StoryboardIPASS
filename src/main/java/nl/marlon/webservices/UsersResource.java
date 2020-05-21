package nl.marlon.webservices;

import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("users")
public class UsersResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers(){
		return Response.ok(User.getAllUsers()).build();
	}

	@POST
	@Path("createUser")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password){
		User newUser = User.createUser(username, email, password);
		if(newUser == null){
			return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("Error", "User already exists")).build();
		}
		return Response.ok(newUser).build();
	}
}

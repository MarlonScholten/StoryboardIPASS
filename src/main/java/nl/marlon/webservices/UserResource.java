package nl.marlon.webservices;

import nl.marlon.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserResource {

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id){
		User user = User.getUserById(id);

		if(user == null){
			Map<String, String> messages =  new HashMap<>();
			messages.put("error", "user does not exist");
			messages.put("requestedID", Integer.toString(id));
			return Response.status(409).entity(messages).build();
		}
		return Response.ok(user).build();
	}
}

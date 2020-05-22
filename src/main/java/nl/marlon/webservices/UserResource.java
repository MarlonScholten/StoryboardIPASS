package nl.marlon.webservices;

import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("email") String email, @FormParam("password") String password){
		Boolean correctLogin = User.checkCredentials(email, password);

		if(correctLogin){
			return Response.ok().build();
		} else{
			Map<String, String> messages =  new HashMap<>();
			messages.put("error", "Email or password incorrect");
			messages.put("requested Email", email);
			return Response.status(409).entity(messages).build();
		}
	}
}

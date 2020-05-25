package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.User;
import nl.marlon.security.MySecurityContext;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.HashMap;
import java.util.Map;

@Path("user")
public class UserResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("email") String email, @FormParam("password") String password) throws UnauthorizedException {
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@Context SecurityContext msc){
		if(msc == null){
			return Response.status(409).build();
		}
		return Response.ok(msc.getUserPrincipal()).build();
	}
}

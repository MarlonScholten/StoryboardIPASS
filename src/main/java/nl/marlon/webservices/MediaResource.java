package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("user/media")
public class MediaResource {
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMedia(@Context SecurityContext msc, @PathParam("id") String id) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		if(user.getArchive().deleteMedia(id)){
			return Response.ok().build();
		}
		return Response.status(409).build();
	}
}
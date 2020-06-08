package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.User;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("user/media")
public class MediaResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewMedia(@Context SecurityContext msc,
								@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("description") String notes,
								@FormParam("type") String type) throws UnauthorizedException {

//		if(msc == null){
//			return Response.status(409).build();
//		}
//		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
//		System.out.println(type);
		return Response.ok().build();
	}
}
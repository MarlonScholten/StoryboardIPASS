package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;


@Path("user/genres")
public class GenreResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGenres(@Context SecurityContext msc) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		ArrayList allGenres = user.getArchive().getAllGenres();
		if(allGenres != null){
			return Response.ok(allGenres).build();
		}
		return Response.status(404).build();
	}
}


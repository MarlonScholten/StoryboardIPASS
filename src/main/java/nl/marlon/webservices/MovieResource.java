package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Anime;
import nl.marlon.model.Media;
import nl.marlon.model.Movie;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@Path("user/movies")
public class MovieResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMovies(@Context SecurityContext msc) throws UnauthorizedException {
		List<Movie> allMovies = new ArrayList();

		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		for(Media media : user.getArchive().getAllMedia()){
			if(media instanceof Movie){
				allMovies.add((Movie)media);
			}
		}
		return Response.ok(allMovies).build();
	}
}

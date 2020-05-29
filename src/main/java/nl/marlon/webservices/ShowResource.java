package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Anime;
import nl.marlon.model.Media;
import nl.marlon.model.Show;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@Path("user/shows")
public class ShowResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllShows(@Context SecurityContext msc) throws UnauthorizedException {
		List<Show> allShows = new ArrayList();

		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		for(Media media : user.getArchive().getAllMedia()){
			if(media instanceof Show){
				allShows.add((Show) media);
			}
		}
		return Response.ok(allShows).build();
	}
}

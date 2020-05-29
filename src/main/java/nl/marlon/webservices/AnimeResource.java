package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Anime;
import nl.marlon.model.Media;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@Path("user/anime")
public class AnimeResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAnime(@Context SecurityContext msc) throws UnauthorizedException {
		List<Anime> allAnime = new ArrayList();

		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		for(Media media : user.getArchive().getAllMedia()){
			if(media instanceof Anime){
				allAnime.add((Anime)media);
			}
		}
		return Response.ok(allAnime).build();
	}
}

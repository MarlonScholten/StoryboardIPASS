package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Manga;
import nl.marlon.model.Media;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@Path("user/manga")
public class MangaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllManga(@Context SecurityContext msc) throws UnauthorizedException {
		List<Manga> allManga = new ArrayList();

		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		for(Media media : user.getArchive().getAllMedia()){
			if(media instanceof Manga){
				allManga.add((Manga)media);
			}
		}
		return Response.ok(allManga).build();
	}
}

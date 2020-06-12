package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.File;
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
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewManga(@Context SecurityContext msc,
								@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("thumbnail") File thumbnail,
								@FormParam("notes") String notes,
								@FormParam("genres") List<String> genres,
								@FormParam("chapter") int chapter,
								@FormParam("link") String link) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		ArrayList<Genre> genreObjs = new ArrayList<>();
		for(String genre : genres){
			Genre target = user.getArchive().getGenreByName(genre);
			if(target != null){
				genreObjs.add(target);
			}
		}

		Manga newManga = new Manga(title, description, thumbnail, notes, genreObjs, chapter, link);
		if(user.getArchive().addMedia(newManga)){
			return Response.ok(newManga).build();
		} else{
			return Response.status(409).build();
		}
	}
}

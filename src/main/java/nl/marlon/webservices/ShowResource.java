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
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewShow(@Context SecurityContext msc,
								@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("thumbnail") File thumbnail,
								@FormParam("notes") String notes,
								@FormParam("genres") List<String> genres,
								@FormParam("season") int season,
								@FormParam("episode") int episode) throws UnauthorizedException {
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

		Show newShow = new Show(title, description, thumbnail, notes, genreObjs,  season, episode);
		if(user.getArchive().addMedia(newShow)){
			return Response.ok(newShow).build();
		} else{
			return Response.status(409).build();
		}
	}
}

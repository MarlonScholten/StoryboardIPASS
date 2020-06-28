package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Genre;
import nl.marlon.model.Media;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;


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
		if(!(allGenres == null)){
			return Response.ok(allGenres).build();
		}
		return Response.status(404).build();
	}
	@Path("/add/{name}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewGenre(@Context SecurityContext msc,
								@PathParam("name") String name) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		Genre newGenre = new Genre(name);
		if(user.getArchive().addGenre(newGenre)){
			return Response.ok(newGenre).build();
		} else {
			return Response.status(409).build();
		}
	}
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGenre(@Context SecurityContext msc,
								@FormParam("genres") List<String> genres) throws UnauthorizedException {
		if(msc == null){
			System.out.println("msc is null");
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
		for(Genre genre : genreObjs){
			user.getArchive().deleteGenre(genre);
		}
		ArrayList<Media> allMedia = user.getArchive().getAllMedia();
		for(Media media: allMedia){
			for(Genre genre : genreObjs){
				if(media.getGenres().contains(genre)){
					media.getGenres().remove(genre);
				}
			}
		}
		return Response.ok().build();
	}
}


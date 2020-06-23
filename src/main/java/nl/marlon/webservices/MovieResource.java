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
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewMovie(@Context SecurityContext msc,
								@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("thumbnail") File thumbnail,
								@FormParam("notes") String notes,
								@FormParam("genres") List<String> genres,
								@FormParam("director") String director,
								@FormParam("watched") boolean watched) throws UnauthorizedException {
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

		Movie newMovie = new Movie(title, description, thumbnail, notes, genreObjs, director, watched);
		if(user.getArchive().addMedia(newMovie)){
			return Response.ok(newMovie).build();
		} else{
			return Response.status(409).build();
		}
	}
	@Path("patch/{id}")
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	public Response patchMovie(@Context SecurityContext msc,
							   @PathParam("id") String id,
							   @FormParam("director") String director,
							   @FormParam("watched") boolean watched,
							   @FormParam("notes") String notes) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		Media targetMedia = user.getArchive().getMediaById(id);
		if(targetMedia != null && targetMedia instanceof Movie){
			Movie movie = (Movie) targetMedia;
			movie.setDirector(director);
			movie.setWatched(watched);
			movie.setNotes(notes);
			return Response.ok(targetMedia).build();
		}
		return Response.status(409).build();
	}
}

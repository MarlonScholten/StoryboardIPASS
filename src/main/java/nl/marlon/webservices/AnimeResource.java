package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Anime;
import nl.marlon.model.Genre;
import nl.marlon.model.Media;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.io.*;
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
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewAnime(@Context SecurityContext msc,
								@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("thumbnail") File thumbnail,
								@FormParam("notes") String notes,
								@FormParam("genres") List<String> genres,
								@FormParam("season") int season,
								@FormParam("episode") int episode,
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

		Anime newAnime = new Anime(title, description, thumbnail, notes, genreObjs,  season, episode, link);
		if(user.getArchive().addMedia(newAnime)){
			return Response.ok(newAnime).build();
		} else{
			return Response.status(409).build();
		}
	}
	@Path("patch/{id}")
	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	public Response patchAnime(@Context SecurityContext msc,
							   @PathParam("id") String id,
							   @FormParam("season") int season,
							   @FormParam("episode") int episode,
							   @FormParam("notes") String notes,
							   @FormParam("link") String link) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		Media targetMedia = user.getArchive().getMediaById(id);
		if(targetMedia != null && targetMedia instanceof Anime){
			Anime anime = (Anime) targetMedia;
			System.out.println(anime);
			anime.setSeason(season);
			anime.setEpisode(episode);
			anime.setLink(link);
			anime.setNotes(notes);
			return Response.ok(targetMedia).build();
		}
		return Response.status(409).build();
	}
}

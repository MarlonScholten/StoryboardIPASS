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

@Path("user/books")
public class BookResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks(@Context SecurityContext msc) throws UnauthorizedException {
		List<Book> allBooks = new ArrayList();

		if(msc == null){
			return Response.status(409).build();
		}
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		for(Media media : user.getArchive().getAllMedia()){
			if(media instanceof Book){
				allBooks.add((Book)media);
			}
		}
		return Response.ok(allBooks).build();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNewBook(@Context SecurityContext msc,
								@FormParam("title") String title,
								@FormParam("description") String description,
								@FormParam("thumbnail") File thumbnail,
								@FormParam("notes") String notes,
								@FormParam("genres") List<String> genres,
								@FormParam("author") String author,
								@FormParam("page") int page) throws UnauthorizedException {
		if(msc == null){
			return Response.status(409).build();
		}
		// convert string genre names to objects
		User user = User.getUserByEmail(msc.getUserPrincipal().getName());
		ArrayList<Genre> genreObjs = new ArrayList<>();
		for(String genre : genres){
			Genre target = user.getArchive().getGenreByName(genre);
			if(target != null){
				genreObjs.add(target);
			}
		}

		Book newBook = new Book(title, description, thumbnail, notes, genreObjs, page, author);
		if(user.getArchive().addMedia(newBook)){
			return Response.ok(newBook).build();
		} else{
			return Response.status(409).build();
		}
	}
}

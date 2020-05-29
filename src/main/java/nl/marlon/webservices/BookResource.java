package nl.marlon.webservices;

import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.Book;
import nl.marlon.model.Media;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
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
}

package nl.marlon.webservices;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.marlon.Exceptions.UnauthorizedException;
import nl.marlon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;

@Path("/authenticate")
public class AuthenticationResource {
	final static public Key key= MacProvider.generateKey();
	private String createToken(String userId,String role) {
		Calendar expiration=Calendar.getInstance();
		expiration.add(Calendar.HOUR,8);
		return Jwts.builder()
				.setSubject(userId)
				.setExpiration(expiration.getTime())
				.claim("role",role)
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("email") String email, @FormParam("password") String password) {
		User user;
		try {
			user = User.getUserByEmail(email);
		} catch (UnauthorizedException e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
		if(user.checkPassword(password)) {
			String token=createToken(String.valueOf(user.getId()),user.getRole());
			AbstractMap.SimpleEntry<String, String> JWT=new AbstractMap.SimpleEntry<>("JWT",token);
			return Response.ok(JWT).build();
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
}

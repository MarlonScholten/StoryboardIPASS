package nl.marlon.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import nl.marlon.model.User;
import nl.marlon.webservices.AuthenticationResource;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthorizationFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
		MySecurityContext msc = new MySecurityContext(null,scheme);
		String authHeader=requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (authHeader !=null && authHeader.startsWith("Bearer ")) {
			String token=authHeader.substring("Bearer ".length()).trim();
			try {
				JwtParser parser= Jwts.parser().setSigningKey(AuthenticationResource.key);
				Claims claims=parser.parseClaimsJws(token).getBody();
				String user=claims.getSubject();
				msc=new MySecurityContext(User.getUserById(Integer.parseInt(user)),scheme);
			} catch (JwtException | IllegalArgumentException e) {
				e.printStackTrace();
				System.out.println("Invalid JWT!");
			}
		}
		requestContext.setSecurityContext(msc);
	}
}
package nl.marlon.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		packages("nl.marlon.webservices, nl.marlon.security");
		register(RolesAllowedDynamicFeature.class);
	}
}

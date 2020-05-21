package nl.marlon.setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		packages("nl.marlon.webservices");
	}
}

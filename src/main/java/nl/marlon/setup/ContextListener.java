package nl.marlon.setup;

import nl.marlon.model.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.util.ArrayList;

@WebListener
public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce){
		User marlon = new User("Marlon", "marlon_scholten@live.nl", "123");

		File braveImg = new File("src/main/webapp/images/brave-new-world.jpg");

		Genre scifi= new Genre("Sci-fi");
		Genre thriller= new Genre("Thriller");
		ArrayList<Genre> bravegenres = new ArrayList<>();
		bravegenres.add(scifi);
		bravegenres.add(thriller);

		Book bravenewworld = new Book("Brave new world", "A sci-fi thriller with interesting characters and a more interesting world", braveImg,"Very cool", bravegenres, 23, "Aldous Huxley");
		Anime psychopass = new Anime("Psycho Pass", "A sci-fi police thriller", braveImg, "pretty gory", bravegenres, 2, 4, "https://www1.animeultima.to/a/psycho-pass-2_481893");

		marlon.getArchive().addMedia(bravenewworld);
		marlon.getArchive().addMedia(psychopass);
	}
	public void contextDestroyed(ServletContextEvent sce){

	}
}

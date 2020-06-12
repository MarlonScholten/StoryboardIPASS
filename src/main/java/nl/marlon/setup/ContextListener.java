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
		User demo = new User("Demo", "demo", "123");

		File braveImg = new File("src/main/webapp/images/brave-new-world.jpg");

		Genre scifi= new Genre("Sci-fi");
		Genre thriller= new Genre("Thriller");
		Genre horror = new Genre("Horror");
		Genre comedy = new Genre("Comedy");
		Genre romance = new Genre("Romance");
		Genre adventure =  new Genre("Adventure");

		marlon.getArchive().addGenre(scifi);
		marlon.getArchive().addGenre(thriller);
		marlon.getArchive().addGenre(horror);
		marlon.getArchive().addGenre(comedy);
		marlon.getArchive().addGenre(romance);
		marlon.getArchive().addGenre(adventure);

		ArrayList<Genre> bravegenres = new ArrayList<>();
		bravegenres.add(scifi);
		bravegenres.add(thriller);

		Book bravenewworld = new Book("Brave new world", "A sci-fi thriller with interesting characters and a more interesting world", braveImg,"Very cool", bravegenres, 23, "Aldous Huxley");
		Anime psychopass = new Anime("Psycho Pass", "A sci-fi police thriller", braveImg, "pretty gory", bravegenres, 2, 4, "https://www1.animeultima.to/a/psycho-pass-2_481893");
		Movie goodwillhunting =  new Movie("Good Will Hunting", "A movie about a kid who is too smart", braveImg, "Gus Van Sant", true);
		Manga onepiece = new Manga("One Piece", "A boy named luffy wants to become the pirate king", braveImg, 244, "https://mangaplus.shueisha.co.jp/titles/100020");
		Show vikings = new Show("Vikings", "badassery", braveImg, 2, 12);


		demo.getArchive().addMedia(bravenewworld);
		marlon.getArchive().addMedia(bravenewworld);
		marlon.getArchive().addMedia(psychopass);
		marlon.getArchive().addMedia(goodwillhunting);
		marlon.getArchive().addMedia(onepiece);
		marlon.getArchive().addMedia(vikings);
	}
	public void contextDestroyed(ServletContextEvent sce){

	}
}

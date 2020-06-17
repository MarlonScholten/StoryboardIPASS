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

		File braveImg = new File("brave-new-world.jpg");

		Genre scifi= new Genre("Sci-fi");
		Genre thriller= new Genre("Thriller");
		Genre horror = new Genre("Horror");
		Genre comedy = new Genre("Comedy");
		Genre romance = new Genre("Romance");
		Genre adventure =  new Genre("Adventure");

		ArrayList<Genre> bravegenres = new ArrayList<>();
		bravegenres.add(scifi);
		bravegenres.add(thriller);

		Book bravenewworld = new Book("Brave new world", "A sci-fi thriller with interesting characters and a more interesting world", braveImg,"Very cool", bravegenres, 23, "Aldous Huxley");
		Anime psychopass = new Anime("Psycho Pass", "A sci-fi police thriller", braveImg, "pretty gory", bravegenres, 2, 4, "https://www1.animeultima.to/a/psycho-pass-2_481893");
		Anime Onepiece = new Anime("One Piece", "A pirate adventure", braveImg, "very rich in fantasy", bravegenres, 1, 890, "https://www1.animeultima.to/a/psycho-pass-2_481893");
		Anime Onepace = new Anime("One Pace", "A pirate adventure", braveImg, "very rich in fantasy", bravegenres, 1, 890, "https://www1.animeultima.to/a/psycho-pass-2_481893");
		Anime unoPiece = new Anime("Uno Piece", "A pirate adventure", braveImg, "very rich in fantasy", bravegenres, 1, 890, "https://www1.animeultima.to/a/psycho-pass-2_481893");
		Movie goodwillhunting =  new Movie("Good Will Hunting", "A movie about a kid who is too smart", braveImg, "Gus Van Sant", true);
		Manga onepiece = new Manga("One Piece", "A boy named luffy wants to become the pirate king", braveImg, 244, "https://mangaplus.shueisha.co.jp/titles/100020");
		Show vikings = new Show("Vikings", "badassery", braveImg, 2, 12);

		// Marlon account
		marlon.getArchive().addGenre(scifi);
		marlon.getArchive().addGenre(thriller);
		marlon.getArchive().addGenre(horror);
		marlon.getArchive().addGenre(comedy);
		marlon.getArchive().addGenre(romance);
		marlon.getArchive().addGenre(adventure);

//		marlon.getArchive().addMedia(bravenewworld);
		marlon.getArchive().addMedia(psychopass);
		marlon.getArchive().addMedia(Onepiece);
		marlon.getArchive().addMedia(Onepace);
		marlon.getArchive().addMedia(unoPiece);
		marlon.getArchive().addMedia(goodwillhunting);
		marlon.getArchive().addMedia(onepiece);
//		marlon.getArchive().addMedia(vikings);

		// Demo Account
		User demo = new User("demo", "demo@hotmail.com", "mypassword");

		Book gulag = new Book("The Gulag Archipelago", "History book about russian gulags. A real story", braveImg,"", bravegenres, 23, "Aleksandr Solzjenitsyn");
		Book crimeAndPun = new Book("Crime and Punishment", "Book about the darker side of humanity", braveImg,"", bravegenres, 12, "Fjodor Dostojevski");
		Book catcherRye = new Book("The Catcher in the Rye", "Book about a boy who feels lost", braveImg,"", bravegenres, 16, "J.D. Salinger");
		Book notesUnder = new Book("Notes from Underground", "book about notes", braveImg,"", bravegenres, 34, "Fjodor Dostojevski");

		Anime dororo = new Anime("Dororo", "A cursed boy slowly regains his humanity", braveImg, "dark", bravegenres, 1, 5, "");
		Anime vinland = new Anime("Vinland saga", "Vikings", braveImg, "realistic", bravegenres, 1, 5, "");
		Anime towergod = new Anime("Tower of God", "a gauntlet", braveImg, "mysterious", bravegenres, 1, 5, "");

		Movie matrix =  new Movie("The Matrix", "blue pill or red pill", braveImg, "Lana & Lilly Wachowski", true);
		Movie fightclub =  new Movie("Fight Club", "its about a fight club", braveImg, "David Fincher", true);
		Movie killbill =  new Movie("Kill Bill", "the bride needs to kill bill", braveImg, "Quentin Tarantino", true);

		Manga madeabyss = new Manga("Made in Abyss", "A dark adventure going all the way down into the abyss", braveImg,70, "");
		Manga berserk = new Manga("Berserk", "A dark adventure", braveImg,30, "");
		Manga fma = new Manga("Full Metal Alchemist", "Magic comes at a cost", braveImg,30, "");

		Show breakingbad = new Show("Breaking bad", "selling meth is dangerous", braveImg, 5, 12);
		Show narcos = new Show("Narcos", "Pablo escobars rise and fall", braveImg, 5, 12);
		Show alteredcarbon = new Show("Altered Carbon", "people can now store their consciousness in devices", braveImg, 5, 12);

		// Demo
		demo.getArchive().addGenre(scifi);
		demo.getArchive().addGenre(thriller);
		demo.getArchive().addGenre(horror);
		demo.getArchive().addGenre(comedy);
		demo.getArchive().addGenre(romance);
		demo.getArchive().addGenre(adventure);

		demo.getArchive().addMedia(gulag);
		demo.getArchive().addMedia(crimeAndPun);
		demo.getArchive().addMedia(catcherRye);
		demo.getArchive().addMedia(notesUnder);
		demo.getArchive().addMedia(dororo);
		demo.getArchive().addMedia(vinland);
		demo.getArchive().addMedia(towergod);
		demo.getArchive().addMedia(matrix);
		demo.getArchive().addMedia(fightclub);
		demo.getArchive().addMedia(killbill);
//		demo.getArchive().addMedia(madeabyss);
//		demo.getArchive().addMedia(berserk);
//		demo.getArchive().addMedia(fma);
//		demo.getArchive().addMedia(breakingbad);
//		demo.getArchive().addMedia(narcos);
//		demo.getArchive().addMedia(alteredcarbon);
	}
	public void contextDestroyed(ServletContextEvent sce){

	}
}

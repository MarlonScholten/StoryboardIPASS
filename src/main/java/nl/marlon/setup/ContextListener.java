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

		ArrayList<Genre> towergenres = new ArrayList<>();
		towergenres.add(adventure);
		towergenres.add(comedy);
		towergenres.add(romance);

		Book gulag = new Book("The Gulag Archipelago", "History book about russian gulags. A real story", braveImg,"", bravegenres, 23, "Aleksandr Solzjenitsyn");
		Book crimeAndPun = new Book("Crime and Punishment", "Book about the darker side of humanity", braveImg,"", bravegenres, 12, "Fjodor Dostojevski");
		Book catcherRye = new Book("The Catcher in the Rye", "Book about a boy who feels lost", braveImg,"", bravegenres, 16, "J.D. Salinger");
		Book notesUnder = new Book("Notes from Underground", "book about notes", braveImg,"", bravegenres, 34, "Fjodor Dostojevski");

		Anime dororo = new Anime("Dororo", "A cursed boy slowly regains his humanity", braveImg, "dark", bravegenres, 1, 5, "");
		Anime vinland = new Anime("Vinland saga", "Vikings", braveImg, "realistic", bravegenres, 1, 5, "");
		Anime towergod = new Anime("Tower of God", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodd = new Anime("Tower of Godd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddd = new Anime("Tower of Goddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddd = new Anime("Tower of Godddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddd = new Anime("Tower of Goddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddddd = new Anime("Tower of Godddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddddd = new Anime("Tower of Goddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddddddd = new Anime("Tower of Godddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddddddd = new Anime("Tower of Goddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddddddddd = new Anime("Tower of Godddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddddddddd = new Anime("Tower of Goddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddddddddddd = new Anime("Tower of Godddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddddddddddd = new Anime("Tower of Goddddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddddddddddddd = new Anime("Tower of Godddddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddddddddddddd = new Anime("Tower of Goddddddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergodddddddddddddddd = new Anime("Tower of Godddddddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");
		Anime towergoddddddddddddddddd = new Anime("Tower of Goddddddddddddddddd", "Tower of God centers around a boy called Twenty-Fifth Bam, who has spent most of his life trapped beneath a vast and mysterious Tower, with only his close friend, Rachel, to keep him company. When Rachel enters the Tower, Bam manages to open the door into it as well, and faces challenges at each floor of this tower as he tries to find his closest companion.", braveImg, "mysterious", towergenres, 1, 13, "https://www.kickassanime.rs/anime/kami-no-tou-346996/episode-12-914903");

		Movie matrix =  new Movie("The Matrix", "blue pill or red pill", braveImg, "Lana & Lilly Wachowski", false);
		Movie fightclub =  new Movie("Fight Club", "its about a fight club", braveImg, "David Fincher", true);
		Movie killbill =  new Movie("Kill Bill", "the bride needs to kill bill", braveImg, "Quentin Tarantino", true);

		Manga madeabyss = new Manga("Made in Abyss", "A dark adventure going all the way down into the abyss", braveImg,70, "");
		Manga berserk = new Manga("Berserk", "A dark adventure",  braveImg,30, "");
		Manga fma = new Manga("Full Metal Alchemist", "Magic comes at a cost", braveImg,30, "");

		Show breakingbad = new Show("Breaking bad", "selling meth is dangerous", braveImg, 5, 12);
		Show narcos = new Show("Narcos", "Pablo escobars rise and fall", braveImg, 5, 12);
		Show alteredcarbon = new Show("Altered Carbon", "people can now store their consciousness in devices", braveImg, 5, 12);

		// Empty account
		User empty = new User("Empty", "empty", "empty");

		// Marlon account
		marlon.getArchive().addGenre(scifi);
		marlon.getArchive().addGenre(thriller);
		marlon.getArchive().addGenre(horror);
		marlon.getArchive().addGenre(comedy);
		marlon.getArchive().addGenre(romance);
		marlon.getArchive().addGenre(adventure);

		marlon.getArchive().addMedia(gulag);
		marlon.getArchive().addMedia(crimeAndPun);
		marlon.getArchive().addMedia(catcherRye);
		marlon.getArchive().addMedia(notesUnder);
		marlon.getArchive().addMedia(dororo);
		marlon.getArchive().addMedia(vinland);
		marlon.getArchive().addMedia(towergod);
		marlon.getArchive().addMedia(towergodd);
		marlon.getArchive().addMedia(towergoddd);
		marlon.getArchive().addMedia(towergodddd);
		marlon.getArchive().addMedia(towergoddddd);
		marlon.getArchive().addMedia(towergodddddd);
		marlon.getArchive().addMedia(towergoddddddd);
		marlon.getArchive().addMedia(towergodddddddd);
		marlon.getArchive().addMedia(towergoddddddddd);
		marlon.getArchive().addMedia(towergodddddddddd);
		marlon.getArchive().addMedia(towergoddddddddddd);
		marlon.getArchive().addMedia(towergodddddddddddd);
		marlon.getArchive().addMedia(towergoddddddddddddd);
		marlon.getArchive().addMedia(towergodddddddddddddd);
		marlon.getArchive().addMedia(towergoddddddddddddddd);
		marlon.getArchive().addMedia(towergodddddddddddddddd);
		marlon.getArchive().addMedia(towergoddddddddddddddddd);
		marlon.getArchive().addMedia(matrix);
		marlon.getArchive().addMedia(fightclub);
		marlon.getArchive().addMedia(killbill);
		marlon.getArchive().addMedia(madeabyss);
		marlon.getArchive().addMedia(berserk);
		marlon.getArchive().addMedia(fma);
		marlon.getArchive().addMedia(breakingbad);
		marlon.getArchive().addMedia(narcos);
		marlon.getArchive().addMedia(alteredcarbon);

		// Demo Account
		User demo = new User("demo", "demo@hotmail.com", "mypassword");

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

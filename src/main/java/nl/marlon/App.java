package nl.marlon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class App {
	public static void main(String [] args) throws IOException {
		Person marlon = new Person("Marlon", "marlon_scholten@live.nl", "123");
		Archive marchive = new Archive(marlon);

		File braveImg = new File("src/main/webapp/images/brave-new-world.jpg");

		Genre scifi= new Genre("Sci-fi");
		ArrayList<Genre> bravegenres = new ArrayList<>();
		bravegenres.add(scifi);

		Book bravenewworld = new Book("Brave new world", "A sci-fi thriller with interesting characters and a more interesting world", braveImg,"Very cool", bravegenres, 23, "Aldous Huxley");
		System.out.println(bravenewworld.toString());
	}
}

package nl.marlon.model;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArchiveTest {

	@Test
	void getOwner() {
		User user = new User("user", "user@email.com", "123");
		Archive archive = new Archive(user);

		assertEquals(user, archive.getOwner());
	}

	@Test
	void setOwner() {
		User user = new User("user", "user@email.com", "123");
		User user1 = new User("user1", "user1@email.com", "1234");
		Archive archive = new Archive(user);
		archive.setOwner(user1);

		assertEquals(user1, archive.getOwner());
	}

	@Test
	void getAllMedia() {
		User user = new User("user", "user@email.com", "123");
		File braveImg = new File("brave-new-world.jpg");
		Book gulag = new Book("The Gulag Archipelago", "History book about russian gulags. A real story", braveImg, 23, "Aleksandr Solzjenitsyn");
		Book crimeAndPun = new Book("Crime and Punishment", "Book about the darker side of humanity", braveImg,"", 12, "Fjodor Dostojevski");
		user.getArchive().addMedia(gulag);
		user.getArchive().addMedia(crimeAndPun);
		System.out.println(user.getArchive().getAllMedia());
		ArrayList<Media> expectedOutput = new ArrayList<>();
		expectedOutput.add(gulag);
		expectedOutput.add(crimeAndPun);

		assertEquals(expectedOutput, user.getArchive().getAllMedia());
	}

	@Test
	void addValidMedia() {
		User user = new User("user", "user@email.com", "123");
		File braveImg = new File("brave-new-world.jpg");
		Book gulag = new Book("The Gulag Archipelago", "History book about russian gulags. A real story", braveImg, 23, "Aleksandr Solzjenitsyn");

		assertEquals(true, user.getArchive().addMedia(gulag));
	}

	@Test
	void addInvalidMedia() {
		User user = new User("user", "user@email.com", "123");
		Archive archive = new Archive(user);

		assertEquals(false, user.getArchive().addMedia(archive));
	}

	@Test
	void getMediaById() {
		User user = new User("user", "user@email.com", "123");
		File braveImg = new File("brave-new-world.jpg");
		Book gulag = new Book("The Gulag Archipelago", "History book about russian gulags. A real story", braveImg, 23, "Aleksandr Solzjenitsyn");
		user.getArchive().addMedia(gulag);

		assertEquals(gulag, user.getArchive().getMediaById(gulag.id));
	}

	@Test
	void deleteMedia() {
		User user = new User("user", "user@email.com", "123");
		File braveImg = new File("brave-new-world.jpg");
		Book gulag = new Book("The Gulag Archipelago", "History book about russian gulags. A real story", braveImg, 23, "Aleksandr Solzjenitsyn");
		user.getArchive().addMedia(gulag);

		assertEquals(true, user.getArchive().deleteMedia(gulag.id));
	}

	@Test
	void addGenre() {
		User user = new User("user", "user@email.com", "123");
		Genre genre = new Genre("Horror");

		assertEquals(true, user.getArchive().addGenre(genre));
	}

	@Test
	void getGenreByName() {
		User user = new User("user", "user@email.com", "123");
		Genre genre = new Genre("Horror");
		user.getArchive().addGenre(genre);

		assertEquals(genre, user.getArchive().getGenreByName("Horror"));
	}
}
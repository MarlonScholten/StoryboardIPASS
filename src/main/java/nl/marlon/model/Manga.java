package nl.marlon.model;

import java.io.File;
import java.util.ArrayList;

public class Manga extends Media {
	private int chapter;
	private String link = "";
	// Feature idea: track the arc?

	// Full constructor
	public Manga(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int chapter, String link) {
		super(title, description, thumbnail, notes, genres);
		this.chapter = chapter;
		this.link = link;
	}
	// No genres
	public Manga(String title, String description, File thumbnail, String notes, int chapter, String link) {
		super(title, description, thumbnail, notes);
		this.chapter = chapter;
		this.link = link;
	}
	// No notes
	public Manga(String title, String description, File thumbnail, ArrayList<Genre> genres, int chapter, String link) {
		super(title, description, thumbnail, genres);
		this.chapter = chapter;
		this.link = link;
	}
	// No Link
	public Manga(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int chapter) {
		super(title, description, thumbnail, notes, genres);
		this.chapter = chapter;
	}
	// No genres & notes
	public Manga(String title, String description, File thumbnail, int chapter, String link) {
		super(title, description, thumbnail);
		this.chapter = chapter;
		this.link = link;
	}
	// No genres & link
	public Manga(String title, String description, File thumbnail, String notes, int chapter) {
		super(title, description, thumbnail, notes);
		this.chapter = chapter;
	}
	// No notes & link
	public Manga(String title, String description, File thumbnail, ArrayList<Genre> genres, int chapter) {
		super(title, description, thumbnail, genres);
		this.chapter = chapter;
	}
	// Bare minimum
	public Manga(String title, String description, File thumbnail, int chapter) {
		super(title, description, thumbnail);
		this.chapter = chapter;
	}

	public int getChapter() {
		return chapter;
	}

	public void setChapter(int chapter) {
		this.chapter = chapter;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return super.toString() +
				"Type: " + this.getClass().getSimpleName() + "\n" +
				"Chapter: " + chapter + "\n" +
				"Link: " + link + "\n";
	}
}

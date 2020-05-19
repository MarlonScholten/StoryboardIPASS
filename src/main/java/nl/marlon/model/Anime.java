package nl.marlon.model;

import java.io.File;
import java.util.ArrayList;

public class Anime extends Media{
	private int season;
	private int episode;
	private String link = "";

	// Full constructor
	public Anime(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int season, int episode, String link) {
		super(title, description, thumbnail, notes, genres);
		this.season = season;
		this.episode = episode;
		this.link = link;
	}
	// No genres
	public Anime(String title, String description, File thumbnail, String notes, int season, int episode, String link) {
		super(title, description, thumbnail, notes);
		this.season = season;
		this.episode = episode;
		this.link = link;
	}
	// No notes
	public Anime(String title, String description, File thumbnail, ArrayList<Genre> genres, int season, int episode, String link) {
		super(title, description, thumbnail, genres);
		this.season = season;
		this.episode = episode;
		this.link = link;
	}
	// No link
	public Anime(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int season, int episode) {
		super(title, description, thumbnail, notes, genres);
		this.season = season;
		this.episode = episode;
	}
	// No genres & notes
	public Anime(String title, String description, File thumbnail, int season, int episode, String link) {
		super(title, description, thumbnail);
		this.season = season;
		this.episode = episode;
		this.link = link;
	}
	// No link & genres
	public Anime(String title, String description, File thumbnail, String notes, int season, int episode) {
		super(title, description, thumbnail, notes);
		this.season = season;
		this.episode = episode;
	}
	// No notes & link
	public Anime(String title, String description, File thumbnail, ArrayList<Genre> genres, int season, int episode) {
		super(title, description, thumbnail, genres);
		this.season = season;
		this.episode = episode;
	}
	// Bare Minimum
	public Anime(String title, String description, File thumbnail, int season, int episode) {
		super(title, description, thumbnail);
		this.season = season;
		this.episode = episode;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
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
				"Season: " + season + "\n" +
				"Episode: " + episode + "\n"+
				"Link: " + link + "\n";
	}
}

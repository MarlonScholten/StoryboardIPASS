package nl.marlon.model;

import java.io.File;
import java.util.ArrayList;

public class Show extends Media {
	private int season;
	private int episode;

	// Full constructor
	public Show(String title, String description, File thumbnail, String notes, ArrayList<Genre> genres, int season, int episode) {
		super(title, description, thumbnail, notes, genres);
		this.season = season;
		this.episode = episode;
	}
	// No Genres
	public Show(String title, String description, File thumbnail, String notes, int season, int episode) {
		super(title, description, thumbnail, notes);
		this.season = season;
		this.episode = episode;
	}
	// No Notes
	public Show(String title, String description, File thumbnail, ArrayList<Genre> genres, int season, int episode) {
		super(title, description, thumbnail, genres);
		this.season = season;
		this.episode = episode;
	}
	// No Genres & Notes
	public Show(String title, String description, File thumbnail, int season, int episode) {
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

	@Override
	public String toString() {
		return super.toString() +
				"Type: " + this.getClass().getSimpleName() + "\n" +
				"Season: " + season + "\n" +
				"Episode: " + episode + "\n";
	}
}

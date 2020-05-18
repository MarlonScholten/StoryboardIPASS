package nl.marlon;

import java.awt.*;

public class Anime extends Media{
	private int season;
	private int episode;
	private String link;

	// Full constructor
	public Anime(String title, String description, String notes, int season, int episode, String link) {
		super(title, description, notes);
		this.season = season;
		this.episode = episode;
		this.link = link;
	}
	// No notes
	public Anime(String title, String description, int season, int episode, String link) {
		super(title, description);
		this.season = season;
		this.episode = episode;
		this.link = link;
	}
	// No link
	public Anime(String title, String description, String notes, int season, int episode) {
		super(title, description, notes);
		this.season = season;
		this.episode = episode;
	}
	// No notes and no link. Bare minimum
	public Anime(String title, String description, int season, int episode) {
		super(title, description);
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
}

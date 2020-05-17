package nl.marlon;

import java.awt.*;
import java.util.ArrayList;

public class Show {
	private String title;
	private String description;
	private Image thumbnail;
	private String notes;
	private int Season;
	private int episode;
	private ArrayList<Genre> genres;

	public Show(String title, String description, Image thumbnail, String notes, int season, int episode) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		Season = season;
		this.episode = episode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getSeason() {
		return Season;
	}

	public void setSeason(int season) {
		Season = season;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}

	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}
}

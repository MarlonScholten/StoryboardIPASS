package nl.marlon;

import java.awt.*;
import java.util.ArrayList;

public class Manga {
	private String title;
	private String description;
	private Image thumbnail;
	private String notes;
	private int chapter;
	private String link;
	private ArrayList<Genre> genres;

	public Manga(String title, String description, Image thumbnail, String notes, int chapter) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		this.chapter = chapter;
	}

	public Manga(String title, String description, Image thumbnail, String notes, int chapter, String link) {
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.notes = notes;
		this.chapter = chapter;
		this.link = link;
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
}

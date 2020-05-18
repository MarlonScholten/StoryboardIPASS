package nl.marlon;

import java.awt.*;

public class Book extends Media{
	private int page;
	private String author;

	//Full  constructor
	public Book(String title, String description, String notes, int page, String author){
		super(title, description, notes);
		this.page = page;
		this.author = author;
	}
	// No notes
	public Book(String title, String description, int page, String author){
		super(title, description);
		this.page = page;
		this.author = author;
	}
	// No author
	public Book(String title, String description, String notes, int page){
		super(title, description, notes);
		this.page = page;
	}
	// No Notes & author
	public Book(String title, String description, int page){
		super(title, description);
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}

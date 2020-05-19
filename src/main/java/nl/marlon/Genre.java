package nl.marlon;

import java.util.ArrayList;

public class Genre {
	private String name;
	private ArrayList<Media> items = new ArrayList<>();

	// Full constructor
	public Genre(String name, ArrayList<Media> items) {
		this.name = name;
		this.items = items;
	}

	public Genre(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Media> getItems() {
		return items;
	}
}

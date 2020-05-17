package nl.marlon;

import java.util.ArrayList;

public class Archive {
	private Person owner;
	private ArrayList<Category> categories;

	public Archive(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
}

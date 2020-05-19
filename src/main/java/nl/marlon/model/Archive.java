package nl.marlon.model;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

public class Archive {
	private User owner;
	private ArrayList<Media> allMedia = new ArrayList<>();

	// Full constructor
	public Archive(User owner, ArrayList<Media> allMedia) {
		this.owner = owner;
		this.allMedia = allMedia;
	}

	public Archive(User owner) {
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Media> getAllMedia() {
		return allMedia;
	}
}

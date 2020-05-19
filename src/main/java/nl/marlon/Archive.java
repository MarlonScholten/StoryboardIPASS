package nl.marlon;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;

public class Archive {
	private Person owner;
	private ArrayList<Media> allMedia = new ArrayList<>();

	// Full constructor
	public Archive(Person owner, ArrayList<Media> allMedia) {
		this.owner = owner;
		this.allMedia = allMedia;
	}

	public Archive(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public ArrayList<Media> getAllMedia() {
		return allMedia;
	}
}

package nl.marlon;

import javax.print.attribute.standard.Media;
import java.util.List;

public class Archive {
	private Person owner;
	private List<Media> allMedia;

	// Full constructor
	public Archive(Person owner, List<Media> allMedia) {
		this.owner = owner;
		this.allMedia = allMedia;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public List<Media> getAllMedia() {
		return allMedia;
	}
}

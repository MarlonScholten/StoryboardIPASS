package nl.marlon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;


public class Archive {
	private User owner;
	private ArrayList<Media> allMedia = new ArrayList<>();
	private ArrayList<Genre> allGenres = new ArrayList<>();

	// Full constructor
	public Archive(User owner, ArrayList<Media> allMedia) {
		this.owner = owner;
		this.allMedia = allMedia;
	}

	public Archive(User owner) {
		this.owner = owner;
	}

	@JsonIgnore
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Media> getAllMedia() {
		return allMedia;
	}

	public boolean addMedia(Object obj) {
		if(obj instanceof Media){
			Media media = (Media) obj;
			if(!(allMedia.contains(media))){
				allMedia.add(media);
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}

	public ArrayList getAllGenres() {
		return allGenres;
	}

	public boolean createGenre(String name){
		Genre newGenre = new Genre(name);
		if(allGenres.contains(newGenre)){
			return false;
		} else{
			allGenres.add(newGenre);
			return true;
		}
	}
}

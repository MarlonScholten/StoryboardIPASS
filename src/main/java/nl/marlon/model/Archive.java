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

	public Media getMediaById(String id){
		for(Media media : allMedia){
			if(media.id.equals(id)){
				return media;
			}
		}
		return null;
	}

	public boolean deleteMedia(String id){
		for(Media media : allMedia){
			if(media.id.equals(id)){
				allMedia.remove(media);
				return true;
			}
		}
		return false;
	}

	public boolean addGenre(Object obj){
		if(obj instanceof Genre){
			Genre genre = (Genre) obj;
			if(!(allGenres.contains(genre))){
				allGenres.add(genre);
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}

	public Genre getGenreByName(String name){
		for(Genre genre: allGenres){
			if (genre.getName().equals(name)){
				return genre;
			}
		}
		return null;
	}

	public ArrayList getAllGenres() {
		return allGenres;
	}
}

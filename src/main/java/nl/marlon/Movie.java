package nl.marlon;

public class Movie extends Media {
	private String director;
	private boolean seen;

	//Full constructor
	public Movie(String title, String description, String notes, String director, boolean seen){
		super(title, description, notes);
		this.director = director;
		this.seen = seen;
	}
	//No notes
	public Movie(String title, String description, String director, boolean seen){
		super(title, description);
		this.director = director;
		this.seen = seen;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}
}

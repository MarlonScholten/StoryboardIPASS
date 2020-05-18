package nl.marlon;

public class Manga extends Media {
	private int chapter;
	private String link;

	//Full constructor
	public Manga(String title, String description, String notes, int chapter, String link){
		super(title, description, notes);
		this.chapter = chapter;
		this.link = link;
	}
	//No notes
	public Manga(String title, String description, int chapter, String link){
		super(title, description);
		this.chapter = chapter;
		this.link = link;
	}
	//No link
	public Manga(String title, String description, String notes, int chapter){
		super(title, description, notes);
		this.chapter = chapter;
	}
	//No notes & link
	public Manga(String title, String description, int chapter){
		super(title, description);
		this.chapter = chapter;
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

package nl.marlon;

public class Show extends Media {
	private int season;
	private int episode;

	//Full constructor
	public Show(String title, String description, String notes, int season, int episode){
		super(title, description, notes);
		this.season = season;
		this.episode = episode;
	}
	//No notes
	public Show(String title, String description, int season, int episode){
		super(title, description);
		this.season = season;
		this.episode = episode;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getEpisode() {
		return episode;
	}

	public void setEpisode(int episode) {
		this.episode = episode;
	}
}

package models.trackTV;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Content {

	private String title;
	private int year;
	private String url;
	private String overview;
	private String country;
	private String status;
	private String network;
	private String poster;
	ArrayList<String> genres;
	People people;
	private String air_day;
	private String air_time;
	private String imdb_id;
	private String tvrage_id;
	ArrayList<Episode> top_episodes;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public ArrayList<String> getGenres() {
		return genres;
	}
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	public String getAir_day() {
		return air_day;
	}
	public void setAir_day(String air_day) {
		this.air_day = air_day;
	}
	public String getAir_time() {
		return air_time;
	}
	public void setAir_time(String air_time) {
		this.air_time = air_time;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getTvrage_id() {
		return tvrage_id;
	}
	public void setTvrage_id(String tvrage_id) {
		this.tvrage_id = tvrage_id;
	}
	public ArrayList<Episode> getTop_episodes() {
		return top_episodes;
	}
	public void setTop_episodes(ArrayList<Episode> top_episodes) {
		this.top_episodes = top_episodes;
	}
	public People getPeople() {
		return people;
	}
	public void setPeople(People people) {
		this.people = people;
	}
	
	
}

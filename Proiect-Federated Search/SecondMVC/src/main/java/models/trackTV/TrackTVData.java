package models.trackTV;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TrackTVData {

	private int noEntries;
	private ArrayList<Content> content;
	
	public int getNoEntries() {
		return noEntries;
	}
	public void setNoEntries(int noEntries) {
		this.noEntries = noEntries;
	}
	public ArrayList<Content> getContent() {
		return content;
	}
	public void setContent(ArrayList<Content> content) {
		this.content = content;
	} 
	
}

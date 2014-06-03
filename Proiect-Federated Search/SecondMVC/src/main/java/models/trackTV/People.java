package models.trackTV;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class People {

	ArrayList<Actor> actors;

	public ArrayList<Actor> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	} 

    @Override
    public String toString(){
        String result = "";
        for(Actor actor : actors){
            result += actor.getName();
        }
        return result;
    }
}

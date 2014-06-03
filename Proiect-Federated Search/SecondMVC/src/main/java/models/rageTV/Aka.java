package models.rageTV;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by cudrescu on 5/26/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Aka {

    private ArrayList<AkaContent> aka;

    public ArrayList<AkaContent> getAka() {
        return aka;
    }

    public void setAka(ArrayList<AkaContent> aka) {
        this.aka = aka;
    }
}

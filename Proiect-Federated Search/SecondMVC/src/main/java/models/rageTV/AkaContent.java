package models.rageTV;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by cudrescu on 5/26/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class AkaContent {

    private String content;
    private String country;
    @JsonIgnore
    private String attr;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}

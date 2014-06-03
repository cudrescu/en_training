package models.imdb;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by cudrescu on 5/23/2014.
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class ImdbTempReply {

    private String message;
    private String detail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

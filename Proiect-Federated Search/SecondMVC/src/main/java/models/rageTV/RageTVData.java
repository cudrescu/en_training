package models.rageTV;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by cudrescu on 5/26/2014.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class RageTVData {

    private String airtime;
    private String showid;
    private String status;
    private String runtime;
    private String airday;
    private String origin_country;
    private String timezone;
    private String startdate;
    private String seasons;
    private String showname;
    private String classification;
    private String started;
    private String showlink;
    @JsonProperty("akas")
    private Aka akas;
    private Network network;

    public String getAirtime() {
        return airtime;
    }

    public void setAirtime(String airtime) {
        this.airtime = airtime;
    }

    public String getShowid() {
        return showid;
    }

    public void setShowid(String showid) {
        this.showid = showid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getAirday() {
        return airday;
    }

    public void setAirday(String airday) {
        this.airday = airday;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getShowlink() {
        return showlink;
    }

    public void setShowlink(String showlink) {
        this.showlink = showlink;
    }

    public Aka getAkas() {
        return akas;
    }

    public void setAkas(AkaContent aka) {
        this.akas = akas;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}

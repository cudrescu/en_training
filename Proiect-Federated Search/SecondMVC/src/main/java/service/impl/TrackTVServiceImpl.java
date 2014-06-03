package service.impl;

import models.trackTV.TrackTVData;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import service.TrackTVService;

import java.io.IOException;

/**
 * Created by Cristian on 5/25/2014.
 */
@Service
public class TrackTVServiceImpl implements TrackTVService{

    private static final String url = "http://localhost:8081/tracktv?query=";
    private TrackTVData trackTVData;
    private String movieName;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TrackTVData getTrackTVData() {
        return trackTVData;
    }

    public void setTrackTVData(TrackTVData trackTVData) {
        this.trackTVData = trackTVData;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    private TrackTVData getDataFromServer(String movieName) {

        TrackTVData trackTVReply = null;
        String serverReply;

        try {
            serverReply = restTemplate.getForObject(url+movieName, String.class);
            ObjectMapper mapper = new ObjectMapper();
            trackTVReply = mapper.readValue(serverReply, TrackTVData.class);
        }
        catch (HttpMessageNotReadableException e){}
        catch (HttpClientErrorException e){}
        catch (JsonMappingException e) {}
        catch (JsonParseException e) {}
        catch (IOException e) {}
        catch (ResourceAccessException e){}

        return trackTVReply;
    }

    @Override
    public void run(){
        setTrackTVData(getDataFromServer(movieName));
    }
}

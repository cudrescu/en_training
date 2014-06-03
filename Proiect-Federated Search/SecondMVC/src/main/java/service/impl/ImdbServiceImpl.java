package service.impl;

import models.imdb.ImdbData;
import models.imdb.ImdbTempReply;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import service.ImdbService;

/**
 * Created by Cristian on 5/25/2014.
 */
@Service
public class ImdbServiceImpl implements ImdbService{

    private static final String url = "http://localhost:8082/movies/";
    private static final int maxWaitingTime = 3000;
    private ImdbData[] imdbData;
    private String movieName;

    @Autowired
    private RestTemplate restTemplate;

    public String getMovieName() {
        return movieName;
    }

    @Override
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public ImdbData[] getImdbData() {
        return imdbData;
    }

    public void setImdbData(ImdbData[] imdbData) {
        this.imdbData = imdbData;
    }

    private ImdbData[] getDataFromServer(String movieName) {

        ImdbData[] imdbData = null;
        ImdbTempReply imdbTempReply;
        int waitTime = 0;
        try  {
            imdbTempReply = restTemplate.getForObject(url+movieName, ImdbTempReply.class);
            while(true) {
                try {
                   String serverReply;
                   ResponseEntity<String> responseEntity = restTemplate.getForEntity(imdbTempReply.getDetail(), String.class);
                    if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                        serverReply = responseEntity.getBody();
                        ObjectMapper mapper = new ObjectMapper();
                        imdbData = mapper.readValue(serverReply, ImdbData[].class);
                        break;
                    }
                } catch (Exception e) {
                    try {
                        Thread.sleep(500);
                        waitTime += 500;
                    } catch (InterruptedException ie) {}
                    finally {
                        if(waitTime >= maxWaitingTime)
                            break;
                    }
                }
            }
        }
        catch (HttpMessageNotReadableException e) {}
        catch (HttpServerErrorException e){}
        catch (HttpClientErrorException e){}
        catch (ResourceAccessException e){}

        return imdbData;
    }

    @Override
    public void run(){
        setImdbData(getDataFromServer(movieName));
    }
}

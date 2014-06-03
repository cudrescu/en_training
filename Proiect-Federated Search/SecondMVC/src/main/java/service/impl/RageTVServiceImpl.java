package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import service.RageTVService;

/**
 * Created by Cristian on 5/25/2014.
 */
@Service
public class RageTVServiceImpl implements RageTVService{

    private static final String url =  "http://localhost:8083/tvrage/query/";
    private static final String callback = "?callback=http://localhost:8080/callback";
    private static final int maxWaitingTime = 3000;
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

    private void getDataFromServer(String movieName) {

        int waitTime = 0;

        while(true) {
            try {
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(url + movieName + callback, String.class);
                if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                    break;
                }
            }catch(HttpServerErrorException e){
                try {
                    Thread.sleep(500);
                    waitTime += 500;
                } catch (InterruptedException ie) {}
            }
            catch (ResourceAccessException e){
                break;
            }
            finally {
                if(waitTime >= maxWaitingTime)
                    break;
            }
        }
    }

    @Override
    public void run(){
        getDataFromServer(movieName);
    }
}

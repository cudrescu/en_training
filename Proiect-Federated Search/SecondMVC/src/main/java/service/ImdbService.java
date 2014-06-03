package service;

import models.imdb.ImdbData;

import java.util.List;

/**
 * Created by Cristian on 5/25/2014.
 */
public interface ImdbService extends Runnable{

    public void setMovieName(String movieName);

    public ImdbData[] getImdbData();
}

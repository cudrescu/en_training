package service;

import models.trackTV.TrackTVData;

/**
 * Created by Cristian on 5/25/2014.
 */
public interface TrackTVService extends Runnable{

    public void setMovieName(String movieName);

    public TrackTVData getTrackTVData();
}

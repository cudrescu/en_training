package service;

import models.mergeData.MovieData;

import java.util.List;

/**
 * Created by cudrescu on 5/29/2014.
 */
public interface MainService extends Runnable {
    public void setMovieName(String movieName);
    public List<MovieData> getMovieDataList();
}

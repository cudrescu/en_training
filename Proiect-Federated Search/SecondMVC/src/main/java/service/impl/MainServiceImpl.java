package service.impl;

import models.mergeData.MovieData;
import org.springframework.beans.factory.annotation.Autowired;
import service.MainService;
import service.MovieService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cudrescu on 5/29/2014.
 */
public class MainServiceImpl implements MainService{

    private String movieName;
    private List<MovieData> movieDataList;

    @Autowired
    MovieService movieService;

    @Override
    public void run() {
        movieDataList = new ArrayList<MovieData>(movieService.processRequest(movieName));
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<MovieData> getMovieDataList() {
        return movieDataList;
    }
}

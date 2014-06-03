package service.impl;

import dao.MovieDao;
import dao.QueryDao;
import models.imdb.ImdbData;
import models.mergeData.MovieData;
import models.mergeData.Query;
import models.rageTV.RageTVData;
import models.trackTV.Content;
import models.trackTV.TrackTVData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ImdbService;
import service.MovieService;
import service.RageTVService;
import service.TrackTVService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cudrescu on 5/26/2014.
 */
@Service
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;
    @Autowired
    private QueryDao queryDao;
    @Autowired
    private ImdbService imdbService;
    @Autowired
    private RageTVService rageTVService;
    @Autowired
    private TrackTVService trackTVService;

    private RageTVData[] rageTVData;
    private ImdbData[] imdbData;
    private TrackTVData trackTVData;
    private boolean callbackChecker = false;
    private static final int maxWaitingTime = 3000;
    private List<MovieData> movieDataList = new ArrayList<MovieData>();
    private Query query;

    private void init(){
        if(movieDataList!=null)
            movieDataList.clear();

        callbackChecker = false;
        rageTVData = null;
        imdbData = null;
        trackTVData = null;
    }

    @Override
    @Transactional
    public void saveMovieData(MovieData toBeSaved) {
      movieDao.saveAndFlush(toBeSaved);
    }

    @Override
    @Transactional
    public void removeMovieData(MovieData toBeRemoved) {
        movieDao.delete(toBeRemoved);
    }

    @Override
    @Transactional
    public void removeQuery(Query toBeRemoved){
        queryDao.delete(toBeRemoved);
    }

    @Override
    @Transactional
    public void saveQuery(Query toBeSaved) {
       queryDao.saveAndFlush(toBeSaved);
    }

    @Override
    public void setAnswerFromCallbackServer(RageTVData[] rageTVData){
        this.rageTVData = rageTVData;
        this.callbackChecker = true;
    }

    @Override
    public List<Query> findQueries(String movieName){
        return queryDao.findQueryByRequestedMovie(movieName);
    }

    @Override
    public void getMovieDataFromServer(String movieName, Query query) {

        imdbService.setMovieName(movieName);
        rageTVService.setMovieName(movieName);
        trackTVService.setMovieName(movieName);

        Thread imdbThread = new Thread(imdbService);
        Thread rageTVThread = new Thread(rageTVService);
        Thread trackTVThread = new Thread(trackTVService);

        imdbThread.start();
        rageTVThread.start();
        trackTVThread.start();

        try {
            imdbThread.join();
            rageTVThread.join();
            trackTVThread.join();
        } catch (InterruptedException e) {}

        imdbData = imdbService.getImdbData();
        trackTVData = trackTVService.getTrackTVData();

        int waitTime = 0;
        while (!isRageTVDataReceived() && waitTime < maxWaitingTime){
            try {
                Thread.sleep(250);
                waitTime += 250;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mergeRageTVData(rageTVData, query);
        mergeTrackTVData(trackTVData, query);
        mergeImdbData(imdbData, query);
    }

    private boolean isRageTVDataReceived(){
        return callbackChecker;
    }

    private int searchExistingEntry(String movieTitle, String movieID){
        for(int i = 0; movieDataList != null && i<movieDataList.size(); i++){
            if(movieDataList.get(i).getTitle().equals(movieTitle))
                return i;
            if(movieDataList.get(i).getImdbID().equals(movieID)){
                return i;
            }
        }
        return -1;
    }

    private void mergeImdbData(ImdbData[] imdbData, Query query) {

        for (int i = 0; imdbData!= null && i < imdbData.length; i++) {
            int index = searchExistingEntry(imdbData[i].getTitle(), imdbData[i].getImdbID());

            if(index == -1){
                movieDataList.add(new MovieData());
                movieDataList.get(movieDataList.size()-1).setQuery(query);
                setAttributesToMovieData(imdbData[i], movieDataList.size() - 1, movieDataList);
            }

            if(index != -1){
                setAttributesToMovieData(imdbData[i], index, movieDataList);
            }
        }
    }

    private void mergeRageTVData(RageTVData[] rageTVData, Query query) {

        for (int i = 0; rageTVData != null && i < rageTVData.length; i++) {
            int index = searchExistingEntry(rageTVData[i].getShowname(), rageTVData[i].getShowid());

            if(index == -1){
                movieDataList.add(new MovieData());
                movieDataList.get(movieDataList.size()-1).setQuery(query);
                setAttributesToMovieData(rageTVData[i], movieDataList.size() - 1, movieDataList);
            }

            if(index != -1){
                setAttributesToMovieData(rageTVData[i], index, movieDataList);
            }
        }
    }

    private void mergeTrackTVData(TrackTVData trackTVData, Query query) {

        for (int i = 0; trackTVData!= null && i < trackTVData.getNoEntries(); i++) {
            int index = searchExistingEntry(trackTVData.getContent().get(i).getTitle(), trackTVData.getContent().get(i).getTvrage_id());

            if(index == -1){
                movieDataList.add(new MovieData());
                movieDataList.get(movieDataList.size()-1).setQuery(query);
                setAttributesToMovieData(trackTVData.getContent().get(i), movieDataList.size() - 1, movieDataList);
            }

            if(index != -1){
                setAttributesToMovieData(trackTVData.getContent().get(i), index, movieDataList);
            }
        }
    }

    private void setAttributesToMovieData(ImdbData imdbData, int index, List<MovieData> movieDataList) {
        movieDataList.get(index).setTitle(imdbData.getTitle());
        movieDataList.get(index).setYear(imdbData.getYear());
        movieDataList.get(index).setRated(imdbData.getRated());
        movieDataList.get(index).setReleased(imdbData.getReleased());
        movieDataList.get(index).setRuntime(imdbData.getRuntime());
        movieDataList.get(index).setGenre(imdbData.getGenre());
        movieDataList.get(index).setDirector(imdbData.getDirector());
        movieDataList.get(index).setWriter(imdbData.getWriter());
        movieDataList.get(index).setActors(imdbData.getActors());
        movieDataList.get(index).setPlot(imdbData.getPlot());
        movieDataList.get(index).setLanguage(imdbData.getLanguage());
        movieDataList.get(index).setCountry(imdbData.getCountry());
        movieDataList.get(index).setAwards(imdbData.getAwards());
        movieDataList.get(index).setPoster(imdbData.getPoster());
        movieDataList.get(index).setMetascore(imdbData.getMetascore());
        movieDataList.get(index).setImdbRating(imdbData.getImdbRating());
        movieDataList.get(index).setImdbVotes(imdbData.getImdbVotes());
        movieDataList.get(index).setImdbID(imdbData.getImdbID());
        movieDataList.get(index).setType(imdbData.getType());
    }

    private void setAttributesToMovieData(RageTVData rageTVData, int index, List<MovieData> movieDataList) {
        movieDataList.get(index).setTitle(rageTVData.getShowname());
        movieDataList.get(index).setYear(rageTVData.getStarted());
        movieDataList.get(index).setCountry(rageTVData.getOrigin_country());
        movieDataList.get(index).setStatus(rageTVData.getStatus());
        movieDataList.get(index).setAir_time(rageTVData.getAirtime());
        movieDataList.get(index).setAir_day(rageTVData.getAirday());
        movieDataList.get(index).setImdbID(rageTVData.getShowid());

        movieDataList.get(index).setSeasons(rageTVData.getSeasons());
        movieDataList.get(index).setClassification(rageTVData.getClassification());
    }

    private void setAttributesToMovieData(Content trackTVData, int index, List<MovieData> movieDataList) {
        movieDataList.get(index).setTitle(trackTVData.getTitle());
        movieDataList.get(index).setYear(Integer.toString(trackTVData.getYear()));
        movieDataList.get(index).setPoster(trackTVData.getPoster());
        movieDataList.get(index).setCountry(trackTVData.getCountry());
        movieDataList.get(index).setGenre(trackTVData.getGenres().toString());
        movieDataList.get(index).setActors(trackTVData.getPeople().toString());
        movieDataList.get(index).setPlot(trackTVData.getOverview());
        movieDataList.get(index).setImdbID(trackTVData.getImdb_id());
        movieDataList.get(index).setUrl(trackTVData.getUrl());

        movieDataList.get(index).setNetwork(trackTVData.getNetwork());
        movieDataList.get(index).setAir_day(trackTVData.getAir_day());
        movieDataList.get(index).setAir_time(trackTVData.getAir_time());
        movieDataList.get(index).setStatus(trackTVData.getStatus());
    }

    @Override
    public void getMovieDataFromDB(String movieName) {
        List<Query> queryList = findQueries(movieName);
        for(Query query : queryList){
           for(MovieData movieData : query.getMovieDataList()){
                movieDataList.add(movieData);
           }
        }
    }

    @Override
    public synchronized List<MovieData> processRequest(String movieName) {

        init();

        getMovieDataFromDB(movieName);
        if(movieDataList == null || movieDataList.isEmpty()){

            query = new Query();
            query.setRequestedMovie(movieName);
            Timestamp insertedTime = new Timestamp(System.currentTimeMillis());
            query.setInsertedTime(insertedTime);

            getMovieDataFromServer(movieName,query);
            query.setMovieDataList(movieDataList);

            if(!movieDataList.isEmpty()){
                saveQuery(query);
            }
        }

        return movieDataList;
    }
}

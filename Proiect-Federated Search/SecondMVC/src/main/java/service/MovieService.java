package service;

import models.mergeData.MovieData;
import models.mergeData.Query;
import models.rageTV.RageTVData;

import java.util.List;

/**
 * Created by cudrescu on 5/26/2014.
 */
public interface MovieService{

    public void saveMovieData(MovieData toBeSaved);

    public void saveQuery(Query query);

    public void removeMovieData(MovieData toBeRemoved);

    public void removeQuery(Query query);

    public void setAnswerFromCallbackServer(RageTVData[] rageTVData);

    public void getMovieDataFromServer(String movieName, Query query);

    public void getMovieDataFromDB(String movieName);

    public List<MovieData> processRequest(String movieName);

    public List<Query> findQueries(String movieName);
}

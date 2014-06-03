package com.springapp.service;

import dao.MovieDao;
import dao.QueryDao;
import models.mergeData.Query;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import service.impl.MovieServiceImpl;

import static java.lang.System.out;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cudrescu on 5/30/2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

    private static String requestedMovie = "stargate";
    private static Date insertedTime = new Timestamp(System.currentTimeMillis());
    private static Query query = new Query(){{
        setRequestedMovie(requestedMovie);
        setInsertedTime(insertedTime);
    }};

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private QueryDao queryDao;

    @Mock
    private MovieDao movieDao;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testFindByRequestedMovieSuccess() throws Exception {
        when(queryDao.findQueryByRequestedMovie(requestedMovie)).thenReturn(Arrays.asList(query));

        List<Query> actualQuery = movieService.findQueries(requestedMovie);

        assertThat(actualQuery.get(0), is(query));
    }

    @Test
    public void testFindByRequestedMovieFail() throws Exception {
        when(queryDao.findQueryByRequestedMovie(requestedMovie)).thenReturn((Collections.<Query>emptyList()));

        List<Query> actualQuery = movieService.findQueries(requestedMovie);

        verify(queryDao, times(1)).findQueryByRequestedMovie(requestedMovie);
    }

    @Test
    public void testSaveSuccess() throws Exception {
        when(queryDao.save(query)).thenReturn(query);

        movieService.saveQuery(query);

        assertThat(query.getRequestedMovie() , is(requestedMovie));
    }


    @Test
    public void testSaveFail() throws Exception {
        //exception.expect(RuntimeException.class);
        when(queryDao.save(query)).thenThrow(RuntimeException.class);

        movieService.saveQuery(query);

        assertThat(query.getRequestedMovie() , is(requestedMovie));
    }

}

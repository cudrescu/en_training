package com.springapp.repository;

import models.mergeData.Query;

import java.util.List;

/**
 * Created by cudrescu on 5/30/2014.
 */
public class QueryRepositoryStub {

    List<Query> queries;

    public List<Query> getQueries() {
        return queries;
    }

    public void setQueries(List<Query> queries) {
        this.queries = queries;
    }
}

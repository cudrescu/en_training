package dao;

import models.mergeData.MovieData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Cristian on 5/25/2014.
 */
@Repository
public interface MovieDao extends JpaRepository<MovieData,Long> {

}

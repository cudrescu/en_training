package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by cudrescu on 5/30/2014.
 */
public interface QueryDao  extends JpaRepository<models.mergeData.Query,Long> {

    public List<models.mergeData.Query> findQueryByRequestedMovie(String requestedMovie);

    @Query("SELECT q FROM Query q WHERE q.insertedTime < :currentTime")
    public List<models.mergeData.Query> find(@Param("currentTime") Timestamp currentTime);
}

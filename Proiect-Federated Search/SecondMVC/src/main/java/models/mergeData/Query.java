package models.mergeData;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by cudrescu on 5/30/2014.
 */
@Entity
@Table(name="query")
public class Query {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idQuery;
    private String requestedMovie;
    @Basic(optional = false)
    @Column(name = "insertedTime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertedTime;

    @OneToMany(mappedBy="query", fetch=FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private List<MovieData> movieDataList;

    public List<MovieData> getMovieDataList() {
        return movieDataList;
    }

    public void setMovieDataList(List<MovieData> movieDataSet) {
        this.movieDataList = movieDataSet;
    }

    public int getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(int idQuery) {
        this.idQuery = idQuery;
    }

    public String getRequestedMovie() {
        return requestedMovie;
    }

    public void setRequestedMovie(String requestedMovie) {
        this.requestedMovie = requestedMovie;
    }

    public Date getInsertedTime() {
        return insertedTime;
    }

    public void setInsertedTime(Date insertedTime) {
        this.insertedTime = insertedTime;
    }
}

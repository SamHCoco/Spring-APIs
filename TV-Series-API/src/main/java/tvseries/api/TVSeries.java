package tvseries.api;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TVSeries {

    @Id
    private String id;
    private String title;
    private int year;
    private String genre;
    private String description;

    protected TVSeries(){

    }

    public TVSeries(String id, String title, int year, String genre, String description){
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.description = description;
    }

    //  GETTERS
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }
}

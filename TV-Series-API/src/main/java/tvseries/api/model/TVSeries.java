package tvseries.api.model;

import javax.persistence.*;

@Entity
@Table(name = "tvseries")
public class TVSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private int year;
    private String genre;
    private String description;

    public TVSeries(){

    }

    // constructor for unit testing
    public TVSeries(int id, String title, int year, String genre, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.description = description;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // GETTERS
    public int getId() {
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

    /**
     * Updates the fields of the object with the field values of another TVSeries object.
     * @param tvSeries The TVSeries object whose field values will update the object's field values.
     */
    public void updateFields(TVSeries tvSeries){
        if(tvSeries.getTitle() != null && !tvSeries.getTitle().isEmpty()){
            title = tvSeries.getTitle();
        }
        if(tvSeries.getGenre() != null && !tvSeries.getGenre().isEmpty()){
            genre = tvSeries.getGenre();
        }
        if(tvSeries.getDescription() != null && !tvSeries.getDescription().isEmpty()){
            description = tvSeries.getDescription();
        }
        if(tvSeries.getYear() != 0){
            year = tvSeries.getYear();
        }
    }
}

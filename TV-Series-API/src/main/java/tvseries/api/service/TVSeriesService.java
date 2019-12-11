package tvseries.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import tvseries.api.model.TVSeries;
import tvseries.api.repository.TVSeriesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@ComponentScan("tvseries.api")
public class TVSeriesService {

    @Autowired
    private TVSeriesRepository tvSeriesRepository;

    /**
     * Service to get all TV series in database, or just a subset, filtered by release year or genre, or both.
     * @param genre The desired genre (Adventure, Sci-Fi, Comedy-Drama or Crime).
     * @param year The desired release year for TV series.
     * @return All TV series in the database, or all series filtered by year, genre or both.
     */
    public List<TVSeries> getAllTVSeries(String genre, Integer year){
        List<TVSeries> tvSeries = new ArrayList<>();
        if(genre == null && year == null){
            tvSeriesRepository.findAll().forEach(tvSeries::add);

        } else if(year != null && genre != null){
            tvSeriesRepository.findAllByYearAndGenre(year, genre).forEach(tvSeries::add);

        } else if(year != null && genre == null){
            tvSeriesRepository.findAllByYear(year).forEach(tvSeries::add);

        } else if(year == null && genre != null){
            tvSeriesRepository.findAllByGenre(genre).forEach(tvSeries::add);
        }
        return tvSeries;
    }

    /**
     * Service to get a single TV series from the database, specified by its ID.
     * @param id The ID of the desired TV series.
     * @return The queried TV series, or null if it's not present in the database.
     */
    public TVSeries getTVSeries(int id){
        if(tvSeriesRepository.findById(id).isPresent()){
            return tvSeriesRepository.findById(id).get();
        }
        return null;
    }

    /**
     * Service to add a single TV series to the database.
     * @param tvSeries The TV series to be added to the database.
     * @return True if the TV series as successfully added, or false otherwise.
     */
    public boolean addTVSeries(TVSeries tvSeries){
        boolean isAdded = false;
        tvSeriesRepository.save(tvSeries);
        if(tvSeriesRepository.existsById(tvSeries.getId())){
            isAdded = true;
        }
        return isAdded;
    }

    /**
     * Service to delete a single TV series from the database.
     * @param id The ID of the TV series to be deleted.
     * @return True if the TV series was successfully deleted, or false otherwise.
     */
    public boolean deleteTVSeries(int id){
        boolean isDeleted = false;
        if(tvSeriesRepository.findById(id).isPresent()){
            tvSeriesRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }
}

package tvseries.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TVSeriesService {

    @Autowired
    private TVSeriesRepository tvSeriesRepository;

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

    public TVSeries getTVSeries(int id){
        if(tvSeriesRepository.findById(id).isPresent()){
            return tvSeriesRepository.findById(id).get();
        }
        return null;
    }

    public void addTVSeries(TVSeries tvSeries){
        tvSeriesRepository.save(tvSeries);
    }

    public boolean deleteTVSeries(int id){
        boolean isDeleted = false;
        if(tvSeriesRepository.findById(id).isPresent()){
            tvSeriesRepository.deleteById(id);
            isDeleted = true;
        }
        return isDeleted;
    }
}

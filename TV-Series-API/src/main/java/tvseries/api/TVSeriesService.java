package tvseries.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TVSeriesService {

    @Autowired
    private TVSeriesRepository tvSeriesRepository;

    public List<TVSeries> getAllTVSeries(){
        List<TVSeries> tvSeries = new ArrayList<>();
        tvSeriesRepository.findAll().forEach(tvSeries::add);
        return tvSeries;
    }

    public TVSeries getTVSeries(int id){
        if(tvSeriesRepository.findById(id).isPresent()){
            return tvSeriesRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public void addTVSeries(TVSeries tvSeries){
        tvSeriesRepository.save(tvSeries);
    }
}

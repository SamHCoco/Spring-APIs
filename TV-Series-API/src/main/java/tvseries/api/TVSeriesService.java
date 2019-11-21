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
}

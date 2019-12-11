package tvseries.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tvseries.api.model.TVSeries;

import java.util.List;

@Repository
public interface TVSeriesRepository extends CrudRepository<TVSeries, Integer> {
    List<TVSeries> findAllByGenre(String genre);
    List<TVSeries> findAllByYear(int year);
    List<TVSeries> findAllByYearAndGenre(int year, String genre);
}

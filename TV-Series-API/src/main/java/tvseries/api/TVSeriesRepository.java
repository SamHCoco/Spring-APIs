package tvseries.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVSeriesRepository extends CrudRepository<TVSeries, Integer> {

}

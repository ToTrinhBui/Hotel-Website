package hotel.data;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.Stats;

public interface StatsRepository extends CrudRepository<Stats, Integer>{

}

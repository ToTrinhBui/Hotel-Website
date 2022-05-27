package hotel.data;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
}
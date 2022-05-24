package hotel.data;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}

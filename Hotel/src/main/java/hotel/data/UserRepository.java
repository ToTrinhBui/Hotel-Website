package hotel.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hotel.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "select * from customer c where c.name like %:keyword% or c.phone like %:keyword%", nativeQuery = true)
	public List<User> search(String keyword);
}

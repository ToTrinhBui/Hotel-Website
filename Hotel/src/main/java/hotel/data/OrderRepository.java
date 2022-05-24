package hotel.data;

import org.springframework.data.repository.CrudRepository;

import hotel.entity.Order;

public interface OrderRepository extends CrudRepository<Order, String> {
}
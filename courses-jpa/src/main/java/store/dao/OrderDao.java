package store.dao;

import java.util.List;

import store.models.Order;

public interface OrderDao {

	void deleteByIdentifier(int identifier);

	List<Order> findAll();

	Order findByIdentifier(int identifier);

	Order save(Order order);

}

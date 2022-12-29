package store.dao;

import java.util.List;

import store.models.Customer;

public interface CustomerDao {

	void deleteByIdentifier(int identifier);

	List<Customer> findAll();

	Customer findByIdentifier(int identifier);

	Customer save(Customer customer);

}

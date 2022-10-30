package store.dao;

import java.util.List;

import store.models.Product;

public interface ProductDao {

	void deleteByIdentifier(int identifier);

	List<Product> findAll();

	Product findByIdentifier(int identifier);

	void save(Product product);

}

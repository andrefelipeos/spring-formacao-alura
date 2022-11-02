package store.dao;

import java.util.List;

import store.models.Category;
import store.models.Product;

public interface ProductDao {

	void deleteByIdentifier(int identifier);

	List<Product> findAll();

	Product findByIdentifier(int identifier);

	List<Product> findByCategory(Category category);

	void save(Product product);

}

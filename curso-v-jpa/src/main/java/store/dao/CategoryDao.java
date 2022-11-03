package store.dao;

import java.util.List;

import store.models.Category;

public interface CategoryDao {

	void deleteByIdentifier(int identifier);

	List<Category> findAll();

	Category findByIdentifier(int identifier);

	Category save(Category category);

}

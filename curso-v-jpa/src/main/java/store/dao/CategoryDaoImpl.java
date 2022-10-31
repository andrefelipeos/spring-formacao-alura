package store.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Category;

public class CategoryDaoImpl implements CategoryDao {

	private EntityManager entityManager = null;

	public CategoryDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByIdentifier(int identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Category category) {
		this.entityManager.persist(category);
	}

}

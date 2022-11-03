package store.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Category;
import store.util.JPAUtil;

public class CategoryDaoImpl implements CategoryDao {

	private EntityManager entityManager = null;

	public CategoryDaoImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> findAll() {
		return entityManager.createQuery("SELECT c FROM Category c", Category.class)
				.getResultList();
	}

	@Override
	public Category findByIdentifier(int identifier) {
		return entityManager.find(Category.class, identifier);
	}

	@Override
	public void save(Category category) {
		entityManager.getTransaction().begin();
		this.entityManager.persist(category);
		entityManager.getTransaction().commit();
	}

}

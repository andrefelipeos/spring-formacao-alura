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
		entityManager.getTransaction().begin();
		entityManager.remove(findByIdentifier(identifier));
		entityManager.getTransaction().commit();
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
	public Category save(Category category) {
		entityManager.getTransaction().begin();
		category = entityManager.merge(category);
		entityManager.getTransaction().commit();
		return category;
	}

}

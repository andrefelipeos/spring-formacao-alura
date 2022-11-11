package store.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import store.models.Customer;
import store.util.JPAUtil;

public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager = null;

	public CustomerDaoImpl() {
		this.entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public void deleteByIdentifier(int identifier) {
		entityManager.getTransaction().begin();
		entityManager.remove(findByIdentifier(identifier));
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Customer> findAll() {
		return entityManager.createQuery("SELECT c FROM Customer c", Customer.class)
				.getResultList();
	}

	@Override
	public Customer findByIdentifier(int identifier) {
		return entityManager.find(Customer.class, identifier);
	}

	@Override
	public Customer save(Customer customer) {
		entityManager.getTransaction().begin();
		customer = entityManager.merge(customer);
		entityManager.getTransaction().commit();
		return customer;
	}

}

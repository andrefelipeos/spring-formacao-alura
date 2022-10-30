package store;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import store.models.Product;

public class Main {

	public static void main(String[] args) {
		Product mobile = new Product("XPhone", "Octacore, 2GB", new BigDecimal(1200));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgresql");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(mobile);
		em.getTransaction().commit();
		em.close();
	}

}

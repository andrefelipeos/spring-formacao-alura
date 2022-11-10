package store;

import java.math.BigDecimal;

import store.dao.CategoryDao;
import store.dao.CategoryDaoImpl;
import store.dao.ProductDao;
import store.dao.ProductDaoImpl;
import store.models.Category;
import store.models.Product;

public class Main {

	public static void main(String[] args) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		ProductDao productDao = new ProductDaoImpl();

		Category book = new Category("BOOK");
		Category cloth = new Category("CLOTH");

		book = categoryDao.save(book);
		cloth = categoryDao.save(cloth);

		Product book01 = new Product("Daring Greatly", "by Brené Brown", new BigDecimal(20), book);
		Product book02 = new Product("The ABC crimes", "by Agatha Christie", new BigDecimal(20), book);
		Product tshirt01 = new Product("T-shirt I", "green, with a pocket", new BigDecimal(50), cloth);
		Product tshirt02 = new Product("T-shirt II", "blue, with a nice symbol", new BigDecimal(50), cloth);

		productDao.save(book01);
		productDao.save(book02);
		productDao.save(tshirt01);
		productDao.save(tshirt02);
	}

}

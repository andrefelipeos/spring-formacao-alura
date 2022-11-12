package store;

import java.math.BigDecimal;
import java.util.List;

import store.dao.CategoryDao;
import store.dao.CategoryDaoImpl;
import store.dao.CustomerDao;
import store.dao.CustomerDaoImpl;
import store.dao.OrderDao;
import store.dao.OrderDaoImpl;
import store.dao.ProductDao;
import store.dao.ProductDaoImpl;
import store.dto.SalesReport;
import store.models.Category;
import store.models.Customer;
import store.models.ItemOrder;
import store.models.Order;
import store.models.Product;

public class Main {

	public static void main(String[] args) {
		insertData();
	}

	private static void insertData() {
		CategoryDao categoryDao = new CategoryDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		ProductDao productDao = new ProductDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();

		Category books = new Category("BOOK");
		Category clothes = new Category("CLOTH");

		books = categoryDao.save(books);
		clothes = categoryDao.save(clothes);

		Product book01 = new Product("Daring Greatly", "by Brené Brown", new BigDecimal(20), books);
		Product book02 = new Product("The ABC crimes", "by Agatha Christie", new BigDecimal(20), books);
		Product tshirt01 = new Product("T-shirt I", "green, with a pocket", new BigDecimal(50), clothes);
		Product tshirt02 = new Product("T-shirt II", "blue, with a nice symbol", new BigDecimal(50), clothes);

		book01 = productDao.save(book01);
		book02 = productDao.save(book02);
		tshirt01 = productDao.save(tshirt01);
		tshirt02 = productDao.save(tshirt02);

		Customer customer01 = new Customer("John Smith", "12345678900");
		Customer customer02 = new Customer("Jane Smith", "98765432100");

		customer01 = customerDao.save(customer01);
		customer02 = customerDao.save(customer02);

		Order order01 = new Order(customer01);
		Order order02 = new Order(customer02);

		order01.addItem(new ItemOrder(2, order01, tshirt01));
		order01.addItem(new ItemOrder(1, order01, tshirt02));
		order01.addItem(new ItemOrder(1, order01, book02));
		order02.addItem(new ItemOrder(2, order02, tshirt02));
		order02.addItem(new ItemOrder(1, order02, book01));
		order02.addItem(new ItemOrder(1, order02, book02));

		order01 = orderDao.save(order01);
		order02 = orderDao.save(order02);

		System.out.println(((OrderDaoImpl) orderDao).totalSalesValue());
		List<SalesReport> report = ((OrderDaoImpl) orderDao).salesReport();
		report.forEach(row -> {
			System.out.println(row.productsName() + ": " + row.amountSold() + " - " + row.dateOfLastSale());
		});
		List<Product> listOfBooks = productDao.findByCategory(books);
		listOfBooks.forEach(book -> System.out.println(book.getName()));
	}

}

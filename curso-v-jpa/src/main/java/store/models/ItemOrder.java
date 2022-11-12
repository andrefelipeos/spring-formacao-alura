package store.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items_order")
public class ItemOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;

	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	private int amount;

	@ManyToOne
	private Order order;

	@ManyToOne
	private Product product;

	public ItemOrder() {
		super();
	}

	public ItemOrder(int amount, Order order, Product product) {
		this.amount = amount;
		this.order = order;
		this.product = product;
		this.unitPrice = product.getPrice();
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public int getAmount() {
		return amount;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}

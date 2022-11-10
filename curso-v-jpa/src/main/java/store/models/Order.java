package store.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;
	private BigDecimal totalValue;
	private LocalDate date = LocalDate.now();

	@ManyToOne
	private Customer costumer;

	@OneToMany(mappedBy = "order")
	private List<ItemOrder> itens = new ArrayList<ItemOrder>();

	public Order() {
		super();
	}

	public Order(Customer costumer) {
		this.costumer = costumer;
	}

	public void addItem(ItemOrder item) {
		item.setOrder(this);
		this.itens.add(item);
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Customer getCostumer() {
		return costumer;
	}

	public void setCostumer(Customer costumer) {
		this.costumer = costumer;
	}

}

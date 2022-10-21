package alura.spring.jdbc.models;

public class Product {

	private int identifier;
	private String name;
	private String description;

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

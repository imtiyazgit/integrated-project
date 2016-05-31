package model;

public class Product {

	private long id;

	private String name;

	private int amount;

	public Product(long id, String name,int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}

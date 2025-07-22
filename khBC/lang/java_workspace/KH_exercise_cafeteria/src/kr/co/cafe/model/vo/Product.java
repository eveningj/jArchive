package kr.co.cafe.model.vo;

public abstract class Product {
	private String name;
	private int price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return name + " : " + price + "원";
	}
	
	public abstract String getType();
	
	public abstract int getFinalPrice();
}

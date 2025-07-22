package kr.co.food.model.vo;

public abstract class Product implements Comparable   {
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
	@Override
	public String toString() {
		return "Prodcut [name=" + name + ", price=" + price + "]";
	}
	@Override 
	public int compareTo(Object o) {
		return -1;
	}
	
	
	
	public abstract String getType();
	
}

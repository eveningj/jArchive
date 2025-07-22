package kr.co.cafe.model.vo;

public class Combo extends Product {
	private Food food;
	private Beverage bev;
	
	public Combo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Combo(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	public Combo(String comboName, Food food, Beverage bev) {
		super();
		this.food = food;
		this.bev = bev;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Beverage getBev() {
		return bev;
	}
	public void setBev(Beverage bev) {
		this.bev = bev;
	}
	
	public String getType() {
		return "콤보";
	}

	@Override
	public int getFinalPrice() {
		return (int) ((food.getFinalPrice()+bev.getFinalPrice())*0.8);
	}
	@Override
	public String toString() {
		return "콤보 [음식 =" + food + ", 음료 =" + bev + "]";
	}
	
	
	
	
	
	
	
}

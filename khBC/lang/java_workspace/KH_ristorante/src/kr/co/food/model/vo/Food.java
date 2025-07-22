package kr.co.food.model.vo;

public class Food extends Product  {

	private boolean spicy; //true 면 맵고 false 면 안매움
	
	
	public Food() {
		super();
	}

	public Food(String name, int price,boolean spicy) {
		super(name, price);
		this.spicy = spicy;
	}

	public boolean isSpicy() {
		return spicy;
	}

	public void setSpicy(boolean spicy) {
		this.spicy = spicy;
	}

	
	
	@Override
	public String getType() {
		return "음식";
	}
}

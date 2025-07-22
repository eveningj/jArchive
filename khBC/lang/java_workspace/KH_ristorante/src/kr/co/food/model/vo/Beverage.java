package kr.co.food.model.vo;

public class Beverage extends Product{
	private int volume;

	public Beverage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beverage(String name, int price, int volume) {
		super(name, price);
		this.volume = volume;
		// TODO Auto-generated constructor stub
	}


	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
	
	@Override
	public String getType() {
		return "음료";
	}
	
	
}

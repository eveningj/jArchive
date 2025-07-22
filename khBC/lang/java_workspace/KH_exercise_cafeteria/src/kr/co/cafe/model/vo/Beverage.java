package kr.co.cafe.model.vo;
public class Beverage extends Product{
	public Beverage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Beverage(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getType() {
		return "음료";
	}
	@Override
	public int getFinalPrice() {
		return getPrice() ;	
		
	}
}
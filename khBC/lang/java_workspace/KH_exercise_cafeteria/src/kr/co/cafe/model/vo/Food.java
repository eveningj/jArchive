package kr.co.cafe.model.vo;
public class Food extends Product{
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getType() {
		return "음식"; //출력 메소드 작성 시, 팝콘 핫도그 중 선택 작성 요망
	}
	
	@Override
	public int getFinalPrice() {
		return getPrice();
		
	}
}
package kr.co.iei.point.model.vo;

public class Gold extends Silver {

	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getBonus() {
		return 0.05*getPoint(); //-> Class Silver 의 point 가 private 이므로.
	}
}

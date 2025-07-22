package kr.co.iei.point.model.vo;

//Grade는 모든 등급을 담당하는 클래스의 공통 부모 클래스
//새로운 등급 클래스를 만들때는 Grade클래스를 상속 -> Grade는 추상클래스이므로 추상메소드를 반드시 구현해야함.
//-> 등급별로 보너스는 다르게 연산해야 하므로 getBonus() 메소드를 반드시 구현하도록 추상메소드로 설정
public abstract class Grade {
	private String grade;
	private String name;
	private int point;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String grade, String name, int point) {
		super();
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public abstract double getBonus();
}

package kr.co.iei.point.model.vo;

public class Silver {
	private String grade;
	private String name;
	private int point;
	
	//constructor
	public Silver(){
	}
	public Silver(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	//getter
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public double getBonus() {
		return 0.02*point;
	}
	//setter
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setpoint(int point) {
		this.point = point;
	}
	
}//class.

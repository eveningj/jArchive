package kr.co.iei.point.model.vo;

public class Silver {
	
	private String grade;
	private String name;
	private int point;
	//보너스는 변수 만들 필요 없었음.
	//point 에 종속적이기 때문에 실제 데이터를 저장하진 않고 getter 만 생성
//	public double getBonus() return 0.02*point
	double bonusPoint = (double)point*0.02;

	
	public Silver() {
		
	}//D.C.().
	
	public Silver(String grade, String name, int point,double bonusPoint) {
		this.grade = grade;
		this.name = name;
		this.point = point;
		this.bonusPoint = bonusPoint;
	}//V.C.().
	
	
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
	public Double getBonusPoint() {
		return bonusPoint;
	}
	//setter
	public void setGrade (String grade) {
		this.grade = grade;
	}
	public void setName (String name) {
		this.name = name;
	}
	public void setPoint (int point) {
		this.point = point;
	}
	
		
	

}//class. Silver

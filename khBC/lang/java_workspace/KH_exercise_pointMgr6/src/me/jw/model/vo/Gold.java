package me.jw.model.vo;

public class Gold extends Grade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3904680065180534689L;

	public Gold(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	
	public double getBonus() {
		return getPoint()*0.05;
	}
}

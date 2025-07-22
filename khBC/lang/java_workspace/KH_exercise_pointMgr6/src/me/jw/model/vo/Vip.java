package me.jw.model.vo;

public class Vip extends Grade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8653910127990015725L;

	public Vip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}

	public double getBonus() {
		return getPoint()*0.03;
	}
}

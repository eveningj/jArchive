package me.jw.model.vo;

public class Silver extends Grade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 2441273573464702166L;

	public Silver(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}

	public double getBonus() {
		return getPoint()*0.03;
	}
}

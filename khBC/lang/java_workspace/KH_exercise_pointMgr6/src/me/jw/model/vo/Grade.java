package me.jw.model.vo;

import java.io.Serializable;

public abstract class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String grade;
	private final String name;
	private final int point;
	
	public Grade(String grade, String name, int point) {
		super();
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	
	public abstract double getBonus();
	
	@Override
	public String toString() {
		return "Grade [grade=" + grade + ", name=" + name + ", point=" + point + "]";
	}
	
	
	
}

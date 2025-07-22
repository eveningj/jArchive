package me.jw.model.dto;

import java.util.ArrayList;

import me.jw.filemgr.FileManager;
import me.jw.model.dao.PointDAO;
import me.jw.model.vo.Grade;

public class PointDTO {
	private  String grade;
	private  String name;
	private  int point;
	private ArrayList<Grade> g;
	
	public PointDTO() {
		super();
	}
		
	public PointDTO(String grade, String name, int point, PointDAO dao, FileManager fm) {
		super();
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	public PointDTO(FileManager fm) {
		super();
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
	
	public ArrayList<Grade> getList() {
		return g;
	}
	public void setList(ArrayList<Grade> g) {
		this.g= g;
	}
	
}

package me.jw.model.dao;

import java.util.ArrayList;

import me.jw.filemgr.FileManager;
import me.jw.model.dto.PointDTO;
import me.jw.model.vo.Gold;
import me.jw.model.vo.Grade;
import me.jw.model.vo.Silver;
import me.jw.model.vo.Vip;

public class PointDAO {

	ArrayList<Grade> members;
	PointDTO dto;
	FileManager fm;

	public PointDAO() {
		super();
		dto = new PointDTO();
		fm = new FileManager(dto);
		if (!fm.importMember()) {
			members = new ArrayList<Grade>();
		} else {
			members = dto.getList();
			if (members == null) {
				members = new ArrayList<Grade>();
			}
		}
	}

	public Grade searchMember(String name) {
		for (Grade g : members) {
			if (g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}

	public ArrayList<Grade> selectAllMembers() {
		return members;
	}

	public boolean insertMember(String grade, String name, int point) {
		switch (grade) {
		case "silver":
			Grade s = new Silver(grade, name, point);
			members.add(s);
			dto.setList(members);
			fm.exportMember();
			return true;
		case "gold":
			Grade g = new Gold(grade, name, point);
			members.add(g);
			dto.setList(members);
			fm.exportMember();
			return true;
		case "vip":
			Grade v = new Vip(grade, name, point);
			members.add(v);
			dto.setList(members);
			fm.exportMember();
			return true;
		default:
			return false;
		}
	}

	public boolean deleteMember(Grade g) {
		if (members.remove(g)) {
			fm.exportMember();
			return true;
		}
		return false;
	}

}

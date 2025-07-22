package kr.co.iei.point.model.dto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import kr.co.iei.point.model.mo.Gold;
import kr.co.iei.point.model.mo.Grade;
import kr.co.iei.point.model.mo.Silver;
import kr.co.iei.point.model.mo.Vip;

public class PointDao {
	ArrayList<Grade> member;

	public PointDao() {
		super();
		member = new ArrayList<Grade>();

		Grade g1 = new Silver("silver", "회원1", 1000);
		Grade g2 = new Gold("gold", "회원2", 2000);
		Grade g3 = new Vip("vip", "회원3", 3000);
		member.add(g1);
		member.add(g2);
		member.add(g3);
	}

	public void insertMember(Grade s) {
		member.add(s);
	}
	/* ==
	public void insertMember(String grade, String name, int point) {
		switch (grade) {
		case "silver":
			Grade s = new Silver(grade, name, point);
			member.add(s);
			break;
		case "gold" : 
			Grade g = new Gold(grade, name, point); 
			member.add(g);
			break;
		case "vip" : 
			Grade v = new Vip(grade, name, point);
			member.add(v);
			break;
			default :
			System.out.println("잘못 입력하셨습니다.") 
			break;
	}
	}*/
	public ArrayList<Grade> printMembers() {
		return member;
	}

	public Grade printOneMember(String name) {
		for(Grade g : member) {
			if(g.getName().equals(name)) {
				return g;
			}
		}
		return null;
	}
	public int searchMember(String name) {
		for(int i =0; i<member.size(); i++) {
			Grade a = member.get(i);
			if(a.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	public void delete(int searchIndex) {
		member.remove(searchIndex);
	}
	public void updateMember(String grade, String name, int point, int searchIndex) {
		switch(grade.toLowerCase()) {
		case "silver":
			Grade sMember = new Silver(grade, name, point);
			member.set(searchIndex, sMember);
			break;
		case "gold" :
			Grade gMember = new Gold(grade, name, point);
			member.set(searchIndex, gMember);
			break;
		case "vip" : 
			Grade vMember = new Vip(grade, name, point);
			member.set(searchIndex, vMember);
			break;
		}
		
	}
	public void exportMember() {
		 
		
		ObjectOutputStream oos = null;
		//0. 반환할 보조스트림 생성
		
			try {
				FileOutputStream fos = new FileOutputStream("Member.txt");
				//1. 주스트림 생성
				oos = new ObjectOutputStream(fos);
				oos.writeObject(member);
				//2. 보조스트림을 이용해서 export
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					oos.close();
					//3. 자원반환
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	public void importMember() {
		// -1. 파일 존재 유무
		File file = new File("Member.txt");
		ObjectInputStream ois = null;
		//0. 반환할 보조스트림 생성
		if(file.exists()) {
		try {//1.주스트림 생성
			FileInputStream fis = new FileInputStream("Member.txt");
			ois = new ObjectInputStream(fis);
			Object ob = ois.readObject();
			member = (ArrayList<Grade>)ob;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
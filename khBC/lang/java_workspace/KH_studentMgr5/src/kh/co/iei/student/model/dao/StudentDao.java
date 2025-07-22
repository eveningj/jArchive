package kh.co.iei.student.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import kh.co.iei.student.model.vo.Student;

//DATA ACCESS OBJECT
//데이터관련 작업은 DAO 가 전부 처리 (CRUD)
public class StudentDao {

	ArrayList<Student> students;

	public StudentDao() {
		super();
//		students = new ArrayList<Student>();
		importStudent();	//-> FileNOTFound Exception -> CATCH
	}

	// Controller 에게 Data 를 받아 List 에 추가하는 메소드
	public void insertUser(Student s) {
		students.add(s);
		exportStudent(); //유의.
	}

	public ArrayList<Student> selectAllStudent() {
		return students;
	}

	// 매개 변수로 받은 이름과 일치하는 학생 정보를 리턴하는 메소드 (만약에 일치하는 이름이 없으면 null 리턴)
	public Student searchStudent(String name) {
		for (Student s : students) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	

	public boolean deleteStudentInfo(Student s) {
		return (students.remove(s));
		// export.
	}
	
	public boolean deleteStudentEdu(String name) {
		int searchIndex = searchIndexEdu(name);
		if (searchIndex == -1) {
			return false;
		}else {
			students.remove(searchIndex);
			exportStudent(); //순서 유의.
			return true;
		}
	}
	
	public int searchIndexEdu(String name) {
		for (int i = 0; i < students.size();i++) {
			Student s = students.get(i);
			if(s.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void updateStudent (Student s,String name, int age, String addr) {
		s.setName(name);
		s.setAge(age);
		s.setAddr(addr);
	}
	
	public void exportStudent() {
		ObjectOutputStream oos = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("studentBackup.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void importStudent() {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("studentBackup.txt");
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			students = (ArrayList<Student>)obj;
		} catch (FileNotFoundException e) {
			students = new ArrayList<Student>(); // 빈 리스트를 이 때 만들어 줌.
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) {
					ois.close();
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
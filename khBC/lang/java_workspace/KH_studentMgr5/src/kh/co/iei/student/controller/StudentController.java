package kh.co.iei.student.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kh.co.iei.student.model.dao.StudentDao;
import kh.co.iei.student.model.vo.Student;


//DTO 라고 부르기도 함 ( Data Test Object, 데이터 전송용 객체)
public class StudentController {
	Scanner sc;
	StudentDao dao;

	// 데이터 관련 작업(조회, 삽입, 수정, 삭제)은 dao를 통해 처리
	public StudentController() {
		super();
		sc = new Scanner(System.in);
		dao = new StudentDao();
	}

	public void main() {
		while (true) {
			System.out.println("\n------------ 학생 관리 프로그램 v5 ------------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 전체 학생 정보 출력");
			System.out.println("3. 학생 정보 조회");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선 택 > >");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				insertUser();
				break;
			case 2:
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudentInfo();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못 입력했습니다.");
				return;
			}
		}
	}

	public void insertUser() {
		System.out.println("\n----------------- 학생 정보 등록 -----------------\n");
		System.out.print("등록할 학생 이름 입력 :");
		String name = sc.next();
		System.out.print("등록할 학생 나이 입력 :");
		int age = sc.nextInt();
		System.out.print("등록할 학생 주소 입력 :");
		sc.nextLine();
		String addr = sc.nextLine();
		Student s = new Student(name, age, addr);
		// List 에 데이터를 추가
		// DAO 의 메소드에게 데이터를 주면서 리스트에게 추가해줘, 라고 요청
		// 전달해줄 데이터 : s || name , age , addr
		// 받을 데이터 : 없음
		dao.insertUser(s);
		System.out.println("학생 정보 등록 완료 !");
	}

	public void printAllStudent() {
		System.out.println("\n----------------- 전체 학생 출력 -----------------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("--------------------------------------------------");

		// students List 에 있는 모든 정보 출력
		// Controller 는 LIst 를 가지고 있지 않음 -> DAO 가 가지고 있기 떄문에 요청
		// 전달해야줘야 하는 데이터 : 없음
		// 받아야하는 데이터 : ArrayList<Student>
		ArrayList<Student> students = dao.selectAllStudent();
		for (Student s : students) {
			System.out.println(s.getName() + "\t" + s.getAge() + "\t" + s.getAddr());
		}
	}

	public void printOneStudent() {
		System.out.println("\n--------------------- 학생 조회 ---------------------\n");
		System.out.print("조회할 학생 이름 입력 : ");
		String name = sc.next();
		//dao에게 학생정보를 찾아달라고 요청
		if (dao.searchStudent(name)==null) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}else {
			Student s = dao.searchStudent(name);
			System.out.println("이름 :"+s.getName());
			System.out.println("나이 :"+s.getAge());
			System.out.println("주소 :"+s.getAddr());
		}
		//전달해줘야할 데이터 : String
		//받아야할 데이터 : Student
	}

	public void updateStudentInfoEdu() {
		System.out.println("\n--------------------- 학생 정보 수정 ----------------- \n");
		System.out.println("수정할 학생 이름 입력 : ");
		String name = sc.next();
		Student s = dao.searchStudent(name);
		if (s == null) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}
		
	}
	
	public void deleteStudentInfo() {
		System.out.println("\n--------------------- 학생 정보 삭제 ----------------- \n");
		System.out.println("삭제할 학생 이름 입력 : ");
		String name = sc.next();
		//dao 에게 삭제 요청
		//전송해줄 데이터 : 이름 (String
		//받을 데이터 : 삭제 성공 /실패 여부 ( 숫자/ 논리형 / 문자열) => 논리형으로 삭제 성공하면 true, 실패하면 false
		Student s = dao.searchStudent(name);
		if (s == null) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}else {
			if (dao.deleteStudentInfo(s)) {
				dao.exportStudent();
				System.out.println("삭제 완료 !");
			}else {
				System.out.println("삭제하지 못했습니다.");
			}
		}
	}
	
	public void updateStudent() {
		System.out.println("\n--------------------- 학생 정보 수정 ----------------- \n");
		System.out.println("수정하고 학생 이름 입력 : ");
		String name = sc.next();
		Student s = dao.searchStudent(name);
		if (s==null) {
			System.out.println("학생 정보를 찾을 수 없습니다.");
		}else {
			//수정을 2가지 방식으로 할 수 있음.
			//1. New Index
//			dao.deleteStudentInfo(s);
			System.out.println("수정할 학생 이름 입력 :");
			String nName = sc.next();
			System.out.println("수정할 학생 나이 입력 :");
			int nAge = sc.nextInt();
			System.out.println("수정할 학생 주소 입력 :");
			String nAddr = sc.next();
			Student ns = new Student(nName, nAge, nAddr);
//			dao.insertUser(ns);
			//2. Switch Data
			dao.updateStudent(s, nName, nAge, nAddr);
			
			/*
			 * 수정 요청
			 * 전달해줄 데이터 : 나이, 주소
			 * 받아올 데이터 : 없음
			 * 1.
			 * dao.updateStudent(ns, name  age, addr)
			 * 2. public void updateStudentEdu(Student s) {
			 * 	int searchIndex = dao.searchIndex(name());
			 * 	students.set(searchIndex, s);
			 * if (searchIndex == -1) {
			 *  학생 없어 }
			 *  else {
			 *  수정 내용.
			 *  }
			 *  
			 *  3. students.get(searchIndex).setAge(age);
			 *  
			 */
			
		}
		
	}
	
	
}

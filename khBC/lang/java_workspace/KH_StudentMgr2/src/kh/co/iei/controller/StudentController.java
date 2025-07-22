package kh.co.iei.controller;


import java.util.Scanner;

import kh.co.iei.model.vo.Student;

public class StudentController {
	//동명이인이 없는 조건에서 학생을 최대 10명 관리하는 프로그램
	//학생 1명 정보는 이름(String), 나이(int), 주소(String)
	//서로 다른 자료형 여러개를 하나로 묶어서 관리할 때 -> 객체 사용
	//이름, 나이, 주소를 하나의 객체로 묶어서 관리 -> 학생 10명 저장도 -> 객체 배열
	
	//사용자 정의 자료형
	Student[] students;
	Scanner sc;
	int index;
	
	public StudentController() {
		students = new Student[10];
		sc = new Scanner(System.in);
		index = 0;
		
		
		//테스트를 위한 학생 정보를 미리 등록.
		Student s1 = new Student();
		s1.setName("학생1");
		s1.setAge(20);
		s1.setAddr("서울시 영등포구");
		Student s2 = new Student("학생2", 30, "서울시 강남구");
		Student s3 = new Student("학생3", 22, "서울시 관악구");
		
		students[index++] = s1;
		//index ++
		students[index++] = s2;
		students[index++] = s3;
		
	}//StudentController().
	
	//main menu repeat
	public void main() {
		while(true) {
			System.out.println("\n---------- 학생 관리 프로그램 v2 ----------\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 전체 학생 출력");
			System.out.println("3. 학생 1명 출력");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 > > >  ");
			
			int select = sc.nextInt();
		
			switch (select) {
			case 1:
				insertStudent();
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
			case 5: deleteStudent();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다.");
				break;
			}//switch, select.
		}//while, true.
	}//main().
	
	//이름, 나이, 주소를 입력받아서 Student 객체로 묶어서 배열에 저장하는 메소드
	public void insertStudent() {
		System.out.println("\n---------- 학생 정보 등록 ----------\n");
		System.out.print("등록할 학생 이름 입력 : ");
		String name = sc.next();
		System.out.print("등록할 학생 나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("등록할 학생 주소 입력 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		//입력받은 정보를 Student 객체 안에 저장
		//객체를 생성하는 방법의 수 -> Student 클래스의 생성자 수와 동일
		
		/*
		// 1) 기본 생성자로 Student 객체를 생성하고 값을 저장하는 방법 //가질 수 있는 정보가 한정돼있을 때.
		Student s = new Student();
			//기본 생성자로 Student 객체를 생성하면 객체 내부 변수에 기본값으로 세팅 
			//String -> null, int -> 0
			//-> 사용자에게 입력받은 값을 변수에 대입
			//-> 변수들은 접근제어지시자가 private 이라 접근 불가 -> setter 를 사용
		s.setName(name);
		s.setAge(age);
		s.setAddr(addr);
		*/
		
		//	2) 모든 전역변수를 초기화하는 생성자를 이용하여 객체 생성 -> 모든 데이터를 가지고있을 때
		students[index] = new Student(name, age, addr);
		index++;
		System.out.println("학생 정보 등록 완료!");
	}//insertStudent().
	
	//저장된 모든 학생 정보를 출력하는 메소드
	public void	printAllStudent() {
		System.out.println("\n---------- 전체 학생 정보 출력 ----------\n");
		System.out.println("이름\t나이\t주소");
		System.out.println("---------------------------------------");
		for(int i=0;i<index;i++) {
			//students 는 Student[] 타입.
			//Student[] 타입은 Student 타입을 여러개 저장하는 배열.
			//students 에서 인덱스를 이용해서 데이터를 꺼내오면 그 자료형은 -> Student
				//사용자 정의 자료형인 Student 사용해야함.
			
			Student s = students[i];
			//저장된 Student에서 내부에 있는 변수에 이름, 나이, 주소 -> 꺼내오려고 함.
			String name = s.getName();
			int age = s.getAge();
			String addr = s.getAddr();
			System.out.println(name+"\t"+age+"\t"+addr);
		}
	}//printAllStudent().

	//학생 이름을 매개변수로 받아서 해당이름의 학생이 배열에 몇번째 있는지 조회하는 메소드
	//일치하는 이름이 없으면 -1 리턴 ( 인덱스는 음수일 수 없으므로.)
	public int searchStudent(String name) {
		int searchIndex = -1;
		for(int i=0; i<index;i++) {
			Student s = students[i];
			String searchName = s.getName();
			if(searchName.equals(name)) {
				searchIndex = i;
					break;
			}//if searchName.
		}//for searchIndex.
		return searchIndex;
	}//searchStudent().
	
	//학생 이름을 입력받아 해당 학생이 존재하면 학생 정보를 출력하느 메소드
	public void printOneStudent() {
		System.out.println("\n---------- 학생 정보 조회 ----------\n");
		System.out.print("조회할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			Student s =  students[searchIndex];
			System.out.println("학생 이름 : "+s.getName());
			System.out.println("학생 나이 : "+s.getAge());
			System.out.println("학생 주소 : "+s.getAddr());
		}
	}//printOneStudent().
	
	
	//학생 이름을 입력받아서 해당하는 학생이 존재하면 삭제하는 메소드
	public void deleteStudent() {
		System.out.println("\n---------- 학생 정보 삭제 ----------\n");
		System.out.print("삭제할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			for(int i = searchIndex; i< index-1; i++) {
				students[i] = students[i+1];
			}//for.
			/*
			students[index-1] = null;
			index--;*/
			/*index--;
			students[index] = null;*/
			students[--index] = null;
			System.out.println("삭제 완료!");
		}//else.
		
	}//deleteStudent().
	
	
	public void updateStudent() {
		System.out.println("\n---------- 학생 정보 수정 ----------\n");
		System.out.print("수정할 학생 이름 입력 : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex == -1) {
			System.out.println("학생 정보를 조회할 수 없습니다.");
		}else {
			System.out.print("수정할 학생 나이 입력 : ");
			int age = sc.nextInt();
			System.out.print("수정할 학생 주소 입력 : ");
			sc.nextLine();
			String addr = sc.nextLine();
			
			//항상 '변수에 직접적인 접근 불가능 한 걸 인지할 것!'
			
			//1) setter 를 이용해서 객체에 저장되어 있는 변수값을 수정 - 객체 내부 필드 직접 수정
			Student s = students[searchIndex];
//			s.age = age; //Student calss 의 variable 은 private로 선언되어 있어 직접적으로 값 수정이 불가능.
			//값 수정하고 싶으면 해당 변수의 setter 를 호출해서 처리해야함.
			s.setAge(age);
			s.setAddr(addr);
			
			/*//2) 새로운 Student 객체를 만들어서 배열의 해당 위치에 새로운 주소를 대입. -기존 객체는 버려짐.
			Student s = new Student(name, age, addr);
			students [searchIndex] = s;*/
			
			
			//PIN : 두가지 방법의 메모리 차이 or 해시코드 차이를 알 수 있도록 할 것.
			
			
			System.out.println("정보 수정 완료!");
		}//else.
	}//updateStudent() 
}//class,.
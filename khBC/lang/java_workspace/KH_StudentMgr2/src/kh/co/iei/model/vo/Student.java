package kh.co.iei.model.vo;

//학생 1명 정보를 저장하는 객체
//학생 1명당 이름(String), 나이(int), 주소(String)
//전역변수로 생성

public class Student {

	private String name;
	private int age;
	private String addr;

	// 기본 생성자
	// 모든 전역변수를 초기화하는 생성자
	// 각 변수별 getter
	// 각 변수별 settter

	// B . C
	public Student() {
	} // B.C .
		// V . C
	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}// V.C .
	//GETTER
	
	public String getName() {
		return name;
	}// getName.
	public int getAge() {
		return age;
	}// getAge.
	public String getAddr() {
		return addr;
	}// getAddr.
	public void setName(String name) {
		this.name = name;
		
	// SETTER
	}// setName.
	public void setAge(int age) {
		this.age = age;
	}// setAge.
	public void setAddr(String addr) {
		this.addr = addr;
	}// setAddr.

}// class, Student.

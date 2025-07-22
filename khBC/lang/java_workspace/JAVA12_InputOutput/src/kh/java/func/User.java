package kh.java.func;

import java.io.Serializable;
//Serializable -> Marker Interface /해당 객체가 가능함을 표시.
public class User implements Serializable{
	
	//직렬화에 사용되는 객체 고유번호
	//목적은 클래스의 내용이 바뀌었을 때 식별하기 위함
	private static final long serialVersionUID = 1L;
	
	private String id;
	//필요한 경우에 직렬화 제외 => transient ( null )
	private String pw;
	private String name;
	private int age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

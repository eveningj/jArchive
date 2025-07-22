package kh.java.func;

public class AnimalMgr {
	
	//Tiger, Rabbit 모두 저장하려는 변수
	//Tiger, Rabbit 두 클래스의 공통 조상 클래스 -> Object
	
	private Object data;

	public AnimalMgr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnimalMgr(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

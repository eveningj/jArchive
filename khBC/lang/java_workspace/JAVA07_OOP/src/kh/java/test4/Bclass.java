package kh.java.test4;

public class Bclass extends Aclass {
	private int test;
	
	
	public Bclass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bclass(int num, String str) {
		super(num, str);
		// TODO Auto-generated constructor stub
	}
	
	//생성자에서는 super 가 우선.
	public Bclass(int num, String str, int test) {
		super(num,str);
		this.test= test;
		
	}

	
	//DYNAMIC BINDING
//	@ : annontation  -> 시스템에 알림을 주는 것.
//	-> 지시문, 유도문 -> 코드가 아님.
	//@OVerride -> 컴파일러에 상속받은 부모 클래스의 메소드를 내가 수정해서 쓰겠다고 알림
	@Override
	public void test1() {
		System.out.println("하하하하하하");
	}
	
//	@Override -> ERROR
	public void test2() {
		System.out.println("ㅎㅎㅎㅎ");
	}
}

package kh.java.test5;

//abstract method 를 포함한 class 는 반드시 abstract class
// -> method 를 포함하지 않더라도 class 선언은 가능.
public abstract class TestClass1 {
	private int num;

	public TestClass1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestClass1(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void testMethod1() {
		System.out.println("test-1");
	}
	//메소드에 코드 실행부분이 없음 -> 미완성된 메소드 -> 추상메소드 abstract method
	//코드 실행부분을 의도적으로 만들지 않았을 때 abstract 키워드를 사용
	public abstract void testMethod2();
}

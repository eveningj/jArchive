package kh.java.test5;

public class TestClass3 extends TestClass1{
	
	//추상클래스를 상속하면 추상메소드를 강제로 오버라이딩해야하고,
	//오버라이딩을 하고나면 일반 클래스 상속한 것 처럼 추가로 변수, 메소드 생성하는 것은 제한 없음
	
	
	private String str;
	@Override
	public void testMethod2() {
		System.out.println("testMethod2 - TestClass3");
	}

	
	public void testMethod3() {
		System.out.println("testMethod3");
	}
}

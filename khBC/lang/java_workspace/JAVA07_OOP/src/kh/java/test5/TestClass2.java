package kh.java.test5;

public class TestClass2 extends TestClass1 {
	//상속한 클래스가 추상클래스면, 
//	상속받은 클래스는 추상클래스의 추상메소드를 반드시 구현해서 사용해야함. (오버라이딩 강제화)
	@Override
	public void testMethod2() {
		System.out.println("testMethod2 = TestClass2");
	}
}

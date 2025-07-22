package kh.java.test5;

public class TestMgr {
	public void main() {
//TestClass1 은 추상클래스(미완성클래스)이므로 객체 생성이 불가능		
//		TestClass1 tc1 = new TestClass1();
//		TestClass2 는 TestClass1 을 상속해서 미완성된 메소드를 완성했기 때문에 객체 생성이 가능하다.
		TestClass2 tc2 = new TestClass2();
		tc2.testMethod1();
		tc2.testMethod2();
		//추상클래스는 미완성 클래스로 객체 생성은 불가능하지만 다형의 부모타입으로는 사용 가능하다.
		TestClass1 tc1 = new TestClass2();
		tc1.testMethod1();
		tc1.testMethod2();
	}
	
}

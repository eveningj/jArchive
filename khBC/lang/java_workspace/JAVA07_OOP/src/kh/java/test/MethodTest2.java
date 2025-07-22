package kh.java.test;
//import kh.java.test.MethodTest1; // MethodTest1;// 같은 패키지에 있는 경우 import 는 생략 가능.

public class MethodTest2 {
	public void test1() {
		MethodTest1 mt = new MethodTest1();
		mt.test1();
		mt.test2();
//		mt.test3(); // private 는 같은 패키지에 속한 클래스에도 호출 불가능.
	}
}

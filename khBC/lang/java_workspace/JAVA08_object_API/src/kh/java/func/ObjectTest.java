package kh.java.func;

public class ObjectTest {
	public void test1() {
		TestClass1 tc1 = new TestClass1();
		int num = tc1.hashCode();
		// hashcode : 객체의 고유한 값 != 주소
		System.out.println("tc1 hascode :" + num);
		TestClass1 tc2 = new TestClass1();
		System.out.println("tc2 hashcode :" + tc2.hashCode());

		TestClass1 tc3 = tc1;
		System.out.println("tc3 hashcode :" + tc3.hashCode());

		// equals : 같은 객체인지 확인하는 메소드
		String str1 = new String("abc");
		String str2 = new String("abc");
		if (str1 == str2) {
			System.out.println("두 문자열이 같습니다.");
		} else {
			System.out.println("두 문자열이 다릅니다.");

		}
		if(str1.equals(str2)) {
			System.out.println("두 문자열이 같습니다.");
			
		}else {
			System.out.println("두 문자열이 다릅니다.");
		}
	
		if(tc1.equals(tc2)) {
			System.out.println("두 객체가 같습니다.");
		}else {
			System.out.println("두 객체가 다릅니다.");
		}if(tc1.equals(tc3)) {
			System.out.println("두 객체가 같습니다.");
		}else {
			System.out.println("두 객체가 다릅니다.");
		}
 	
	
	}//
	
	public void test2() {
		TestClass1 tc1 = new TestClass1(100,"hi");
		TestClass1 tc2 = new TestClass1(300,"Hello");
		System.out.println(tc1);	//"출력할 때" 객체 이름을 바로 사용하면 자동으로 toString() 호출
		System.out.println(tc1.toString()); //해당 객체를 소개하는 메소드
		System.out.println(tc1.hashCode());
		
		System.out.println(tc1.getNum());
		System.out.println(tc1.getStr());
		
			
		}
	}//

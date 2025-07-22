package kh.java.test;

import java.util.Scanner;

public class MethodTest1 {
	public void test1() {
		System.out.println("test1");
		//같은 클래스 내부의 메소드를 호출 할 때는 별명 없이 바로 메소드 이름으로 호출
	test3();
	test2();
	}
	// 접근 제어 지시자를 생략하면 -> default 인 접근 제어지시자로 동작 -> 
//								default 는 사용가능 범위(현재 이 클래스, 같은 패키지에 있는 클래스) 
	void test2() {
		System.out.println("test2");
	}
	//메소드의 접근 제어지시자를 private로 선언하면, 해당 메소드는 현재 이 클래스 내부에서만 사용이 가능.
	private void test3() {
		System.out.println("test3");
	}
	
	public void test4() {
		System.out.println("메소드 테스트4");
		test8();
//		int num = test5();
//		System.out.println(num);
//		String data = test7();
//		System.out.println(data);
		return; //반환형이 void 인 경우는 return 구문 생략 가능
	}
	//반환형에 자료형을 입력하면 메소드를 수행하고나면 해당하는 자료형을 되돌려주겠다는 명시
	public int test5() {
		System.out.println("메소드 테스트5");
		
		return 1000;
//		return 데이터; 작성한 데이터를 되돌려주면서 (반환하면서) 그 순간 메소드를 종료시킴.
	}
	
	public int test6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();
		if(num%2 == 0) {
			return num;
		}
		return -1;
//		if(num%2 !=0) {
//			return num-1;
			
//		}
//		else {
//			return -1; // <- 무슨 일이 있어도 return 값이 명시 될 수 있게.
//		}
	}
	public String test7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if(num%2 == 0) {
			return "짝수";
		} else {
			return "홀수";
		}
	}
	public void test8() {
		System.out.println("test8");
		test9(100);
		test9(20);
		test10(100,200);
		test10(200,100);
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		test10(num1,num2);
		test10(num2,num1);
		test11(77,"hi");
//		test11()
		//test9("hi") :  선언된 매개변수와 일치한 데이터를 전송해야함.
		
	}
	public void test9(int num) {
	System.out.println("매개 변수로 전달받은 수 : "+num);	
	}
	public void test10(int num1, int num2) {
	System.out.println("num1 : " +num1);
	System.out.println("num2 : " +num2);
	}
	public void test11(int num, String str) {
		System.out.println("num test 11 : "+num);
		System.out.println("str : "+str);
	}
	public void test12() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
//		int sum1 = num1 + num2; //빅데이터도 써야하고, 머신러닝, AI 분석까지 하는 10만 줄 까지 코드
		int sum1 = sum(num1,num2);
		System.out.println("야 엄청 어려웠다 결과는 : "+sum1);
		
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		System.out.print("네번째 정수 입력 : ");
		int num4 = sc.nextInt();
		
//		int sum2 = num3 + num4;
		int sum2 = sum(num3,num4);
		System.out.println("두번째 결과는 : "+sum2);
		// int sum[][] = new int[10][10]
		
	}
	
	//접근제어지시자 리턴타입 메소드이름(매개변수)
	public int sum(int num1, int num2) {
		int result = num1 + num2;
		return result;
		
	}
	
	public void sum2(int num1, int num2)  {
		int result = num1 + num2; 
		System.out.println("야 엄청 어려웠다 결과는 : "+result);
	}
	
	public void test13() {
		int num = 100;
		test14(num);
		System.out.println(num);
		
}	public void test14(int num) {
		num+=100;
		System.out.println("test14 : " + num);
}
	public void test15() {
		int[] arr = {1,2,3};
//		test16(arr);
		test17(arr[1]);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public void test16(int[] arr) {
		arr[1] = 200;
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	
	public void test17(int num) {
		num = 200;
		System.out.println(200);
	}
	
	//메소드 오버로딩 -> 메소드 오버라이딩과 오버로딩의 차이 -> 면접, 실무 키워드
	//오버로딩의 조건
	//-> 변수명은 중요하지 않음 X , parameter 선언부 (type, 개수, 순서) 다름.
//	return 값의 타입은 오버로딩에 영향을 주지 않음.(같거나, 다르거나 무관)
	public void test18() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		
		int sum = add(num1,num2);
		System.out.println("두 수의 합은 : "+sum);
		
	}
	
	//매개변수로 정수를 받아서 합을 구해서 리턴하는 메소드를 생성, 메소드 이름은 add
	public int add(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}
	public int add(int num1, int num2, int num3) {
		int result = num1 + num2 + num3;
		return result;
	}
	public String add(String su1, int su2) {
		return "hi";
	}
}
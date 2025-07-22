package kh.java.func;

import java.util.Scanner;

public class OperatorTest {

	public void test1() {

		// 산술연산자(+,-,*,/,%)
		// 대입연산자(=) : a = b -> b라는 값을 a라는 공간(변수)에 대입
		// 복합대입연산자(Compound Assignment Operators) : 산술연산자와 대입연산자가 결합된 형태의 연산자
		// +=, -=, *=,/=, %=
		// 현재 변수에 들어있는 데이터를 산술 연산해서 변수에 다시 대입하는 연산자

		int num = 10;
		System.out.println("num : " + num);
		num += 5; // num = num + 5;
		System.out.println("num : " + num);
		num *= 3; // num = num * 3;
		System.out.println("num : " + num);

		// 복합대입연산자가 산술+대입연산자보다 처리속도가 빠름.

	}

	public void test2() {
		// 증감연산자 <- 산술연산자에 속함(++,--)

		int num = 10;

		System.out.println("num : " + num);

		num++;// num 변수의 값을 1 증가시킴.
		System.out.println("\nnum : " + num);
		++num;// num 변수의 값을 1 증가시킴.
		System.out.println("num : " + num);

		System.out.println();

		num--;// num 변수의 값을 1 감소시킴.
		System.out.println("num : " + num);
		num--;// num 변수의 값을 1 감소시킴.
		System.out.println("num : " + num);

		// 증감연산자가 단독으로 사용되면 위치가 앞/뒤 상관없이 결과가 동일함.

		// 변수++ : 후위연산 -> 인접연산이 있으면 인전연산을 수행하고 (그리고 정의하고, 대입되고) 증감이 동작, 결국 결과값에 주목해야함
		// ++변수 : 전위연산 -> 인접연산이 있으면 증감을 수행하고 인접연산 수행, 결국 결과값에 주목해야함
		int num1 = 10;
		int num2 = num1++ + 2;
		System.out.println("\nnum1 : " + num1);
		System.out.println("num2 : " + num2);

		int a = 10;
		int b = 10;
		int c = (a++) + (++b) + a;
		// a : 11, b : 11 , c : 32 ,
		System.out.println("\na :" + a);
		System.out.println("b :" + b);
		System.out.println("c :" + c);

	}

	public void test3() {
		Scanner sc = new Scanner(System.in);

		System.out.println("관계 연산자");
		// 관계연산자( <, > <=, >=, == )
		// 10 < 20 -> 참 (true) / 거짓 (false)
		// 컴퓨터가 판단하게 함.
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();

		// < 과 > 에 대하여
		boolean bool1 = num1 < num2;
		System.out.println("bool1 : " + bool1);
		boolean bool2 = num1 > num2;
		System.out.println("bool2 : " + bool2);

		// <= 과 >=에 대하여 (부등호가 항상 먼저 오게)
		boolean bool3 = num1 <= num2;
		System.out.println("bool3 : " + bool3);
		boolean bool4 = num1 >= num2;
		System.out.println("bool4 : " + bool4);

		// == (같다) !=(같지 않다) =(은 대입연산자)
		boolean bool5 = num1 == num2;
		System.out.println("\nbool5 : " + bool5);
		boolean bool6 = num1 != num2;
		System.out.println("bool6 : " + bool6);

	}

	public void test4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		System.out.print("네번째 정수 입력 : ");
		int num4 = sc.nextInt();

		boolean result1 = num1 < num2;
		boolean result2 = num3 < num4;
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);

		boolean result3 = result1 && result2;
		System.out.println("result3 : "+result3);

		boolean result4 = result1 || result2;
		System.out.println("result4 : "+result4);
		//! 연산 : 논리값 반전 연산자
		boolean result5 = !result1;
		System.out.println("result5 : "+result5);
		
		//삼항 연산자
		//조건식을 사용하여 논리값에 따라 값이 달라짐.
	}
	public void test5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		/*
		 * <삼항연산자>
		 * (1) ? (2) : (3)
		 * 조건식 ? 참일_때_값 : 거짓일_때_값;
		 * (1) : only 논리값 (조건식)
		 * (2) : (1)의 논리값이 true 인 경우, 여기에 있는 코드가 실행
		 * (3) : (1)의 논리값이 false 인 경우, 여기에 있는 코드가 실행
		 */
		
		
		//정수 판별
		int result1 = num1 > num2 ? num1 : num2;
		System.out.print("result1 : "+result1);
		
		boolean check = num1 > num2;
		int result2 = check ? num1 : num2;
		System.out.println("\nresult2 : "+result2);
		
		System.out.println("result3 : " + (num1 > num2 ? num1 : num2));
		
		//문자열 출력해서 판별
		String str = num1 > num2 ? "num1이 더 크다" : "num2가 더 크다";
		System.out.println("resultStr : "+str);
		//가능한데, 권장하지 않음.
		System.out.println(num1 > num2 ? num1 : "num2가 더 크다");
		
		
	}
	
}
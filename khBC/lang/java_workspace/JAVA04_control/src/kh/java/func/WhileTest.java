package kh.java.func;

import java.util.Scanner;

public class WhileTest {

	public void test1() {
		// 안녕하세요를 5번 반복해서 출력
		/*
		 * while(조건식) { 조건식이 true면 실행되는 코드 }
		 */

		int i = 0;

		while (i < 5) {
			System.out.println("안녕하세요");
			i++;
		}

		/*
		 * for(int i=0; i<5;i++) { System.out.println("안녕하세요"); }
		 */

	}

	public void test2() {
		Scanner sc = new Scanner(System.in);

//		System.out.print("몇번 출력하시겠습니까? : ");
//		int count = sc.nextInt();
//		while (i < count) {
//			System.out.println("안녕하세요");
//			i++;
//		}
//
//		int j = 0;
//		do {
//			System.out.println("안녕하세요2");
//				j++;

		int i = 0;
		int sum = 0;
		while (i < 5) {
			System.out.printf("정수 값을 입력하세요 : ");
			int j = sc.nextInt();
			sum += j;
			i++;
		}
		System.out.printf("입력한 정수의 값 : %d", sum);

	}

	public void test3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("첫번쨰 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		int num2 = sc.nextInt();

		int sum = 0;
		int start = num1 < num2 ? num1 : num2;
		int end = num1 > num2 ? num1 : num2;
		while (start <= end) {
			sum += start;
			start++;
		}
		if (num1 == num2) {

			System.out.printf("%d , %d 사이의 정수의 합 : 0", num1, num2);

		}
		System.out.printf("%d , %d 사이의 정수의 합 : %d", num1, num2, sum);

	}

	public void test4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int num1 = sc.nextInt();
		int sum = 0;
		int i = 1;
		
		while (i<=num1) {
			if (i%2==0) {
				sum += i;}
			i++;
		}
		System.out.printf("짝수들의 합은 : %d", sum);
	}
}

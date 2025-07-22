package kh.java.func;

import java.util.Scanner;

public class ifTest {

	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 10을 입력하세요 : ");
		int num = sc.nextInt();
		/*
		 * if(논리형 데이터 or 조건식) -> 최종적으로 참/거짓이 있어야함. { 논리형데이터 or 조건식의 결과가 true면 실행 될
		 * 코드(false면 실행되지 않음)
		 * 
		 */
		if (num == 10) {
			System.out.println("참 잘했어요.");
		}
		System.out.println("끝!");
	}

	public void exam1() {

		Scanner sc = new Scanner(System.in);

		System.out.println("=====숫자 구별 프로그램=====");
		System.out.print("임의의 정수를 입력하세요 : ");
		int num1 = sc.nextInt();

		if (num1 > 0) {
			System.out.println("당신이 입력한 수 " + num1 + "은(는) 양수입니다. ");
		}
		if (num1 == 0) {
			System.out.println("당신이 입력한 수" + num1 + "입니다. ");
		}
		if (num1 < 0) {
			System.out.println("당신이 입력한 수" + num1 + "은(는) 음수입니다. ");
		}
	}
//		앞선 모든 if문은 논리값에 관계없이 모두 조건 검사 -> 실행을 거친다.

	public void exam2() {

		Scanner sc = new Scanner(System.in);

		System.out.println("===== 두 수 비교 프로그램=====");
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");
		char operator1 = sc.nextLine().charAt(0);

		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();

		double result = 0;

		if (operator1 == '+') {
			result = (int) (num1 + num2);
		}
		if (operator1 == '-') {
			result = (int) (num1 - num2);
		}
		if (operator1 == '*') {
			result = (int) (num1 * num2);
		}
		if (operator1 == '/') {
			result = (double) num1 / num2;
		}

		if (result == (int) result) {
			System.out.printf("%d%c%d = %d", num1, operator1, num2, (int) result);
		}
		if (result != (int) result) {
			System.out.printf("%d%c%d = %f ", num1, operator1, num2, result);
		}
	}
//	(double)(num1 / num2)	 정수 나눗셈 후 형변환 → 소수점 손실
//	(double)num1 / num2	 실수 나눗셈 발생 → 정확한 결과

	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		// 입력한 정수가 홀수/짝수인지 출력 (삼항연산자가 아닌 if문 이용)
		// -> 2로 나눴을 때 나머지가 0일 때 짝수

		if (num % 2 == 0) {
			System.out.println("입력한 정수는 짝수입니다");
		} else {
			System.out.println("입력한 정수는 홀수입니다");
		}

	}

	public void test3() {
		Scanner sc = new Scanner(System.in);

		int adultprice = 15000;
		int kidsprice = 5000;
		System.out.println("=====놀이공원 프로그램=====");
		System.out.print("입장하실 총 인원은 몇명입니까?");
		int totalcount = sc.nextInt();
		System.out.print("어른은 몇명입니까? (1인당 " + adultprice + " 원) : ");
		int adultCount = sc.nextInt();
		System.out.print("아이는 몇명입니까? (1인당 " + kidsprice + " 원) : ");
		int kidsCount = sc.nextInt();
		// 금액 계산을 해서 알려줄지, 아니면 인원이 틀린지 실행흐름이 달라짐
		// 총 인원 수와 어른 인원, 아이 인원 합친 인원 수가 같은지 체크함
		int sum = adultprice + kidsprice;

		if (adultCount + kidsCount == totalcount) {
			System.out.println("지불하실 총 금액은 " + sum + "원 입니다.");
		} else {
			System.out.println("입력하신 인원 수가 맞지 않습니다.");
		}
	}

	public void test4() {
		Scanner sc = new Scanner(System.in);

		System.out.println("===== 퀴즈 프로그램=====");
		System.out.println("첫번째 퀴즈");
		System.out.print("사과는 영어로 무엇일까요? (1. apple, 2. steve jobs 3. 몰라) : ");
		int exam1 = sc.nextInt();

		boolean ex1;
		boolean ex2;
		int score = 0;

		if (exam1 == 1) {
			System.out.println("정답 !!");
			ex1 = true;
			score += 1;
		} else {
			System.out.println("땡 !");
			ex1 = false;
		}
		System.out.println();
		System.out.println("두번째 퀴즈");
		System.out.print("바나나는 길어 길으면 기차 기차는? (1. 비싸, 2. 빨라, 3. 몰라) : ");
		int exam2 = sc.nextInt();
		if (exam2 == 2) {
			System.out.println("정답 !!");
			ex2 = true;
			score += 1;
		} else {
			System.out.println("땡 !");
			ex2 = false;
		}

		// 최종적으로 맞춘 정답의 수를 출력!
		// 정답을 2개 다 맞춘 경우 ; answer1 == 1 && answer2 == 2
		// 정답을 1개 맞춘 경우 ; answer1 ==1 || answer2 == 2
		// 병합 [
		// 정답을 0개 맞춘 경우 ;
		System.out.println();
		System.out.println("총 " + score + " 문제를 맞추셨습니다.");
		if (ex1 == true && ex2 == true) {
			System.out.println("모든 문제를 맞추셨습니다, 축하합니다!");
		} else {
			System.out.println("조금 더 노력해보세요.");
		}

	}

	public void inlearn() {
		/*
		 * 온라인 쇼핑몰의 할인 시스템을 개발해야 한다. 한 사용자가 어떤 상품을 구매할 때, 다양한 할인 조건에 따라 총 할인 금액이 달라질 수
		 * 있다. 각각의 할인 조건은 다음과 같다. 아이템 가격이 10000원 이상일 때, 1000원 할인 나이가 10살 이하일 때 1000원 할인
		 * 
		 */
		Scanner sc = new Scanner(System.in);

		System.out.println("상품 가격을 입력해주세요. : ");
		int price = sc.nextInt();
		System.out.println("당신의 나이를 입력해주세요. : ");
		int age = sc.nextInt();
		System.out.println("중복 할인은 적용되지 않습니다.");
		int discount = 0;

		if (price >= 10000) {
			discount = -1000;
			System.out.println("10000원 이상 금액 할인");
		} else if (age <= 10) {
			discount = -2000;
			System.out.println("10세 이하 금액 할인");
		}

		System.out.println("금액 할인은 " + discount + "결제 금액은 " + (price + discount) + " 원 입니다.");

	}

	public void test5() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수를 입력하세요.");
		int num = sc.nextInt();
		if (num > 1000) {
			System.out.println("1000 보다 큰 수 입니다.");
		} else if (num > 100) {
			System.out.println("100보다 큰 수 입니다.");
		} else if (num > 10) {
			System.out.println("10보다 큰 수 입니다.");
		}

	}

	public void exam3() {
		System.out.println("=====대/소문자 변환 프로그램=====");

		Scanner sc = new Scanner(System.in);

		System.out.print("문자 입력 : ");
		char sample = sc.nextLine().charAt(0);
		System.out.println("=====결과=====");

		if (sample >= 65 && sample <= 90) {
			System.out.println("대문자를 입력하셨습니다.");
			sample += 32;
			System.out.print("대문자로 변환 : " + sample);
		} else if (sample >= 97 && sample <= 122) {
			System.out.println("소문자를 입력하셨습니다.");
			sample -= 32;
			System.out.print("대문자로 변환 : " + sample);
		} else {
			System.out.println("영문자를 입력해주세요.");
		}
	}

	public void exam4() {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 입력 : ");

		int num = sc.nextInt();
/*
 * 		3의 배수	-> 3으로 나눴을 때 나머지가 0
 * 		4의 배수  -> 4로 나눴을 때 나머지가 0
 * 		등의 경우의 수 생각.
 */
		System.out.println("=====결과=====");
		if (num == 0) {
			System.out.print("0을 입력하셨습니다.");
		} else if (num %3 == 0 && num %4 == 0) {
			System.out.printf("[%d]은(는) 3의 배수면서 4의 배수입니다.", num);
		} else if (num %3 == 0) {
			System.out.printf("[%d}은(는) 3의 배수입니다.", num);
		} else if (num %4 == 0) {
			System.out.printf("[%d]은 (는) 4의 배수입니다.", num);
		} else {
			System.out.printf("[%d]은(는) 3의 배수도, 4의 배수도 아닙니다", num);
		}

	}

	public void examMe () {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력 : ");
		int num = sc.nextInt();
		boolean m3 = (num %3 == 0);
		boolean m4 = (num %4 == 0);
		
		System.out.println("=====결과======");
		if (num==0) {System.out.println("0을 입력하셨습니다.");}
		else if (m3==true && m4==true) {
			System.out.println("3의 배수면서 4의 배수");
		} else if (m3 == true) {
			System.out.println("3의 배수");
		} else if (m4 == true) {
			System.out.println("4의 배수");
		}	else {
			System.out.println("3의 배수도 아니고 4의 배수도 아님");	
		}
	}
}

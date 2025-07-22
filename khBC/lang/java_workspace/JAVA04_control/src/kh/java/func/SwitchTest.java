package kh.java.func;

import java.util.Scanner;

public class SwitchTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1~3 사이 정수를 입력하세요 : ");
		int num = sc.nextInt();

		// switch 문 (수식을 작성하지 앟는 이상 범위가 제한적)
		// 변수 하나에 대응하는 일치하는 값 (변수 여러개 안됨.)

		// switch 의 장점 :

		switch (num) {
		case 1:
			System.out.println("111111");
			break;
		case 2:
			System.out.println("22222222");
			break;
		case 3:
			System.out.println("3333333333");
			break;
		default:
			System.out.println("1~3사이 숫자를 입력하세요.");
			break;

		/*
		 * switch(비교할 변수 or 계산식) { case 리터럴값 : 실행코드 break; case 리터럴값 : 실행코드 break; }
		 */

		/*
		 * if(num == 1) { System.out.println("111111111"); }else if (num ==2) {
		 * System.out.println("222222222"); }else if (num ==3 ) {
		 * System.out.println("333333333"); }else {
		 * System.out.println("1~3사이 숫자를 입력하시오.");
		 */
		}
	}

	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("a/b/c/ 중 1개를 입력하세요.");
		String str = sc.next();
		char ch = str.charAt(0);

		switch (ch) {
		case 'a':
			System.out.println("aaaaaaaaaaaa");
			break;
		case 'b':
			System.out.println("bbbbbbbbbbb");
			break;
		default:
			System.out.println("a/b/c 중 1개를 입력하세요!");
			break;
		}

	}

	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 : ");
		String str = sc.next();
		// switch 에 문자열을 쓸 수 있는 것은 자바 1.7 이상인 경우에만 가능함.
		switch (str) {
		case "aa":
			System.out.println("aaaaaaaaa");
			break;
		case "bb":
			System.out.println("bbbbbbbbb");
			break;
		case "cc":
			System.out.println("ccccccccc");
			break;
		default:
			System.out.println("zzzz");
			break;
		}

	}

	public void test4() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			System.out.println("1111111");
			break;
		case 2:
			System.out.println("2222222");
			// break 가 없으면, 다음 케이스의 검사 없이 다음 케이스가 실행됨.
		case 3:
			System.out.println("3333333");
			break;
		default:
			System.out.println("0000000");
			break;
		}
	}

	public void exam1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("장학금 지불 시스템 입니다.");
		System.out.print("학점을 입력하세요 (A, B, C, D, E, F) : ");
		char grade = sc.next().charAt(0);

		switch (grade) {
		case 'A':
			System.out.println("수고하셨습니다, 장학금 100% 지급입니다.");
			break;
		case 'B':
			System.out.println("수고하셨습니다, 장학금 50% 지급입니다.");
			break;
		case 'C':
			System.out.println("장학금을 바라시면 조금 더 열심히 합시다");
			break;
		case 'D':
			System.out.println("크흠...");
			break;
		case 'F':
			System.out.println("학사경고입니다!!!!");
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 대문자 A~F 중 한 글자를 입력하세요.");
			break;
		}
	}

	public void myTest1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("요일 숫자를 입력하세요. (1~7)");
		int dayNum = sc.nextInt();
		switch (dayNum) {
		case 1 -> System.out.println("월요일");
		case 2 -> System.out.println("화요일");
		case 3 -> System.out.println("수요일");
		case 4 -> System.out.println("목요일");
		case 5 -> System.out.println("금요일");
		case 6 -> System.out.println("토요일");
		case 7 -> System.out.println("일요일");
		default -> System.out.println("잘못 입력하셨습니다.");

		}

	}

	public void exam2() {
		Scanner sc = new Scanner(System.in);

		System.out.println("달을 입력하면 해당 날짜의 일수를 출력");
		System.out.println("일수를 알고싶은 달을 입력하세요. (1~12) ");

		int month = sc.nextInt();
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12: {
			System.out.printf("%d월달은 31일 까지 있습니다.", month);
			break;
		} case 2: {
			System.out.printf("%d월달은 28일 까지 있습니다.", month);
			break;
		} case 4, 6, 9, 11: {
			System.out.printf("%d월달은 30일 까지 있습니다.", month);
			break;
		} default: {
			System.out.printf("잘못된 입력을 했습니다.", month);
			break;
		}

		}
	}

	public void exam2_1() {
		Scanner sc = new Scanner(System.in);

		System.out.println("달을 입력하면 해당 날짜의 일수를 출력");
		System.out.println("일수를 알고싶은 달을 입력하세요. (1~12) ");
		int month = sc.nextInt();
		
		switch (month) {
		case 1, 3, 5, 7, 10, 12 -> System.out.printf("%d월은 31일 까지 있습니다", month);
		case 2 -> System.out.printf("%d월은 28일 까지 있습니다", month);
		case 4, 6, 9, 11 -> System.out.printf("%d월은 28일 까지 있습니다", month);
		default -> System.out.println("잘못된 입력");
		}
	}
	

}

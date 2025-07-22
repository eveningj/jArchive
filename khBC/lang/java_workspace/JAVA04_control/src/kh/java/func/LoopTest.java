package kh.java.func;

import java.util.Scanner;

public class LoopTest {

	public void test1() {
		// for를 이용한 무한 반복 -> 초기, 조건, 증감부분을 비워두면 됨.
//		for(;;) {
//			System.out.println("inf.circulation");
//		}
	}

	public void test2() {
		// while을 이요한 무한반복 -> while 의 조건식이 항상 true가 나올 수 있도록 처리
		while (true) {
			System.out.println("inf.circulation");
			break;
		}
	}

	public void test3() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("정수를 입력하세요 : ");
			int num = sc.nextInt();
			if (num == 1) {
				break; // break는 즉시 반복문을 빠져나감.
//				System.out.println("Break");//break 이후 코드는 동작하지않으므로 코드 작성이 불가능 -> 도달할 수 없음.
			} else if (num == 2) {
				continue;// 즉시 다음 반복회차로 이동함. (while에서는 조건검사, for 증감식)
				// system.out.println("continue");// continue 이후 코드는 동작하지 않으므로 코드작성이 불가능
			} else {
				System.out.println("입력한 정수는 : " + num);
			}
			System.out.println("반복은 가장 마지막 부분");
		}

		System.out.println("while이 종료되면 출력되는 구문");
	}

	public void test4() {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			System.out.print(i + "_정수 입력 : ");
			int num = sc.nextInt();
			if (num == 1) {
				break;
			} else if (num == 2) {
				continue;
			} else {
				System.out.println("입력한 숫자는 : " + num);
			}
			System.out.println("반복문 가장 마지막 부분");
		}
		System.out.println("반복문이 종료되는 출력되는 메시지");

	}

	public void test5() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n-----카카오톡-----");
			System.out.println("1.친구목록");
			System.out.println("2.채팅");
			System.out.println("3.오픈채팅");
			System.out.println("4.쇼핑");
			System.out.println("5.종료\n");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			if (select == 1) {
				System.out.println("여기에는 내 친구들이 나올 예정");
			} else if (select == 2) {
				System.out.println("내 대화목록이 나올 예정");
			} else if (select == 3) {
				System.out.println("내가 참여한 오픈채팅 목록이 나올 예정");
			} else if (select == 4) {
				System.out.println("쇼핑 페이지가 나올 예정");
			} else if (select == 5) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
		}
	}

	public void test6() {

		Scanner sc = new Scanner(System.in);

		boolean power = true;
		while (power) {
			System.out.println("\n-----카카오톡-----");
			System.out.println("1.친구목록");
			System.out.println("2.채팅");
			System.out.println("3.오픈채팅");
			System.out.println("4.쇼핑");
			System.out.println("5.종료\n");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				System.out.println("친구목록 나와라");
				break;
			case 2:
				System.out.println("채팅목록 나옴");
				break;
			case 3:
				System.out.println("오픈채팅목록 나옴");
				break;
			case 4:
				System.out.println("쇼핑페이지 나옴");
			case 5:
				System.out.println("시스템을 종료합니다.");
				power = false; // while 종료시키기 위한 값 변경
				break; // switch 종료
//				break; //while 종료 X -> swtich break; 가 동작하면 접근 불가.

			}// switch
		} // while
	}// method

	public void test7() {
		// 중첩 for문
		for (int i = 0; i < 3; i++) {
			System.out.println(i + "_반복문 1");
			for (int j = 0; j < 3; j++) {
				System.out.println(j + "_반복문 2");
			}
		}
	}

	public void test8() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("i : " + i + " /j :" + j);
			}
		}
	}

	public void testExam1() {
		for (int j = 1; j <= 9; j++) {
			System.out.println(" ");
			for (int i = 2; i <= 9; i++) {
				int mul = i * j;
				System.out.printf("%d*%d = %2d ", i, j, mul);
			}
		}
	}

	public void testExercise() {
		for (int i = 5; i > 0; i--) {
			System.out.print(i);
			for (int j = i - 1; j > 0; j--) {
				System.out.print(" " + j);
			}
			System.out.println();
		}
	}

	public void star1() {

//		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("*");
		}
	}

	public void star2() {
		for (int i = 0; i < 5; i++) {
			System.out.print("*");
		}
	}

	public void star3() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star6() {
		for (int i = 1; i <= 5; i++) {
			System.out.print(i);
			for (int j = i + 1; j < (i + 5); j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	public void star7() {
		for (int i = 5; i >= 1; i--) {
			System.out.print(i);
			for (int j = (i + 1); j < (i + 5); j++) {
				System.out.print(j);
			}
			System.out.println();

		}
	}

	public void star8() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
	}

	public void star9() {
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}// method

	public void star10() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 5; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star11() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star12() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 4; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star13() {
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 2; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star16() {
		for (int i = 1; i <= 5; i++) {
			for (int b = 4; b >= i; b--) {
				System.out.print(" ");
			}
			for (int s = 1; s <= (2 * i) - 1; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void star17() {
		Scanner sc = new Scanner (System.in);
		System.out.println("역삼각형 별 짓기");
		System.out.print("삼각형의 높이 입력 : ");
		int n = sc.nextInt();
		
		for (int i = n; i >= 0; i--) {
			for (int b = 0; b < n-i ; b++) {
				System.out.print("b");
				// 첫번쨰엔 반복 안되고,
				// 두번째부터 +1 씩.
//				i 를 기준. 
			}
			for (int s = 0; s<(2*i)+1; s++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} public void star18() {
		//정삼각형 + 역정삼각형 결합,
		// 중심 n 을 기준.
		//높이는 h;
		
		Scanner sc = new Scanner (System.in);
		System.out.println("정삼각형과 역정삼각형의 결합");
		System.out.println(">> 중심을 기준으로 증감하는 모델 <<");
		System.out.println("삼각형의 높이 입력 : ");
		int h = sc.nextInt();
		
		
	}
}
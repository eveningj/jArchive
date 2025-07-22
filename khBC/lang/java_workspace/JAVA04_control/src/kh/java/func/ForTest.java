package kh.java.func;

import java.util.Scanner;

public class ForTest {
	Scanner sc = new Scanner(System.in);

	public void test1() {
		/*
		 * for문 사용 방법 초기값 설정 : 반복 횟수를 조절하기 위한 변수 선언 및 초기화 작업 조건식 : 반복문의 수행여부를 결정하는 조건식
		 * (최종적으로 boolean형 데이터로 연산이 끝나며, true == 실행, false == for 종료 증감식 : 초기값에서 사용하는
		 * 변수를 조작해서 조건식을 이용해 횟수를 조절하기위한 증/감 구문 for (초기값설정 ; 조건식;조건변화를 위한 증감식) { 실행코드; }
		 * 
		 */
		for (int i = 1; i <= 3; i++) {
			System.out.println(i);
			System.out.println("Hi");
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(i + 1 + "번째 반복");
			System.out.println("Hello");
		}

	}

	public void forExam1() {
		for (int i = 0; i < 5; i++) {
			System.out.println("안녕하세요");
		}

	}

	public void forExam2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇번 출력하시겠습니까?");
		int num = 0;

		for (num = sc.nextInt(); num != 0; num = sc.nextInt()) {
			System.out.println("안녕하세요");
			if (num == 0) {
				System.out.println("아무것도 출력하지 않겠습니다.");
			}
		}
	}

	public void forExam3() {
		System.out.println("구구단 2단입니다.");
		for (int num = 1; num < 10; num++) {
			System.out.println("2 * " + num + " = " + num * 2);
		}
	}

	public void forExam4() {
		System.out.println("몇단을 출력하시겠습니까? ");
		Scanner sc = new Scanner(System.in);
		int mNum = sc.nextInt();
		
		for (int num = 1; num < 10; num++) {
			System.out.println(mNum+ " * " + num + " = " + num * mNum);
		}
	}

	public void forExam5() {
		System.out.println("");
		//구구단 중 짝수단만 출력하기.
		
		for (int dan=1;dan<=9;dan++) {
			if (dan%2!=0) {
				continue;
			} for (int j=1;j<=9;j++) {
				int result = dan*j;
				System.out.printf("%d * %d = %d", j,dan,result);
			}
		}
		}
		
		
	public void forExamNum1() {
		
		Scanner sc = new Scanner(System.in);
		int result = 0; 
		
		for (int i=0; i<5;i++) {
			
			System.out.print("정수 값을 입력하시오 : ");
			int num = sc.nextInt();
			
			result += num;
		}
		
			System.out.printf("입력한 5개의 정수의 합 : %d", result);
		}  
		
	public void forExamNum2() {
		
		Scanner sc = new Scanner(System.in);
				int result = 0;
		
				System.out.print("첫번째 수 입력 : ");
				int num1 = sc.nextInt();
				System.out.print("\n두번째 수 입력 : ");
				int num2 = sc.nextInt();
				int sum = 0;

//				num1>num2 ? num1 : num2 활용해 보기.

				
/*	기존 코드
 * 				if (num1<num2) {
					for (int i = num1+1; i <= num2; i++) { //삼항 연산자로 정리
						sum += i;
					}  
				} else if (num1>num2) {
					for (int i = num2+1; i <= num1; i++) {
							sum += i;
						} 
				} else {
					sum = 0;
						}
						*/
				
				
				/*
				 * 강사님 코드
				 * 1. for (int i = 0 ; i < num2- num1 +1 ; i++) {
				 * 	sum += (i+num1);
				 * 
				 * 2. for(int i = num1 ; i < num2 =1; i++) {
				 * 	sum += 1;
				 */
				for (int i = num1<num2 ? num1 : num2; i <= (num1>num2 ? num1 : num2); i++ ) {
						sum += i;
						if (num1 == num2) {
							sum = 0;
							break;
						}
				}
				System.out.printf("\n%d ~ %d의 정수의 합 : %d", num1, num2, sum);
	}
	
	public void forExamNum3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");	
		int num = sc.nextInt();
		int sum = 0;
		/*
		for (int i = 1; i<=num; i++) {
			if (i%2==0) {
				sum+=i;
			}
		}*/
		
		for (int i = 0; i<=num; i+=2) {
				sum+=i;
		}
		
		System.out.printf("짝수들의 합은 : %d", sum);
			
			
			
	}
	
	public void test2() {
		for(int i=5;i>0;i--) {
			System.out.println(i+"_HI");
		}
	}
}

package kh.java.var;
import java.util.Scanner;

public class Example {
	public  void exam1 () {
		/*
		 * 정수 두개를 입력 받아 두 수의 합, 차, 곱, 나눈 몫, 나눈 나머지를 출력
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 : ");
		int iNum1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int iNum2 = sc.nextInt();
		System.out.println();
		System.out.println("========결과========");
		System.out.println();
		int sumNum = iNum1+iNum2;
		int minNum = iNum1-iNum2;
		int multNum = iNum1*iNum2;
		int divNum = iNum1/iNum2;
		int restNum = iNum1%iNum2;
		System.out.println("더하기 결과 : "+sumNum);
		System.out.println("빼기 결과 : "+minNum);
		System.out.println("곱하기 결과 : "+multNum);
		System.out.println("나누기 몫 : "+divNum);
		//컴퓨터는 동일한 데이터 타입의 연산만 하고, 동일한 타입의 결과를 하기 떄문에 정수/정수 로 결과값도 정수로 나옴.
		System.out.println("나누기 나머지 : "+restNum);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
	}

	public void exam2 () {
		
		Scanner sc = new Scanner(System.in);
				
		System.out.print("가로 길이 입력 : ");
		int horzL = sc.nextInt();
		System.out.print("세로 길이 입력 : ");
		int vertL = sc.nextInt();
		System.out.println();
		System.out.println("========결과========");
		int extent = horzL+vertL;
		int circum = 2*(horzL+vertL);
		System.out.println();
		System.out.println("면적 : "+extent);
		System.out.println("둘레 : "+circum);
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
	}
	
	public void exam3 () {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		// 🔧 next() → nextLine()으로 변경하여 공백 포함 이름 입력 가능
		System.out.print("나이 (세) : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("키(cm) : ");
		double height = sc.nextDouble();
		int iHeight = (int)height;
		
		System.out.print("몸무게(kg) : ");
		double weight = sc.nextDouble();
		
		System.out.print("성별 : ");
		String genderString = sc.next();
		char gender = genderString.charAt(0);
		
		System.out.println("\n----------------[입력정보]--------------------\n");
		System.out.printf("이름\t: %s\n", name);
		System.out.printf("나이\t: %d세\n", age);
		System.out.printf("주소\t: %s\n", address);
		System.out.printf("키\t: %dcm\n", iHeight);
		System.out.printf("몸무게\t: %.1f.kg\n", weight);
		System.out.printf("성별\t: %c\n", gender);
		System.out.println("---------------------------------------------\n");
	}
	

	public void exam4 () {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 : ");
		int kScore = sc.nextInt();
		System.out.print("수학 점수 입력 : ");
		int mScore = sc.nextInt();
		System.out.print("영어 점수 입력 : ");
		int eScore = sc.nextInt();
		
		int sScore = (kScore + mScore + eScore);
		double avg = (double)sScore/3;
		System.out.printf("당신의 성적의 총 합은 %d점이고, 평균은 %.2f 입니다!\n", sScore, avg);
		System.out.println("----------------------------------------");
		System.out.println();
		
		
	}
	public void exam5 () {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영어단어 입력 : ");
		String eWord1 = sc.nextLine();
		char ch1 = eWord1.charAt(0);
		char ch2 = eWord1.charAt(1);
		char ch3 = eWord1.charAt(2);
		
		System.out.printf("첫번째 단어 : %s", ch1);
		System.out.println();
		System.out.printf("두번째 단어 : %s", ch2);
		System.out.println();
		System.out.printf("세번째 단어 : %s", ch3);
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
		//스캐너 종료
		sc.close();
	}

}



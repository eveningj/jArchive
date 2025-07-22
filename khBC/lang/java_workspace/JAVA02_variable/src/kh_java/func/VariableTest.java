package kh_java.func;

public class VariableTest {
	public void test1() {
		//기본자료형 8개
		//	논리형(boolean), 문자형(char), 정수형(byte,short,int,long), 실수형(float,double)
		//참조자료형
		//	문자열(string)
		
		//변수 선언 : 컴퓨터의 메모리 중 일정 영역을 데이터 저장용도로 사용하겠다라고 알림
		//변수 선언 방법 -> 자료형 변수이름;
		//1. 논리형 변수 선언
		
		
		
		boolean bool;
		//2. 문자형 변수 선언
		char ch;
		//변수는 선언하면 최초에 쓰레기 값이 들어있는 상태 -> 바로 사용하는 것이 불가능
		//변수에 데이터를 한번 대입해줘야 사용이 가능 -> 최초에 한번 데이터를 대입 (변수의 초기화)
		// = 은 개발에서, 등호가 아닌 대입연산자
		// A = B; -> B라는 데이터를 A라는 변수에 대입
		//==가 같다.
		//'a' 를 ch 변수에 대입
		ch = 'a';
		System.out.println(ch);
		//논리형 변수에 데이터 대입
		
		bool = true;// 논리형은 사용 데이터가 2개 (true/false)
		//System.out.println(num1); //변수는 선언 이후에 사용해야함
		//정수형 변수 선언
		int num1;
		//System.out.println(num1); //변수는 선언 이후에도 초기화를 한 후 사용해야함
		//num1 변수에 10이라는 데이터를 대입
		num1 = 10;
		System.out.println(num1);	//변수를 사용하면 해당 데이터를 복사해서 가져옴
		num1 = 100;					//변수에 다른 데이터를 대입하면 해당 데이터로 변경
		System.out.println(num1);
		// 대입연산자는 우측을 우선으로 연산.
		// -> 현재 num1에 저장된 데이터를 복사해서 +100 연산을 한 결과를 num1 변수에 대입
		num1 = num1 + 100; 	
		System.out.println(num1);
		//4. 실수형 변수 선언(double), 변수이름은 num2, 값은 3.14로 초기화 후 출력
		double pi;
		pi = 3.14;
		System.out.println(pi);
		//변수를 선언하면서 바로 초기화 하는 작업
		double num2 = 3.14;
	}
	public void test2() {
		int num1 = 1000;
		long num2 = 2000000l;
		float num4 = 3.14f;
		System.out.println(num1);
		num1 = 2000;	//일반 변수는 값을 다시 대입하면 새로운 값으로 변경
		System.out.println(num1);
		//변수 선언시 final 키워드를 앞에 붙이면 일반 변수가 아닌 상수형 변수
		//상수형 변수의 특징은 한번 값을 초기화하고 난 뒤 값 변경이 불가능
		//일반 변수는 변수 이름을 카멜 표기법으로 작성되는 것에 반해,
		//상수형 변수는 구분을 위해서 모두 대문자로 작성
		//변수 선언은 한 메소드에 종속됨.
		final int NUM5;
		NUM5 = 200;
		System.out.println(NUM5);
		//NUM5 = 300; //초기화 후 값 변경하려고 하면 에러가 발생
	}
//	Data overflow
	
	public void test3() {
		int num = 2147483647; 
		long result = (long)num + 1; //( ) 로 형변환 되기 전에, num은 int로 정의됨.
		System.out.println(result); //2147483647
		
		//강제 형변환 해야하는 경우 (큰 자료형 데이터를 작은 자료형에 넣을 때)
		//강제 형변환은 데이터의 유실을 체크해야함.
		int num2 = 290;
		byte num3 = (byte)num2;	//num2의 데이터를 강제로 byte타입으로 변환.
		System.out.println(num3);
		
		//자동으로 형변환 되는 경우 (작은 자료형을 큰 자료형에 넣을 때)
		byte num4 = 100;
		int num5 = num4;
		System.out.println(num5);
	}
	
	public void test4() {
//		System.out.println();//괄호 안의 내용을 출력 후 개행(엔터)
//		System.out.print(); 괄호 안의 내용을 출력
		System.out.println("안녕하세요.");
		System.out.print("제 이름은 ");
		System.out.println("김정우 입니다");
		
		System.out.println("----------------");
		//
		System.out.println("");
		System.out.print("안녕하세요. ");
		System.out.println("");
//		System.out.print(); print 명령어의 경우 ()안에 반드시 데이터를 넣어줘야 함.
		System.out.print("제 이름은 ");
		System.out.println("김정우 입니다.");
		System.out.println();
		//간단 실습
		/* 자바의 기본 자료형
		 * 논리형 (boolean) 문자형 (char) 정수형(int,long), 실수형(float, double), 문자열 (String)
		 * 
		 * 문제 : 실습 문제 : 변수를 3개 선언 -> 이름 (문자열), 나이(int), 주소 (문자열)
		 * 각 변수에 본인의 이름, 나이, 주소를 대입
		 * 최종 출력 예
		 * 안녕하세요, 제 이름은 이윤수이고, 나이는 XX살, 사는 곳은 서울입니다.
		 */
		
		String name = "김정우";
		int year = 2025;
		int birth = 1997;
		int age = year - birth + 1;
		int age1 = 20;
		String adr = "서울";
		
		//예제 1
		System.out.println("안녕하세요, 제 이름은 " + name + "이고, 나이는 " + age + "살, 사는 곳은 " + adr + "입니다.");

		
		System.out.println('A' + 0);
		System.out.println();
		//예제 2
		System.out.print("안녕하세요 제 이름은 ");
		System.out.print(name);
		System.out.print("이고, 나이는 ");
		System.out.print(age1);
		System.out.print(" 이고, 사는 곳은 ");
		System.out.print(adr);
		System.out.println(" 입니다.");
		System.out.println();
}
		public void test5() {
			String name = "김정우";
			int age = 29;
			String address = "서울시 영등포구";
			System.out.println("안녕하세요, 제 이름은" + name +"이고, 나이는 "+age+"살, 사는 곳은 "+address+"입니다.");
			//System.out.printf();
			System.out.printf("안녕하세요, 제 이름은 %s이고, 나이는 %d살, 사는 곳은 %s입니다.", name, age, address);
//			순서가 중요함.
			// 1. 문자열 %s
			// 2. 정수 %d, %o : 8진수, %x 16진수
			// 3. 실수 %f, %e : 지수 %A :16진수 실수(짧은 표현 사용)
			// pdf 참조.
			
		}
		
		public void test6() {
			int num = 100;
			int num2 = 200;
				//-> 정수는 : 100
			//1.
			System.out.print("정수는 : ");
			System.out.print(num);
			System.out.println();
			//2.
			System.out.println("정수는 : "+num);
			//3.
			System.out.printf("정수는 : %d, %d", num, num2);
			System.out.println();
			double doubleNum = 3.14;
			System.out.printf("실수는 : %.2f", doubleNum); //%f는 소숫점 여섯째 짜리까지 출력
			System.out.println();
			//소숫점 자리 수를 조절하고 싶은 경우, %앞에 .2, .3 기입 (%.numf)
			System.out.printf("실수는 : %.1f", doubleNum);
			System.out.println();
			//format은 format 지정 했을 때 값을 꼭 주어야함. > 오류 (더 입력했을 땐 유실)
			System.out.printf("정수는 : %d", 300);
			System.out.println();
			System.out.println();
			
			
			//문자, 문자열 처리
//			문자
			char ch = 'A';
			System.out.printf("문자 : %c", ch);
			System.out.println();
//			문자열
			String str = "Hello";
			System.out.printf("문자열 : %s", str);
			System.out.println();
			System.out.println();
			
			System.out.printf("%c %s %d %.2f", ch,str,num,doubleNum);
			
			System.out.println();
			System.out.println();
			//오늘 우리반 출석률은 100%입니다.
			int number = 100;			
			System.out.printf("오늘 우리 반 출석률은 %d%%입니다.", number);
			System.out.println();
			//print, println에서는 %는 특별한 의미가 없음.
			System.out.println("오늘 우리 반 출석률은 " +number+"%입니다.");
		
			// 제 이름은 "김정우" 입니다.
			
			
			
			System.out.println("제 이름은 \"김정우\" 입니다.");
			System.out.println("제 이름은\t김정우\n입\\니다.");
			
		}
		public void exam1() {
			int ex1 = 100;
			long ex2 = 999999999999l;
			float ex3 = 468.520f;
			double ex4 = 5697.890123;
			char ex5 = 'A';
			String ex6 = "Hello JAVA";
			boolean ex7 = true;
			
			System.out.println();
			System.out.println();
			System.out.printf("%d,\n%d,\n%f,\n%f,%c,\n%s,", ex1, ex2, ex3, ex4, ex5, ex6 + ex7);
			
		}
		public void exam2() {
			String name = "김정우";
			int year = 2025;
			int birth = 1997;
			int age = (year-birth+1);
			String gender = "남자";
			String address = "서울시";
			String email = "jwkimhere@gmail.com";
			String phoneNumber = "01055685925";
			
			System.out.print("이름\t나이\t성별\t지역\t전화번호\t\t이메일\n");
			System.out.println("----------------------------------------------------------------------------------");
			
			System.out.printf("%s\t%d\t%s\t%s\t%s\t%s", name,age,gender,address,phoneNumber,email);

			System.out.println();
			System.out.println("----------------------------------------------------------------------------------");
			
			String name1 = "고길동";
			int year1 = 2025;
			int birth1 = 1976;
			int age1 = (year1-birth1+1);
			String gender1 = "남자";
			String address1 = "경기도";
			String phoneNumber1 = "01098765432";
			String email1 = "mrgogo@email.com";
			
			System.out.printf("%s\t%d\t%s\t%s\t%s\t%s", name1,age1,gender1,address1,phoneNumber1,email1);
		
		}
		

		
	}
	
		


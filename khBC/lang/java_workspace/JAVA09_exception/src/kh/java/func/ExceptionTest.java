package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {

	Scanner sc = new Scanner(System.in);
	
	public ExceptionTest() {
		super();
	}
	
	
	//UNCHECKED EXCEPTION 
	public void test1() {
		//정수 두개를 입력받아서 몫을 연산해서 출력하는 기능
		
		while(true) {
			try {
				System.out.print("정수를 입력하세요 : ");
				int num1 = sc.nextInt();
				System.out.print("정수를 입력하세요 : ");
				int num2 = sc.nextInt(); //ERROR 시 catch 로 바로 이동함. -> exception 발생시.
				
				int result = num1/num2;
				System.out.println("결과 : "+ result);
				break;
				
				}catch(InputMismatchException e) {
					sc.nextLine(); //입력 도중 에러가 발생하여 버퍼가 비정상적인 상태 -> 버퍼를 비워서 정상으로 둠. 
					System.out.println("잘못 입력하셨습니다.");
					continue; //Buffer 를 비우지 않으면 scanner 가 비정상적으로 작동함.
				}//catch
				
		}//while
	}//test1();
	
	public void test2() {
		
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt(); //ERROR 시 catch 로 바로 이동함. -> exception 발생시.
			try {
				int result = num1/num2;
				System.out.println("결과 : "+ result);
			}catch(ArithmeticException e)  {
				System.out.println("0으로는 나눌 수 없습니다.");
			}
			
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
			}//catch
	}//test2();
	
	public void test3() {
		
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt(); //ERROR 시 catch 로 바로 이동함. -> exception 발생시.
			
			int result = num1/num2;
			System.out.println("결과 : "+ result);
		}catch (Exception e) {
			System.out.println("ERROR");
		}
	}//test3();
	
	public void test4() {
		
		//한 try 구문에 여러개의 catch 작성 가능함. -> 순서를 신경써야함
		// -> 범위가 넓은 걸 아래로 !
		try {
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt(); //ERROR 시 catch 로 바로 이동함. -> exception 발생시.
			if(num2 == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				return;
			}//RUNTIME ERROR 는 애초에 막는게 좋음.
			int result = num1/num2;
			System.out.println("결과 : "+ result);
			
//		}catch(Exception e) {
//		} //UNREACHABLE.
			}catch(InputMismatchException e) { //->else if 처럼 동작함.
				sc.nextLine(); //입력 도중 에러가 발생하여 버퍼가 비정상적인 상태 -> 버퍼를 비워서 정상으로 둠. 
				System.out.println("잘못 입력하셨습니다.");
			}catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}catch(Exception e) {
				System.out.println("에러가 발생했습니다.");
			}
		
		
	}//test4();
	
	public void test5() {
		
		try { 	//CHECKED EXCEPTION//  -> Compilation error
				//반드시 처리해야함.
			FileInputStream fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//test5();
	
	public void test6() throws FileNotFoundException {
		//checked exception 을 처리하지 않고 throw 를 이용해서 던지면
		//이 메소드를 사용하는 쪽에서 처리해야함.
		FileInputStream fis = new FileInputStream("test.txt");
	}//test6();
	
	public void test7() {
		//checked exception 을 직접 처리해야함 (test6 이 처리를 안하고 던졌기 때문에.)
		//만약 test7에서도 trhows 하면 ? -> test7을 쓰는 쪽에서 반드시 처리.
		
		try {
			test6();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//test7();

	public void test8() {
		try {
			System.out.println("윈도우에서 자원을 빌려오는 코드");
			System.out.print("정수를 입력하세요 : ");
			int num1 = sc.nextInt();
			System.out.print("정수를 입력하세요 : ");
			int num2 = sc.nextInt(); //ERROR 시 catch 로 바로 이동함. -> exception 발생시.
			if(num2 == 0 ) {
				System.out.println("0으로 나눌 수 없습니다.");
				return;
			}
			
			int result = num1/num2;
			System.out.println("결과 : "+ result);
			
			}catch(InputMismatchException e) { //->else if 처럼 동작함.
				sc.nextLine(); //입력 도중 에러가 발생하여 버퍼가 비정상적인 상태 -> 버퍼를 비워서 정상으로 둠. 
				System.out.println("잘못 입력하셨습니다.");
			}finally {
		System.out.println("윈도우에서 자원을 반납");
			}//finally
	}//test8();
}

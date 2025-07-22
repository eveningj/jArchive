package kh_java.func;
//JRE System Library에 있음.
import java.util.Scanner;

public class ScannerTest {
	public void test1() {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("정수를 입력해보세요 : ");
		//사용자 콘솔에 키보드값을 입력하는 것을 기다림, 입력하고 엔터를 치면 입력한 내용을 정수 형태로 가져옴.
		//Scanner는 다양한 입력 소스를 사용할 수 있는데, System.in을 넘기면 키보드 입력을 대상으로 동작하는 Scanner 객체가 된다.
		int num = sc.nextInt();
		System.out.println("입력한 정수는 : "+num);
		System.out.print("실수를 입력하세요 : ");
		double dNum = sc.nextDouble();
		System.out.printf("입력한 실수는 : %g", dNum);
		boolean bool = sc.nextBoolean();
		System.out.println("입력한 데이터는 : "+bool);
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		//스캐너를 이용한 문자, 문자열 입력받기
		//문자열 입력받을 때 : sc.next(), sc.nextLine() -> 두 개 차이는 띄어쓰기 포함 여부
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();//이름은 띄어쓰기 없이 입력할 예정으로 sc.next() 사용.
		System.out.println("입력한 문자열은 : "+name);
		System.out.print("주소를 입력하세요 : ");
//		Scanner를 사용할 때, nextInt()나 next() 같은 메서드는 숫자 또는 단어까지만 읽고, 줄바꿈 문자(\n)는 버퍼에 남겨둔다.
		
		//!!!!sc.nextLine()은 버퍼를 비운 상태로 사용해야함.!!!
		sc.nextLine();//버퍼에 남아있는 엔터를 처리하는 목적
//		sc.close();
		String address = sc.nextLine();//주소는 띄어쓰기를 포함해서 입력해야 하므로 sc.nextLine() 을 사용함.
		System.out.println("입력한 주소 : "+address);
		
		//문자 입력 받을 때 -> 문자를 직접 입력받는 방법은 없음
		//문자열로 먼저 입력받고 -> 저장된 문자열에서 문자를 추출
		System.out.println();
		String str= sc.next();
		System.out.println(str);
		//문자열.charAt(숫자) : 문자열에서 숫자 번째에 해당하는 글자를 문자타입으로 가져옴.
		//글자 위치를 셀 때는 0부터 세야함!
		char ch1 = str.charAt(1);
		System.out.println(ch1);
		
		
	
	}
	
	
	
}

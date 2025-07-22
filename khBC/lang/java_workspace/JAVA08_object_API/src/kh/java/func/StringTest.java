package kh.java.func;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

//import java.lang.*;
public class StringTest {
	public String test1() {
		//외부 클래스 사용시 import 생략 가능 조건
		//1.같은 패키지 내 클래스 사용 시 생략 가능.
		//2.java.lang package 내부의 클래스는 import 없이 사용 가능.
		StringBuilder sb = new StringBuilder(); // "" // 문자열의 길이를 정수로 반환.
		System.out.println("문자열 길이 : "+sb.length());
		//StringBuilder는 toString()을 오버라이딩함.
		//->toString() 호출 시 저장된 문자열을 그대로 반환.
		System.out.println(sb.toString());
		//append(param) : 현재 저장된 문자열에 매개변수로 전달한 값을 뒤에 추가.
		//append는 오버로딩으로 여러 자료형을 추가할 수 있게 구현되어 있음.
		sb.append("test");
		System.out.println("문자열 길이 : "+sb.length());
		System.out.println(sb.toString());
		System.out.println("문자열 길이 : "+sb.length());
		sb.append(1);
		System.out.println(sb.toString());
		System.out.println("문자열 길이 : "+sb.length());
		sb.append(1.1);
		System.out.println(sb.toString());
		sb.append(" 안녕");
		System.out.println(sb.toString());
		System.out.println("문자열 길이 : "+sb.length());
		//insert(정수,데이터) : 첫번째 매개변수 위치에 두번째 매개변수 데이터를 삽입
		sb.insert(3, " data");
		System.out.println(sb.toString());
		StringBuilder sb2 = new StringBuilder();
		//replace(정수, 정수, 데이터) :첫번째 매개변수 위치부터 두번째 매개변수 '앞' 까지를 세번째 매개변수로 변환.
		sb.replace(3, 9, "수정구문");
		//for(int i=3; i<9;i++)
		System.out.println(sb.toString());
		//delete(정수,정수) : 첫번째 매개변수 위치부터 두번째 매개변수 앞까지를 삭제함.
		sb.delete(3, 10);
		System.out.println(sb.toString());
		//reverse() : 현재 문자열 순서를 뒤집음.
		sb.reverse();
		System.out.println(sb.toString());
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println(sb);
		return sb.toString();
	}//
	
	public void test2() {
		//회원가입 시 이메일 or 전화번호 인증 시 사용하는 랜덤 코드 생성;
		//조합 -> 영어 대문자/ 영어 소문자 / 숫자를 랜덤으로 조합해서 8자리 랜덤코드 생성;
		//instant
		Random r = new Random();
		StringBuilder sb = new StringBuilder();//""
		for(int i=0;i<8;i++) {
			//이번 반복회차에서 대문자/소문자/숫자 중 하나를 랜덤으로 선택;
			int flag = r.nextInt(3); //0 : 숫자, 1 : 대문자, 2 : 소문자
			if(flag ==0) {
				int randomNum = r.nextInt(10); //-> 10개의 숫자. 0~9 사이 중 1개를 랜덤으로 추출.
				sb.append(randomNum);
			}else if(flag == 1 ) {
				int randomNum = r.nextInt(26) + 65;
				char ch = (char)randomNum;
				sb.append(ch);
			}else if(flag == 2 ) {
				int randomNum = r.nextInt(26) + 97;
				char ch = (char)randomNum;
				sb.append(ch);
				
			}
		}//for()
		System.out.println(sb.toString());
	}//
	
	public void test3() {
		//String에서 자주 사용하는 메소드
		String str1 = "AbcdEfg";
		//toUpperCase() : 문자열을 모두 대문자로 변환해서 리턴함(원본 문자열은 영향 없음);
		System.out.println(str1.toUpperCase());
		System.out.println(str1);
		//toLowerCase() : 문자열을 모두 소문자로 변환해서 리턴함(원본 문자열은 영향 없음)-> 변경된 데이터를 return 할 뿐이다.;
		System.out.println(str1.toLowerCase());
		System.out.println(str1);
		String str2 = "한글이 섞인 abCdef";
		System.out.println(str2.toUpperCase());
		System.out.println(str2.toLowerCase());
		
		String str3 = "abcdabcd";
		//replace(문자열1, 문자열2) : 문자열1을 찾아서 문자열2로 대체한 후 리턴 (원본 데이터 영향 없음);
		System.out.println(str3.replace("a","A" ));
		System.out.println(str3);
		
		//indexOf(문자열) : 매개변수로 준 문자열을 찾아서 그 위치를 정수로 리턴
		int num1 = str3.indexOf("b");
		System.out.println(num1);
		//없는 것.
		int num2 = str3.indexOf("B");//parameter 로 준 문자열을 찾을 수 없으면 -1을 리턴;
		System.out.println(num2);
		//lastIndexOf(문자열) : 매개변수로 준 문자열을 찾아서 그 위치로 정수로 리턴(뒤에서부터 검색)
		//-> 앞에서의 숫자.
		int num3 = str3.lastIndexOf("b");
		System.out.println(num3);
		
		
		String str4 = "abcdefghijk";
		//substring(정수1, 정수2) : 문자열 중 정수 1부터 정수 2 앞까지를 리턴함.
		String str5 = str4.substring(3, 7);
		System.out.println(str5);
		System.out.println(str4);
		//substring(정수1) : 문자열 중 정수1부터 끝까지 리턴
		String str6 = str4.substring(3);
		System.out.println(str6);
		
		String filename = "abcd.txt";
		int num4 = filename.lastIndexOf(".");
		String onlyFilename = filename.substring(0,num4);
		String extension = filename.substring(num4);
		System.out.println(onlyFilename);
		System.out.println(extension);
		String newFilename = onlyFilename+"(1)"+extension;
		System.out.println(newFilename);
		
		//split(문자열) : 매개변수로 전달한 문자열을 기준으로대상 문자열을 잘라서 배열로 리턴
		String str7 = "이윤수/서울/강사/KH";
		
		String[] arr = str7.split("/");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(str7);
		
		str7.charAt(0);
		
		String str8 = "abcDEF";
		
		
	}//

	public void test4() {
		String str = "이윤수/서울/강사/KH";
		//첫번째 매개변수의 문자열을 두번째 매개변수 문자열을 '기준으로' 잘라서 '토큰'으로 관리하는 개체
		StringTokenizer st = new StringTokenizer(str,"/");
		
		while (st.hasMoreTokens()) {
			String str1 = st.nextToken();
			System.out.println(str1);
		}
		/*int count = st.countTokens();
		for(int i=0;i<count;i++) {
			String str1 = st.nextToken();
			System.out.println(str1);
		}*/
		
		
		/*
		int count = st.countTokens();//현재 저장되어있는 토큰의 수를 리턴
		System.out.println("현재 저장된 토큰 수 : "+count);
		String str1 = st.nextToken();//현재 남아있는 토큰 중 가장 앞의 토큰을 꺼내옴. -> 소모하는 개념이기 때문에 토큰.
		System.out.println(str1);
		count = st.countTokens();//현재 저장되어있는 토큰의 수를 리턴
		System.out.println("현재 저장된 토큰 수 : "+count);
		String str2 = st.nextToken();
		System.out.println(str2);
		System.out.println("현재 저장된 토큰 수 : "+st.countTokens());
		String str3 = st.nextToken();
		System.out.println(str3);
		System.out.println("현재 저장된 토큰 수 : "+st.countTokens());
		String str4 = st.nextToken();
		System.out.println(str4);
		System.out.println("현재 저장된 토큰 수 : "+st.countTokens());
//		String str5 = st.nextToken(); //NoSuchElementException
//		System.out.println(str5); //토큰이 없을 때 다음 토큰을 요청하면 에러 발생.
///
///
///
 */
	}

}


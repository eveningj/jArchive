package kh.java.func;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApiTest {
	public static void test() {

	}

	public void math() {
		// Singleton Pattern
		// : 프로그램 시작할 때 객체를 미리 만들어두고, 만들어진 객체를 사용함.
		// -> RUN 할 때. (ctrl f11 할 떄.)

		// 다른 class 를 객체화 해서 사용할 때
		// 1. 객체생성
		// TestClass1 tc = new TestClass();
		// 2. 객체의 메소드 호출
		// tc.methodName();

		// 프로그램 시작시 미리 만들어진 객체(사용 준비가 끝난 상태)
		// -> 여러 곳에서 사용하더라도 매번 객체를 생성하는게 아니라 시작할 때 만들어지 객체를 재사용
		// -> 메모리를 효율적으로 쓰는 것이 목표임.
		// -> Singleton Pattern.
		// -> Singleton Pattern 으로 메소드를 만드는 방버ㅓㅂ
		// -> 메소드를 Static 으로 생성.
		// -> 수학 기능을 담당하는 Math Class 는 Singleton으로 만들어진 Class -> 객체를 생성하지 않고 바로 사용.

		// Math.메소드(); -> 클래스 명명하지 않아도 됨.

		// abs(숫자) : 절대값 (양수/음수 부호를 모두 양수로 변환)
		// 삼항연산자 메소드임.
		int num1 = Math.abs(-10);
		int num2 = Math.abs(10);
		System.out.println(num1);
		System.out.println(num2);

		// 올림, 버림, 반올림
		System.out.println(Math.ceil(10.1));// 소수 첫째자리에서 올림
		System.out.println(Math.floor(10.9));// 소수 첫째자리에서 버림
		System.out.println(Math.round(10.4));// 정수로 리턴
		System.out.println(Math.round(10.5));// 정수로 리턴
		// 1.3456 -> 반올림해서 소수 2자리까지 표현 ->1.35
		// 1.3456 -> 134.56 -> 135 -> 1.35
		System.out.println(Math.round(1.3456 * 100) / (double) 100);

		// max(숫자1,숫자2), min(숫자1,숫자2) -> return
		System.out.println(Math.max(100, 200));
		System.out.println(Math.max(200, 100));
		System.out.println(Math.min(200, 100));
		System.out.println(Math.min(100, 200));

		System.out.println(Math.random());// 0.0 ~ 1.0 사이의 임의의 실수 1개 리턴

	}//

	public void test1() {
		// 컴퓨터의 날짜 계산 방법 -> 1970 1월 1일 0시부터 현재까지 몇 ms 흘렀는지를 저장.
		Date date1 = new Date(); // <- 객체가 만들어지는 시점의 시스템 시간을 가져옴.
		System.out.println(date1);
//		new Date("asdf"); //<- VERSION ISSUE
		// Date 객체는 생성자가 2개 (추가로 있는 생성자는 모두 deprecate 없어질 에정인 생성자)
		// 기본 생성자를 사용하면 -> 현재 시스템 시간을 가져옴(객체 생성 시점);
		// long 매개변수를 주는 형태로 사용하면 -> 기준 시간에서 매개변수로 받은 시간 만큼 흐른 시간을 가져옴 -> Timer
		Date date2 = new Date(0);
		System.out.println(date2);
		Date date3 = new Date(24 * 60 * 60 * 1000);
		System.out.println(date3);

		// SimpleDateFormat : date타입을 원하는 형식의 문자열로 리턴해주는 객체

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String str1 = sdf1.format(date1);
		System.out.println(str1);
		String str2 = sdf1.format(date2);
		System.out.println(str2);
		// SimpleDateFormat의 패턴문자
		/*
		 * 년도 : yyyy or yy 월 : M or MM or MMM or MMMM 일 : d or dd 요일 : E or EEEE 오전 / 오후
		 * : a 시간 : H or HH or h or hh (대문자는 24시 표기 / 소문자는 12시 표기) 분 : m or mm 초 : s or
		 * ss 밀리초 : SSS
		 **/
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss.SSS EEEE");
		String str3 = sdf2.format(date1);
		System.out.println(str3);
	}

	public void test3() {
		// Date 객체는 날짜 및 시간을 표현하는 객체
		// 날짜 및 시간을 계산하고 싶으면 Calendar 사용
		// Calendar의 생성자의 접근제어 지시자가 protected 여서 사용이 불가능

		// Calendar 객체의 getInstance() 메소드가 Singleton Pattern 으로 구현되어 있음.
		Calendar time1 = Calendar.getInstance();// getInstance() 메소드가 실행되는 시점의 시간을 캘린더 객체로 리턴
		// Calendar 객체에서 정보를 가져오는 방법 -> 인스턴스를 저장한 변수.get(알고싶은 정보)

		// -> 정수로 RETURN.
		System.out.println(time1.get(Calendar.YEAR)); // 년도
		System.out.println(time1.get(Calendar.MONTH) + 1); // 월(0~11로 제공) -> 필요하면 보정
		System.out.println(time1.get(Calendar.DATE)); // 일
		System.out.println(time1.get(Calendar.AM_PM)); // AM : 0 / PM : 1
		System.out.println(time1.get(Calendar.HOUR)); // 시간
		System.out.println(time1.get(Calendar.MINUTE)); // 분
		System.out.println(time1.get(Calendar.SECOND)); // 초
		System.out.println(time1.get(Calendar.MILLISECOND)); // 밀리초
		System.out.println(time1.get(Calendar.DAY_OF_WEEK)); // 요일 -> 1 : 일요일 ~ 7: 토요일

		System.out.println("---------------------------------------");
		Calendar day1 = Calendar.getInstance();
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH) + 1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		// 캘린더 객체의 정보를 변경 -> 2025/11/4
		day1.set(Calendar.MONTH, 10); //11월로 변경
		day1.set(Calendar.DATE, 4);//4일로 변경
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH) + 1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		System.out.println("---------------------------------------");
		
		
		day1.set(2026, 3, 21);
		System.out.println(day1.get(Calendar.YEAR));
		System.out.println(day1.get(Calendar.MONTH) + 1);
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));

		
		Calendar day2 = Calendar.getInstance();
		//getTimeInMillis() : 1970 1월 1일 0시부터 몇 ms가 지났는지 long 타입으로 반환
		
		long time = day2.getTimeInMillis();
		System.out.println("time : "+ time);
		long day = time/(24*60*60*1000);
		System.out.println("day : "+ day/365);
		System.out.println();

		Date date1 = new Date(time);
		System.out.println(date1);
		Date date2 = new Date(time+86400000);
		System.out.println(date2);
		String str1 = day2.get(Calendar.YEAR)+ "-"+(day2.get(Calendar.MONTH+1)+"-"+day2.get(Calendar.DATE));
		
		System.out.println(str1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str2 = sdf.format(date1);
		System.out.println(str2);
	}//
	
	public void wrap1() {
		//Wrapper Class : primitive type 을 reference type 사용할 수 있도록 포장하는 클래스 -> 객체로 다뤄야할 필요가 있을 때
		/*
		 * boolean -> Boolean
		 * char -> Character
		 * bye -> Byte
		 * short -> Short
		 * int -> Integer
		 * long -> Long
		 * float -> Float
		 * double -> Double
		 * */
		
		//정수형 변수에 10을 대입
		int num1 = 10;
		//Wrapper가 필요한 경우 -> (int -> Integer) : : 기본형을 참조형으로 써야할 때.
		Integer num2 = new Integer(100); //기본형을 참조형으로 포장 -> BOXING
		int num3 = num2.intValue(); //Wrapper 로 감싸진 데이터를 다시 기본형으로 전환 -> UNBOXING
		
		//실수형 변수에 10.5를 대입
		double d1 = 10.5;
		//double -> Double
		Double d2 = new Double(10.5); //BOXING;
		double d3 = d2.doubleValue(); //UNBOXING;
		
		
		//AUTO-BOXING, AUTO-UNBOXING
		int num11 = 100;
		Integer num12 = 100;
		int num13 = num12;
		
		Double d11 = 3.14;
		double d12 = d11;
		
		
	}
	
	public void wrap2() {
		// Wrapper Class 를 사용하는 경우	 기본형 <-> 문자열 데이터 변환
		//1) 문자열로 있는 데이터를 기본자료형으로 변환하고 앂을 때
		
		String str1 = "100";
		//변경하고 싶은 기본 자료형의 Wrapper Class 를 사용.
		
		int num1 = Integer.parseInt(str1);
		System.out.println(num1);
		
		String str2 = "3.14";
		double d1 = Double.parseDouble(str2);
		System.out.println(d1);
		
		/* 정상적으로 변환이 불가능한 문자열을 변환하려고하면 에러 발생.
		String str3 = "100a";
		int num2 = Integer.parseInt(str3);
		System.out.println(num2);
	*/
		//문자열을 -> 문자로 변경할 때
		String str4 = "ABCD";
		char ch = str4.charAt(2);
		
		//2) 기본 자료형을 문자열로 바꾸는 경우
		int num2 = 100;
		double d2 = 3.14;
		
		// String abcd = num2+""
		int num3 = 100;
		double d3 = 3.14;
		
		
		//2-1) WRAPPER CLASS
		String str5 = Integer.valueOf(num2).toString();
		String str6 = Double.valueOf(d2).toString();
		System.out.println(str5);
		System.out.println(str6);
		
		//2-2) String CLASS
		String str7 = String.valueOf(num2);
		String str8 = String.valueOf(d3);
		
		
		
	}
}


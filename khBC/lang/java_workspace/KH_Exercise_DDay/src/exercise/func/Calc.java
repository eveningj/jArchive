package exercise.func;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Calc {

	Scanner sc = new Scanner(System.in); 
	
	public Calc() {
		super();
	}

	public void main() {
		System.out.println("========= D-Day 계산기 =========");
		System.out.print("D-Day (년도) [YYYY] 입력 : ");
		int dYear = sc.nextInt();
		System.out.print("D-Day (월) [MM] 입력 : ");
		int dMonth = sc.nextInt();
		System.out.print("D-Day (일) [DD] 입력 : ");
		int dDay = sc.nextInt();
		
		
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
//		int thisYear = time1.get(Calendar.YEAR);
//		int thisMonth = time1.get(Calendar.MONTH)+1;
//		int thisDate = time1.get(Calendar.DATE);
		
		long miliTime = time1.getTimeInMillis();
		Date todayDate = new Date(miliTime);
		time2.set(dYear, dMonth-1, dDay);
		Date dDayDate = time2.getTime();
		long dMiliTime = time2.getTimeInMillis();
		
		long tMday = miliTime/(1000*60*60*24);
		long dMday = dMiliTime/(1000*60*60*24);
		long diffDay = Math.abs(tMday-dMday);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String today = sdf.format(todayDate);
		String ddDay = sdf.format(dDayDate);
		System.out.println("오늘 날짜 : " +today);
		System.out.println("D-Day 날짜 : "+ ddDay);
		
		if( tMday == dMday) {
			System.out.println("오늘은 D-Day 입니다.");
		}else if ( tMday > dMday) {
			System.out.printf("D day로 부터 %d일 남았습니다.\n",diffDay);
		}else if ( tMday < dMday) {
			System.out.printf("D day로 부터 %d일 지났습니다.\n",diffDay);
		}
		
//		System.out.printf("오늘 날짜 : %d년 %d월 %d일\n", thisYear, thisMonth, thisDate);
//		System.out.printf("D-day 날짜 : %d년 %d월 %d일", dYear, dMonth, dDay);
	}
}

package kh.java.func;

import java.util.Scanner;

public class ArrayTest {
	public void test1() {
		//1,2,3,4,5 라는 5개 데이터를 각각 저장하고 출력
		//1) 변수를 이용한 처리 -> 데이터가 5개면 변수도 5개
		int num0 = 1;
		int num1 = 2;
		int num2 = 3;
		int num3 = 4;
		int num4 = 5;
		System.out.println("변수를 이용한 값 출력");
		System.out.println(num0);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		//2) 배열을 이용한 처리
		//배열 -> 동일한 자료형 여러개를 하나로 묶어서 인덱스로 관리
		// 정수 5개를 저장할 배열
		//배열 생성 방법 -> 자료형[] 변수이름 = new 자료형[길이];
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		System.out.println("배열를 이용한 값 출력");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		//for문을 이용한 출력
		System.out.println("for문을 이용한 출력");
		for(int i=0;i<5;i++) {
			System.out.println(arr[i]);
		}
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		//길이가 5인 정수형 배열을 선언해서 순선대로 1,2,3,4,5를 저장한 후 출력
		
		//1) 길이가 5인 정수형 배열 선언
		int[] arr1;			//정수형 배열의 주소를 저장할 변수 선언(참조형)
		arr1 = new int[5];//배열에 길이를 지정하는 행위  ->
		//배열은 할당하면 기본값으로 데이터가 초기화 되어 있음
		//기본값 : 정수(0), 실수(0,0), 문자(' '), 논리형(false), 참조형(null ->주소값이 비어있어)
		for(int i=0;i<5;i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		//for문을 이용한 대입
		for(int i=0;i<5;i++) {
			arr1[i] = (i+1);
		}
		/*
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		arr1[3] = 4;
		arr1[4] = 5;
		*/
		System.out.println("---------------------------");
		for(int i=0;i<5;i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		System.out.println("---------------------------");
		//길이가 5인 정수형배열을 선언해서 순서대로 데이터를 대입
		int[] arr2 = {1,2,3,4,5};
		for(int i=0;i<5;i++) {
			System.out.println(i + " : " + arr1[i]);
		}
		System.out.println("---------------------------");
		//길이가 3인 문자열 배열을 만들어서 "hello", "hi", "bye"를 대입 후 출력
		String[] arr3 = new String[3];
		for(int i=0; i<3; i++) {
			System.out.println(i + " : " + arr3[i]);
		}
		System.out.println("----------------------------");
		arr3[0] = "hello";
		arr3[1] = "hi";
		arr3[2] = "bye";	
		for(int i=0; i<3; i++) {
			System.out.println(i + " : " + arr3[i]);
		}
		System.out.println("---------------------------");
		String[] arr4 = {"hello","hi","bye"};
		for(int i=0;i<3;i++) {
			System.out.println(i + " : " + arr4[i]);
		}
	}
	
	public void exam1() {
		String[] arr1 = new String[5];
		arr1[0] = "딸기";
		arr1[1] = "복숭아";
		arr1[2] = "키위";
		arr1[3] = "사과";
		arr1[4] = "바나나";
		System.out.println(arr1[4]);
		System.out.println("--------------------");
		
		System.out.println("for문을 쓰지않고 전체 출력");
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println(arr1[3]);
		System.out.println(arr1[4]);
		System.out.println("---------------------");
		
		System.out.println("for문을 이용하여 전체 출력");
		String[] arr2 = {"딸기","복숭아","키위","사과","바나나"};
		for(int i = 0; i<5; i++) {
			System.out.println(arr2[i]);
		}
	}
	public void exam2() {
		int[] arr1 = new int[100];
		System.out.println("값을 순서대로 배열 인덱스에 넣고 출력");
		for(int i = 0; i<100; i++) {
			arr1[i] = (i+1);
			System.out.println(arr1[i]);
		}
	}
	public void exam3() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		String[] subject = {"국어", "영어", "수학"};
		for(int i =0; i<3; i++) {
			System.out.print(subject[i]+"점수 입력 : ");
			arr[i] = sc.nextInt();
			arr[3] += arr[i];
		}
//		System.out.print(subject[0]+"점수 입력 : ");
//		arr[0] = sc.nextInt();
//		System.out.print(subject[1]+"점수 입력 : ");
//		arr[1] = sc.nextInt();
//		System.out.print(subject[2]+"점수 입력 : ");
//		arr[2] = sc.nextInt();
		arr[3] = arr[0] + arr[1] + arr[2];
		
		System.out.println("국어 점수 : "+arr[0]);
		System.out.println("영어 점수 : "+arr[1]);
		System.out.println("수학 점수 : "+arr[2]);
		System.out.println("합계 : "+arr[3]);
		System.out.printf("평균 : %.2f",(double)arr[3]/3);
	}
	public void motel() {
		Scanner sc = new Scanner(System.in);
		//방을 관리할 배열 -> 방은 총 10개 -> 길이가 10인 배열 생성
		//난이도 하 : 정수 -> 0이면 빈방, 1이면 손님이 있는 방
		//난이도 상 : 논리형 -> false 빈방, true 손님이 있는방
		int[] rooms = new int [10];//배열을 할당하면 기본값으로 세팅(정수 -> 0 -> 모두 빈방인상태로 세팅)
		boolean power = true;
		while(power) {
			System.out.println("\n---------- 모텔 관리 프로그램 -------------\n");
			System.out.println("1. 입실");
			System.out.println("2. 퇴실");
			System.out.println("3. 방보기");
			System.out.println("4. 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			int roomNum = 0;
			switch(select) {
			case 1:
				//구현순서 2
				System.out.print("몇번방에 입실하시겠습니까?  ");
				int count = 0;
				//rooms[i] = sc.nextInt();
				for(int i = 0; i<10; i++) {
					if(rooms[i] != 0 ) {
						System.out.println(rooms[i]+1+"번방에 입실했습니다.");
						break;
					}
					count = rooms[i];
				}
				roomNum = count; 
				break;
			case 2:
				//구현순서 3
				break;
			case 3:
				//구현순서 1
				for(int i = 0; i<10; i++) {
					if(rooms[i] == roomNum) {
						System.out.println((i+1)+"번방에는 손님이 있습니다.");
					}else {
						System.out.println((i+1)+"번방은 빈방입니다.");
					}
				}
				
				break;
			case 4:
				power = false;
				break;
			}
		}
	}
	
	public void motel2() { //gpt 답안
	    Scanner sc = new Scanner(System.in);
	    int[] rooms = new int[10]; // 0: 빈방, 1: 손님 있음
	    boolean power = true;

	    while (power) {
	        System.out.println("\n---------- 모텔 관리 프로그램 -------------\n");
	        System.out.println("1. 입실");
	        System.out.println("2. 퇴실");
	        System.out.println("3. 방보기");
	        System.out.println("4. 종료");
	        System.out.print("선택 >> ");
	        int select = sc.nextInt();

	        switch (select) {
	            case 1:
	                System.out.print("몇번방에 입실하시겠습니까? (1~10) >> ");
	                int checkIn = sc.nextInt();
	                if (checkIn < 1 || checkIn > 10) {
	                    System.out.println("잘못된 방 번호입니다.");
	                } else if (rooms[checkIn - 1] == 1) {
	                    System.out.println(checkIn + "번방은 이미 손님이 있습니다.");
	                } else {
	                    rooms[checkIn - 1] = 1;
	                    System.out.println(checkIn + "번방에 입실했습니다.");
	                }
	                break;

	            case 2:
	                System.out.print("몇번방에서 퇴실하시겠습니까? (1~10) >> ");
	                int checkOut = sc.nextInt();
	                if (checkOut < 1 || checkOut > 10) {
	                    System.out.println("잘못된 방 번호입니다.");
	                } else if (rooms[checkOut - 1] == 0) {
	                    System.out.println(checkOut + "번방은 이미 빈방입니다.");
	                } else {
	                    rooms[checkOut - 1] = 0;
	                    System.out.println(checkOut + "번방에서 퇴실했습니다.");
	                }
	                break;

	            case 3:
	                for (int i = 0; i < 10; i++) {
	                    if (rooms[i] == 1) {
	                        System.out.println((i + 1) + "번방에는 손님이 있습니다.");
	                    } else {
	                        System.out.println((i + 1) + "번방은 빈방입니다.");
	                    }
	                }
	                break;

	            case 4:
	                power = false;
	                System.out.println("프로그램을 종료합니다.");
	                break;

	            default:
	                System.out.println("잘못된 선택입니다.");
	        }
	    }

	    sc.close(); // 스캐너 종료
	}
	
	public void exam4() {
		Scanner sc = new Scanner(System.in);
		//int[] arr = {5,4,2,1,3};
		
		int[] arr = new int[7];
		//배열명.length -> 현재 배열의 길이를 정수형태로 가져옴
		for(int i=0;i<arr.length;i++) {
		System.out.print((i+1)+"번째 숫자 입력 : ");
		arr[i] = sc.nextInt();
		}
		
		//배열 0번 인덱스에 있는 수와, 배열 1번 인데스에 있는 수를 비교해서 0번 인덱스의 수가 더 크면 자리를 바꾸는 코드
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		/*
		for(int i=0;i<3;i++) {
			if(arr[i] > arr[i+1]) {
				int tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}	
		}
		for(int i=0;i<2;i++) {
			if(arr[i] > arr[i+1]) {
				int tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}	
		}
		for(int i=0;i<1;i++) {
			if(arr[i] > arr[i+1]) {
				int tmp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = tmp;
			}	
		}
		*/
		/*
		if(arr[0] > arr[1]) {
			int tmp = arr[0];
			arr[0] = arr[1];
			arr[1] = tmp;
		}
		if(arr[1] > arr[2]) {
			int tmp = arr[1];
			arr[1] = arr[2];
			arr[2] = tmp;
		}
		if(arr[2] > arr[3]) {
			int tmp = arr[2];
			arr[2] = arr[3];
			arr[3] = tmp;
		}
		if(arr[3] > arr[4]) {
			int tmp = arr[3];
			arr[3] = arr[4];
			arr[4] = tmp;
		}
		*/
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
	}
}












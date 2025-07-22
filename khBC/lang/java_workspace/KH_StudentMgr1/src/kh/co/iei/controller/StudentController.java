package kh.co.iei.controller;

import java.util.Scanner;

public class StudentController {
	// 학생 최대 10명 정보를 관리하는 프로그램
		// 각 학생은 이름(String), 나이(int), 주소(String) 정보를 가지고 있음.
		// 단, 동명이인은 없음
		// 각 정보를 10개씩 관리할 배열 생성

		String[] names;
		int[] ages; // 정수 '배열' 이라 slot 엔 0, int[] 에는 null.
		String[] addrs;
		// 키보드 입력받을 스캐너
		Scanner sc;
		// 1) 학생 정보를 새로 입력받으면 배열에 몇번째에 넣을지 기억하고 있는 변수
		// 2) 현재 저장된 학생 수
		int index;
		
		//기본 생성자를 만들어서 전역변수에 초기값을 세팅.
		public StudentController() {
			sc = new Scanner(System.in);
			names = new String[10];
			ages = new int[10];
			addrs = new String[10];
			index = 0;
		}
		
		

		// 메인 메뉴를 진행하는 메소드
		public void main() {
			while (true) {
				System.out.println("\n----------- 학생 관리 프로그램v1 -----------\n");
				System.out.println("1. 학생 정보 등록 ");
				System.out.println("2. 학생 정보 출력 (전체 학생정보 출력) ");
				System.out.println("3. 학생 정보 출력 (이름을 입력받아서 일치하는 1명)");
				System.out.println("4. 학생 정보 수정 (이름을 입력받아서 일치하는 1명)");
				System.out.println("5. 학생 정보 삭제 (이름을 입력받아서 일치하는 1명)");
				System.out.println("0. 프로그램 종료");
				System.out.print("선 택 > > > >   ");
				int select = sc.nextInt();

				switch (select) {
				case 1 -> {
					insertStudent();
				}
				case 2 -> {
					printAllStudent();
				}
				case 3 -> {
					printOneStudent();
				}
				case 4 -> {
					updateStudent();
				}
				case 5 -> {
					deleteStudent();
				}
				case 0 -> {
					System.out.println("시스템을 종료합니다.");
					return;
				}
				default -> {
					System.out.println("잘못 입력하셨습니다.");
				}
				
				}//switch, select.
				
			}//while.
		}//method, main.
		
		//학생정보를 입력받아서 배열에 저장하는 메소드
		public void insertStudent() {
			System.out.println("\n---------- 학생 정보 입력 ----------\n");
			//등록할 학생 정보를 입력 받음
			System.out.print("등록할 학생 이름 입력 : ");
			String name = sc.next();
			System.out.print("등록할 학생 나이 입력 : ");
			int age = sc.nextInt();
			System.out.print("등록할 학생 주소 입력 : ");
			sc.nextLine();
			String addr = sc.nextLine();
			//입력받은 정보를 각 배열에 저장
			names[index] = name;
			ages[index] = age;
			addrs[index] = addr;
			System.out.println("정보 등록 완료 !");
			//학생 1명 정보를 배열에 모두 저장하고나면 인덱스는 다음위치를 기록하기 위해서 +1
			index++;
		}//method,insertStudent.

		//현재 저장되어 있는 모든 학생 정보 출력 메소드
		public void printAllStudent() {
			System.out.println("\n------------ 전체 학생 정보 출력 ------------\n");
			System.out.println("이름\t나이\t주소");
			System.out.println("-----------------------------------------");
			for (int i=0; i<index; i++) {
				System.out.println(names[i]+"\t"+ages[i]+"\t"+addrs[i]);
			}//for, print.
					
		}//method, printAllStudent.
		
		//학생 이름을 입력받아서 해당 이름과 일치하는 학생 정보를 출력하는 메소드
		public void printOneStudent() {
			System.out.println("\n------------  학생 정보 출력 (1명) ------------\n");
			System.out.print("조회할 학생 이름 입력 : ");
			String name = sc.next();
			
			//입력받은 이름은 names 배열에서 조회 -> 배열에 몇번째 있는지 조회 -> 몇번째인지 알아야 나이, 주소도 찾을 수 있으므로.
			int searchIndex = -1;//조회가 안됐을 때의 값으로 처음 초기화
			
			for(int i=0; i<names.length; i++) {
			if (names[i].equals(name)) { //문자열은 같은지 비교할 때 비교연산자를 사용하지 않고 equals메소드로 비교함.
				searchIndex = i;
				break;// 동면이인이 없으므로 같은 이름을 찾으면 이름을 검사하는 반복문 종료.
			}
			}//for, search. 
			
			if (searchIndex==-1) {
				System.out.println("학생 정보를 조회할 수 없습니다.");
			}else {
				System.out.println("이름 : "+names[searchIndex]);
				System.out.println("나이 : "+ages[searchIndex]);
				System.out.println("주소 : "+addrs[searchIndex]);
				
			}
		}//method, printOneStudent.

		//이름을 입력받아서 해당 학생이 있으면 나이와 주소를 추가로 입력받아서 정보를 수정하는 메소드
		public void updateStudent() {
			System.out.println("\n------------  학생 정보 수정 (1명) ------------\n");
			System.out.print("수정할 학생 이름 입력 : ");
			String name = sc.next();
			int searchIndex = searchStudent(name);
			if(searchIndex == -1) {
				System.out.println("학생 정보를 찾을 수 없습니다.");
			}else {
				System.out.print("수정할 나이 입력 : ");
				int age = sc.nextInt();
				System.out.print("수정할 주소 입력 : ");
				sc.nextLine();
				String addr = sc.nextLine();
				ages[searchIndex] = age;
				addrs[searchIndex] = addr;
				
				System.out.println("정보 수정 완료 ! !");
			}
			
		}//method,updateStudent().
		
		//학생 이름을 names 배열에서 조회하여 몇번쨰 있는지 리턴하는 메소드
		//단, 학생이름이 names 배열에 존재하지 않으면 -1 을 리턴
		public int searchStudent(String name) {
			int searchIndex = -1;
			for (int i=0;i<index;i++) {
				if(name.equals(names[i])) {
					searchIndex =i;
					break;
				}
			}
			return searchIndex;
		}//method, searchStudent.
		
		//학생 이름을 입력 받아 존재하면 해당 학생 정보를 삭제
		public void deleteStudent() {
			System.out.println("\n------------  학생 정보 삭제 (1명) ------------\n");
			System.out.print("삭제할 학생 이름 입력 : ");
			String name = sc.next();
			int searchIndex = searchStudent(name);
			if(searchIndex == -1) {
				System.out.println("학생 정보를 조회할 수 없습니다.");
			}else {
				//데이터를 삭제하면 한 칸씩 땡겨오는 작업 *** POINT
				for(int i=1; i<index-1; i++) {
				 names[i] = names[i+1];
				ages[i] = ages[i+1];
				addrs[i] = addrs[i+1];
				}//for, sort.
				index--;
				names[index] = null;
				ages[index] = 0;
				addrs[index] = null;
				
				System.out.println("정보 삭제 완료 ! !");
				
			}
		}//method, deleteStudent.
} //class, StudentController.

	

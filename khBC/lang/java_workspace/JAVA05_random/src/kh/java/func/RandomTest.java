package kh.java.func;

import java.util.Random;
import java.util.Scanner;


public class RandomTest {
	public void test1() {
		//Random : 무작위
		//자바에서 무작위데이터를 기능을 제공하는 클래스 : Random
		//1. import java.util.Random;
		//2. Random r == new Random();
		Random r = new Random();
		int num1 = r.nextInt();//int범위 내에서 무작위 숫자 1개를 가져옴
		System.out.println(num1);
		//r.nextInt()를 사용하면 정수 전체범위에서 무작위로 1개
		//약 -21억 ~ 21억 사이의 무작위 수를 받음
		//->경우의 수가 너무 많아서 활용이 어려움 -> 경우의 수를 조절가능
		//r.nextInt(정수) : 해당 숫자 갯수만큼 범위에서 랜덤수 1개를 가져옴
		//범위숫자의 기준은 0부터 숫자 갯수
		int num2 = r.nextInt(5);
		System.out.println(num2);
		
		int num3 = r.nextInt(13);//0~12
		System.out.println(num3);
		
		//0~26사이의 랜덤수를 추출해서 num4에 저장한 후 출력
		int num4 = r.nextInt(27);
		System.out.println(num4);
		
		//1~10사이의 랜덤수를 추출해서 num5에 ㅊ저정한 후 출력
		int num5 = r.nextInt(10) + 1;
		//범위설정하는방법
		//r.nxetInt(숫자1)+숫자2
		//숫자1 : 랜덤 경우의 수
		//숫자2 ; 랜덤 시작 숫자
		
		//10~30 사이의 랜덤수를 추출해서 num6에 저장한 후 출력
		int num6 = r.nextInt(21) + 10;
		System.out.println(num6);
		
		//알파벳 소문자 중 랜덤한 문자 1개를 저장해서 출력
		char ch = (char)(r.nextInt(26) + 97);
		System.out.println(ch);
		
		
//		double num2 = r.nextDouble();//실수(0.0~1.0) 무작위 숫자 1개를 가져옴
//		System.out.println(num2);
	}
	public void coin() {
		//동전 앞/뒤 맞추기 게임
		//컴퓨터가 동전을 던져서 앞/뒤 중 하나의 값을 갖고있음 -> 사용자가 그걸 맞추는 게임
		Random r = new Random();//	컴퓨터의 앞/뒤를 랜덤으로 결정하기 위해서 사용
		Scanner sc = new Scanner(System.in);	//사용의 선택을 입력받기 위해 사용
		
		boolean power = true;
		int win = 0;
		int lose = 0;
		while(power) {
			System.out.println("============ 동전 앞/뒤 맞추기 ===========");
			System.out.println("1. 게임 시작");
			System.out.println("2. 전적 보기");
			System.out.println("0. 게임 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				//컴퓨터가 동전을 던진다 -> 앞/뒤 중에 1개의 값을 가지면 됨 -> 경우의 수 2개
				//-> 앞면이면 1 / 뒷면이면 2 -> 필요한 랜덤수는 1~2
				int coin = r.nextInt(2) + 1;
				
				System.out.print("골라봐 임마(1.앞면 / 2.뒷면) : ");
				int userSelect = sc.nextInt();
				System.out.println("정답 : "+(coin==1?"앞":"뒤"));
				/*
				if(coin == 1) {
					System.out.println("정답 : 앞");
				}else {
					System.out.println("정답 : 뒤");
				}
				*/
//				System.out.println("정답 : "+coin);
				
				if(coin == userSelect) {
					win++;
					System.out.println("정답입니다!!");
				} else {
					lose++;
					System.out.println("ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ");
				}
				break;
			case 2:
				System.out.println("WIN : "+win);
				System.out.println("Lose : "+lose);
				break;
			case 0:
				power = false;//반복문을 멈추기위한 변수 데이터 변경
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}//switch
		}//while
	}//coin()
	
	public void exam1() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		boolean power = true;
		int win = 0;
		int lose = 0;
		int draw= 0;
		while(power) {
			System.out.println("=======가위 바위 보 게임========");
			System.out.println("1. 게임시작");
			System.out.println("2. 전적확인");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int select = sc.nextInt();
			switch (select) {
			case 1 :
				System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보) : ");
				int user = sc.nextInt();
				int com = r.nextInt(3) + 1;//1,2,3중 하나의 임의의값
				System.out.println("=========결과========");
				
				
				if(1 == user) {
					System.out.println("당신은 가위를 냈습니다.");
				} else if (2 == user) {
					System.out.println("당신은 바위를 냈습니다.");
				} else if (3 == user) {
					System.out.println("당신은 보를 냈습니다.");
				} 
					
				if(1 == com) {
					System.out.println("컴퓨터는 가위를 냈습니다.");
				} else if (2 == com) {
					System.out.println("컴퓨터는 바위를 냈습니다.");
				} else if (3 == com) {
					System.out.println("컴퓨터는 보를 냈습니다.");
				} 
				System.out.println("==========================");
				
				//가위바위보 이기는경우(user입장) : 사 : 가 / 컴 : 보,    사:바 / 컴:가,     사:보 / 컴:바
				//->						user==1 && com==3    user==2 com==1,  user==3 && com==2
				
				if((user==1 && com==3) ||  (user==2 && com==1) || (user==3 && com==2)) {
					win++;
					System.out.println("당신이 이겼습니다.");
				}else if(user== com) {
					draw++;
					System.out.println("비겼습니다.");
				}else {
					lose++;
					System.out.println("당신이 졌습니다.");
				}
				break;
			case 2 :
				System.out.println("win : "+win);
				System.out.println("lose : "+lose);
				System.out.println("draw : "+draw);
				break;
			case 0 :
				power = false;
				break;
			default  :
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
	
	public void exam2() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		int score = 0;			//기록보관용 변수
		while(power) {
			System.out.println("====UP & Down Game====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("0. End Game");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				int count = 1;//도전 회차를 처리하기위한 변수
				int com = r.nextInt(100) + 1;
				while(true){
					System.out.print(count+"회차 번호 입력 : ");
					int user = sc.nextInt();
					//사용자가 입력한 값이 1~100사이인지 체크해서 처리
					if(1>user || user>100) {
						System.out.println("입력범위가 잘못되었습니다.");
						continue;
					}
					
					if(user<com) {
						System.out.println("<<UP>>");
					} else if (user>com) {
						System.out.println("<<DOWN>>");					
					} else if (user==com) {
						if(score > count || score == 0) {
							score = count;
						}
						System.out.println("<<정답>>");
						break; //정답인경우 게임을 반복하는 while을 종료
					}
					count++;
					
					/*
					if(1<=user && user<=100) {
						if(user<com) {
							count++;
							System.out.println("<<UP>>");
						} else if (user>com) {
							count++;
							System.out.println("<<DOWN>>");					
						} else if (user==com) {
							count++;
							minCount = count;
							System.out.println("<<정답>>");
							break; //정답인경우 게임을 반복하는 while을 종료
						}
						count++;
					}else {
						System.out.println("입력범위가 잘못되었습니다.");
					}
					*/
				}//게임 반복용 while
				break;
			case 2:
				if(score == 0) {
					System.out.println("기록이 없습니다.");
				}else {
					System.out.println("현재 최고 기록은 "+score+"회 입니다.");
				}
				break;
			case 0:
				power = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}
	public void exam3() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		int win = 0;
		int lose = 0;
		while(power) {
			System.out.println("==== Baskin Robins31 Game ====");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("0. End Game");
			System.out.print("선택 > ");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				//턴게임 -> 사용자와 컴퓨터가 1~3사이 숫자를 외쳐서 숫자가 1씩 커지는 게임
				// -> 이때 31을 외치는 쪽이 패배
				System.out.println("<< Game Start >>");
				int num = 0;			//숫자를 누적하기 위해서 사용 -> 화면에 출력할 숫자
				while(true) {
					System.out.println("<< Your Turn >> ");
					System.out.print("Input Number : ");
					int userNum = sc.nextInt();
					if(1>userNum || userNum>3) {
						System.out.println("입력범위가 잘못되었습니다.");
						continue;
					}
					for(int i=0;i<userNum;i++) {
						num++;
						System.out.println(num+"!");
						if(num == 31) {
							lose++;
							System.out.println("패배!");
							break;
						}
					}
					if(num == 31) {
						break;
					}
					System.out.println("<< Computer Turn >>");
					int comNum = r.nextInt(3)+1;
					for(int i=0;i<comNum;i++) {
						num++;
						System.out.println(num+"!");
						if(num == 31) {
							win++;
							System.out.println("승리!");
							break; //출력용 for를 종료
						}
					}
					if(num == 31) {
						break; //게임을 종료
					}
//				if(userNum == 1) {
//					for(int i=0;i<1;i++) {
//						System.out.println((i+1)+"!");
//					}
//				}else if(userNum == 2) {
//					for(int i=0;i<2;i++) {
//						System.out.println((i+1)+"!");
//					}
//				}else if(userNum == 3) {
//					for(int i=0;i<3;i++) {
//						System.out.println((i+1)+"!");
//					}
//				}
				}
				break;
			case 2:
				System.out.println("Win : "+win);
				System.out.println("LOSE : "+lose);
				break;
			case 3:
				power = false;
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}//메뉴 while
	}//br31() 종료
}

















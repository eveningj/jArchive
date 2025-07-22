package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {

	public void test1() {
		// Random : 무작위
		// 자바에서 무작위데이터를 기능을 제공하는 클래스 : Random
		// 1.import java.util.Random;
		// 2.Random r = new Random();
		Random r = new Random();
		int num1 = r.nextInt();// int 범위 내에서 무작위 숫자 1개를 가져옴
		System.out.println(num1);
//		double num2 = r.nextDouble();//실수(0.0~1.0) 중 무작위 숫자 1개를 가져옴
//		System.out.println(num2);

//		r.nextInt()를 사용하면 정수 전체 범위에서 무작위로 1개
//		약 -21억 ~ 21억 사이의 무작위 수를 받음.
//		-> 경우의 수가 너무 많아서 활용이 어려움 -> 경우의 수를 조절 가능
//		r.nextInt(정수) : 해당 숫자 갯수만큼 범위엥서 랜덤 수를 1개를 가져옴
//		범위 숫자의 기준은 0부터 ~ 숫자 갯수

		int num2 = r.nextInt(5);
		System.out.println(num2);

		int num3 = r.nextInt(13); // 0~12
		System.out.println(num3);

		// 0~26사이의 ㅇ랜덤수를 추출해서 num4에 저장한 후 출력

		int num4 = r.nextInt(27);
		System.out.println(num4);

//		1~10 사이의 랜덤 수를 추출해서 num5 에 저장한 후 출력
//		범위 설정하는 방법
//		r.nextInt(숫자1)+숫자2
		// 숫자 1: 랜덤 경우의 수
		// 숫자 2: 랜덤 시작 숫자
//		int num5 = r.nextInt(10) +1;

//		10~30 사이의 랜덤 수를 추출하여 num6에 저장한 후 출력
		int num6 = r.nextInt(21) + 10;
		System.out.println(num6);

		// 알파벳 소문자 중 랜덤한 문자 1개를 저장해서 출력
		char ch = (char) (r.nextInt(26) + 97);
		System.out.println(ch);
	}

	public void coin() {
//		동전 앞/뒤 맞추기 게임
//		컴퓨터가 동전을 던져서 앞/뒤 중 하나의 값을 갖고있음 -> 사용자가 그걸 맞추는 게임
		Random r = new Random();// 컴퓨터의 앞/뒤를 랜덤으로 결정하기 위해서 사용
		Scanner sc = new Scanner(System.in); // 사용자의 선택을 입력받음.

		boolean power = true;
		while (power) {
			System.out.println("============== 동전 앞/뒤 맞추기 ==============");
			System.out.println(("1. 게임 시작"));
			System.out.println(("2. 전적 보기"));
			System.out.println(("0. 게임 종료"));
			System.out.print(("선택 >> "));

			int select = sc.nextInt();
			int win = 0;
			int lose = 0;

			switch (select) {
			case 1:// 컴퓨터가 동전을 던진다 -> 앞/뒤 중에 1개의 값을 가지면 됨 -> 경우의 수 2개
//			-> 앞면이면 1 / 뒷면이면 2 -> 필요한 랜덤수는 1~2

				int coin = r.nextInt(2) + 1;
				System.out.println("골라봐 (1.앞면 / 2. 뒷면 ) : ");
				int userSelect = sc.nextInt();
				System.out.println("정답 : " + (coin == 1 ? "앞" : "뒤"));
				/*
				 * if(coin==1) { System.out.println("정답 : 앞"); } else {
				 * System.out.println("정답 : 뒤"); }
				 */
				System.out.print("정답 : " + coin);
				if (coin == userSelect) {
					win++;
					System.out.println("\n정답입니다!");
				} else {
					lose++;
					System.out.println("ㅋㅋㅋㅋㅋㅋ");
				}
			case 2:
				System.out.println("WIN :" + win);
				System.out.println("LOSE :" + lose);
				break;
			case 0:
				System.out.println("게임을 종료하겠습니다.");
				power = false; // 반복문을 멈추기위한 변수 데이터 변경
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}// switch
		} // while
	}// coin

	public void rsp() {

		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean power = true;
		int win = 0;
		int lose = 0;
		int draw = 0;

		while (power) {
			System.out.println("========== 가위바위보 게임 ==========");
			System.out.println("1.게임시작");
			System.out.println("2.전적확인");
			System.out.println("0.프로그램 종료");
			System.out.print("선택 >> ");

			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("숫자를 선택하세요 (1. 가위/2. 바위/3. 보)"); // 게임시작

				int userSelect = sc.nextInt();
				int cSelect = r.nextInt(3) + 1;

				int result = (3 + userSelect - cSelect) % 3;

				if (userSelect < 1 || userSelect > 3) {
					System.out.println("잘못 입력하였습니다. 1 , 2, 3 중 하나의 숫자를 입력해 주세요.");
				} else {
					switch (userSelect) {
					case 1:
						System.out.println("당신은 가위를 냈습니다.");
						break;
					case 2:
						System.out.println("당신은 바위를 냈습니다.");
						break;
					case 3:
						System.out.println("당신은 보를 냈습니다.");
						break;

					}
					switch (cSelect) {
					case 1:
						System.out.println("컴퓨터는 가위를 냈습니다.");
						break;
					case 2:
						System.out.println("컴퓨터는 바위를 냈습니다.");
						break;
					case 3:
						System.out.println("컴퓨터는 보를 냈습니다.");
						break;
					}

					// 가위바위보 이기는 경우 (user입장) - 사:가 / 컴:보, 사:바 / 컴:가, 사:보 / 컴:바
					// if ( (user==1&&com==3) || (user==2 && com++1) || (user==3 && com==2))

					if (result == 0) {
						System.out.println("비겼습니다.");
						draw++;
					} else if (result == 1) {
						System.out.println("당신이 이겼습니다.");
						win++;
					} else if (result == 2) {
						System.out.println("당신이 졌습니다.");
						lose++;
					}
				}
				break;

			case 2:
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				System.out.println("DRAW : " + draw);
				break;

			case 0:
				System.out.println("게임을 종료하겠습니다.");
				power = false;
				break;

			default:
				System.out.println("잘못 입력 하셨습니다."); // 유효성 검사

			}
		}
	}

	public void upAndDown() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		boolean power = true;
		int bestScore = 0; //회차 기록

		while (power) {
			System.out.println("========== Up & Down GAME ==========");
			System.out.println("1. Game Start !");
			System.out.println("2. Game Score");
			System.out.println("3. End Game");

			System.out.print("선택 > ");
			int menuSelect = sc.nextInt();
			
			switch (menuSelect) {
			case 1:
				System.out.println("<< GAME START >>");
				int correct = r.nextInt(51); //0~50 사이의 숫자, 사용할 정답 번호
				System.out.println("0부터 50까지의 정수를 입력하세요.");
				System.out.println("50회차 까지 도전하실 수 있습니다.");

				for (int i = 1; i <= 50; i++) {	//i 는 도전회차
					System.out.printf("%d회차 번호 입력 ! : ", i);
					int input = sc.nextInt();
					
					if(!(input>=0 && input<=50)) { //입력값 범위 유효성 검사
						System.out.println("입력범위가 잘못되었습니다.");
						System.out.println("회차 기회를 소모했습니다. 다음 회차로 넘어갑니다.");
						continue; }
					
					if (input < correct) {	//	사용자가 입력한 숫자가 정답보다 작은 경우
						System.out.println(">>>>UP<<<<");
					} else if (input > correct) { //	사용자가 입력한 숫자가 정답보다 큰 경우
						System.out.println(">>>>DOWN<<<<");
					} else if (input == correct) { //정답인 경우
						System.out.println("정답!!!!!!");
						if (bestScore > i || bestScore == 0) {
							bestScore = i;
						}
						break; //정답인 경우 게임을 반복하는 while 을 종료
					} else {
						System.out.println("잘못된 입력입니다. ");
						break;
						
					} // if 유효성 검사 end.
					} //게임 반복 while end.
					
			case 2:
				if (bestScore == 0) {
					System.out.println("아직 기록이 없습니다.");
				} else {
					System.out.println("현재 최고 기록은 " + bestScore + "회 입니다.");
				}
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				power = false;
				break;
			default :
				System.out.println("잘못된 입력입니다.");
				break;
			}//switch
		}//while
	}//method

	public void baskinRobiins() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int win = 0;
		int lose = 0;
		boolean power = true;

		while (power) {
			System.out.println("===== BASKIN ROBBINS31 =====");
			System.out.println("1. New GAME");
			System.out.println("2. GAME SCORE");
			System.out.println("3. End Game");
			System.out.print("선 택 > ");
			int menuSelect = sc.nextInt();

			switch (menuSelect) {
			
			case 1:
				//턴게임 -> 사용자와 컴퓨터가 1~3사이 숫자를 외쳐서 숫자가 1씩 커지는 게임
				// -> 이 때 31을 외친 쪽이 패배
				System.out.println("<<GAME START>>");
				int cInput = r.nextInt(3) + 1;
				int gameResult = 0;
				while (gameResult < 31) {
					System.out.println(">>YOUR TURN<<");
					System.out.print("Input Number : ");
					int input = sc.nextInt();

					if (input < 1 || input > 3) {
						System.out.println("1 ~ 3 사이의 숫자를 입력해 주세요.");
					} else {
						for (int i = 1; i <= input; i++) {
							gameResult += 1;
							System.out.println(gameResult + "!");
							if (gameResult >= 31) {
								System.out.println("패배하였습니다.....");
								lose++;
								break;
							} 
						}if (gameResult < 31) {
						System.out.println(">>COMPUTER TURN<<");
						for (int j = 1; j <= cInput; j++) {
							gameResult += 1;
							System.out.println(gameResult + "!");
							if (gameResult >= 31) {
								System.out.println("승리하였습니다 ! ! ! ! ");
								win++;
								break;
							}
							} // if
						} // if2
					} // while
				}
				break;

			case 2:
				System.out.println("<< 당신의 전적 >>");
				System.out.println("WIN : " + win);
				System.out.println("LOSE : " + lose);
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				power = false;
				break;
			default :
				System.out.println("잘못된 값을 입력하셨습니다.");
				break;
			}

		}
	}

	public void diceGame() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		boolean power = true;
		boolean again = true;
		int gold = 10000;
		int win = 0;
		int lose = 0;
		int draw = 0;

		while (power) {
		System.out.println("===== DICE GAME =====");
		System.out.println("1.NEW GAME");
		System.out.println("2.GAME SCORE");
		System.out.println("3.End Game");
		System.out.print("선택 > ");
		int select = sc.nextInt();

		switch (select) {
		case 1:
			int dice1 = r.nextInt(6) + 1;
			int dice2 = r.nextInt(6) + 1;
			int dice3 = r.nextInt(6) + 1;
			int cDice1 = r.nextInt(6) + 1;
			int cDice2 = r.nextInt(6) + 1;
			int cDice3 = r.nextInt(6) + 1;
			int userSum = dice1 + dice2 + dice3;
			int comSum = cDice1 + cDice2 + cDice3;
			System.out.println("<<Game Start>>");
			System.out.println("1번째 주사위 값 : " + dice1);
			System.out.println("2번째 주사위 값 : " + dice2);
			System.out.println("3번째 주사위 값 : " + dice3);
			System.out.println("내 주사위 총 합 : " + userSum);
			System.out.print("베팅 하시겠습니까? [y/n] : ");
			String bet = sc.next();
			switch (bet) {
			case "y":
				while (again) {
					System.out.printf("얼마를 베팅하시겠습니까? (현재 내 소지금 %d원) : ", gold);
					int betGold = sc.nextInt();
					System.out.println("컴퓨터 1번째 주사위 값 : " + cDice1);
					System.out.println("컴퓨터 2번째 주사위 값 : " + cDice2);
					System.out.println("컴퓨터 3번째 주사위 값 : " + cDice3);
					System.out.println("컴퓨터 주사위 총합 : " + comSum);
					if (userSum > comSum) {
						System.out.println("<< 결과 >>");
						System.out.println("승 리 !!!");
						gold += betGold;
						System.out.printf("소지금 %d원에서 %d원 증가하였습니다.", gold, betGold);
						win++;
						System.out.print("한번 더 하시겠습니까? [y/n]");
						String againInput = sc.next();
						switch (againInput) {
						case "y":
							break;
						case "n":
							System.out.println("메인 메뉴로 돌아갑니다.");
							again = false;
							break;
						default:
							System.out.println("잘못된 값을 입력하셨습니다.");
							break;
						}

					} else if (userSum < comSum) {
						System.out.println("<< 결과 >>");
						System.out.println("패 배 ...");
						gold -= betGold;
						System.out.printf("소지금 %d원에서 %d원 차감하였습니다.", gold, betGold);
						lose++;
						System.out.print("한번 더 하시겠습니까? [y/n]");
						String againInput = sc.next();
						switch (againInput) {
						case "y":
							break;
						case "n":
							System.out.println("메인 메뉴로 돌아갑니다.");
							again = false;
							break;
						default:
							System.out.println("잘못된 값을 입력하셨습니다.");
							break;
						} break;
					} else if (userSum == comSum) {
						System.out.println("<< 결과 >>");
						System.out.println("비겼습니다 ! ");
						draw++;
						System.out.print("한번 더 하시겠습니까? [y/n]");
						String againInput = sc.next();
						switch (againInput) {
						case "y":
							break;
						case "n":
							System.out.println("메인 메뉴로 돌아갑니다.");
							again = false;
							break;
						default:
							System.out.println("잘못된 값을 입력하셨습니다.");
							break;
						} break;
					}
				}

			case "n":
				System.out.println("메인 메뉴로 돌아갑니다.");
				break;
			default:
				System.out.println("잘못된 입력을 하셨씁니다. 메인 메뉴로 돌아갑니다.");
				break;
			} break; // bet end
		case 2:
			System.out.println("<<당신의 전적>>");
			System.out.println("WIN :" + win);
			System.out.println("LOSE :" + lose);
			System.out.println("DRAW :" + draw);
			System.out.println("내 소지금 :" + gold);
			break;
		case 3 : 
			System.out.println("게임을 종료하겠습니다.");
			power = false;
		default:
			System.out.println("잘못된 입력을 하셨습니다.");
			break;
		}
		}
	}
}
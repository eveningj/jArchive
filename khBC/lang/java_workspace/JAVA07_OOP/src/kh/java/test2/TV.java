package kh.java.test2;

import java.util.Scanner;

public class TV {
	/*
	 * TV 객체 속성 : 크기 / 전원 / 볼륨 / 채널 기능 : 전원 on,off / 채널 1 증가 / 채널 1 감소 / 볼륨 1 증가 /
	 * 볼륨 1 감소 / 숫자 입력해서 채널 변경 속성 -> 전역 변수로 생성 => eclipse 는 전역변수, 지역분수를 구분하기위해 색상이
	 * 다름.
	 * 
	 * 전역변수 -> 지역변수와 다르게 선언하면 기본값 세팅이 되어있음 ( 숫자 : 0, 문자 : ' ', 논리 : false, 참조형 :
	 * null)
	 * 
	 * 기능 -> 메소드로 생성
	 */
	int inch;
	int channel;
	int volume;
	boolean power;

	public void powerOnoff() {
		// 현재 전원 상태를 반전(켜져있으면 끄고, 꺼져있으면 키고)
		// true -> false / false -> true
		power = !power;
		if (power) {
			System.out.println("전운이 켜졌습니다.");
		} else {
			System.out.println("전원이 꺼졌습니다.");
		}

	}

	public void channelUp() {
		// 현재 채널 1 증가
		channel++;
		System.out.println("현재 채널은 " + channel + "입니다.");
	}

	public void channelDown() {
		// 현재 채널 1 감소
		channel--;
		System.out.println("현재 채널은 " + channel + "입니다.");
	}

	public void changeChannel() {
		// 숫자 입력 받아서 입력받은 숫자로 채널 변경
		Scanner sc = new Scanner(System.in);
		System.out.print("채널 번호 입력 : ");
		int input = sc.nextInt();
		channel = input;
		System.out.println("현재 채널 : " + channel);
	}

	public void volumeUp() {
		// 현재 볼륨을 1 증가
		volume++;
		System.out.println("현재 볼륨은 " + volume+ "입니다.");

	}

	public void volumeDown() {
		// 현재 볼륨을 1 감소
		volume--;
		System.out.println("현재 볼륨은 " + volume+ "입니다.");
	}

	public void tvStart() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("========= 내가 처음 만들어본 TV =========");
			sleep(1000); //1초
			System.out.println("1. 전원버튼");
			sleep(500); //1초
			System.out.println("2. 채널 올리기");
			sleep(500); //1초
			System.out.println("3. 채널 내리기");
			sleep(500); //1초
			System.out.println("4. 채널 입력");
			sleep(500); //1초
			System.out.println("5. 볼륨 올리기");
			sleep(500); //1초
			System.out.println("6. 볼륨 내리기");
			sleep(500); //1초
			System.out.println("0. TV 버리기");
			sleep(500); //1초
			System.out.print("선 택 > >  ");
			sleep(500); //1초
			int select = sc.nextInt();
			

			switch (select) {
			case 1: // 전원
				powerOnoff();
				break;
			case 2: // 채널 up
				if(power) {
					channelUp();
				}
				break;
			case 3: // 채널 down
				if(power) {
					channelDown();
				}
				break;
			case 4: // 채널 input
				if(power) {
					changeChannel();
				}
				break;
			case 5: // 볼륨 up
				if(power) {
					volumeUp();
				}
				break;
			case 6: // 볼륨 down
				if(power) {
					volumeDown();
				}
				break;
			case 0: // TV 버리기
				return; //데이터를 반환, 즉시 메소드 종료 -> tvStart 의 return type 은 void, 반환값 없음, 메소드 종료.

			default: // 유효성 검사
				System.out.println("잘못 입력하셨습니다.");
				break;

			}
		}
	}
		
		public void sleep(int time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

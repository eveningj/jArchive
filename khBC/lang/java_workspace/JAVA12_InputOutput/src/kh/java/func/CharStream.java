package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStream {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장할 파일명 입력 : ");
		String fileName = sc.nextLine();
		//0. 반환할 객체 미리 선언
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName); //1.파일 생성하고 스트림 연결
			System.out.println("종료는 exit");
			while(true) {
				System.out.println("내용입력 :");
				String str = sc.nextLine() + "\r\n";
				if (str.equals("exit\r\n")) {
					break;
				}
				//2. 출력 메소드 사용
				//문자스트림은 1문자 단위로 전송 -> 문자열을 매개변소로 주면 내부에서 알아서 처리
				fw.write(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				//3.자원 반환
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void subStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장할 파일명 입력 (보조스트림) : ");
		String fileName = sc.nextLine();
		
		//0. 반환할 객체 선언(보조스트림을 사용하면 자원 반환 시 보조스트림만 반환하면 자동으로 주 스트림 반환 완료
		BufferedWriter bw  = null;
		
		try {
			FileWriter fw = new FileWriter(fileName); // 1. 주 스트림 생성
			bw = new BufferedWriter(fw);
			System.out.println("종료는 exit");
			while(true) {
				System.out.println("내용 입력 : ");
				String str = sc.nextLine() ;
				if(str.equals("exit")) {
					break;
				}
				bw.write(str); //2. 출력메소드 사용 (보조스트림을 이용해 출력)
				bw.newLine(); //보조스트림에만 있는 개행처리 메소드
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void readerTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("로드할 파일명 입력 : ");
		String filename = sc.nextLine();
		
		//0. 데이터를 읽어올 보조스트림 선언
		BufferedReader br = null;
		try {
			//1. 파일 내용을 읽어올 주 스트림 생성
			// 이 때 해당 파일이 존재하지 않으면 바로 예외로 빠짐.
			FileReader fr = new FileReader(filename);
			//주 스트림 이용해 보조스트림 생성
			br = new BufferedReader (fr);
			
			//readLine() : 스트림이 연결된 파일에서 1줄을 문자열로 읽어옴
			//readLine() 이 호출될 때마다 한 줄 읽어오고 다음줄로 넘어감.
			//더 이상 읽어올 데이터가 없으면 null.
			while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

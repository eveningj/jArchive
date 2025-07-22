package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StreamTest {
	//quiz.txt 파일 내용을 읽어서 quiz.gif 로 내보내기
	public void test1() {
		//subStream 을 사용하는 버전
		//quiz.txt 파일을 읽어옴 -> InputStream 과 Reader 중 고려.
		
		//0. 파일에서 데이터를 읽어올 보조스트림
		BufferedReader br = null;
		
		//quiz.gif 로 내보냄
		//내보냄 -> OutputStream, Writer  -> 내보낼 데이터가 이미지 -> OutputStream 사용 
		//0. 파일 내보낼 보조스트림 생성
		BufferedOutputStream bos =  null;
		
		//
		try {
			//1. 파일 내용을 읽어오기 위한 주 스트림 생성
			FileReader fr = new FileReader("quiz.txt");
			//주 스트림을 이용해 보조 스트림을 생성
			br = new BufferedReader(fr);
			//quiz.txt 는 1줄짜리 긴 문자열 -> 1줄만 읽어오면 전체파일을 다 읽어옴
			System.out.println("파일 읽어오기 전");
			String str = br.readLine();
			System.out.println("파일 읽어오기 후");
			//읽어온 문자열 형태 -> 10진수 공백 반복
			//공백을 제거한 문자열을 byte타입의 형태로 처리
			//ArrayList<Byte> 타입으로 저장
			ArrayList<Byte> list = new ArrayList<Byte>();
			//문자열에서 공백 기준으로 잘라서 토큰 형태로 변환
			StringTokenizer sT = new StringTokenizer(str," ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken();
				int iNum = Integer.parseInt(num);
				byte bNum = (byte)iNum;
				list.add(bNum);
			}
			System.out.println(list.size()); 
			
			//파일 내보내기
			FileOutputStream fos = new FileOutputStream("quiz.gif");
			bos = new BufferedOutputStream(fos);
			for(byte b : list) {
				bos.write(b);
			}
			System.out.println("내보내기 끝");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//
	
	public void test2() {
		//subStream 을 사용하지 않는 버전
		//quiz.txt 읽어오기 위한 주 스트림 선언
		FileReader fr = null;
		//quiz.gif 로 내보내기 위한 주 스트림 선언
		FileOutputStream fos = null;
		
		try {
			fr = new FileReader("quiz.txt");
			StringBuilder sb = new StringBuilder();
			System.out.println("파일 읽어오기 시작");
			while(true) {
				//read() : 문자 1개를 읽어옴
				//read() 는 더이상 읽어올 문자가 없으면 -1을 리턴
				int data = fr.read();
				if(data == -1) {
					break;
				}
				char ch = (char)data;
				sb.append(ch);
			}
			System.out.println("파일 읽어오기 끝");
			ArrayList<Byte> list = new ArrayList<Byte>();
			StringTokenizer sT = new StringTokenizer(sb.toString(), " ");
			while(sT.hasMoreTokens()) {
				String num = sT.nextToken();
				int iNum = Integer.parseInt(num);
				byte bNum = (byte)iNum;
				list.add(bNum);
			}
			System.out.println(list.size());
			//내보내기 시작
			fos = new FileOutputStream("quiz1.gif");
			System.out.println("내보내기 시작");
			for (byte b : list) {
				fos.write(b);
			}
			System.out.println("내보내기 끝");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

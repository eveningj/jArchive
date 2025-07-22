package kh.java.func;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileTest {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명 입력 : ");
		String filename = sc.nextLine();
		//파일 객체
		// -> 파일과 스트림을 연결해서 데이터를 주고받는 객체가 아님.
		// -> 해당 파일에 대한 정보를 얻어옴 -> FileNotFoundException 을 처리하지 않아도 됨. 
		
		File file = new File(filename);
		//exist() : 해당 파일이 존재하면 true / 존재하지 않으면 false
		if (file.exists()) {
			System.out.println("파일 있음");
			System.out.println("파일 이름 : " + file.getName());
			System.out.println("파일 상대 경로 : " +file.getPath());
			System.out.println("파일 상대 경로 : " +file.getAbsolutePath());
			System.out.println("파일 상대 크기 : " +file.length() + "byte");
			System.out.println("해당 파일을 삭제하시겠습니가");
			int select = sc.nextInt();
			if (select == 1) {
				//파일을 삭제하고 삭제 결과를 리턴함. (지워졌으면 true/' 못지워졌으면 false)
				boolean result = 
				file.delete();
				
				System.out.println(result);
			}
		}else {
			System.out.println("파일 없음");
		}
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		String filename = null;
		while(true) {
		System.out.print("저장할 파일명 입력 : ");
		filename = sc.nextLine(); 
		File file = new File("test/"+filename);
		
		if(file.exists()) {
			System.out.println("이미 사용중인 파일 이름입니다.");
		}else {
			break;
		}
		}
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("test/" + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장할 파일명 입력 : ");
		String filename = sc.nextLine();
		//test.txt 를 입력했다고 가정하면
		//test	.txt 로 분리.
		//-> 숫자가 붙을 때 확장자는 유지하고 파일 이름만 변경해야하기 때문에.
		//.위치 찾기
		int dotIndex = filename.lastIndexOf(".");
		//문자열 시작부터 마지막 . 앞까지만 잘라내기
		
		String onlyFilename = filename.substring(0,dotIndex);
		System.out.println(onlyFilename);
		//문자열의 .위치부터 끝까지 복사하기 -> .txt
		String extension = filename.substring(dotIndex);
		System.out.println(extension);
		
		//파일명 중복을 처리하기 위한 변수
		String filepath = filename;
		//중복된 파일명이 있으면 뒤에 붙일 숫자 변수
		int count = 0;
		while(true) {
			if(count != 0) {
				filepath = onlyFilename + "_" +count+extension;
			}
			
			//설정한 파일 이름이 중복파일진지 체크
			File file = new File("test/"+filepath);
			if(file.exists()) {
				count++;	//파일 이름이 존재하면 다음 회차를 위해 count++;
			}else {
				break;	//파일 이름이 존재하지 않으면 파일명 사용하면 되니까 반복문 종료함.
			}
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream ("test/" +filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

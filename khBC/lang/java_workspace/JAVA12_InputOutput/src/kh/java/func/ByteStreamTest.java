package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamTest {
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장할 파일 이름 입력 : ");
		String fileName = sc.nextLine();
		//0. 자원반환을 위해서 벼누슬ㄹ 미리 선언(FileOutputStream 객체 생성코드는 try/catch가 필수)
		//-> try 구문 안에서 사용하면 finally 에서 자원 반환이 불가능하므로.
		FileOutputStream fos = null;
		//FileOutputStream객체를 생성하면서 문자열로 파일 이름을 전송하면 파일을 생성
		//객체를 생성하면 지정한 위치에 파일이 생성되고 해당 파일이랑 스트림으로 연결
		//파일 이름만 작성하면 현재 프로젝트 폴더에 파일이 생성됨
		//C드라이브부터 전체 경로를 주면 그 위치에 파일이 만들어짐
		
		try {
			fos  = new FileOutputStream(fileName); //1.스트림 생성
			System.out.println("종료는 exit을 입력하세요.");
			while (true) {
			System.out.println("내용 입력 : ");
			String msg = sc.nextLine()+"\r\r";
			if(msg.equals("exit\r\\n")) {
				break;
			}
			//FileOutStream은 ByteStream 으로 데이터를 내보낼 때 byte 단위로 내보나야함
			//-> 문자열은 byteStream 으로 내보내기에는 너무 큼 -> 문자열을 byte 단위로 쪼갬
			byte [] data = msg.getBytes(); // 이 메소드 -> byte 배열로 만듦.
			fos.write(data);	//2. 스트림을 통해 파일에 데이터 내보내기 (메소드를 통한 출력)
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

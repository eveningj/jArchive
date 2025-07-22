package kh.java.func;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public void server() {
		int port = 9090;

		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		BufferedInputStream bis = null; // 파일을 읽어오기 위한 보조 스트림

		try {
			server = new ServerSocket(port);
			System.out.println("파일 서버 준비 완료");
			System.out.println("클라이언트 접속 대기 . . .");

			Socket socket = server.accept(); // 연결지향

			System.out.println("클라이언트 접속 완료");
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);

			// 파일들이 들어있는 폴더를 파일 객체로 생성
			File dir = new File("files");

			// foler 내부의 파일을 모두 file 객체로 가져옴
			File[] files = dir.listFiles();
			/*
			 * 파일 갯수를 먼저 클라이언트에 전송 
			 * -> 파일 갯수만큼 파일 이름을 보낼 예정이므로 수신할 횟수를 전송
			 * 
			 * 
			 * String fileLength = String.valueOf(files.length); dos.writeUTF(fileLength);
			 */

			dos.writeInt(files.length);
			for (int i = 0; i < files.length; i++) {
				String filename = files[i].getName();
				// 파일들을 write 하기전에, 파일이 몇개인지 클라이언트에게 명시해줘야함.
				dos.writeUTF(filename);
			}
			
			//클라이언트가 다운로드 요청을 한 파일 이름을 받음
			//파일 이름 받고, 전송해줌.
			
			String filename = dis.readUTF();
			File sendFile = new File("files/"+filename);
			int fileSize = (int)sendFile.length(); // 파이르 크기를 저장
			
			byte[] fileContent = new byte[fileSize]; //파일을 메모리에 저장하기 위한 배열
			
			//전송할 파일을 읽어오기 위한 스트림 생성
			FileInputStream fis = new FileInputStream("files/"+filename);
			bis = new BufferedInputStream(fis);
			//확보된 메모리에 파일 정보를 읽어옴.
			bis.read(fileContent);
			
			//클라이언트에게 파일 크기  전송
			dos.writeInt(fileSize);
			//클라이언트에게 파일 전송
			dos.write(fileContent);
			dos.flush(); //버퍼에 남아있을 수 있는 데이터를 강제로 내보내기
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				server.close();
				dis.close();
				dos.close();
				bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

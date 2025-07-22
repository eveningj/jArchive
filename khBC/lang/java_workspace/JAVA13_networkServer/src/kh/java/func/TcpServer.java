package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
	public void testServer() {
		Scanner sc = new Scanner(System.in);
		// 1. 서버에서 사용할 포트번호를 지정
		// 사용 가능한 포트 번호 범위 : 0~ 65535 중 1개
		// 0~1023 사이의 포트 번호는 잘 알려진 포트번호로 일반적으로 사용하지 않음
		// -> Wellkown ports

		int port = 7777;

		// 반환할 객체 미리 선언
		// 서버 포트를 열고 접속을 기다리는 객체
		ServerSocket server = null;
		// 데이터 주고받을 때 사용할 subStream
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			// 2. 서버 소켓 객체 생성
			// 생성자로 전달한 포트 번호로 서비스를 제공할 객체 생성
			server = new ServerSocket(port);
			System.out.println("서버 준비 완료");
			System.out.println("클라이언트 접속 기다리는 중");
			// 3. server.accept() : 클라이언트 접속을 기다리는 코드
			// 4. 클라이언트가 접속 요청을 하면 수락해서 통신하기 위한 소켓 객체를 전달받음
			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");
			
			//5.데이터를 주고받기 위한 스트림 추출(소켓 내부에 양방향 스트림 이미 존재)
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			//6. subStream 으로 성능/기능 개선
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			
			//데이터 송/수신 준비 끝
			while(true) {
				if(socket.isClosed()) {
					System.out.println("소켓 닫혔당");
				}
			System.out.println("To.Client : ");
			String msg = sc.nextLine();
			//클라이언트로 문자열을 전송
			dos.writeUTF(msg);
			if(msg.equals("exit")) {
				break;
			}
			
			String msg2 = dis.readUTF();
			System.out.println("From.Client :"+msg2);
			if (msg2.equals("exit")) {
				System.out.println("상대가 갔어");
				break;
			}
			}
//			if (socket.isClosed()) {
//			System.out.println("서버 연결 끝나고 코드작성");}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
				System.out.println("스트림 닫힘");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

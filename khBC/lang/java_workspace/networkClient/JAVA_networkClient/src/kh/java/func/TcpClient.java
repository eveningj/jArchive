package kh.java.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class TcpClient {
	public void clientTest() {
		//1. 서버의 IP address 와 port 번호를 지정
		Scanner sc = new Scanner(System.in);

		
		//localhost, 127.0.0.1 -> 루프백 혹은 내 컴퓨터 호출
		String serverIP = "192.168.10.47"; //serverIP
		int serverPort = 7777;
		//Resource Return code
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			//2. 지정한 아이피주소와 포트번호로 소켓객체 생성
			//서버에 접속 요청을 보냄
			socket = new Socket(serverIP, serverPort);
			System.out.println("서버접속 완료!");
			//3. 데이터를 주고받기 위한 스트림 추출(소켓 내부에 야방향 스트림이 이미 존재)
			// 클라이언트에서 먼처 '요청 하기 위한 순서'
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			//4. subStream 으로 성능 개선
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			
			//데이터 송/수신 준비 끝
			//서버가 전송한 문자열을 수신
			while(true) {
				
			String msg = dis.readUTF();
			System.out.println("From server : "+ msg);
			if (msg.equals("exit")) {
				System.out.println("상대가 서버 닫았어");
				break;
			}
			System.out.println("To. Server : ");
			String msg2 = sc.nextLine();
			dos.writeUTF(msg2);
			if (msg2.equals("exit")) {
				break;
			}
			}
//			if (socket.isClosed()) {
//			System.out.println("서버 연결 끝나고 코드작성"); }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
				dos.close();
				dis.close();
				System.out.println("자원 반환 잘 되었음");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}

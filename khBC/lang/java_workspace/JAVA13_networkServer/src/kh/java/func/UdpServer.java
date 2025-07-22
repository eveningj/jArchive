package kh.java.func;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {
	//1. 서버에서 사용할 포트번호 지정
	//UDP 사용 가능 포트 번호 : 0~65535
	//-> PROTOCOL 마다 port 가 별도로 관리됨 -> 중복가능( TCP 6666 , UDP 6666)
	public void server() {
		int port =  8888;
		//자원 반환할 객체 선언
		DatagramSocket socket = null;
		
		try {
			//2. DatagramSocket 객체 생성 (UDP 서비스 준비 완료)
			socket = new DatagramSocket(port);
			System.out.println("서버 소켓 생성 완료");
			//client 가 보낼 메세지를 저장할 공간 생성
			byte[] inMsg = new byte[1024];
			DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			socket.receive(inPacket);; //클라이언트의 메세지를 받기 위해 기다리는 코드
			//client 가 보낸 메세지가 DatagramPacket 형태로 전송될 예정
			//client 가 보낸 msg를 패킷이 받아 생성자로 전달한 배열에 데이터를 집어넣어줌.
			
			//전달받은 데이터(byte[]) 를 문자열로 변환해서 사용
			String clientMsg = new String(inMsg).trim(); // trim() -> 사용하지 않는 공간 잘라냄.  
			System.out.println(clientMsg);
			
			
			
			//UDP는 연결하고 통신하는 구조가 아님
			//클라이언트가 전달해준 패킷에서 클라이언트의 아이피/포트를 추출
			
			InetAddress clientIp = inPacket.getAddress();
			int clientPort = inPacket.getPort();
			System.out.println("클라이언트 Port : "+clientPort);
			System.out.println("클라이언트 IP : "+clientIp);
			
			String msg = "난 UDP 서버야!";
			byte[] outMsg = msg.getBytes();
			DatagramPacket outPacket = new DatagramPacket(outMsg, outMsg.length, clientIp,
					clientPort);
			socket.send(outPacket);
			System.out.println("데이터 전송 완료");
			
		
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//내부 스트림 X
			socket.close();
		}
		
		
	}
}

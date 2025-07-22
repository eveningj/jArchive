package kh.java.func;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;



// 상대가 서버를 켰던 안켰던 중요하지않음
// -> 데이터 전송에 중점. oneside. client 에서 줌.
public class UdpClient {
	public void client() {
		//1. 서버 포트번호 지정
		int serverPort = 8888;
		
		
		//자원 반환할 객체 선언
		DatagramSocket socket = null;
		
		try {
			//DatagramSocket 은 송신용 포트를 자동으로 할당함.
			socket = new DatagramSocket();	//클라이언트는 포트를 열고 요청을 기다리는게 아니므로 포트 번호를 생성자에서 사용하지 않음
			//전송할 데이터
			String msg = "안녕 나는 UDP 클라이언트야";
			byte[] outMsg = msg.getBytes();
			//서버 아이피 주소를 문자열이 아닌 InetAddress 형태로 생성
			InetAddress serverIP = InetAddress.getByName("127.0.0.1");
			//패킷에 목적지 할당 해주어야함.
			DatagramPacket outPacket = new DatagramPacket(outMsg, outMsg.length, serverIP, serverPort);
			
			//서버로 데이터 전송
			socket.send(outPacket);
			
			byte[] inMsg = new byte[1024];
			DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
			socket.receive(inPacket);
			
			String serverMsg = new String(inMsg).trim();
			System.out.println(serverMsg);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//상대방이 연결이 안되었어서 try catch 를 잡을 필요가 없음.
			// 내부 스트림 X
			socket.close();
		}
		
	}
}
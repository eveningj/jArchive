package me.jw.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class DNSClient {
	public void accessSever() {
		Scanner sc = new Scanner(System.in);
		
		String serverIP = "192.168.10.47";
		int serverPort = 6779;
		
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		
		try {
			socket = new Socket(serverIP, serverPort);
			System.out.println("서버에 성공적으로 접속했습니다.");
			while(true) {
			System.out.print("알고싶은 도메인 주소 : ");
			String domainAddress = sc.nextLine();
			
			OutputStream out = socket.getOutputStream();
			InputStream in = socket.getInputStream();
			dos = new DataOutputStream(out);
			dis = new DataInputStream(in);
			
			dos.writeUTF(domainAddress);
			String IPAddress= dis.readUTF();
			System.out.println(IPAddress);
			System.out.println("서버의 응답을 기다리십시오.");
			if(!dis.readBoolean()) {
				System.out.println("서버를 종료하였습니다.");
				break;
			}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				socket.close();
				dos.close();
				dis.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

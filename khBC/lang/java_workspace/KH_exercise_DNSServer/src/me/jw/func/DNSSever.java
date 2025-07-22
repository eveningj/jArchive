package me.jw.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class DNSSever {
	public void severOpen() {
		Scanner sc = new Scanner(System.in);

		int port = 6779;

		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			server = new ServerSocket(port);
			System.out.println("DNS 서버 준비 완료");
			while (true) {
			System.out.println("클라이언트 요청 대기");
			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);

				String domainAddress = dis.readUTF();
				String domainIP = null;
				
				
				HashMap<String, String> domain  = new HashMap<String, String>();
				
				domain.put("www.naver.com", "125.209.222.142");
				domain.put("www.google.com", "172.217.175.4");
				domain.put("www.kh-academy.co.kr", "125.209.222.142");
				
				if (domain.containsKey(domainAddress)) {
					domainIP = domain.get(domainAddress);
					dos.writeUTF(domainIP);
				}else {
					System.out.println("클라이언트가 요청한 주소 없음.");
					domainIP = "요청한 주소는 없습니다.";
					dos.writeUTF(domainIP);
				}
				
				

				System.out.print("서버를 종료하시겠습니까? [y/n] : ");
				String select = sc.nextLine();
				if(select.equals("y")) {
					break;
				}
				dis.close();
				dos.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				server.close();
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

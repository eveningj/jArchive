package me.jw.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void client() {
		Scanner sc = new Scanner(System.in);
		
		String serverIp =  "192.168.10.25";
		int serverPort = 1212;
		
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			socket = new Socket(serverIp, serverPort);
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			System.out.println("접속 완료");
			System.out.println("<<<<< BASEBALL GAME >>>>>");
			System.out.println("<<<<< GAME START >>>>>");
		
			
			int count = 0;
			
			while (count<10) {
			for (int i = 0; i<3; i++) {
				System.out.print((i+1)+"번째 숫자 입력 : ");
				int num = sc.nextInt();
				dos.writeInt(num);
//				dos.write(i);
			}
			int strike = dis.readInt();
			int ball = dis.readInt();
			System.out.println((count+1)+"회 ---> "+strike+"스트라이크"+ball+"볼");
			count++;
			}//while
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
				dos.close();
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

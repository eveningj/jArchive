package me.jw.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server {

	public void server() {
		System.out.println("<<< BASEBALL GAME >>>");

		int port = 8888;

		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			server = new ServerSocket(port);
			System.out.println("클라이언트 접속 대기중 . . ");

			Socket socket = server.accept();
			System.out.println("클라이언트 접속 완료");

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			Random r = new Random();
			ArrayList<Integer> sNumbers = new ArrayList<Integer>();
			ArrayList<Integer> cNumbers = new ArrayList<Integer>();

			System.out.print("서버 숫자 : ");
			// 중복검사 :
			for (int i = 0; i < 3; i++) {
				int sNumber = r.nextInt(9) + 1;
				if (!sNumbers.contains(sNumber)) {
					sNumbers.add(sNumber);
					System.out.print(sNumbers.get(i) + " ");
				} else {
					i--;
				}
			}

			System.out.println("<<<<< Game Start >>>>>");

			int count = 0;
			while (count < 10) {
				System.out.println("클라이언트가 입력한 수 : ");
				int[] numArr = new int[3];
				;
				int[] digitArr = new int[3];

				int num = 0;
				for (int i = 0; i < 3; i++) {
					num = dis.readInt(); // value
//				digit = dis.readInt(); //index
					numArr[i] = num;
					digitArr[i] = i;
				}

				int ball = 0;
				int strike = 0;

				if (strike < 3) {
					for (int i = 0; i < 3; i++) {
					    if (numArr[i] == sNumbers.get(i)) {
					        strike++;
					    } else if (sNumbers.contains(numArr[i])) {
					        ball++;
					    }
					}
					System.out.println("클라이언트가 입력한 수 :");
					for (int i = 0; i < 3; i++) {
						cNumbers.add(digitArr[i], numArr[i]);
						System.out.print(cNumbers.get(i) + " ");
					} // client
					dos.writeInt(strike);
					dos.writeInt(ball);

					count++;

				} else {
					dos.writeUTF("축하합니다. Win!");
					System.out.println("3스트라이크, 접속 종료.");
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

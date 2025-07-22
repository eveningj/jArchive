package me.jw.func;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Func {

	public void client() {
		Scanner sc = new Scanner(System.in);

		String serverIP = "1.220.236.74";
		int serverPort = 18080;

		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			System.out.println("서버 접속중 . . .");
			socket = new Socket(serverIP, serverPort);
			System.out.println("서버에 성공적으로 접속했습니다.");

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();

			dis = new DataInputStream(in);
			dos = new DataOutputStream(out);
			while (true) {
				String line = dis.readUTF();
				System.out.println(line);
				if (line.contains("?")) {
					break;
				}
			}

			String answer = sc.nextLine();
			dos.writeUTF(answer);
			while (true) {
				String line = dis.readUTF();
				System.out.println(line);
				if (line.contains("?")) {
					break;
				}
			}
			String answer2 = sc.nextLine();
			dos.writeUTF(answer2);

			while (true) {
				String line = dis.readUTF();
				System.out.println(line);
				if (line.contains("?")) {
					break;
				}
			}

			String input = sc.nextLine();
			ArrayList<Integer> headset = new ArrayList<Integer>();
			int sum = 0;
			for (int i = 0; i < input.length(); i++) {
				headset.add(i, (int) input.charAt(i));
				sum += headset.get(i);
			}
			System.out.println(sum);

			Integer answerH = sum;
			String answer3 = answerH.toString();

			dos.writeUTF(answer3);

			while (true) {
				String line = dis.readUTF();
				System.out.println(line);
				if (line.contains("끝")) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}

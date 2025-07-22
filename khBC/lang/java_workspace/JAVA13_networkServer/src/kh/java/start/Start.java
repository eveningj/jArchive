package kh.java.start;

import kh.java.func.FileServer;
import kh.java.func.TcpServer;
import kh.java.func.UdpServer;

public class Start {
	public static void main(String[] args) {
		FileServer file = new FileServer();
		file.server();
	}
}

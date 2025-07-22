package me.jw.start;

import me.jw.client.Client;
import me.jw.server.Server;

public class Start {
	public static void main(String[] args) {
		Server se = new Server();
		se.server();
		
//		Client cl = new Client();
//		cl.client();
	}
}

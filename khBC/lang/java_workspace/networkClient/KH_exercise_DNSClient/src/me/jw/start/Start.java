package me.jw.start;

import me.jw.func.DNSClient;

public class Start {
	public static void main(String[] args) {
		DNSClient dns = new DNSClient();
		dns.accessSever();
	}
}

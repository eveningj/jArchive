package me.jw.start;

import me.jw.func.DNSSever;

public class Start {
	public static void main(String[] args) {
		DNSSever dns = new DNSSever();
		dns.severOpen();
	}
}

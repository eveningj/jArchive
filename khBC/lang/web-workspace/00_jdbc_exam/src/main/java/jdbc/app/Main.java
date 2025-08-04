package jdbc.app;

import jdbc.member.controller.MemberController;

public class Main {
	public static void main(String[] args) {
		MemberController memberController = new MemberController();
		memberController.searchId();
	}
}

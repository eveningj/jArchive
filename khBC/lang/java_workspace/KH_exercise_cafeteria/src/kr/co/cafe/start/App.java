package kr.co.cafe.start;

import java.util.Scanner;

import kr.co.cafe.controller.CartItemController;
import kr.co.cafe.controller.ProductController;

public class App {
	public static void main(String[] args) {
		ProductController pc = new ProductController();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n ----------- 매점 메뉴 -----------\n");
			System.out.println("1. 직원");
			System.out.println("2. 손님");
			System.out.println("0. 프로그램 종료");
			System.out.println("선택 >> ");
			int select = sc.nextInt();
			switch(select) {
			case 1 :
				pc.employeeMenu();
				break;
			case 2 :
				CartItemController ci = new CartItemController(pc);
				ci.main();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("다시 선택해 주세요.");
			}
		}
	}//main() 종료
		
	}

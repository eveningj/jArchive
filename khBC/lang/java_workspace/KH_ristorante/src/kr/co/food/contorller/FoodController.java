package kr.co.food.contorller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import kr.co.food.model.vo.Beverage;
import kr.co.food.model.vo.CartItem;
import kr.co.food.model.vo.Food;
import kr.co.food.model.vo.Product;

public class FoodController  {
	Scanner sc;
	ArrayList<Product> menuList;
	ArrayList<CartItem> cartList;

	public FoodController() {
		super();
		sc = new Scanner(System.in);
		menuList = new ArrayList<Product>();
		cartList = new ArrayList<CartItem>();

		Food f1 = new Food("햄버거", 10500, false);
		Food f2 = new Food("라면", 5000, true);
		Food f3 = new Food("제육", 9000, true);
		Beverage b1 = new Beverage("물", 1000, 500);
		Beverage b2 = new Beverage("콜라", 2000, 300);
		Beverage b3 = new Beverage("맥주", 6000, 500);
		menuList.add(f1);
		menuList.add(f2);
		menuList.add(f3);
		menuList.add(b1);
		menuList.add(b2);
		menuList.add(b3);

	}

	public void main() {
		while (true) {
			try {
			System.out.println("\n================ 식당 ================\n");
			System.out.println("[1]. 직원");
			System.out.println("[2]. 손님");
			System.out.println("[0]. 프로그램 종료");
			System.out.println("선택 > >  ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				employeeMenu();
				break;
			case 2:
				customerMenu();
				break;
			case 0:
				return;
			default :
				System.out.println("[대괄호] 안의 숫자를 입력하세요.");
				break;
			}// switch();
			}catch (InputMismatchException e) {
				System.out.println("정수를 입력하세요");
				sc.nextLine();
			}
		} // while();

	}// main();

	public void employeeMenu() {
		while (true) {
			try {
			System.out.println("\n================ 퇴근하고 싶다 ================\n");
			System.out.println("[1]. 현재 메뉴 보기");
			System.out.println("[2]. 신규 메뉴 등록");
			System.out.println("[3]. 메뉴 정보 수정");
			System.out.println("[4]. 메뉴 삭제");
			System.out.println("[0]. 퇴근");
			System.out.println("선택 > > ");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				viewMenu();
				break;
			case 2:
				insertMenu();
				break;
			case 3:
				updateMenu();
				break;
			case 4:
				deleteMenu();
				break;
			case 0:
				System.out.println("나 간다");
				return;
			default :
				System.out.println("[대괄호] 안의 숫자를 입력하세요.");
				break;
			}// switch();
			}catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
				sc.nextLine();
			}
		} // while();
	}// employeeMenu();

	public void customerMenu() {
		while (true) {
			try {
			System.out.println("\n================ 빨리 빨리 줘봐 ================\n");
			System.out.println("[1]. 현재 메뉴 보기");
			System.out.println("[2]. 장바구니 넣기");
			System.out.println("[3]. 장바구니 보기");
			System.out.println("[4]. 장바구니 빼기");
			System.out.println("[0]. 나가기");
			System.out.println("선택 > > ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				viewMenu();
				break;
			case 2:
				insertCart();
				break;
			case 3:
				viewCart();
				break;
			case 4:
				deleteCartItem();
				break;
			case 0:
				return;
			default :
				System.out.println("[대괄호] 안의 숫자를 입력하세요.");
				break;
			}// switch();
			}catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요");
				sc.nextLine();
			}//catch
		} // while();
	}// customerMenu();

	public void viewMenu() {
		System.out.printf("음식타입\t이름\t가격\t특징");
		for (Product p : menuList) {
			System.out.println();
			System.out.print(p.getType() + "\t" + p.getName() + "\t" + p.getPrice() + "\t");
			switch (p.getType()) {
			case "음식":
				Food f = (Food) p;
				String spicy = f.isSpicy() ? "매움" : "안매움";
				System.out.print(spicy);
				break;
			case "음료":
				Beverage b = (Beverage) p;
				System.out.print(b.getVolume() + "ml");
				break;
			}// switch
		} // for
	}// viewMenu()

	public void insertMenu() {
		System.out.print("메뉴 타입을 선택하세요 [음식/ 음료] : ");
		String type = sc.next();
		switch (type) {
		case "음식":
			System.out.print("메뉴 이름을 입력하세요 : ");
			String name = sc.next();
			System.out.print("메뉴 가격을 입력하세요 : ");
			int price = sc.nextInt();
			if (price<0) {
				System.out.println("공짜로 팔 순 없습니다. 메뉴로 돌아갑니다.");
				break;
			}
			System.out.print("음식이 매운가요 ? [1.yes / 2. no] ");
			int spicyCheck = sc.nextInt();
			boolean spicyBool = false;
			switch (spicyCheck) {
			case 1:
				spicyBool = true;
				break;
			case 2:
				spicyBool = false;
				break;
			default:
				System.out.println("1 또는 2 로 입력");
				break;
			}
			Product p = new Food(name, price, spicyBool);
			menuList.add(p);
			System.out.println("됐어");
			break;
		case "음료":
			System.out.print("메뉴 이름을 입력하세요 : ");
			name = sc.next();
			System.out.print("메뉴 가격을 입력하세요 : ");
			price = sc.nextInt();
			if (price<0) {
				System.out.println("공짜로 팔 순 없습니다. 메뉴로 돌아갑니다.");
				break;
			}
			System.out.print("음료 용량(ml) 를 입력하세요 : ");
			int bVolume = sc.nextInt();
			p = new Beverage(name, price, bVolume);
			menuList.add(p);
			System.out.println("됐어");
			break;
		default:
			System.out.println("음식/음료 중에 입력하세요. 메인 메뉴로 돌아갑니다.");
			break;
		}// switch
	}// insertMenu()

	public void updateMenu() {
		System.out.println("수정하고 싶은 메뉴 입력 : ");
		String name = sc.next();
		int searchIndex = -1;
		for (int i = 0; i < menuList.size(); i++) {
			if (name.equals(menuList.get(i).getName())) {
				searchIndex = i;
			}
		} // for

		if (searchIndex == -1) {
			System.out.println("그런 메뉴는 존재하지 않아.");
		} else {
			System.out.println("수정할 메뉴 이름 입력 : ");
			String newName = sc.next();
			System.out.println("수정할 메뉴 가격 입력 : ");
			int price = sc.nextInt();
			if (price<0) {
				System.out.println("공짜로 팔 순 없습니다. 메뉴로 돌아갑니다.");
			}
			switch (menuList.get(searchIndex).getType()) {
			case "음식":
				System.out.println("음식이 매운가요? [1.yes / 2. no] ");
				int select = sc.nextInt();
				Boolean spicyBool = false; 
				switch (select) {
				case 1:
					spicyBool = true;
					Product p = new Food(newName, price, spicyBool);
					menuList.set(searchIndex, p);
					System.out.println("Done");
					break;
				case 2:
					spicyBool = false;
					p = new Food(newName, price, spicyBool);
					menuList.set(searchIndex, p);
					break;
				default:
					System.out.println("하라는대로 입력해");
					break;
				}
				break;
			case "음료":
				System.out.println("수정할 음료 용량은 ? (ml) :  ");
				int bVolume = sc.nextInt();
				Product p = new Beverage(newName, price, bVolume);
				menuList.set(searchIndex, p);
				System.out.println("Done");
				break;
			}
		}
	}// updateMenu();

	public void deleteMenu() {
		System.out.println("삭제하고 싶은 메뉴 이름 입력 : ");
		String name = sc.next();
		int searchIndex = -1;
		for (int i = 0; i < menuList.size(); i++) {
			if (name.equals(menuList.get(i).getName())) {
				searchIndex = i;
			}
		} // for

		if (searchIndex == -1) {
			System.out.println("그런 메뉴는 존재하지 않아.");
		} else {
			menuList.remove(searchIndex);
			System.out.println("Done");
		}
	}//deleteMenu();

	public void insertCart() {
		System.out.println("장바구니에 넣을 메뉴 이름을 입력하세요 : ");
		String name = sc.next();
		
		int searchIndex = -1;
		
		for (int i = 0; i < menuList.size(); i++) {
			if (name.equals(menuList.get(i).getName())) {
				searchIndex = i;
			}
		} // for
	
		if(searchIndex == -1) {
			System.out.println("메뉴 이름을 확인하세요");
		}else {
			
			System.out.println("몇개 구매하시겠습니까?");
			int amount = sc.nextInt();
			if (amount<0) {
				System.out.println("그렇게 살 순 없습니다. 메뉴로 돌아갑니다.");
				return;
			}else if (amount == 0) {
				System.out.println("아무것도 사지 않았습니다. 메뉴로 돌아갑니다. ");
				return;
			}
			int price = menuList.get(searchIndex).getPrice();
			System.out.println("장바구니에 넣었습니다");
		}
	}//insertCart();
	
	public void viewCart() {
		int sum = 0;
		int sPrice = 0;
		System.out.println("이름\t가격\t구매수량\t물건가격");
		for (CartItem c : cartList) {
			sPrice += sum;
		}
		
		System.out.println("총 가격 : "+sPrice);
	}//viewCart();
	
	public void deleteCartItem() {
		System.out.println("장바구니에서 뺄 메뉴 이름을 입력하세요 : ");
		String name = sc.next();
		
		int searchIndex = -1;
		
		for (int i = 0; i < cartList.size(); i++) {
				searchIndex = i;
			}
	
		if(searchIndex == -1) {
			System.out.println("장바구니에서 메뉴 이름을 확인하세요");
		}else {
			System.out.println("장바구니에서 뺄 메뉴 수량을 입력하세요 : ");
			int cAmount = sc.nextInt();
			if (cAmount<0) {
				System.out.println("그렇게 뺄 수 없습니다. 메뉴로 돌아갑니다.");
				return;
			}else if (cAmount==0) {
				System.out.println("아무것도 빼지 않았습니다. 메뉴로 돌아갑니다.");
				return;
			}
			int newAmount = cartList.get(searchIndex).getAmount()-cAmount; 
			if (newAmount<=0) {
				cartList.remove(searchIndex);
				System.out.println("장바구니에서 제거되었습니다.");
			}else {
				CartItem c = new CartItem();
				c.setAmount(newAmount);
				cartList.set(searchIndex, c);
				System.out.println(cAmount+"개 만큼 장바구니에서 "+name+"을(를) 뺐습니다.");
			}
		}
	}

	

}//class


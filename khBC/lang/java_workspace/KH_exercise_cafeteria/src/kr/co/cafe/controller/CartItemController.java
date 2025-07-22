package kr.co.cafe.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import kr.co.cafe.model.vo.Beverage;
import kr.co.cafe.model.vo.CartItem;
import kr.co.cafe.model.vo.Combo;
import kr.co.cafe.model.vo.Food;
import kr.co.cafe.model.vo.Product;

public class CartItemController {
	
	Product p;
	CartItem c;
	ProductController pc;
	HashMap<String, CartItem> cItem;
	Scanner sc;
	
	public CartItemController() {
		super();
		cItem = new HashMap<String, CartItem>();
		sc = new Scanner(System.in);
		pc = new ProductController();
		// TODO Auto-generated constructor stub
	}
	public CartItemController(Product p, CartItem c, ProductController pc) {
		super();
		this.p = p;
		this.c = c;
		this.pc = pc;
		this.cItem = new HashMap<>();
	    this.sc = new Scanner(System.in);
		
	}
	
	public CartItemController(ProductController pc) {
		super();
		this.pc = pc;
		this.cItem = new HashMap<>();
	    this.sc = new Scanner(System.in);
		this.pc = pc;
	}
	
	public void main() {
		while(true) {
			
		
		System.out.println("1. 메뉴 확인");
		System.out.println("2. 장바구니 확인");
		System.out.println("3. 장바구니에 넣기");
		System.out.println("4. 장바구니 수정"); // 이 메뉴 안에 삭제 들어가게끔.
		System.out.println("0. 돌아가기");
		int select = sc.nextInt();
		
		switch (select) {
		case 1:
			viewMenu();
			break;
		case 2:
			viewCartItem();
			break;
		case 3:
			addCartItems();
			break;
		case 4:
			updateCartItem();
			break;
		case 0:
			return;
		}//switch
		}//while
		
	}//main();
	
	public void viewMenu() {
	    if (pc.getMenuList() == null || pc.getMenuList().size() == 0) {
	        System.out.println("등록된 메뉴가 없습니다.");
	        return;
	    }

	    System.out.println("[메뉴\t종류\t가격]");
	    System.out.println("--------------------------------------");

	    for (String key : pc.getMenuList().keySet()) {
	        Product product = pc.getMenuList().get(key);
	        System.out.printf("%s\t %s \t %d원%n",
	                 product.getName(), product.getType(), product.getPrice());
	    }

	    System.out.println("--------------------------------------");
	}
	
	public void addCartItems() {
	    System.out.println("1. 음식 담기");
	    System.out.println("2. 음료 담기");
	    System.out.println("0. 돌아가기");
	    System.out.print("선택: ");
	    int select = sc.nextInt();
	    sc.nextLine(); // 개행 소비

	    Map<String, Product> menu = pc.getMenuList();
	    String targetType = null;

	    switch (select) {
	        case 1:
	            targetType = "음식";
	            break;
	        case 2:
	            targetType = "음료";
	            break;
	        case 0:
	            return;
	        default:
	            System.out.println("잘못된 입력입니다.");
	            return;
	    }

	    System.out.println("선택 가능한 " + targetType + " 메뉴:");
	    for (String name : menu.keySet()) {
	        Product p = menu.get(name);
	        if (targetType.equals(p.getType())) {
	            
	        	System.out.println("메뉴 종류 : " + p.getType());
	        	System.out.println("메뉴 이름 : " + p.getName());
	        	System.out.println("메뉴 가격 : " + p.getPrice());
	        }
	    }

	    System.out.print("담을 메뉴의 이름을 입력하세요: ");
	    String menuName = sc.nextLine();

	    if (!menu.containsKey(menuName)) {
	        System.out.println("해당 메뉴가 존재하지 않습니다.");
	        return;
	    }

	    Product selected = menu.get(menuName);

	    if (!targetType.equals(selected.getType())) {
	        System.out.println("선택한 메뉴는 " + targetType + "이 아닙니다.");
	        return;
	    }

	    System.out.print("수량을 입력하세요: ");
	    int amount = sc.nextInt();
	    sc.nextLine();

	    String itemName = selected.getName();
	    if (cItem.containsKey(itemName)) {
	        CartItem existing = cItem.get(itemName);
	        existing.setAmount(existing.getAmount() + amount);
	        System.out.println("선택하신 메뉴의 수량이 증가되었습니다.");
	    } else {
	        CartItem newItem = new CartItem(selected, amount);
	        cItem.put(itemName, newItem);
	        System.out.println("장바구니에 추가되었습니다.");
	    }

	    convertCombo(); // 콤보 전환 검사
	}

	
	public boolean searchKey(String name) {
		if (cItem.containsKey(name)) {
			return true;
		}else {
			System.out.println("장바구니에 그런 메뉴는 없습니다. 메뉴로 돌아갑니다. ");
			return false;
		}
	}//
	
	public void updateCartItem() {
		System.out.println("==============================");
		System.out.println("장바구니에서 [수정/삭제] 할 메뉴 이름을 입력하세요 : ");
		String searchName = sc.next();
		
		if (searchKey(searchName)) {
		System.out.println("수정을 원하시면 u, 삭제를 원하시면 d 를 입력하세요. [u/d] ");
		char check = sc.next().charAt(0);
		switch (check) {
		case 'u' : 
			System.out.println("수정할 상품의 수량을 입력하세요 : ");
			int amount = sc.nextInt();
			if (amount>0) {
				CartItem item = cItem.get(searchName);
				item.setAmount(amount);
				System.out.println("수량이 " + amount + "개로 수정되었습니다.");
				convertCombo();
				
			}else {
				System.out.println("0 이하의 수량은 삭제로 간주합니다.");
				deleteCartItem(searchName);
			}
			break;
		case 'd' : 
			deleteCartItem(searchName);
			System.out.println("입력하신 항목을 장바구니에서 삭제하였습니다.");
			break;
		default :
		}
		}//if
		
		
		
	}
	
	public void deleteCartItem(String name) {
		cItem.remove(name);
		System.out.println("정상적으로 삭제 되었습니다.");
	}
	
	/*public void convertCombo() {
	    CartItem foodItem = null;
	    CartItem bevItem = null;

	    for (CartItem item : cItem.values()) {
	        String type = item.getProduct().getType();
	        if (type.equals("음식")) {
	            foodItem = item;
	        } else if (type.equals("음료")) {
	            bevItem = item;
	        }
	    }

	    if (foodItem != null && bevItem != null && foodItem.getAmount() == bevItem.getAmount()) {
	        int comboAmount = foodItem.getAmount();
	        Food food = (Food) foodItem.getProduct();
	        Beverage bev = (Beverage) bevItem.getProduct();

	        String comboName = food.getName() + "와" + bev.getName() + " 콤보";
	        Combo combo = new Combo(comboName, food, bev);
	        CartItem comboItem = new CartItem(combo, comboAmount);

	        cItem.remove(food.getName());
	        cItem.remove(bev.getName());

	        cItem.put(comboName, comboItem);

	        System.out.println("콤보 [" + comboName + "]로 전환되었습니다!");
	    }
	}*/
	
	public void convertCombo() {
	    CartItem foodItem = null;
	    CartItem bevItem = null;

	    // 음식과 음료 아이템 찾기
	    for (CartItem item : cItem.values()) {
	        String type = item.getProduct().getType();
	        if (type.equals("음식")) {
	            foodItem = item;
	        } else if (type.equals("음료")) {
	            bevItem = item;
	        }
	    }

	    if (foodItem == null || bevItem == null) return;

	    int foodQty = foodItem.getAmount();
	    int bevQty = bevItem.getAmount();
	    int comboQty = Math.min(foodQty, bevQty); // 만들 수 있는 콤보 수량

	    if (comboQty == 0) return;

	    // 콤보 생성
	    Food food = (Food) foodItem.getProduct();
	    Beverage bev = (Beverage) bevItem.getProduct();
	    String comboName = food.getName() + "와" + bev.getName() + " 콤보";
	    Combo combo = new Combo(comboName, food, bev);
	    CartItem comboItem = new CartItem(combo, comboQty);

	    // 기존 아이템 제거
	    cItem.remove(food.getName());
	    cItem.remove(bev.getName());

	    // 콤보 추가
	    cItem.put(comboName, comboItem);

	    // 남은 단품 음식/음료 다시 추가
	    int remainFood = foodQty - comboQty;
	    int remainBev = bevQty - comboQty;

	    if (remainFood > 0) {
	        cItem.put(food.getName(), new CartItem(food, remainFood));
	    }

	    if (remainBev > 0) {
	        cItem.put(bev.getName(), new CartItem(bev, remainBev));
	    }

	    System.out.println("[" + comboName + "] 콤보 " + comboQty + "개로 전환되었습니다!");
	}
	
	public void viewCartItem() {
	    if (cItem == null || cItem.size() == 0) {
	        System.out.println("장바구니가 비어 있습니다.");
	        return;
	    }

	    System.out.println("[장바구니 내역]");
	    System.out.println("-------------------------------------------------");
	    System.out.println("상품명\t수량\t가격\t총액");
	    System.out.println("-------------------------------------------------");

	    int total = 0;
	    for (String keyName : cItem.keySet()) {
	        CartItem item = cItem.get(keyName);
	        String name = item.getProduct().getName();
	        int amount = item.getAmount();
	        int unitPrice = item.getProduct().getPrice();
	        int finalPrice = item.getFinalPrice();

	        total += finalPrice;

	        System.out.printf("%s\t%d\t%d\t%d%n", name, amount, unitPrice, finalPrice);
	    }

	    System.out.println("-------------------------------------------------");
	    System.out.printf("총합: %d원%n", total);
	}
}

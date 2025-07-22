package kr.co.cafe.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



import kr.co.cafe.model.vo.Beverage;
import kr.co.cafe.model.vo.Food;
import kr.co.cafe.model.vo.Product;

public class ProductController {
	Scanner sc;
	HashMap<String, Product> menuList;

	public ProductController() {
		super();
		sc = new Scanner(System.in);
		menuList = new HashMap<String, Product>();
		
	}

	
	public void employeeMenu() {
		while(true) {
			try {
				System.out.println("\n----------- 일 해 보자고 -----------\n");
				System.out.println("1. 메뉴 등록");
				System.out.println("2. 메뉴 수정");
				System.out.println("3. 전체 메뉴 보기");
				System.out.println("4. 메뉴 삭제");
				System.out.println("0. 직원 화면 나가기");
				System.out.print("선택 >> ");
				int select = sc.nextInt();
				switch(select) {
				case 1 :
					addProductMenu();
					break;
				case 2 :
					updateProduct();
					break;
				case 3 :
					getAllProductsMenu();
					break;
				case 4 :
					deleteProduct();
					break;
				case 0 :
					System.out.println("메인 화면으로 돌아갑니다.");
					 return;
				default :
					System.out.println("다시 선택해 주세요.");
					break;
				}
			}catch (Exception e) {
				sc.nextLine();
				System.out.println("에러가 발생했습니다. 해당 항목을 재수행 해주세요.");
			}
			
		}
	}
	
	public void addProductMenu(){
		System.out.println("\n----------- 메뉴 등록 ----------\n");
		System.out.print("메뉴 카테고리 선택[음식/음료] : ");
		String type = sc.next();
		switch(type) {
		case "음식" :
			System.out.print("메뉴 이름 입력 : ");
			String foodName = sc.next();
			Product name1 =  menuList.get(foodName);
			if(name1 != null) {
				System.out.println("이미 등록된 메뉴입니다.");
			}else {
				System.out.print("메뉴 가격 입력 : ");
				int foodPrice =sc.nextInt();
				if(foodPrice >= 0) {
					Food f = new Food(foodName, foodPrice);
					Product p1 = f;
					menuList.put(foodName, p1);
					System.out.println("메뉴 등록 완료");	
				}else {
					System.out.println("정상 등록 되지 않았습니다. 가격은 0원 이상으로 입력해주세요.");
				}
					
			}
			
			break;
		case "음료" :
			System.out.print("메뉴 이름 입력 : ");
			String beverageName = sc.next();
			Product name2 = menuList.get(beverageName);
			if(name2 != null) {
				System.out.println("이미 등록된 메뉴입니다.");
				}else {
					System.out.print("메뉴 가격 입력 : ");
					int beveragePrice =sc.nextInt();
					if(beveragePrice >= 0) {
						Beverage b = new Beverage(beverageName, beveragePrice);
						Product p2 = b;
						menuList.put(beverageName, p2);
						System.out.println("메뉴 등록 완료");	
					System.out.println("이미 등록된 메뉴입니다.");
				}else {
					System.out.println("정상 등록 되지 않았습니다. 가격은 0원 이상으로 입력해주세요.");
				}
					
			}
			
			break;
		default :
			System.out.println("정상 등록되지 않았습니다.");
			break;
		}

	}
	
	public void getAllProductsMenu() {
		System.out.println("\n------------ 전체 메뉴 출력 --------------\n");
		System.out.println("메뉴타입\t메뉴이름\t가격");
		Set<String> names = menuList.keySet();
		for(String name : names) {
			Product p = menuList.get(name);
			System.out.println(p.getType()+"\t"+p.getName()+"\t"+p.getPrice());
		}
		
	}
	
	public void deleteProduct() {
		System.out.println("/n------------ 메뉴 삭제 -------------\n");
		System.out.print("삭제 할 메뉴 이름 입력 : ");
		String name = sc.next();
		Product p = menuList.get(name);
		if(p == null ) {
			System.out.println("입력하신 메뉴를 찾을 수 없습니다.");
	    }else {
	    	menuList.remove(p);
	    	System.out.println("메뉴 삭제 완료");
	    }		
	}
	
	public void updateProduct() {
		System.out.println("\n------------ 메뉴 수정 --------------\n");
		System.out.print("수정 할 메뉴 이름 입력 : ");
		String name = sc.next();
		Product p = menuList.get(name);
		if(p == null) {
			System.out.println("입력하신 메뉴를 찾을 수 없습니다.");
		}else {
			menuList.remove(p);
			System.out.print("수정 이름 입력 : ");
			String newName = sc.next();
			p.setName(newName);
			System.out.print("수정 가격 입력 : ");
			int newPrice = sc.nextInt();
			p.setPrice(newPrice);
			System.out.println("메뉴 수정 완료");
			
			getAllProductsMenu();
		}
	}
	
	
	public Map<String, Product> getMenuList() {
	    return menuList;
	}
	
	
	
	
}
/*
1. 메뉴 입력
2. 메뉴 수정
3. 메뉴 출력
4. 메뉴 삭제
*/

/*
void addProduct(Product product);               // CREATE
//Product getProductById(String name);              // READ
Map<String, Product> getAllProducts();          // READ ALL
void updateProduct(Product product);            // UPDATE
void deleteProduct(String name);                  // DELETE
}
*/
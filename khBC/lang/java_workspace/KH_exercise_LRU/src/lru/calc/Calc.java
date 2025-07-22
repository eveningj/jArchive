package lru.calc;

import java.util.ArrayList;
import java.util.Scanner;

import lru.model.Cache;

public class Calc {

	ArrayList<Cache> cache;
	Scanner sc;

	public Calc() {
		super();
		sc = new Scanner(System.in);
		cache = new ArrayList<Cache>();
		// TODO Auto-generated constructor stub
	}

	public void main() {
		int result = 0;
		System.out.println("캐시 크기 입력 : ");
		int cacheSize = sc.nextInt();
		
//		Cache c = cache.get(i)
		while (true) {
			System.out.println("도시 입력 : ");
			String inputCity = sc.next();
			System.out.println("그만 입력하시겠습니까 ? [y/n]");
			String select = sc.next();
			switch (select) {
			case "n":
			if (cacheHit(inputCity)==1) {
				result += cacheHit(inputCity);
				System.out.println("등록 완료");
			}
			else if (cache.size()>=cacheSize) {
				cache.remove(0);
				System.out.println("등록 완료");
				cache.add(new Cache(inputCity));
				result += cacheHit(inputCity);
			}else {
				cache.add(new Cache(inputCity));
				result += cacheHit(inputCity);
				System.out.println("Cache HIT! 등록 완료.");
			}
				continue;
			case "y":
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}//switch();
			break;
		} // while
		System.out.println("캐시 크기 : " + cacheSize);

		System.out.println("총 실행 시간 : "+ result);
//		System.out.println("효율 ?: ");
	}// main();

	public int cacheHit(String city) {
		for (int i = 0; i < cache.size(); i++) {
			Cache c = cache.get(i);
			String searchCity= c.getCities();

			if (city.equals(searchCity)) {
				cache.remove(i);
				cache.add(new Cache(city));
				return 1;
			} // if();
		} // for();
		cache.add(new Cache(city));
		return 5;
	}//
	}


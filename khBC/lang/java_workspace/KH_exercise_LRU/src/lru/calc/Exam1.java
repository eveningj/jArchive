package lru.calc;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exam1 {

	public void test() {
		int cacheSize = 3;
		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
//		String [] arr = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
//		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//		String [] arr = {"Jeju", "Pangyo", "NewYork", "newyork"};
//		String [] arr = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int result = lru1(cacheSize,arr);
		System.out.println(result);
		
	}
	
	public int lru1(int cacheSize, String[] arr) {
		int time = 0;
		if(cacheSize ==0) {
			return 5*arr.length;
		}
		String[] cache = new String[cacheSize];
		int index = 0; //배열 몇번째 까지 사용중인지 체크하는 변수
		for (int i =0; i<arr.length;i++) {
			String city = arr[i].toLowerCase(); //배열에서 도시 이름 1개 꺼내옴
			//캐시에 해당 도시 이름이 있는지 체크
			int searchIndex = -1;
			for(int j=0;j<index;j++) {
				String cacheCity = cache[j];
				if(city.equals(city)) {
					searchIndex = j;
					break;
				}
			}
			//검색결과 searchIndex == -1 이면 없는거 / 있으면 몇번째 있는지
			if(searchIndex == -1) {
				time += 5;
				if(index == cacheSize) {
					for(int j=0;j<index-1;j++) {
						cache[j] = cache[j+1];
					}
					cache[index-1] = city;
				}else {
					cache[index] = city;
					index++;
				}
			}else {
				time += 1;
				for(int j=searchIndex;j<index-1;j++) {
					cache[j] = cache[j+1];
				}
				cache[index-1] = city;
			}
		}
		return time;
		
	}
	
	public int lru2(int cacheSize, String[] arr) {
		int time = 0;
		if(cacheSize == 0) {
			return 5*arr.length;
		}
		ArrayList<String> cache = new ArrayList<String>();
		for (int i=0;i<arr.length;i++) {
			String city = arr[i].toLowerCase();
			int searchIndex = cache.indexOf(city);
			if (searchIndex == -1) {
				time += 5;
				if(cache.size() == cacheSize) {
					cache.remove(0);
				}
				cache.add(city);
			}else {
				time += 1;
				cache.remove(searchIndex);
				cache.add(city);
				
			}
		}
		
		return time;
		
	}
	
	public int lru3(int cacheSize, String[] arr) {
		if(cacheSize == 0) {
			return 5*arr.length;
		}
		int time = 0;
		LinkedList<String> cache = new LinkedList<String>();
		for (int i =0; i<arr.length; i++) {
			String city = arr[i].toLowerCase();
			boolean result = cache.removeFirstOccurrence(city); //리스트에서 매개변수로 준 데이터를 찾아서 지우고 결과를 논리형으로 리턴 (지웠으면 t/ 아니면 f)
			cache.add(city);
			time += 1;
			if(!result) {
				time += 4;
				if(cache.size() > cacheSize) {
					cache.removeFirst();
				}
			}
		}
		return time;
	}
}

package kh.java.func;

public class TestClass {
	public void test1() {
		GenericTest1 gt1 = new GenericTest1();
		gt1.setData1(100);
		gt1.setData2("hi");
		System.out.println(gt1.getData1() + 1);
		System.out.println(gt1.getData2() + 1);
		// 만약에 GenericTest1 과 나머지는 모두 같은데 data1 변수의 타입이 String인 경우
		// -> String type 으로 data1 변수를 사용하는 새로운 클래스를 만들어서 사용함.

		GenericTest2 gt2 = new GenericTest2();
		gt2.setData1("100");
		gt2.setData2("hi");
		System.out.println(gt2.getData1() + 1);
		System.out.println(gt2.getData2() + 1);

		// GenericTest3 Class 의 Data1 변수의 자료형은 Generic으로 설정
		// -> 객체를 생성할 때 자료형을 지정함.
		// 만약 data1의 변수 자료형을 String 으로 사용하고 싶은 경우 :
		GenericTest3<String> gt3 = new GenericTest3<String>();
		gt3.setData1("1000");
		System.out.println(gt3.getData1() + 1);
		// 만약 data1 변수의 자료형을 int 를 쓰고 싶은 겨우 :
		// Generic 으로 자료형을 설정할 때 반드시 참조형으로 설정(기본자료형은 사용할 수 없음)
		// 그럼에도 불구하고 기본형을 쓰고싶으면 -> 기본형을 참조형으로 변경해서 사용 -> Wrapper
		GenericTest3<Integer> gt4 = new GenericTest3<Integer>();
		gt4.setData1(1000);
		System.out.println(gt4.getData1() + 1);

		// GenericTest4 객체를 생성 -> Generic 이 2개 적용되어 있음
		// ->2개 자료형을 모두 지정
		// data 1 : String, data2 : Integer
		GenericTest4<String, Integer> gt5 = new GenericTest4<String, Integer>();
		// data 1 : Integer, data2 : String
		GenericTest4<Integer, String> gt6 = new GenericTest4<Integer, String>();

	}

	public void test2() {
		Tiger t = new Tiger(100);
		Object o = (Object) t;
		// AnimalMgr1의 data 변수는 Object 타입이므로 Tiger 를 업캐스팅하여 저장함.
		AnimalMgr am1 = new AnimalMgr(o);

		Rabbit r = new Rabbit(50);
		AnimalMgr am2 = new AnimalMgr(r); // AnimalMgr에 Rabbit 을 업캐스팅하여 저장함.

		Object o1 = am1.getData();
		// getHP(), tigerFunction() : Object에는 없고, Tiger에만 존재하는 기능
		// upcasting 된 상태에서 부모타입에 명시된 기능만 사용 가능하다.

		// -> Tiger에 있는 기능을 사용하고 싶으면 -> 다운캐스팅
		Tiger t1 = (Tiger) o1;
//		System.out.println(t1.getHp());
		t1.tigerFunction();

		Object o2 = am2.getData();
		Rabbit r1 = (Rabbit) o2;
//		System.out.println(r1.getHp());
		r1.rabbitFunction();
	}

	public void test3() {
		Tiger t1 = new Tiger(200);
		Rabbit r1 = new Rabbit(150);
		// AnimalMgr2의 data 변수는 자료형이 Animal -> Tiger, Rabbit 의 공통 부모
		// Tiger와 Rabbit을 각각 업캐스팅 해서 객체 생성
		AnimalMgr2 am1 = new AnimalMgr2(t1);
		AnimalMgr2 am2 = new AnimalMgr2(r1);
		// am1 의 data변수에는 실제로 Tiger 객체가 저장되어 있지만, 업캐스팅으로 Animal 타입인 척 하고 있음.
		Animal a1 = am1.getData();
		System.out.println(a1.getHp());
		// a1.tigerFunction(); tigerFunction()은 Tiger에만 존재하고 Animal 에는 없음 -> 사용하려면 다운캐스팅
		Tiger t2 = (Tiger) a1;
		t2.tigerFunction();

		Animal a2 = am2.getData();
		System.out.println(a2.getHp());
		// a2.rabbitFunction(); X, 사용하고 싶으면 -> 다운캐스팅
		Rabbit r2 = (Rabbit) r1;
		r2.rabbitFunction();

	}//

	public void test4() {
		Tiger t1 = new Tiger(300);
		Rabbit r1 = new Rabbit(500);

		AnimalMgr3<Tiger> am1 = new AnimalMgr3<Tiger>(t1);
		AnimalMgr3<Rabbit> am2 = new AnimalMgr3<Rabbit>(r1);
		Tiger t2 = am1.getData();
		System.out.println(t2.getHp());
		t2.tigerFunction();

		Rabbit r2 = am2.getData();
		System.out.println(r2.getHp());
		r2.rabbitFunction();

	}

	public void test5() {
		// 정수 배열이 필요한 경우 => int[] -> MyArray<Integer>
		// 길이 제한 없는 배열
		// -> 현재 저장된 데이터의 수를 알 수 있어야함.
		MyArray<Integer> arr1 = new MyArray<Integer>();
		System.out.println("현재 배열의 길이 : " + arr1.size());
		arr1.add(100);
		arr1.add(200);
		arr1.add(300);
		arr1.add(400);
		arr1.add(500);
		arr1.remove(1);
		arr1.insert(1,700);
		System.out.println("현재 배열의 길이 : " + arr1.size());
		for (int i = 0; i < arr1.size(); i++) {
			Integer num = arr1.get(i);
			System.out.println(num);
		}

		MyArray<String> arr2 = new MyArray<String>();
		System.out.println("현재 배열의 길이 : " + arr2.size());
		arr2.add("hi");
		arr2.add("ho");
		arr2.add("hello");
		arr2.add("greetings");
		arr2.add("glad to meet you");
	
		arr2.remove(3);
		arr2.modify(3,"bye");
		arr2.insert(1,"몰라");
		System.out.println("현재 배열의 길이 : " + arr2.size());
		for (int i = 0; i < arr2.size(); i++) {
			String str = arr2.get(i);
			System.out.println(str);
		}//for
	}
}

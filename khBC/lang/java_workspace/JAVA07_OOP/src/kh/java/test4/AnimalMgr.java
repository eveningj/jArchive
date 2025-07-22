package kh.java.test4;

public class AnimalMgr {
	public void main() {
		/*
		//Animal 객체 생성해서 저장
		Animal a1 = new Animal();
		a1.walk();
		//Tiger 객체 생성해서 저장
		Tiger t1= new Tiger();
		t1.walk();
		t1.hunt();
		//Rabbit 객체 생성해서 저장
		Rabbit r1 = new Rabbit();
		r1.walk();
		r1.cute();
		*/
		
		//다형성 -> 부모타입 변수에 자식타입 객체주소를 저장
		Animal a2 = new Tiger(); //자식 타입 객체가 부모타입인 척 하는 상태 -> upcasting
		Animal a3 = new Rabbit(); //upcasting
		a2.walk();
//		a2.hunt() 메소드는 Tiger에만 존재하는 기능이고, Animal 에는 존재하지 않는 기능
//		upcasting 상태에서는 Supercalss 에 존재하는 메소드만 사용이 가능
//		a2.hunt();
		
		//upcasting 으로 사용하지 못하는 기능을 쓰고싶으면 -> downcasting
		Tiger t2 = (Tiger)a2;
		t2.hunt();
		Rabbit r2 = (Rabbit)a3;
		r2.cute();
		//다형성 적용이 불가능한 경우
//		-> subclass 에 superclass 변수를 저장하는 행위 X
//		Tiger t3 = new Animal(); X
//		-> 형제 타입끼리 저장하려는 경우
//		Tiger t3 = new Rabbit();
//		Tiger r3 = new Tiger();
	
	//Rabbit r3 = (Rabbit)a2; // -> 다운 캐싕할 때 자식타입 객체가 맞지않으면 에러 발생
	}
}

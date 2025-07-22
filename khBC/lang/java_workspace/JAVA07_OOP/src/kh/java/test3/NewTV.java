package kh.java.test3;

public class NewTV {
	//속성 : 크기 / 전원 / 볼륨 / 채널
	//전역 변수를 생성할 때 접근 제어 지시자를 이용해서 외부에서 접근을 막음.
	private int inch;
	private boolean power;
	private int channel;
	private int volume;

	
	//생성자	: 객체를 생성할때만 호출하는 메소드
	//생성자 만드는 방법
	//	1.접근제어지시자 : public
	//	2.리턴타입 : 없음(void 가 아니라 아예 명시하면 안됨)
	//	3.메소드 이름 : 클래스 이름과 같아야함.
	//	4.매개변수 : 생성자 역할에 따라 다름.
	
	//만약 클래스 생성시 생정자를 작성하지 않으면 JVM 이 실행할 때 기본생성자를 자동으로 작성
	// ->기본생성자는 매개변수가 없고 내부에서 아무 값도 초기화하지 않는 생성자
	//생성자를 어떠한 형태든 1개라도 만들면 JVM 은 기본생성자를 만들어주지 않음.
	
	//생성자는 필요에 따라, 오버로딩을 통해 여러 개 만드는 것이 가능하다.
	
	////////////////////////////////////////////////////
	//BASICS RULE 
	//기본 생성자 생성
	public NewTV() {
		
	}
	//모든 전역변수를 초기화 할 수 있는 생성자
	public NewTV(int inch, boolean power, int channel, int volume) {
		this.inch = inch;
		this.power = power;
		this.channel = channel;
		this.volume = volume;
	} //필요하면 추가 생성
	public NewTV(int inch) {
		this.inch = inch;
	}
	
	////////////////////////////////////////////////////
	/*
	public NewTV() {
		inch = 100;
	}*/
	//변수에 데이터 세팅 setter
	//변수에 데이터 가져오기 getter
	
	//전역 변수의 접근제어지시자가 private 로 설정 -> 변수의 접근권한은 해당 클래스 네부에서만 기능
	
	
	//변수에 private가 붙어서 외부 클래스에서 해당 변수에 값을 대입하거나, 가져가는 행동이 불가능
	//변수를 생성하고 사용할 수 없으면 변수를 만든 목적이 사라짐
	//변수에 데이터를 가져오거나(getter), 변수에 데이터를 대입(setter)하는 메소드를 만들어서 사용.
	//getter와 setter는 변수별로 하나씩 생성
	
	
	//getter 생성(외부에서 이 메소드를 이용해서 전역변수의 데이터를 가져오기 위한 메소드)
	//1. 접근제어지시자 : public
	//2. 리턴타입 : 되돌려줄 변수의 자료형과 대응되므로 일치하여야한다.
	//3. 메소드의 이름 : get변수명 -> 카멜표기법
	//4. 매개변수 : 없음
	//5. 소스코드 : 해당 전역변수 값을 리턴
	
	public int getInch() {
		return inch;
	}

	//setter 생성 (외부에서 이 메소드를 이용해서 전역변수의 데이터를 수정하기 위한 메소드)
	//1.접근제어지시자 : public
	//2. 리턴타입 : void
	//3. 메소드 이름 : set변수명 -> 카멜표기법
	//4. 매개변수 : 해당 전역변수와 동일한 자료형으르 1개  (변수 이름은 전역변수와 동일)
	//5. 소스코드 : 매개변수로 받은 데이터를 전역변수에 대입
	
	
//	public void setInch(int inch) {
		//this.변수 -> 해당클래스의 전역변수를 지칭하는 키워드
//		this.inch = inch;
//	}
	//boolean형 데이터의 getter 생성시 메소드 이름 get변수명 -> is변수명
	public boolean isPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}

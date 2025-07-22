package kh.java.func;


//Generic 으로 받은 데이터타입의 배열에 기능을 추가한 가상의 배열
public class MyArray <T>{
//	private T[] arr2; -> 나중에 Error 발생률 높음.
	private Object[] arr; // 데이터를 저장할 배열
	private int size; //데이터 저장 갯수
	
	
	public MyArray() { //INITIALIZED
		super();
		arr = new Object[10]; //최초에는 갯수를 모르므로 10개를 저장할 수 있는 배열
		size = 0;
	}
	
	//! ! ! !  배열 중간에 데이터를 삽입하는 메소드
	// +? 배열의 데이터를 정렬하는 메소드
	
	
	
	//배열의 현재 데이터 수를 알려주는 메소드
	public int size() {
		return size;
	}//size();
	
	//배열의 마지막에 데이터를 추가하는 메소드
	public void add(T data) {
		if (arr.length == size ) {
			int newSize = arr.length*2;
			Object[] newArr = new Object[newSize];
			for(int i=0; i<arr.length;i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[size] = data;
		size++;
	}
	//배열에서 데이터를 꺼내는 메소드
	public T get(int i ) {
		return (T)arr[i];
	}
	
	//배열에서 데이터를 지우는 메소드
	public void remove(int index) {
		for (int i=index; i<size-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[--size] = null;
		
	}
	
	//배열의 데이터를 변경하는 메소드
	public void modify(int i, T data) {
		arr[i] = data;
		
	}
	
	public void insert(int index, T data) {
//		for(int i=index; i<index+1; i++) {
//			arr[i+1] = arr[i];
//		}	//WRONG
		for(int i=size-1; i>=index;i--) {
			arr[i+1] = arr[i];
		}
		arr[index] = data;
		size++;
	}
}

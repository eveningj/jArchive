package kh.java.func;

public class ArrayTest2 {
	public void test1() {
		int num1 = 100;
		System.out.println("num1 ; "+num1);//100
		int num2 = num1;
		System.out.println("num2 : "+num2);//100
		num2 = 200;
		System.out.println("num2 : "+num2);//200
		System.out.println("num1 : "+num1);//100
		
		int[] arr1 = {1,2,3,4,5};
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");	//1 2 3 4 5
		}
		System.out.println();
		
		int[] arr2 = arr1;
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");	//1 2 3 4 5
		}
		System.out.println();
		
		arr1[2] = 300;
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");	//1 2 300 4 5
		}
		System.out.println();
		
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");	//1 2 300 4 5
		}
		System.out.println();
	}
	public void test2() { //깊은 복사
		int[] arr1 = {1,2,3,4,5};
		//1) 개발자가 직접 복사
		int[] arr2 = new int[arr1.length]; //복사할 원본배열과 같은 길이 & 같은자료형의 새로운배열 생성
		for(int i=0;i<arr1.length;i++) {
			arr2[i] = arr1[i];
		}
		
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		arr2[3] = 1000;
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
	}
	public void test3() {
		int[] arr1 = {1,2,3,4,5};
		//2) System.arraycopy사용 (배열의 일부만 복사하고 싶을때 주로 사용)
		int[] arr2 = new int[arr1.length];//복사될 배열을 새로 선언()
		//System.arraycopy(5개데이터 전달);
		/*
		 * 1.복사될 원본배열 주소
		 * 2.원본 배열 중 복사를 시작하고 싶은 인덱스번호
		 * 3.깊은복사로 데이터가 들어갈 배열의 주소
		 * 4.깊은복사로 데이터가 들어갈 시작 인덱스번호
		 * 5.복사할 데이터의 길이
		 */
		System.arraycopy(arr1, 1, arr2, 2, 3);
		System.out.println("arr1 출력");
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+" ");
		}
		System.out.println();
		
		System.out.println("arr2 출력");
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
		//3) clone() : 복제 0> 같은 길이와 데이터로 전체를 깊은복사
		int[] arr3 = arr1.clone();
		System.out.println("arr2 출력");
		for(int i=0;i<arr3.length;i++) {
			System.out.print(arr3[i]+" ");
		}
		System.out.println();
	}
	public void test4() {//2차원배열
		//2차원배열 -> 배열 내부 자료형이 배열인 형태의 데이터
		//2차원 배열 선언 -> 자료형[][] 변수이름 = new 자료형[행의길이][열의길이];
		int[][] arr = new int[2][3];
		arr[0][0] = 100;
		arr[0][1] = 200;
		arr[0][2] = 300;
		arr[1][0] = 400;
		arr[1][1] = 500;
		arr[1][2] = 600;
		for(int i=0;i<2;i++) {//arr.length -> 행 길이를 구함
			for(int j=0;j<3;j++) {//arr.length -> 열 길이를 구함
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public void test5() {//가변배열
		//가변배열 -> 2차원 배열의 한 종류
		//		-> 일반 2차원 배열과의 차이점은 각 행별로 사용할 수 있는 열의 수가 다름
		//		-> 2차원 배열은 배열들을 배열로 관리하는 형태 -> 관리되는 각 배열의 길이가 다른 상태
		//가변배열 생성 방법은 최초 배열 생성 시 행의 길이만 입력하고 열의 길이는 입력안함
		int[][] arr = new int[3][];
		//실제로 배열 사용시에는 각 행별로 배열을 할당하고 사용해야함
		arr[0] = new int[5];
		arr[1] = new int[2];
		arr[2] = new int[3];
		arr[0][0] = 1;
		arr[0][1] = 2;
		arr[0][2] = 3;
		arr[0][3] = 4;
		arr[0][4] = 5;
		arr[1][0] = 6;
		arr[1][1] = 7;
		arr[2][0] = 8;
		arr[2][1] = 9;
		arr[2][2] = 10;
		for(int i=0;i<arr.length;i++) {//arr.length -> 행 길이를 구함
			for(int j=0;j<arr[i].length;j++) {//arr.length -> 열 길이를 구함
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}

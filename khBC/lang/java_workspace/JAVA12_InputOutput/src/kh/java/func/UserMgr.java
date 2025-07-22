package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.util.Scanner;

public class UserMgr {
	Scanner sc;
	User user;
	
	public UserMgr() {
		super();
		sc = new Scanner(System.in);
		user = null;
	}
	
	
	public void main() {
		while(true) {
			System.out.println("1.회원 정보 등록 ");
			System.out.println("2.회원 정보 출력 ");
			System.out.println("3.회원 정보 내보내기");
			System.out.println("4.회원 정보 불러오기");
			System.out.println("0. 종 료");
			System.out.println("선택 > > ");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertUser();
				break;
			case 2:
				printUser();
				break;
			case 3:
				exportUser2();
				break;
			case 4:
				importUser2();
				break;
			case 0 :
				return;
			default :
				break;
			}
		}//while()
	}//main()
	public void insertUser() {
		System.out.println("아이디 입력 : ");
		String id = sc.next();
		System.out.println("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.println("이름 입력 :");
		String name = sc.next();
		System.out.println("나이 입력 :");
		int age = sc.nextInt();
		User u = new User(id, pw, name, age);
		user = u;
		System.out.println("등록 완료");
	}//insertUser();
	
	public void printUser() {
		if (user == null) {
			System.out.println("회원 정보가 없습니다.");
		}else {
		System.out.println("아이디 : " +user.getId());
		System.out.println("비밀번호 : " +user.getPw());
		System.out.println("이름 : " +user.getName());
		System.out.println("나이 : " +user.getAge());
		}
	}

	public void exportUser() {
		//user에 들어있는 정보를 id/pw/name/age 형태로 문자열로 만들어서 backup.txt 파일에 저장
		if(user == null) {
			System.out.println("내보낼 정보가 없습니다.");
		}else {
			String exportData = user.getId()+"/"+user.getPw()+"/"+user.getName()+"/"+user.getAge();
			
			//내보낼 데이터는 아이디/ 비밀번호 / 이름 / 나이 형태의 문자열
			//Writer ( 문자열 )
			//0. 보조스트림 선언
			BufferedWriter bw = null;
			
			 
			try {
				FileWriter	fw = new FileWriter("backup.txt");
				//주 스트림을 이용해서 보조스트림 생성
				bw = new BufferedWriter(fw);
				//2. 메소드를 이용해 데이터 내보내기
				bw.write(exportData);
				System.out.println("내보내기 완료");
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}//catch();
			}//finally();
		}//else();
	}//export();
	public void importUser() {
		//backup.txt 파일의 데이터를 읽어옴
		//읽어온 데이터를 편집해서 전역변수 user에 데이터를 저장
		File checkFile = new File("backup.txt");
		if(checkFile.exists()) {
			//읽어올 데이터도 backup.txt 파일 내부에 있는 글씨
			
			//0.보조 스트림 선언
			BufferedReader br = null;
			try {
				FileReader fr = new FileReader("backup.txt");
				br = new BufferedReader(fr);
				//2. method 통해 데이터를 읽어오기
				String str = br.readLine();
				String[] arr = str.split("/");
				String id = arr[0];
				String pw = arr[1];
				String name = arr[2];
				int age = Integer.parseInt(arr[3]);
				User u = new User(id,pw,name,age);
				user = u;
				System.out.println("정보 불러오기 완료");
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//여기서 filenotfound 발생하여 읽어올 파일 없습니다 작성해도 됨.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else {
			System.out.println("읽어올 파일이 없습니다.");
		}
	}//import();
	
	public void exportUser2() {
		if(user == null) {
			System.out.println("내보낼 정보가 없습니다.");
		}else {
			//객체를 직렬화해서 내보내는 보조스트링
			ObjectOutputStream oos = null;
			
			try {
				//1. 데이터를 내보낼 주 스트림 생성
				FileOutputStream fos = new FileOutputStream("backup1.txt");
				//주 스트림을 이용해서 보조스트림 생성
				oos = new ObjectOutputStream(fos);
				//메소드를 이용하여 객체 내보내기
				oos.writeObject(user);
				System.out.println("객체 내보내기 완료");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}//exportUser2();
	
	public void importUser2() {
		File checkFile = new File("backup1.txt");
		if(checkFile.exists()) {
			//내보내진 객체를 읽어와서 역질렬화하는 보조스트림 선언
			ObjectInputStream ois = null;
			
			try {
				FileInputStream fis = new FileInputStream("backup1.txt");
				//주 스트림 이용해서 보조스트림 생성
				ois = new ObjectInputStream(fis);
				//downcasting 필요
				Object obj =  ois.readObject();
				//
				User u = (User)obj;
				user = u;
				System.out.println("가져오기 완료");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else {
			System.out.println("불러올 정보가 없습니다.");
		}
	}
}

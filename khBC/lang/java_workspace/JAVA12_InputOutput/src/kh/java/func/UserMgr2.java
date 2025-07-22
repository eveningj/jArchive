package kh.java.func;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMgr2 {

	ArrayList<User> list;
	Scanner sc;
	User user;

	public UserMgr2() {
		super();
		list = new ArrayList<User>();
		sc = new Scanner(System.in);
		user = null;
	}

	public void main() {
		while (true) {
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 회원 정보 출력");
			System.out.println("3. 회원 정보 백업");
			System.out.println("4. 회원 정보 불러오기");
			System.out.println("0. 간다");

			int select = sc.nextInt();
			switch (select) {
			case 1:
				insertUserInfo();
				break;
			case 2:
				printUserInfo();
				break;
			case 3:
				exportUserInfo();
				break;
			case 4:
				importUserInfo();
				break;
			case 0:
				return;
			}// switch
		} // while
	}// main()

	public void insertUserInfo() {
		System.out.println("아이디 입력 : ");
		String id = sc.next();
		System.out.println("비밀번호 입력 : ");
		String pw = sc.next();
		System.out.println("이름 입력 :");
		String name = sc.next();
		System.out.println("나이 입력 :");
		int age = sc.nextInt();
		User u = new User(id, pw, name, age);
		list.add(u);
		System.out.println("등록 완료");
	}// insertUser();

	public void printUserInfo() {
		if (list.isEmpty()) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.println("아이디\t비밀번호\t이름\t나이");
			for (User u : list) {
				System.out.println(u.getId() + "\t" + u.getPw() + "\t" + u.getName() + "\t" + u.getAge());
			}
		}
	}

	public void exportUserInfo() {
		if (list.size() == 0) {
			System.out.println("내보낼 정보가 없습니다.");
		} else {
			ObjectOutputStream oos = null;
			try {
				System.out.println("어떤 사용자의 정보를 내보내시겠습니까 (id) ? :");
				String searchId = sc.next();

				for (User u : list) {
					if (u.getId().equals(searchId)) {
						int searchIndex = list.indexOf(u);
						User searchUser = list.get(searchIndex);
						String backupID = searchUser.getId();
						FileOutputStream fos = new FileOutputStream(backupID + ".txt");
						oos = new ObjectOutputStream(fos);
						oos.writeObject(searchUser);
						System.out.println("정보 내보내기 완료");
						oos.close();
					}
				} // for
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// export();

	public void importUserInfo() {
		System.out.println("어떤 사용자의 정보를 불러오시겠습니까? (id) : ");
		String searchID = sc.next();

		File checkFile = new File(searchID + ".txt");

		if (checkFile.exists()) {
			ObjectInputStream ois = null;

			try {
				FileInputStream fis = new FileInputStream(searchID + ".txt");
				ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				User u = (User) obj;
				list.add(u);
				System.out.println("가져오기 완료");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("그런 ID 를 가진 사용자는 없습니다.");
		}
	}// import();

	public void exportAllUserInfo() {
		if (list.size() == 0) {
			System.out.println("내보낼 정보가 없습니다.");
		} else {
			ObjectOutputStream oos = null;
			try {
				FileOutputStream fos = new FileOutputStream("allBakup.txt");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				System.out.println("정보 내보내기 완료");
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
	}// exportAll();

	public void importAlluserInfo() {

		File checkFile = new File("allBakup.txt");

		if (checkFile.exists()) {
			ObjectInputStream ois = null;

			try {
				FileInputStream fis = new FileInputStream("allBakup.txt");
				ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				ArrayList<User> backupList = (ArrayList<User>)obj;
				//조건 -> User && ArrayList -> Serializeable
				list = backupList;
				System.out.println("가져오기 완료");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("그런 ID 를 가진 사용자는 없습니다.");
		}
	}// import();

	public void exporAlltUserInfo() {
		ObjectOutputStream oos = null;

		try {
			FileOutputStream fos = new FileOutputStream("allbackup.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
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
}

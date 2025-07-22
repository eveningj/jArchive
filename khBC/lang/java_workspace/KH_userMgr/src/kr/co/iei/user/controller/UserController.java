package kr.co.iei.user.controller;

import kr.co.iei.user.model.vo.User;

public class UserController {

	User userArr[];
	

	
	public UserController() {
		super();
		userArr = new User[10];
	}





public void exam() {


int index = 0;

User user1 = new User("user01", "1234", "유저1", 23, "01022478875");

User user2 = new User("user02", "1357", "유저2", 27, "01095887774");

User user3 = new User("user03", "2468", "유저3", 34, "01036425456");
//User user4 = new User("user04", "2468", "유저4", 35, "01036425456");

userArr[index++] = user1;

userArr[index++] = user2;

userArr[index++] = user3;

//userArr[index++] = user4;

System.out.println("아이디\t비밀번호\t이름\t나이\t전화번호");
for(int i=0;i<index;i++) {

System.out.println(userArr[i].getId()+"\t"+userArr[i].getPw()+"\t"+userArr[i].getName()+"\t"+userArr[i].getAge()+"\t"+userArr[i].getPhone());

}
System.out.printf("범위 : %d, 데이터 : %d", userArr.length, index);

}

}


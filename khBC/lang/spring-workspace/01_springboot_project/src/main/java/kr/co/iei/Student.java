package kr.co.iei;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Alias(value = "student")

public class Student {
	private String name;
	private int age;
	private String addr;
	
	public String getTestData() {
		return "TESTDATA";
	}
}

package prac02;

import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Phone[] phones = new Phone[2]; // {null,null}
		
		for (int i = 0; i < phones.length; i++) {
			
			System.out.print("이름과 전화번호 입력>>");
			String name = scanner.next();
			String tel = scanner.next();
			phones[i] = new Phone(name, tel);
		
		}
		
		for (Phone phone : phones) {
			// Phone phone = phone[0]
			String name = phone.getName();
			String tel = phone.getTel();
			System.out.println(name + "의 번호 " + tel);
		} 
		
		scanner.close();
	}

}

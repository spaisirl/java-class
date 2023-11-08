package ver03;

import java.util.Scanner;

public class PhoneBookMain {

	
	public static void main(String[] args) {
		
		PhoneBook book = new PhoneBook();
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		System.out.println("=====전화번호부 ver03=====");
		
		while (true) {
			System.out.println("----------------------");
			System.out.println("1.입력 2.전체조회 3.종료");
			System.out.println("---------------------");
			
			
				
			System.out.print("선택>");
			int choice = scanner.nextInt();
			scanner.nextLine();
				
			if (choice == 1) {
				System.out.print("이름:");
				String name = scanner.nextLine();
				System.out.print("전번:");
				String phonenum = scanner.nextLine();
				System.out.print("생일:");
				String birday = scanner.nextLine();
				
				PhoneInfo info = new PhoneInfo(name, phonenum, birday);
				book.addInfo(info);
				
				
			} else if(choice == 2) {
				
				book.showAll();
				
				
			} else if (choice == 3) {
				scanner.close();
				System.out.println("=====프로그램 종료=====");
				System.exit(0);
				
			}
		}	
		
		
	}
}

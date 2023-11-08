package ver05;

import java.util.Scanner;

public class PhoneBookMain {

	public static final int INPUT_TEST_DATA = 99;
	
	public static void main(String[] args) {
		
		PhoneBook book = new PhoneBook();
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		System.out.println("=====전화번호부 ver03=====");
		
		while (true) {
			
			MenuViewer.showMenu();
			
			System.out.print("선택>");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1 : {
				System.out.print("이름:");
				String name = scanner.nextLine();
				System.out.print("전번:");
				String phonenum = scanner.nextLine();
				System.out.print("생일:");
				String birday = scanner.nextLine();
				
				PhoneInfo info = new PhoneInfo(name, phonenum, birday);
				
				try {
					book.addInfo(info);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("저장용량이 다찼어요.");
				}
				break;
			}
			
			case 2 : {
				book.showAll();
				break;
			}
			
			case 3 : {
				scanner.close();
				System.out.println("=====프로그램 종료=====");
				System.exit(0);
				break;
			}
			
			
			case INPUT_TEST_DATA : {
				for (int i = 1; i <= 10; i++) {
					PhoneInfo infoTest = 
							new PhoneInfo("이름-" + i,
										  "전번-" + i,
										  "생일-" + i);
					book.addInfo(infoTest);
				
				}
				break;	
				
			
			} 
			
			/*	
			if (choice == 1) {
				System.out.print("이름:");
				String name = scanner.nextLine();
				System.out.print("전번:");
				String phonenum = scanner.nextLine();
				System.out.print("생일:");
				String birday = scanner.nextLine();
				
				PhoneInfo info = new PhoneInfo(name, phonenum, birday);
				
				try {
					book.addInfo(info);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("저장용량이 다찼어요.");
				}
				
			} else if(choice == 2) {
				
				book.showAll();
				
				
			} else if (choice == 3) {
				scanner.close();
				System.out.println("=====프로그램 종료=====");
				System.exit(0);
				
			}
			*/ 
			
			}	
		
		}
		
	} //main
	
}

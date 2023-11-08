package ver08;

import java.util.Scanner;

//추가과제 검색기능추가 - 3. 검색 : 이름은 중복되는 이름이 없게 한다. 중복되는 이름이 있다면, "사용중인 이름이 있습니다."
public class PhoneBookMain {
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static final int INPUT = 1;
	private static final int SHOW_ALL = 2;
	private static final int SEARCH = 3;
	private static final int MODIFY = 4;
	private static final int EXIT = 5;
	private static final int INPUT_TEST_DATA = 99;
	private static final int SCHOOL = 1;
	private static final int COMPANY = 2;
	
	public static void main(String[] args) {
		PhoneBook book = new PhoneBook();
		// scanner.nextInt() - 정수 읽기
		// scanner.nextLine() - 문자열 읽기
		
		System.out.println("===== 전화번호부 ver.08 =====");
		String name = "";
		
		while (true) {
			MenuViewer.showMenu();
			System.out.print("선택> ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case INPUT:
				
				MenuViewer.showSubMenu();
				System.out.print("세부선택> ");
				int subChoice = scanner.nextInt();
				scanner.nextLine();
				
				name = inputName();
				
				//이름 중복 확인 실행
				boolean isDup = book.isNameDup(name);
				if (isDup) {
					System.out.println(name + "(으)로 등록된 정보가 있습니다.");
					continue; //아래의 문장을 실행하지 않고, 반복한다. -> 메뉴로 돌아간다.
				}
				
				System.out.print("전번: ");
				String phoneNumber = scanner.nextLine();
				System.out.print("생일: ");
				String birthDay = scanner.nextLine();
				
				PhoneInfo info = null;
				switch (subChoice) {
					case SCHOOL:
						System.out.print("학교: ");
						String school = scanner.nextLine();
						info = new PhoneInfoSchool(name, phoneNumber, birthDay, school);
						break;
					case COMPANY:
						System.out.print("회사: ");
						String Company = scanner.nextLine();
						info = new PhoneInfoCompany(name, phoneNumber, birthDay, Company);
						break;
				}
				
				try {
					book.addInfo(info);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("저장 용량이 다 찼어요");
				}
				break;
			case SHOW_ALL:
				book.showAll();
				break;
			case SEARCH:
				name = inputName();
				/*
				System.out.println("이름>");
				String searchName = scanner.nextLine(); //이름을 입력받고, 입력 받은 이름을 정보를 불려와야 한다.  f(x) = 2x+1
				*/
				book.searchByName(name);
				break;
				
			case MODIFY:
				while(true) {	
					name = inputName();
					PhoneInfo existInfo = book.isExist(name);
				if (existInfo==null) {
					System.out.println(name + "의 정보가 존재하지 않습니다.");
					continue;
				} else {
					
					System.out.print("전번: ");
					phoneNumber = scanner.nextLine();
					System.out.print("생일: ");
					birthDay = scanner.nextLine();
					PhoneInfo modifyInfo = null;
					if (existInfo instanceof PhoneInfoSchool) {
						System.out.print("학교: ");
						String school = scanner.nextLine();
						modifyInfo = new PhoneInfoSchool(name, phoneNumber, birthDay, school);
					} else if (existInfo instanceof PhoneInfoCompany) {
						System.out.print("회사: ");
						String company = scanner.nextLine();
						modifyInfo = new PhoneInfoSchool(name, phoneNumber, birthDay, company);

					}
					
					book.modify(modifyInfo);
					System.out.println(name + "의 정보가 수정되었습니다.");
					break;
									
					}
					
				
				}
	
			case EXIT:
				scanner.close();
				System.out.println("===== 프로그램 종료 =====");
				System.exit(0);
				break;
			case INPUT_TEST_DATA:
				for (int i = 1; i <= 9; i++) {
					PhoneInfo infoTest = null;
					if (i % 2 == 0) {
						infoTest = 
								new PhoneInfoSchool("이름-" + i,
											  "전번-" + i,
											  "생일-" + i,
											  "학교-" + i);
					} else {
						infoTest = new PhoneInfoCompany("이름-" + i,
								  					"전번-" + i,
								  					"생일-" + i,
								  					"학교-" + i);
					} // if
					
					book.addInfo(infoTest);
				} // for
				
				break;
			}
			
			
		} // while
	} // main
	
	public static String inputName() {
		System.out.print("이름>");
		String name = scanner.nextLine();
		return name;
	}
	
	

}
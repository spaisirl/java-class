package prac04;

import java.util.Scanner;

public class PhoneManger {
	
	private Scanner scanner = new Scanner(System.in);
	private Phone[] phones = null;
	private static PhoneManger instance = new PhoneManger();
	private PhoneManger() {}
	
	public static PhoneManger getInstance() { 
		//PhoneManger pm = PhoneManger.getInstance(); pm.getInstance() 로 쓸 수 있다.
		return instance;
	}
	
	
	
	private void setCount() {
		System.out.println("인원수>>");
		int count = scanner.nextInt();
		phones = new Phone[count];
	} //인원수 
	
	private void inputData() {
		for (int i = 0; i <phones.length; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력)>>");
			String name = scanner.next();
			String tel = scanner.next();
			Phone p = new Phone(name, tel);
			phones[i] = p; //private Phone[] phones 안에 넣는다.
		}
		System.out.println("저장되었습니다...");
	}
	
	private void search() {
		while (true) {
			System.out.print("검색할 이름>>");
			String name = scanner.next();
			
			if(name.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			
			String tel = getTel(name);
			if (tel != null) {
				System.out.println(name + "의 번호는 " + tel + "입니다.");

			} else {
				System.out.println(name + "(이)가 없습니다.");
			}
		}
		
		
	}
		private String getTel(String name) {	
			for (Phone phone : phones) { 
				//Phone에 저장된 name, tel을 불려오기 위해 Phone phone : phones 을 이용.
				//String searchName = phone.getName(); 
				// name을 쓰고 싶지만 위에 name 을 쓰고 있기에 이름을 저장 할 새로운 변수 지정 
				if (phone.getName().equals(name)) {
				// equal 사용법 : "A".equals("a") -> A와 a를 비교한다.
				// if의 사용은 name과 searchName이 같다면, 번호를 불려오기 위함.
					//String tel = phone.getTel();
					// getTel();만 이용 시 String tel = (this).getTel();
					//System.out.println(name + "의 번호는 " + tel + "입니다.");
				
					return phone.getTel();
				} 
			}
			
			return null;
		}
		
		public void run() {
			setCount();
			inputData();
			search();
		}

}

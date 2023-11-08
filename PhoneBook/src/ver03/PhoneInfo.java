package ver03;

public class PhoneInfo {
	
		public String name;
		public String phoneNumber;
		public String birthday;
		
		
		public PhoneInfo(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
		
		public PhoneInfo(String name, String phoneNumber, String birthday) {
			
			this(name,phoneNumber);
			/*
			this.name = name;
			this.phoneNumber = phoneNumber;
			*/
			this.birthday = birthday;
		}
		
		public void showInfo() {
			
			System.out.println("이름: " + this.name);
			System.out.println("전번: " + this.phoneNumber);
			
			if (this.birthday != null) {
				
				System.out.println("생일: " + this.birthday);
			}
		}
		
}

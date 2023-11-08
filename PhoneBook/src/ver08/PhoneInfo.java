package ver08;

public class PhoneInfo {
	
		private String name;
		private String phoneNumber;
		private String birthday;		
		
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

			System.out.println("이름: " + name);
			System.out.println("전번: " + phoneNumber);

			if (this.birthday != null && !birthday.equals("")) {

				System.out.println("생일: " + birthday);
				
			}
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		

		

		
		

}

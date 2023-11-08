package ver09;

public class PhoneInfoSchool extends PhoneInfo {
	
		private String school;

		public PhoneInfoSchool(String name, String phoneNumber, String birthday, String school) {
			super(name, phoneNumber, birthday);
			this.school = school;
		}

		public String getSchool() {
			return school;
		}

		public void setSchool(String school) {
			this.school = school;
		}
		
		public void showInfoSchool() {
			showInfo();
			System.out.println("학교: " + school);
			System.out.println("-------------------------");
		}

		@Override
		public String toString() {
			return "PhoneInfoSchool [school=" + school + "]";
		}
		
}

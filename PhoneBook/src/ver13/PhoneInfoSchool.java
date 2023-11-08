package ver13;

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
		
		@Override
		public void showInfo() {
			super.showInfo(); //폰인포에 있는 쇼인포를 사용하겠다.
			System.out.println("학교: " + school);
			System.out.println("-------------------------");
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("PhoneInfoSchool");
			sb.append("[");
			sb.append("name=");
			sb.append(getName());
			sb.append(",phoneNumber=");
			sb.append(getPhoneNumber());
			sb.append(",birthDay=");
			sb.append(getBirthDay());
			sb.append(",school=");
			sb.append(getSchool());
			sb.append("]");
			return sb.toString();
		}
		
}

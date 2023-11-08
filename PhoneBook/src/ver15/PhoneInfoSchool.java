package ver15;

public class PhoneInfoSchool extends PhoneInfo {
	private String school;
	
	public PhoneInfoSchool(String name, String phoneNumber, 
							String birthDay, String school) {
		super(name, phoneNumber, birthDay);
		this.school = school;
	}
	
	
	public String getSchool() {
		return school;
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

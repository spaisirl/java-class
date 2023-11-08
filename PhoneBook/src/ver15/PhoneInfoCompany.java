package ver15;

public class PhoneInfoCompany extends PhoneInfo {
	
	private String company;
	
	public PhoneInfoCompany(String name, String phoneNumber, 
							String birthDay, String company) {
		super(name, phoneNumber, birthDay);
		this.company = company;
	}
	
	
	
	public String getCompany() {
		return company;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("PhoneInfoCompany");
		sb.append("[");
		sb.append("name=");
		sb.append(getName());
		sb.append(",phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(",birthDay=");
		sb.append(getBirthDay());
		sb.append(",company=");
		sb.append(getCompany());
		sb.append("]");
		return sb.toString();
	}

}

package ver16;

public abstract class PhoneInfo {
	private String name;
	private String phoneNumber;
	private String birthDay;
	
	// public PhoneInfo() { }
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public PhoneInfo(String name, String phoneNumber, String birthDay) {
		/*
		this.name = name;
		this.phoneNumber = phoneNumber;
		*/
		this(name, phoneNumber);
		this.birthDay = birthDay;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getBirthDay() {
		return birthDay;
	}
	
}

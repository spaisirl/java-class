package ver12;

public class PhoneInfoCompany extends PhoneInfo {
	
	private String Company;

	public PhoneInfoCompany(String name, String phoneNumber, String birthday, String Company) {
		super(name, phoneNumber, birthday);
		this.Company = Company;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + Company);
		System.out.println("-------------------------");
	}

	@Override
	public String toString() {
		return "PhoneInfoCompany [Company=" + Company + "]";
	}
	
	

}

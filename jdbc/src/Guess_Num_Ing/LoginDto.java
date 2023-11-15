package Guess_Num_Ing;

public class LoginDto {
	
	private static LoginDto instance = new LoginDto();
	public LoginDto() {};
	public static LoginDto getInstance() {
		return instance;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	private String id;
	private String pw;
	
	public LoginDto (String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
	
	@Override
	public String toString() {
		return "LoginDto [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}

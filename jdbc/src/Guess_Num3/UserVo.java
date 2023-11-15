package Guess_Num3;

public class UserVo {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	
	public UserVo() { }
	
	// getters
	public String getUserId() {
		return this.userId;
	}
	
	public String getUserPw() {
		return this.userPw;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}
	
	// setters
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
				+ "]";
	}

	public UserVo(String userId, String userPw, String userName, String userEmail) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	
	
}

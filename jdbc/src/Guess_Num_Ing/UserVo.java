package Guess_Num_Ing;

public class UserVo {

	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	
	private static UserVo instance = new UserVo();
	
	private UserVo() {
		
	}
	
	public static UserVo getInstance() {
		return instance;
	}
	
		// getter
		
		public String getUserId() {
			return this.userId;
		}

		public String getUserPw() {
			return userPw;
		}

		public String getUserName() {
			return userName;
		}


		public String getUserEmail() {
			return userEmail;
		}

		
		//setter
		
		public void setUserId(String userId) {
			if (userId != null && userId.length() <= 20) {
				this.userId = userId;
			}
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
			return "UserVo [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail="
					+ userEmail + "]";
		}
		
		//필드 생성
		public UserVo(String userId, String userPw, String userName, String userEmail) {
			super();
			this.userId = userId;
			this.userPw = userPw;
			this.userName = userName;
			this.userEmail = userEmail;
		}
		
		


		
}

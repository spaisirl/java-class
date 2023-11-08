package ver15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PhoneBookDao {
	
	// 싱글톤
	private static PhoneBookDao instance = new PhoneBookDao();
	private PhoneBookDao() {
		/* singleton */
	}
	public static PhoneBookDao getInstance() {
		return instance;
	} 
	
	// 접속 정보
	public static final String DIRVER_NAME = 
			"orcle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String ID = "USER01";
	public static final String PW = "1234";
	public static final String SCHOOL_TYPE = "1";
	public static final String COMPANY_TYPE = "2";
	
	// 접속 메서드
	
	public Connection getConnection() {
		
		try {
			Class.forName(DIRVER_NAME);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}

	// 닫기 메서드
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) try {rs.close();} catch (Exception e) {}
		if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
		if (conn != null) try {conn.close();} catch (Exception e) {}
	}

	
	// 입력 기능
	
	private boolean addInfo(PhoneInfo info) {
		
		//이름, 번호, 생일, 학교, 회사를 입력 가능하게
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(DIRVER_NAME);
			conn = DriverManager.getConnection(URL, ID, PW);
			String sql = "INSERT INTO TBL_PHONEINFO (NAME, PHONE_NUMBER, BIRTHDAY, "
					+ " SC_NAME, SC_TYPE)" 
					+ " VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getPhoneNumber());
			pstmt.setString(3, info.getBirthDay());
			if (info instanceof PhoneInfoSchool) {
				pstmt.setString(4, ((PhoneInfoSchool)info).getSchool());
				pstmt.setString(5, SCHOOL_TYPE);
			} else if (info instanceof PhoneInfoCompany) {
				pstmt.setString(4, ((PhoneInfoSchool)info).getSchool());
				pstmt.setString(5, COMPANY_TYPE);	
			}
			int count = pstmt.executeUpdate();
			if (count > 0 ) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (Exception e) {};
			if (conn != null) try {pstmt.close();} catch (Exception e) {};
		}
		
		
		
		try {
			conn = getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("INSERT INTO TBL_PHONEINFO(NAME, PHONE_NUMBER, BIRTHDAY, SC_NAME, SC_TYPE)");
			sb.append(" VALUES (?,?,?,?,?)");
			pstmt = conn.prepareStatement(sb.toString());
			// 데이터 바인딩
			pstmt.setString(1, info.getName());
			pstmt.setString(2, info.getPhoneNumber());
			pstmt.setString(3, info.getBirthDay());
			pstmt.setString(4, ((PhoneInfoSchool)info).getSchool());
			pstmt.setString(5, ((PhoneInfoCompany)info).getCompany());
			// 입력, 수정, 삭제 작업
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		return false;
	}
	
	
	// 수정 기능
	/*
	public void modifyInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	*/
	
	
	// 삭제 기능
	/*
	public boolean deleteInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	// 전체 조회
	
	// 검색
}

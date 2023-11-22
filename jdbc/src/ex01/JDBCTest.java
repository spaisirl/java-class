package ex01;

import java.sql.Connection; // 접속된 객체 (세션 - session)
import java.sql.DriverManager; // 접속 시도
import java.sql.PreparedStatement; // SQL 문장을 실행할 객체
import java.sql.ResultSet; // 결과가 담겨 있는 객체

public class JDBCTest {

	
		public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
		public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		public static final String ID = "USER01";
		public static final String PW = "1234";
		
		// 사용자 생성
		// CREATE USER USER01 IDENTIFIED BY 1234;
		
		// 권한 부여
		// GRANT CONNECT, RESOURCE TO USER01;
		
		/* 테이블 생성
		CREATE TABLE 테이블명 (
			컬럼명1 데이터타입(크기),
			컬러명2 데이터타입(크기)
		);
		
		CREATE TABLE TBL_SCORE(
			USERNAME VARCHAR2(50),
			SCORE NUMBER(10)
		);
		
		- 테이블 정보 (DESC: DESCRIBE(묘사하다))
		DESC TBL_SCORE;
		
		- 데이터 넣기(CREATE)
		INSERT INTO TBL_SCORE (USERNAME, SCORE)
		VALUES ('HONG', 300000);
		
		-넣은 데이터 확인 (READ)
		SELECT USERNAME, SCORE
		FROM TBL_SCORE;
		
		- 데이터 바구니 - VO(VALUE OBJECT), DTO (DATA TRANSFER OBJECT)
		
		Read
		SELECT 컬럼명 1, 컬러명 2, .....
		FROM 테이블명
		WHERE 조건
		[CREATE]
		INSERT INTO 테이블명 (컬럼명1, 컬럼명2, ....)
		VALUES (값1,값2, .....)
		[UPDATE]
		UPDATE 테이블명
		SET
		컬럼명1 = 값1,
		컬럼명2 = 값2,
		...
		WHERE 조건
		
		[DELETE]
		DELETE FROM 테이블명
		WHERE 조건
		
		*/
		
		public static void main(String[] args) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// 1.SQL Plus를 띄운다 - 메모리에 오라클 드라이버를 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 2. 접속
				 conn = DriverManager.getConnection(URL, ID, PW);
				System.out.println("conn:" + conn);
				//3. SQL 문장 작성
				//String sql = "SELECT SYSDATE FROM DUAL";
				String sql = "SELECT USERNAME, SOCRE FROM TBL_SCORE";
				
				// 4. 엔터를 칠 객체 얻어옴
				 pstmt =  conn.prepareStatement(sql);
				//5. 엔터를 치게 한다
				 rs = pstmt.executeQuery();
				// 6. 결과 도출
				while (rs.next() == true) {
					String username = rs.getString("USERNAME");
					int score = rs.getInt("SCORE");
					//String result = rs.getString("SYSDATE");
					//System.out.println("result:" + result);
					System.out.println(username + "|" + score);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			} finally {
				if (rs != null) try {rs.close();} catch (Exception e ) {};
				if (pstmt != null) try {rs.close();} catch (Exception e ) {};
				if (conn != null) try {rs.close();} catch (Exception e ) {};
			}
			
		}


}

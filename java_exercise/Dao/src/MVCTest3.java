import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MVCTest3 {
	public static void main(String[] args) {
		User u = new User("zxcv12", "1111", "홍길동", "aaa@aaa.com");

		System.out.println(u);

		updateUser(u); // 객체 u에 저장된 user_id와 동일한 행의 정보를 update하는 메서드

	}
	// 3. User객체를 매개변수로 받아 user_info테이블에서 해당 사용자의 정보를 update하는 updateUser메서드를 작성하시오.
	static int updateUser(User u) {
		// updateUser()메서드를 작성하시오.(PreparedStatement)
		Connection conn = null; // null로 초기화 한다.
		PreparedStatement pstmt = null;
		
		int result = 0;

		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "c##student"; // 사용자 계정
			String pw = "1234"; // 사용자 계정의 패스워드

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

			conn=DriverManager.getConnection(url,id,pw);  // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "update user_info set password=?, name=?, email=? where user_id = ?"; // sql 쿼리

			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt.setString(1, u.getPwd());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getId());

			result = pstmt.executeUpdate();	// 쿼리를 실행한다.

			System.out.println("user_info 테이블의 정보를 수정했습니다."); // 성공시 메시지 출력

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("user_info 테이블의 정보를 수정에 실패했습니다.");

		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {} // PreparedStatement 객체 해제

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {} // Connection 해제

		}
		return result;
	}

	// 2. User객체를 매개변수로 받아 DB의 user_info테이블에 insert하는 insertUser()메서드를 작성하시오.
	// (실제로 데이터가 잘저장되었는지 DB에서 확인하시오)
	static int insertUser(User u) {
		// insertUser()메서드를 작성하시오.(PreparedStatement)
		Connection conn = null; // null로 초기화 한다.
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "c##student"; // 사용자 계정
			String pw = "1234"; // 사용자 계정의 패스워드

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.

			conn=DriverManager.getConnection(url,id,pw);  // DriverManager 객체로부터 Connection 객체를 얻어온다.

			String sql = "insert into user_info(user_id, password, name, email) values(?,?,?,?)"; // sql 쿼리

			pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.

			pstmt.setString(1, u.getId());
			pstmt.setString(2, u.getPwd());
			pstmt.setString(3, u.getName());
			pstmt.setString(4, u.getEmail());

			result = pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("user_info 테이블에 새로운 레코드를 추가했습니다."); // 성공시 메시지 출력

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("user_info 테이블에 새로운 레코드 추가에 실패했습니다.");

		} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException sqle) {
				} // PreparedStatement 객체 해제

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException sqle) {
				} // Connection 해제

		}
		return result;
	}
}

// 1. user_info테이블에 mappping하기 위한 User클래스를 작성하하고 테스트 하시오.
class User {
	String id;
	String pwd;
	String name;
	String email;

	// 1.1 생성자를 적절히 작성하시오. - 이클립스의 기능이용(메뉴Source > Generate Constructor using
	// Fields...)
	public User(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	// 1.2 toString()을 오버라이딩 하시오 - 이클립스 기능이용
	@Override
	public String toString() {
		return getId() + "," + getPwd() + "," + getName() + "," + getEmail();
	}

	// 1.3 getter와 setter를 추가하시오. - 이클립스 기능이용
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
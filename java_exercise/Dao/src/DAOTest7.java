import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOTest7 {
	public static void main(String[] args) {

		UserDao udao = UserDao.getInstance();
		
		List<User> list = udao.selectAllUsers();
		System.out.println(list);
	}

}

final class UserDao {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스 로드에  실패했습니다.");
		}
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static UserDao ud = new UserDao();

	// 생성자
	private UserDao() {
	}

	// 메서드
	// 1) 인스턴스 생성한 것 가져오는 메서드
	public static UserDao getInstance() {
		if (ud == null) {
			ud = new UserDao();
		}
		return ud;
	} // getInstance()

	// 2) DB 연결하는 메서드
	private boolean connectDB() {
		boolean result = false;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
			String id = "c##student"; // 사용자 계정
			String pw = "1234"; // 사용자 계정의 패스워드

			conn = DriverManager.getConnection(url, id, pw);

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결에  실패했습니다.");
		}
		return result;
	} // connectDB()

	// 3) 연결 해제하는 메서드 
	private void close(AutoCloseable... acs) {
		try {
			for (int i = 0; i < acs.length; i++) {
				if (acs[i] != null)
					acs[i].close();
			}
		} catch (Exception e) {
		}

	} // close()
	
	// DB 사용
	// 6. user_info테이블에 있는 모든 행을 반환하는 selectAllUsers메서드
	public List<User> selectAllUsers() {
		ArrayList<User> userList = new ArrayList<User>(); // user정보 담을 리스트 생성

		// DB와 연결한다.
		if(connectDB()) {
			try {
				
				String sql = "select * from user_info"; // sql 쿼리
				pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
				
				rs = pstmt.executeQuery(); // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
				
				while (rs.next()) { // 결과를 한 행씩 돌아가면서 가져온다.
					String user_id = rs.getString("user_id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String email = rs.getString("email");
					// 가져온값들을 userList에 집어넣는다.
					userList.add(new User(user_id, password, name, email));
				}
				
			} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
				e.printStackTrace();
				System.out.println("user_info 테이블 호출에 실패했습니다.");
			} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다.
				close(rs, pstmt, conn);
			}
			
		}
		return userList;
		
	} // selectAllUsers()

	// 5. user_id를 매개변수로 받아 user_info테이블에서 해당 사용자의 정보를 삭제하는 deleteUser메서드
	public int deleteUser(String userId) {
		int result = 0;
		
		if(connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
				String id = "c##student"; // 사용자 계정
				String pw = "1234"; // 사용자 계정의 패스워드
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
				
				conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.
				
				String sql = "delete from user_info where user_id = ?"; // sql 쿼리
				
				pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
				
				pstmt.setString(1, userId);
				
				result = pstmt.executeUpdate(); // 쿼리를 실행한다.
				
				System.out.println("user_info 테이블의 정보를 삭제했습니다."); // 성공시 메시지 출력
				
			} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
				e.printStackTrace();
				System.out.println("user_info 테이블의 정보삭제에 실패했습니다.");
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
		}
		return result;
	}

	// 4. user_id를 매개변수로 받아 user_info테이블에서 해당 사용자의 정보를 가져오는 selectUser메서드를 작성하시오.
	public User selectUser(String userId) {
		User userData = null;
		
		if(connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
				String id = "c##student"; // 사용자 계정
				String pw = "1234"; // 사용자 계정의 패스워드
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
				
				conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.
				
				String sql = "select * from user_info where user_id = ?"; // sql 쿼리
				pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
				
				pstmt.setString(1, userId);
				
				rs = pstmt.executeQuery(); // 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.
				
				while (rs.next()) { // 결과를 한 행씩 돌아가면서 가져온다.
					String user_id = rs.getString("user_id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String email = rs.getString("email");
					userData = new User(user_id, password, name, email);
				}
				
			} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
				e.printStackTrace();
				System.out.println("user_info 테이블 호출에 실패했습니다.");
			} finally { // 쿼리가 성공 또는 실패에 상관없이 사용한 자원을 해제 한다. (순서중요)
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException sqle) {
					} // Resultset 객체 해제
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
		}
		return userData;
	}

	// 3. User객체를 매개변수로 받아 user_info테이블에서 해당 사용자의 정보를 update하는 updateUser메서드를 작성하시오.
	public int updateUser(User u) {
		int result = 0;
		
		if(connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
				String id = "c##student"; // 사용자 계정
				String pw = "1234"; // 사용자 계정의 패스워드
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
				
				conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.
				
				String sql = "update user_info set password=?, name=?, email=? where user_id = ?"; // sql 쿼리
				
				pstmt = conn.prepareStatement(sql); // prepareStatement에서 해당 sql을 미리 컴파일한다.
				pstmt.setString(1, u.getPwd());
				pstmt.setString(2, u.getName());
				pstmt.setString(3, u.getEmail());
				pstmt.setString(4, u.getId());
				
				result = pstmt.executeUpdate(); // 쿼리를 실행한다.
				
				System.out.println("user_info 테이블의 정보를 수정했습니다."); // 성공시 메시지 출력
				
			} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
				e.printStackTrace();
				System.out.println("user_info 테이블의 정보를 수정에 실패했습니다.");
				
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
		}
		return result;
	}

	// 2. User객체를 매개변수로 받아 DB의 user_info테이블에 insert하는 insertUser()메서드를 작성하시오.
	public int insertUser(User u) {
		int result = 0;
		
		if(connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // 사용하려는 데이터베이스명을 포함한 URL 기술
				String id = "c##student"; // 사용자 계정
				String pw = "1234"; // 사용자 계정의 패스워드
				
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
				
				conn = DriverManager.getConnection(url, id, pw); // DriverManager 객체로부터 Connection 객체를 얻어온다.
				
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
	public User() {
		this("aaaa", "1111", "김무명", "123@naver.com");
	}

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
		return getId() + "," + getPwd() + "," + getName() + "," + getEmail();// + "," + getInDate();
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
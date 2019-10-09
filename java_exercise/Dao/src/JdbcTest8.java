import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest8 {
	public static void main(String[] args) {
		UserDao udao = new UserDao();

		List<User> list = udao.selectAllUsers();
		System.out.println(list);

	} // main()�� ��

} // Ŭ������ ��

class Dao {
	Connection conn;
	String tableName = "";

	Dao() {
		this(null, "");
	}

	Dao(String tableName) {
		this(null, tableName);
	}

	Dao(Connection conn, String tableName) {
		this.tableName = tableName;
		this.conn = conn;
	}

	void rollback() {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {

			}
		}
	}

	void close(AutoCloseable... acs) {
		try {
			for (int i = 0; i < acs.length; i++) {
				if (acs[i] != null)
					acs[i].close();
			}
		} catch (Exception e) {
		}
	}
}

class UserDao extends Dao {
	// Ŭ���� �ε�� �ѹ��� ���ָ� �Ǵϱ�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ���� �ε� ���� : " + e.getMessage());
		}
	}

	PreparedStatement pstmt;
	ResultSet rs;

	// ������
	UserDao() {
		super(null, "user_info");
	}

	UserDao(Connection conn) {
		super(conn, "user_info");
	}

	// DB ����
	boolean connectDB() {
		boolean result = false;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // ����Ϸ��� �����ͺ��̽����� ������ URL ���
			String id = "c##student"; // ����� ����
			String pw = "1234"; // ����� ������ �н�����

			conn = DriverManager.getConnection(url, id, pw);

			result = true;
		} catch (Exception e) {
			System.out.println("���� ���� : " + e.getMessage());
		}
		return result;
	} // connectDB()

	// DB ���
	// 6. user_info���̺� �ִ� ��� ���� ��ȯ�ϴ� selectAllUsers�޼���
	public List<User> selectAllUsers() {
		ArrayList<User> userList = new ArrayList<User>(); // user���� ���� ����Ʈ ����

		// DB�� �����Ѵ�.
		if (connectDB()) {
			try {

				String sql = "select * from user_info"; // sql ����
				pstmt = conn.prepareStatement(sql); // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.

				rs = pstmt.executeQuery(); // ������ �����ϰ� ����� ResultSet ��ü�� ��´�.

				while (rs.next()) { // ����� �� �྿ ���ư��鼭 �����´�.
					String user_id = rs.getString("user_id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String email = rs.getString("email");
					// �����°����� userList�� ����ִ´�.
					userList.add(new User(user_id, password, name, email));
				}

			} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
				e.printStackTrace();
				System.out.println("user_info ���̺� ȣ�⿡ �����߽��ϴ�.");
			} finally { // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�.
				close(rs, pstmt, conn);
			}

		}
		return userList;

	} // selectAllUsers()

	// 5. user_id�� �Ű������� �޾� user_info���̺��� �ش� ������� ������ �����ϴ� deleteUser�޼���
	public int deleteUser(String userId) {
		int result = 0;

		if (connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // ����Ϸ��� �����ͺ��̽����� ������ URL ���
				String id = "c##student"; // ����� ����
				String pw = "1234"; // ����� ������ �н�����

				Class.forName("oracle.jdbc.driver.OracleDriver"); // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.

				conn = DriverManager.getConnection(url, id, pw); // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

				String sql = "delete from user_info where user_id = ?"; // sql ����

				pstmt = conn.prepareStatement(sql); // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.

				pstmt.setString(1, userId);

				result = pstmt.executeUpdate(); // ������ �����Ѵ�.

				System.out.println("user_info ���̺��� ������ �����߽��ϴ�."); // ������ �޽��� ���

			} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
				e.printStackTrace();
				System.out.println("user_info ���̺��� ���������� �����߽��ϴ�.");
			} finally { // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)

				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException sqle) {
					} // PreparedStatement ��ü ����

				if (conn != null)
					try {
						conn.close();
					} catch (SQLException sqle) {
					} // Connection ����

			}
		}
		return result;
	}

	// 4. user_id�� �Ű������� �޾� user_info���̺��� �ش� ������� ������ �������� selectUser�޼��带 �ۼ��Ͻÿ�.
	public User selectUser(String userId) {
		User userData = null;

		if (connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // ����Ϸ��� �����ͺ��̽����� ������ URL ���
				String id = "c##student"; // ����� ����
				String pw = "1234"; // ����� ������ �н�����

				Class.forName("oracle.jdbc.driver.OracleDriver"); // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.

				conn = DriverManager.getConnection(url, id, pw); // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

				String sql = "select * from user_info where user_id = ?"; // sql ����
				pstmt = conn.prepareStatement(sql); // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.

				pstmt.setString(1, userId);

				rs = pstmt.executeQuery(); // ������ �����ϰ� ����� ResultSet ��ü�� ��´�.

				while (rs.next()) { // ����� �� �྿ ���ư��鼭 �����´�.
					String user_id = rs.getString("user_id");
					String password = rs.getString("password");
					String name = rs.getString("name");
					String email = rs.getString("email");
					userData = new User(user_id, password, name, email);
				}

			} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
				e.printStackTrace();
				System.out.println("user_info ���̺� ȣ�⿡ �����߽��ϴ�.");
			} finally { // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException sqle) {
					} // Resultset ��ü ����
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException sqle) {
					} // PreparedStatement ��ü ����
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException sqle) {
					} // Connection ����
			}
		}
		return userData;
	}

	// 3. User��ü�� �Ű������� �޾� user_info���̺��� �ش� ������� ������ update�ϴ� updateUser�޼��带 �ۼ��Ͻÿ�.
	public int updateUser(User u) {
		int result = 0;

		if (connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // ����Ϸ��� �����ͺ��̽����� ������ URL ���
				String id = "c##student"; // ����� ����
				String pw = "1234"; // ����� ������ �н�����

				Class.forName("oracle.jdbc.driver.OracleDriver"); // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.

				conn = DriverManager.getConnection(url, id, pw); // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

				String sql = "update user_info set password=?, name=?, email=? where user_id = ?"; // sql ����

				pstmt = conn.prepareStatement(sql); // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
				pstmt.setString(1, u.getPwd());
				pstmt.setString(2, u.getName());
				pstmt.setString(3, u.getEmail());
				pstmt.setString(4, u.getId());

				result = pstmt.executeUpdate(); // ������ �����Ѵ�.

				System.out.println("user_info ���̺��� ������ �����߽��ϴ�."); // ������ �޽��� ���

			} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
				e.printStackTrace();
				System.out.println("user_info ���̺��� ������ ������ �����߽��ϴ�.");

			} finally { // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)

				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException sqle) {
					} // PreparedStatement ��ü ����

				if (conn != null)
					try {
						conn.close();
					} catch (SQLException sqle) {
					} // Connection ����

			}
		}
		return result;
	}

	// 2. User��ü�� �Ű������� �޾� DB�� user_info���̺� insert�ϴ� insertUser()�޼��带 �ۼ��Ͻÿ�.
	public int insertUser(User u) {
		int result = 0;

		if (connectDB()) {
			try {
				String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // ����Ϸ��� �����ͺ��̽����� ������ URL ���
				String id = "c##student"; // ����� ����
				String pw = "1234"; // ����� ������ �н�����

				Class.forName("oracle.jdbc.driver.OracleDriver"); // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.

				conn = DriverManager.getConnection(url, id, pw); // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

				String sql = "insert into user_info(user_id, password, name, email) values(?,?,?,?)"; // sql ����

				pstmt = conn.prepareStatement(sql); // prepareStatement���� �ش� sql�� �̸� �������Ѵ�.

				pstmt.setString(1, u.getId());
				pstmt.setString(2, u.getPwd());
				pstmt.setString(3, u.getName());
				pstmt.setString(4, u.getEmail());

				result = pstmt.executeUpdate(); // ������ �����Ѵ�.

				System.out.println("user_info ���̺� ���ο� ���ڵ带 �߰��߽��ϴ�."); // ������ �޽��� ���

			} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
				e.printStackTrace();
				System.out.println("user_info ���̺� ���ο� ���ڵ� �߰��� �����߽��ϴ�.");

			} finally { // ������ ���� �Ǵ� ���п� ������� ����� �ڿ��� ���� �Ѵ�. (�����߿�)

				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException sqle) {
					} // PreparedStatement ��ü ����

				if (conn != null)
					try {
						conn.close();
					} catch (SQLException sqle) {
					} // Connection ����

			}
		}
		return result;
	}

}

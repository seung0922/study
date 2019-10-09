import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOTest6 {
	public static void main(String[] args) {
		List<User> list = selectAllUsers();

		System.out.println(list);
	}

	// 6. user_info���̺� �ִ� ��� ���� ��ȯ�ϴ� selectAllUsers�޼���
	static List<User> selectAllUsers() {
		Connection conn = null; // null�� �ʱ�ȭ �Ѵ�.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>(); // user���� ���� ����Ʈ ����

		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; // ����Ϸ��� �����ͺ��̽����� ������ URL ���
			String id = "c##student"; // ����� ����
			String pw = "1234"; // ����� ������ �н�����

			Class.forName("oracle.jdbc.driver.OracleDriver"); // �����ͺ��̽��� �����ϱ� ���� DriverManager�� ����Ѵ�.

			conn = DriverManager.getConnection(url, id, pw); // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

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

		return userList;
	}

	// 5. user_id�� �Ű������� �޾� user_info���̺��� �ش� ������� ������ �����ϴ� deleteUser�޼���
	static int deleteUser(String userId) {
		Connection conn = null; // null�� �ʱ�ȭ �Ѵ�.
		PreparedStatement pstmt = null;

		int result = 0;

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
		return result;
	}

	// 4. user_id�� �Ű������� �޾� user_info���̺��� �ش� ������� ������ �������� selectUser�޼��带 �ۼ��Ͻÿ�.
	static User selectUser(String userId) {
		Connection conn = null; // null�� �ʱ�ȭ �Ѵ�.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User userData = null;

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
		return userData;
	}

	// 3. User��ü�� �Ű������� �޾� user_info���̺��� �ش� ������� ������ update�ϴ� updateUser�޼��带 �ۼ��Ͻÿ�.
	static int updateUser(User u) {
		// updateUser()�޼��带 �ۼ��Ͻÿ�.(PreparedStatement)
		Connection conn = null; // null�� �ʱ�ȭ �Ѵ�.
		PreparedStatement pstmt = null;

		int result = 0;

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
		return result;
	}

	// 2. User��ü�� �Ű������� �޾� DB�� user_info���̺� insert�ϴ� insertUser()�޼��带 �ۼ��Ͻÿ�.
	// (������ �����Ͱ� ������Ǿ����� DB���� Ȯ���Ͻÿ�)
	static int insertUser(User u) {
		// insertUser()�޼��带 �ۼ��Ͻÿ�.(PreparedStatement)
		Connection conn = null; // null�� �ʱ�ȭ �Ѵ�.
		PreparedStatement pstmt = null;
		int result = 0;

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
		return result;
	}
}

// 1. user_info���̺� mappping�ϱ� ���� UserŬ������ �ۼ����ϰ� �׽�Ʈ �Ͻÿ�.
class User {
	String id;
	String pwd;
	String name;
	String email;

	// 1.1 �����ڸ� ������ �ۼ��Ͻÿ�. - ��Ŭ������ ����̿�(�޴�Source > Generate Constructor using
	// Fields...)
	public User() {
		this("aaaa", "1111", "�蹫��", "123@naver.com");
	}

	public User(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	// 1.2 toString()�� �������̵� �Ͻÿ� - ��Ŭ���� ����̿�
	@Override
	public String toString() {
		return getId() + "," + getPwd() + "," + getName() + "," + getEmail();// + "," + getInDate();
	}

	// 1.3 getter�� setter�� �߰��Ͻÿ�. - ��Ŭ���� ����̿�
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
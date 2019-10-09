import java.sql.*;

public class DAOTest2 {
	public static void main(String[] args) {
		User u = new User("tmddnjs", "1122", "��¿�", "tmddnjs@naver.com");

		System.out.println(u);

		insertUser(u); // ��ü u�� ����� ���� DB�� user_info���̺� insert�ϴ� �޼���
		
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

			conn=DriverManager.getConnection(url,id,pw);  // DriverManager ��ü�κ��� Connection ��ü�� ���´�.

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
		return getId() + "," + getPwd() + "," + getName() + "," + getEmail();
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
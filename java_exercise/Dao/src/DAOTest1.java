
public class DAOTest1 {
	public static void main(String[] args) {
		User u = new User("ff22f", "1234", "���ü�", "aaa@aaa.com");

		System.out.println(u);

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
		return id + ", " + pwd + ", " + name + ", " + email;
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
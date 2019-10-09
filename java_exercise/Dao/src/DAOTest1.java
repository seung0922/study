
public class DAOTest1 {
	public static void main(String[] args) {
		User u = new User("ff22f", "1234", "남궁성", "aaa@aaa.com");

		System.out.println(u);

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
		return id + ", " + pwd + ", " + name + ", " + email;
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
package test0813;

// Q1-1. 두개의 정수 x,y를 저장하기 위한 인스턴스 변수가 선언된 Point클래스 정의
class Point {
	int x;
	int y;
	
	// Q1-4. x, y를 매개변수로 하는 생성자와 기본생성자(x,y를 모두 1로 초기화)를 추가
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point() {	// 기본생성자
		this(1, 1);
	}
	
	// Q1-3. Point클래스에 toString() 오버라이딩-> x와 y값을 포함한 문자열 반환
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
	
	// Q1-5. 두 점사이의 거리를 double타입의 값으로 계산해서 반환하는 static메서드 getDistance(Point p1, Point p2)를 추가
	static double getDistance(Point p1, Point p2) {
		// p1과 p2 사이의 거리
		int a = p1.x - p2.x;
		int b = p1.y - p2.y;
		return Math.sqrt(a*a + b*b);
	}
	
	// Q1-6. 두 점사이의 거리를 double타입의 값으로 계산해서 반환하는 getDistance(Point p)를 추가
	double getDistance(Point p) {
		// 인스턴스 변수 x,y와 매개변수 x,y 사이의 거리
		// cm -> im 호출(x), im -> cm 호출(o)
		// 중복되는 코드가 있으므로 줄임
		return getDistance(this, p);
	}
	
	// Q1-7. Point클래스의 equals()를 다음과 같은 조건으로 오버라이딩 하고 테스트하시오.
	// 1) 비교하는 객체가 Point객체가 아니면 false를 반환
	// 2) Point객체의 x와 y의 값이 같을 때만 true를 반환
	public boolean equals(Object obj) {
		// Point객체의 x,y와 비교하는 obj객체의 x,y를 비교위해서는 obj를 Point로 형변환하여 값을 비교해야한다.
		// Object 리모콘의 버튼이 더 적음(x,y 사용불가) Point 리모콘으로 바꿔야 x,y라는 버튼 사용가능
		if(obj instanceof Point)
			return (x == ((Point)obj).x) && (y == ((Point)obj).y);	// 조건식은 true아니면 false로 나옴
		else
			return false;	// Point로 형변환할 수 없다는 것은 Point객체가 아닌것
	}
	
}

// Q1-8. Point클래스를 상속받고 z를 인스턴스 변수로 갖는 Point3D클래스를 작성
class Point3D extends Point {
	int z;
	
	// Q1-9. Point3D클래스에 생성자 Point3D(int x, int y, int z)와 기본 생성자(x, y, z를 1로 초기화)를 추가
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	Point3D() {	// 기본생성자
		this(1, 1, 1);
	}
	
	// Q1-10. Point3D클래스의 toString()이 x, y, z의 값을 문자열로 반환하도록 오버라이딩 하시오.
	public String toString() {
		return super.toString() + ", z = " + z;
	}
}

// Q1-7 테스트해보기위한 클래스
class Test {
	int x = 3;
	int y = 5;
}
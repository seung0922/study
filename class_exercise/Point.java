package test0813;

// Q1-1. �ΰ��� ���� x,y�� �����ϱ� ���� �ν��Ͻ� ������ ����� PointŬ���� ����
class Point {
	int x;
	int y;
	
	// Q1-4. x, y�� �Ű������� �ϴ� �����ڿ� �⺻������(x,y�� ��� 1�� �ʱ�ȭ)�� �߰�
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Point() {	// �⺻������
		this(1, 1);
	}
	
	// Q1-3. PointŬ������ toString() �������̵�-> x�� y���� ������ ���ڿ� ��ȯ
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
	
	// Q1-5. �� �������� �Ÿ��� doubleŸ���� ������ ����ؼ� ��ȯ�ϴ� static�޼��� getDistance(Point p1, Point p2)�� �߰�
	static double getDistance(Point p1, Point p2) {
		// p1�� p2 ������ �Ÿ�
		int a = p1.x - p2.x;
		int b = p1.y - p2.y;
		return Math.sqrt(a*a + b*b);
	}
	
	// Q1-6. �� �������� �Ÿ��� doubleŸ���� ������ ����ؼ� ��ȯ�ϴ� getDistance(Point p)�� �߰�
	double getDistance(Point p) {
		// �ν��Ͻ� ���� x,y�� �Ű����� x,y ������ �Ÿ�
		// cm -> im ȣ��(x), im -> cm ȣ��(o)
		// �ߺ��Ǵ� �ڵ尡 �����Ƿ� ����
		return getDistance(this, p);
	}
	
	// Q1-7. PointŬ������ equals()�� ������ ���� �������� �������̵� �ϰ� �׽�Ʈ�Ͻÿ�.
	// 1) ���ϴ� ��ü�� Point��ü�� �ƴϸ� false�� ��ȯ
	// 2) Point��ü�� x�� y�� ���� ���� ���� true�� ��ȯ
	public boolean equals(Object obj) {
		// Point��ü�� x,y�� ���ϴ� obj��ü�� x,y�� �����ؼ��� obj�� Point�� ����ȯ�Ͽ� ���� ���ؾ��Ѵ�.
		// Object �������� ��ư�� �� ����(x,y ���Ұ�) Point ���������� �ٲ�� x,y��� ��ư ��밡��
		if(obj instanceof Point)
			return (x == ((Point)obj).x) && (y == ((Point)obj).y);	// ���ǽ��� true�ƴϸ� false�� ����
		else
			return false;	// Point�� ����ȯ�� �� ���ٴ� ���� Point��ü�� �ƴѰ�
	}
	
}

// Q1-8. PointŬ������ ��ӹް� z�� �ν��Ͻ� ������ ���� Point3DŬ������ �ۼ�
class Point3D extends Point {
	int z;
	
	// Q1-9. Point3DŬ������ ������ Point3D(int x, int y, int z)�� �⺻ ������(x, y, z�� 1�� �ʱ�ȭ)�� �߰�
	Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	Point3D() {	// �⺻������
		this(1, 1, 1);
	}
	
	// Q1-10. Point3DŬ������ toString()�� x, y, z�� ���� ���ڿ��� ��ȯ�ϵ��� �������̵� �Ͻÿ�.
	public String toString() {
		return super.toString() + ", z = " + z;
	}
}

// Q1-7 �׽�Ʈ�غ������� Ŭ����
class Test {
	int x = 3;
	int y = 5;
}
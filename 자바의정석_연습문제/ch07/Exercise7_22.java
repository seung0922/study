package ch07;

// Shape Ŭ������ �������� �ϴ� Circle Ŭ������ Rectangle Ŭ���� �ۼ�
class Circle extends Shape {
	double r;
	
	Circle() {	// �⺻������
		this(new Point(0,0), 0);
	}
	Circle(Point p, double r) {
		super(p);
		this.r = r;
	}
	
	double calcArea() {	// ������ ���� ����Ͽ� ��ȯ
		return Math.PI * r * r;
	}
}

class Rectangle extends Shape {
	double width;
	double height;
	
	Rectangle() {	// �⺻������
		this(new Point(0,0), 0, 0);
	}
	Rectangle(Point p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}
	
	double calcArea() {	// ������ ���� ����Ͽ� ��ȯ
		return width * height;
	}
	
	boolean isSquare() {	// ���簢������ �ƴ���
		return width == height;
	}
}

abstract class Shape {	// ������ ����
	Point p;

	Shape() {
		this(new Point(0, 0));
	}

	Shape(Point p) {
		this.p = p;
	}

	abstract double calcArea(); // ������ ������ ����ؼ� ��ȯ�ϴ� �޼���

	Point getPosition() {
		return p;
	}

	void setPosition(Point p) {
		this.p = p;
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0, 0);
	}

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}

class Exercise7_22 {
	public static void main(String[] args) {
		Point p = new Point(1,1);
		Rectangle r = new Rectangle(p, 4, 4);
		System.out.println(r.p);
		System.out.println(r.isSquare());
	}
}
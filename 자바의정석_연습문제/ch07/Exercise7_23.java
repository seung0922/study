package ch07;

// Shape Ŭ������ �������� �ϴ� Circle Ŭ������ Rectangle Ŭ���� �ۼ�
class Circle extends Shape {
	double r;
	
	Circle() {	// �⺻������
		this(0.0);
	}
	Circle(double r) {
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
		this(0.0, 0.0);
	}
	Rectangle(double width, double height) {
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

class Exercise7_23 {
	// �־��� �迭�� ��� �������� ���̸� ��� ���ؼ� ��ȯ�Ѵ�.
	static double sumArea(Shape[] arr) {
		double sum = 0.0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i].calcArea();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};
		System.out.println("������ �� : " + sumArea(arr));
	}
}
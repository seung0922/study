package test0813;


//Q1-2. Point Ŭ������ �׽�Ʈ�ϱ� ���� PointTestŬ���� �ۼ��ϰ�, Point��ü ����
public class PointTest {
	public static void main(String[] args) {
		Point p = new Point();
		
		// Q1-3. Point��ü�� x, y���� 3�� 5�� �ʱ�ȭ�ϰ� toString ȣ���Ͽ� x�� y���� ���
		p.x = 3;
		p.y = 5;
		System.out.println(p.x);
		System.out.println(p.y);
		
		// Q1-4 �׽�Ʈ
		Point p2 = new Point();		// �⺻������ - x=1, y=1
		System.out.println(p2.toString());
		
		Point p3 = new Point(6,7);	// x=6, y=7
		System.out.println(p3.toString());
		
		Point p4 = new Point(100,200);	// x=100, y=200
		System.out.println(p4.toString());
		
		Point p5 = new Point(0,0);		// x=0, y=0
		System.out.println(p5.toString());
		
		// Q1-5 �׽�Ʈ
		System.out.println(Point.getDistance(p, p2));	// p�� p2 ������ �Ÿ�
		System.out.println(Point.getDistance(p2, p3));	// p2�� p3 ������ �Ÿ�
		System.out.println(Point.getDistance(p3, p4));	// p3�� p4 ������ �Ÿ�
		System.out.println(Point.getDistance(p4, p5));	// p4�� p5 ������ �Ÿ�
		System.out.println(Point.getDistance(p5, p5));	// p5�� p5 ������ �Ÿ�
		
		// Q1-6 �׽�Ʈ
		System.out.println(p.getDistance(p2));			// p�� p2 ������ �Ÿ�
		System.out.println(p2.getDistance(p3));			// p2�� p3 ������ �Ÿ�
		System.out.println(p3.getDistance(p4));			// p3�� p4 ������ �Ÿ�
		System.out.println(p4.getDistance(p5));			// p4�� p5 ������ �Ÿ�
		System.out.println(p5.getDistance(p5));			// p5�� p5 ������ �Ÿ�
		
		// Q1-8, 9 �׽�Ʈ
		Point3D p3d = new Point3D();
		System.out.println(p3d.x + ", " + p3d.y + ", " + p3d.z);
		
		Point3D p3d2 = new Point3D(4,5,6);
		System.out.println(p3d2.x + ", " + p3d2.y + ", " + p3d2.z);
		
		Point3D p3d3 = new Point3D(100,200,300);
		System.out.println(p3d3.x + ", " + p3d3.y + ", " + p3d3.z);
		
		// Q1-10 �׽�Ʈ
		System.out.println(p3d.toString());
		System.out.println(p3d2.toString());
		System.out.println(p3d3.toString());
		
		// Q1-7 �׽�Ʈ (p�� x=3, y=5)
		System.out.println(p.equals(new Point(3,5)));
		System.out.println(p.equals(new Point(5,5)));
		System.out.println(p.equals(new Point3D(3,5,5)));
		System.out.println(p.equals(new Point3D(3,3,5)));
		
		Test t = new Test();	// x=3, y=5
		System.out.println(p.equals(t));
		
	}
}

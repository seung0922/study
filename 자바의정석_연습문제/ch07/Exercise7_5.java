package ch07;

class Product {
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ���� �� �����ϴ� ���ʽ�����
	
	// ����Ŭ������ Product Ŭ�������� �⺻������ �����ؾ���
	Product() {}
	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv extends Product {
	// �ݵ�� ������ ù�ٿ� �ٸ� ������ ȣ��
	// �׷��� ������ �����Ϸ��� super(); ȣ��
	// �׷��� ����Ŭ������ Product���� �⺻�����ڰ� ����
	// �׷��� �⺻�������� Product() {} �����������
	Tv() {
	}
	
	public String toString() {
		return "Tv";
	}
}

class Exercise7_5 {
	public static void main(String[] args) {
		Tv t = new Tv();
	}
}
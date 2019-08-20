package ch07;

class Exercise7_19 {
	public static void main(String args[]) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();
		
	}
}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // ������ ��ǰ�� �����ϱ� ���� �迭
	int i = 0; // Product�迭 cart�� ���� index

	void buy(Product p) {
		 /* 1.1 ���� ���� ������ ������ ���ؼ� ���� ���� ������ �޼��带 �����Ѵ�. 
		 * 1.2 ���� ���� ����ϸ�, ��ǰ�� ������ ���� ������ ���� 
		 * 1.3 ��ٱ��Ͽ� ������ ������ ��´�.(add�޼��� ȣ��) */
		if(money >= p.price) {
			money -= p.price;
			add(p);
		} else {
			System.out.println("�ܾ��� �����Ͽ�" + p + "��/�� �� �� �����ϴ�.");
		}
		
	}

	void add(Product p) {
		/* 1.1 i�� ���� ��ٱ����� ũ�⺸�� ���ų� ũ�� 
		 * 1.1.1 ������ ��ٱ��Ϻ��� 2�� ū ���ο� �迭�� �����Ѵ�. 
		 * 1.1.2 ������ ��ٱ����� ������ ���ο� �迭�� �����Ѵ�. 
		 * 1.1.3 ���ο� ��ٱ��Ͽ� ������ ��ٱ��ϸ� �ٲ۴�. 
		 * 1.2 ������ ��ٱ���(cart)�� �����Ѵ�. �׸��� i�� ���� 1 ������Ų��. */
		if(i>=cart.length) {
			Product[] cart2 = new Product[cart.length*2];
			for(int n=0; n<cart.length; n++) {
				cart2[n] = cart[n];
			}
			cart = cart2;
		}
		cart[i++] = p;
		
	} // add(Product p)

	void summary() {
		/* 1.1 ��ٱ��Ͽ� ��� ���ǵ��� ����� ����� ����Ѵ�. 
		 * 1.2 ��ٱ��Ͽ� ��� ���ǵ��� ������ ��� ���ؼ� ����Ѵ�. 
		 * 1.3 ������ ��� ���� �ݾ�(money)�� ����Ѵ�. */
		int sum = 0;
		
		System.out.print("������ ���� : ");
		for(int i=0; i<cart.length; i++) {
			System.out.print(cart[i] + ", ");
			sum += cart[i].price;
		}
		System.out.println();

		System.out.println("����� �ݾ� : " + sum);
		System.out.println("���� �ݾ� : " + money);
	} // summary()
}

class Product {
	int price; // ��ǰ�� ����

	Product(int price) {
		this.price = price;
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		super(50);
	}

	public String toString() {
		return "Audio";
	}
}

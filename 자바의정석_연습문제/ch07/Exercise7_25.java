package ch07;

class Outer {
	class Inner {
		int iv = 100;
	}
}

class Exercise7_25 {
	public static void main(String[] args) {
		// Outer Ŭ������ ���� Ŭ���� Inner�� ������� iv�� ���� ����Ͻÿ�.
		Outer o = new Outer();
		Outer.Inner oi = o.new Inner();
		System.out.println(oi.iv);
		
	}
}
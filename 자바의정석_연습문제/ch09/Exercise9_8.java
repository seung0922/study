package dd;

class Exercise9_8 {
	// �־��� ���� �ݿø��Ͽ�, �Ҽ��� ���� n�ڸ��� ���� ��ȯ
	// ex) n=3 �̸�, �Ҽ��� 4° �ڸ����� �ݿø��Ͽ� �Ҽ��� ���� 3�ڸ� �� ��ȯ
	static double round(double d, int n) {
		// Math.round()�� Math.pow() �̿�
		// Math.pow(��, ����) => �����Լ�
		// 1. �ݿø� �ϱ� ���� ���ϰ� ������ ���� ���� ���� 
		int m = (int) Math.pow(10, n);
		
		// 2. �־��� ���� m���� ���Ͽ� round�Լ��� �ݿø����ش�.
		d = d * m;
		d = Math.round(d);
		
		// 3. �ݿø��� ���� �ٽ� m���� ������.
		d = d / m;
		
		return d;
	}

	public static void main(String[] args) {
		System.out.println(Math.round(3.1415));
		
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}
}
package ch06;

class Exercise6_24 {
	// �־��� ���� ���밪�� ��ȯ�ϴ� �޼���
	static int abs(int value) {
		int result = 0;
		if(value<0) {
			result = -(value);
		} else {
			result = value;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int value = 5;
		System.out.println(value+"�� ���밪:"+abs(value));
		value = -10;
		System.out.println(value+"�� ���밪:"+abs(value));
	}
}
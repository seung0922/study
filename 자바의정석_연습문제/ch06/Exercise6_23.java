package ch06;

class Exercise6_23 {
	// �־��� int�� �迭�� �� �߿��� ���� ū �� ��ȯ
	// ���� �־��� �迭�� null�̰ų� ũ�Ⱑ 0�� ���, -999999�� ��ȯ
	static int max(int[] arr) {
		int max = 0;
		if(arr==null || arr.length==0) {
			max = -999999;
//			return max;
		} else {
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > max) {
					max = arr[i];
				}
			}
//			return max;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪:"+max(data));
		System.out.println("�ִ밪:"+max(null));
		System.out.println("�ִ밪:"+max(new int[]{})); // ũ�Ⱑ 0�� �迭
	}
}
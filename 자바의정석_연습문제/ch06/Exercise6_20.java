package ch06;

class Exercise6_20 {
	static int[] shuffle(int[] arr) {
		// �־��� �迭�� ��� ���� ��ġ�� �ٲٴ� �۾��� �ݺ��Ͽ� �ڼ���
		for(int i=0; i<arr.length; i++) {
			int x = (int)(Math.random()*arr.length);	// �� ��ȣ�ϱ�!
			int tmp = arr[i];
			arr[i] = arr[x];
			arr[x] = tmp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
package day2;

public class Arr1 {

	public static void main(String[] args) {
		// Q. �� �迭�� ������ Ȯ���ϼ���.
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
		
		// ó���� �Ѵ�. - �� �迭�� ������ Ȯ���Ѵ�.
		// ��� �� �迭�� ���ٰ� �ϴ°�?
		int i = 0;
		
		// ���ڰ� �ٸ��� �񱳸� �����.
		for(i=0; i<=2; i++) {
			if(arr1[i] != arr2[i]) {
				break;
			}
		}
		
		// ����� Ȯ���Ѵ�.
		// ���� ���� ����(cnt)�� �迭�� ����(arr1.length)�� ��ġ�ϸ� ������
		// i�� ���� arr1.length�� ���ٴ� ���� ��� ��ġ�Ѵٴ� ��
		if(i == arr1.length) {
			System.out.println("�����ϴ�.");
		} else {
			System.out.println("�ٸ��ϴ�.");
		}
		
		
	}

}

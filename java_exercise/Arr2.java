package day2;

public class Arr2 {

	public static void main(String[] args) {
		// Q2. �� �迭�� ���� ���ڰ� � �ִ��� ����ϼ���.
		int[] arr1 = {1,3,4};
		int[] arr2 = {2,3,4};
		
		// �� �迭�� ���� ���ڰ� � �ִ��� ���� ���� ����
		int cnt = 0;
		
		// �۾�ó��
		// ��� ����� �ϴ°�?
		// arr1�� �ϳ��� ���� arr2�� ��簪�� �˻��Ͽ� ���� ���ڸ� cnt++ (�ߺ�����)
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					cnt++;
					break;
				}
			}
		}
		
		// ����� Ȯ���Ѵ�.
		System.out.println("���� ������ ���� :" + cnt);
		
	}

}

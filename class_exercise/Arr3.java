package day2;

public class Arr3 {

	public static void main(String[] args) {
		// Q3. �� �迭�� ���� ���ڰ� ���� �� ��ġ�� ������ S, �ٸ��� B
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,3,5};
		
		int s = 0;	// ���ڰ� ���� ��ġ�� ���� ����
		int b = 0;	// ���ڰ� ���� ��ġ�� �ٸ� ���� ����
		
		// �۾�ó��
		// ��� ����� �ϴ°�?
		// arr1�� �ϳ��� ���� arr2�� ��簪�� �˻��Ͽ� ���� ���ڸ� cnt++ (�ߺ�����)
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1.length; j++) {
				// �� ���� ������
				if(arr1[i] == arr2[j]) {
					if(i==j) {	// ��ġ�� ������
						s++;
					} else {	// ��ġ�� �ٸ���
						b++;
					}
				}
			}
		}
		
		// ����� Ȯ���Ѵ�.
		System.out.println(s + "S" + b + "B");
		
	}

}

package day3;

public class Count {

	public static void main(String[] args) {
		int[] data = {4, 1, 7, 4, 1, 2, 1, 3, 6, 5, 8, 8};
		int[] cntArr = new int[10];
		
		// cntArr�� �� ���� ���� ī���� (0��° �ڸ��� 0����, 1��° �ڸ��� 1 ����, ..., 9��° �ڸ��� 9����)
		for(int i=0; i<data.length; i++) {
			cntArr[data[i]]++;
		}
		
		// cntArr �ߺ����� ���
		for(int i=0; i<cntArr.length; i++) {
			// �ش� �ε������� 0�̻��̸� �ش� �ε��� ���
			if(cntArr[i] > 0) { 
				System.out.printf("%2d", i);
			}
		}
		System.out.println();
		
		// cntArr ���� ���
		// cntArr �ش� �ε��� �ڸ��� �ִ� ���ڰ�����ŭ �ش� �ε��� �� ���
		for(int i=0; i<cntArr.length; i++) {
			for(int j=0; j<cntArr[i]; j++) {
				System.out.printf("%2d", i);
			}
		}
		
	}

}

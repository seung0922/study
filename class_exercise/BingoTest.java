package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BingoTest {
	//�־��� 2���� �迭���� ������ ������ ��� ��ȯ�ϴ� �޼��� �ۼ�
	int bingoCheck(int[][] arr) {
		int result = 0;
		int cntW = 0;	// ���� ī��Ʈ
		int cntH = 0;	// ���� ī��Ʈ
		int cntDiagR = 0;	// �����ʹ��� �밢�� ī��Ʈ
		int cntDiagL = 0;	// ���ʹ��� �밢�� ī��Ʈ
		
		for(int i=0; i<arr.length; i++) {
			cntW = 0;	// ���� ī��Ʈ �ʱ�ȭ
			cntH = 0;	// ���� ī��Ʈ �ʱ�ȭ
			for(int j=0; j<arr[i].length; j++) {
				// ����
				if(arr[i][j]==1) cntW++;
				
				//����
				if(arr[j][i]==1) cntH++;
				
				// ������ �밢��
				if(arr[i][j]==1 && i==j) cntDiagR++;
				
				// ���� �밢��
				if(arr[i][j]==1 && i+j==4) cntDiagL++;

			}
			// ���� ����
			if(cntW==5) result++;

			// ���� ����
			if(cntH==5) result++;
			
			// ������ ���� �밢�� ����
			if(cntDiagR==5) result++;
			
			// ���� ���� �밢�� ����
			if(cntDiagL==5) result++;
			
		}
		return result;
		
		// ����
//		for(int i=0; i<arr.length; i++) {
//			int cnt = 0;
//			for(int j=0; j<arr[i].length; j++) {
//				if(arr[i][j]==1) {
//					cnt++;
//				}
//			}
//			if(cnt==5) {
//				result++;
//			}
//		}
//		return result;
		
		// ����
//		for(int i=0; i<arr.length; i++) {
//			int cnt = 0;
//			for(int j=0; j<arr[i].length; j++) {
//				if(arr[j][i]==1) {
//					cnt++;
//				}
//			}
//			if(cnt==5) {
//				result++;
//			}
//		}
//		return result;
		
		// ������ �밢��
//		int cnt = 0;
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				if(i==j) {
//					if(arr[i][j]==1) {
//						cnt++;
//					}
//				}
//			}
//			if(cnt==5) {
//				result++;
//			}
//		}
//		return result;
		
		// ���� �밢��
//		int cnt = 0;
//		for(int i=0; i<arr.length; i++) {
//			for(int j=0; j<arr[i].length; j++) {
//				if(i+j==4) {
//					if(arr[i][j]==1) {
//						cnt++;
//					}
//				}
//			}
//			if(cnt==5) {
//				result++;
//			}
//		}
//		return result;
		
		
	}
	
	@Test
	void test() {
		int[][] arr = {
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,1}
		};
		
		assertTrue(bingoCheck(arr)==12);
	}
	
	@Test
	void test2() {
		int[][] arr = {
			{1,0,1,0,1},
			{1,0,1,0,1},
			{1,0,1,0,1},
			{1,0,1,0,1},
			{1,0,1,0,1}
		};
		
		assertTrue(bingoCheck(arr)==3);
	}
	
	@Test
	void test3() {
		int[][] arr = {
			{1,0,0,0,1},
			{0,1,0,1,0},
			{0,0,1,0,0},
			{0,1,0,1,0},
			{1,0,0,0,1}
		};
		
		assertTrue(bingoCheck(arr)==2);
	}
	
	@Test
	void test4() {
		int[][] arr = {
			{0,0,0,0,1},
			{0,0,0,1,0},
			{0,0,1,0,0},
			{0,1,0,0,0},
			{1,0,0,0,0},
		};
		
		assertTrue(bingoCheck(arr)==1);
	}

}

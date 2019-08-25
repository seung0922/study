package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BingoTest {
	//주어진 2차원 배열에서 빙고의 갯수를 세어서 반환하는 메서드 작성
	int bingoCheck(int[][] arr) {
		int result = 0;
		int cntW = 0;	// 가로 카운트
		int cntH = 0;	// 세로 카운트
		int cntDiagR = 0;	// 오른쪽방향 대각선 카운트
		int cntDiagL = 0;	// 왼쪽방향 대각선 카운트
		
		for(int i=0; i<arr.length; i++) {
			cntW = 0;	// 가로 카운트 초기화
			cntH = 0;	// 세로 카운트 초기화
			for(int j=0; j<arr[i].length; j++) {
				// 가로
				if(arr[i][j]==1) cntW++;
				
				//세로
				if(arr[j][i]==1) cntH++;
				
				// 오른쪽 대각선
				if(arr[i][j]==1 && i==j) cntDiagR++;
				
				// 왼쪽 대각선
				if(arr[i][j]==1 && i+j==4) cntDiagL++;

			}
			// 가로 빙고
			if(cntW==5) result++;

			// 세로 빙고
			if(cntH==5) result++;
			
			// 오른쪽 방향 대각선 빙고
			if(cntDiagR==5) result++;
			
			// 왼쪽 방향 대각선 빙고
			if(cntDiagL==5) result++;
			
		}
		return result;
		
		// 가로
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
		
		// 세로
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
		
		// 오른쪽 대각선
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
		
		// 왼쪽 대각선
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

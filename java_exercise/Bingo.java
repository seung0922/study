package day3;

public class Bingo {

	public static void main(String[] args) {
		// ctrl+/ 주석	// ctrl+shift+/ 멀티라인 주석
		// alt+up, down 행단위이동
		// ctrl+D 행삭제
		// ctrl+shift+F 자동정렬(들여쓰기)
		// alt+shif+A 컬럼편집
		// ctrl+sapce 자동완성
		// ctrl+F11 실행

		int[][] bingoArr = new int[5][5];
		// int cnt = 1;

		// bingoArr의 각 요소에 1~25를 순서대로 저장, 출력
		for (int i = 0; i < bingoArr.length; i++) {
			for (int j = 0; j < bingoArr[i].length; j++) {
				// 5*5 이므로 5개 단위로 끊어서 생각해보면 행은 5의 배수, 열은 그러한 5의 배수에 +1~+5
				bingoArr[i][j] = i * bingoArr.length + j + 1;
				// bingoArr[i][j] = cnt++;
				System.out.printf("%d\t", bingoArr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// bingoArr의 각 요소의 위치를 임의로 섞어서 출력
		for (int i = 0; i < bingoArr.length; i++) {
			for (int j = 0; j < bingoArr[i].length; j++) {
				int x = (int) (Math.random() * bingoArr.length);
				int y = (int) (Math.random() * bingoArr[i].length);
				bingoArr[i][j] = bingoArr[x][y];
				int tmp = bingoArr[i][j];
				bingoArr[x][y] = tmp;

				System.out.printf("%d\t", bingoArr[i][j]);
			}
			System.out.println();
		}
	}

}

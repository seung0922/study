package day3;

public class Bingo {

	public static void main(String[] args) {
		// ctrl+/ �ּ�	// ctrl+shift+/ ��Ƽ���� �ּ�
		// alt+up, down ������̵�
		// ctrl+D �����
		// ctrl+shift+F �ڵ�����(�鿩����)
		// alt+shif+A �÷�����
		// ctrl+sapce �ڵ��ϼ�
		// ctrl+F11 ����

		int[][] bingoArr = new int[5][5];
		// int cnt = 1;

		// bingoArr�� �� ��ҿ� 1~25�� ������� ����, ���
		for (int i = 0; i < bingoArr.length; i++) {
			for (int j = 0; j < bingoArr[i].length; j++) {
				// 5*5 �̹Ƿ� 5�� ������ ��� �����غ��� ���� 5�� ���, ���� �׷��� 5�� ����� +1~+5
				bingoArr[i][j] = i * bingoArr.length + j + 1;
				// bingoArr[i][j] = cnt++;
				System.out.printf("%d\t", bingoArr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// bingoArr�� �� ����� ��ġ�� ���Ƿ� ��� ���
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

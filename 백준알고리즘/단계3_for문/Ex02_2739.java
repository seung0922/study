package step03;

import java.util.Scanner;

// Q. �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷� �ۼ�

public class Ex02_2739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();	// �׽�Ʈ ���̽� ���� �����ϴ� ����
		
		for (int i = 0; i < cnt; i++) {	// ������ ���� �׽�Ʈ ���̽� ���� ��ŭ �ݺ�
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println(A + B);
		}
	}
}

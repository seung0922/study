package step02;

import java.util.Scanner;

// Q. �־��� �ð����� 45���� �� �ð� ��Ÿ����
// (24�ð� ǥ�� ���)
public class Ex04_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int h = sc.nextInt();
			// h �� 0~23, m�� 0~59
			int m = sc.nextInt();
			
			// 1. m���� 45�� ����
			m = m - 45;
			
			// 2. m�� 0���� ������ 60�� ���Ѵ�
			if(m<0) {
				if(h==0) { // �ð��� 0�ø� ������ 23�ð� �ǵ�������
					h = 23;
				} else { // 0�ð� �ƴϸ� 1�� ����
					h = h - 1;
				}
				m = 60 + m;
			}
			
			System.out.printf("%d %d", h, m);
			
		}
	}

}

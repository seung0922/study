package step02;

import java.util.Scanner;

// Q. �����̸� 1 �ƴϸ� 0�� ����ϴ� ���α׷�
// (������ ������ 4�� ����̸鼭, 100�� ����� �ƴҶ�,
//  �Ǵ� 400�� ����϶�) 
public class Ex03_2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int year = sc.nextInt();
			
			if((year%4==0 && year%100!=0) || year%400==0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}

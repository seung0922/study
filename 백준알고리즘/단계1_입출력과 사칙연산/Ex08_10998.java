package step01;

import java.util.Scanner;

//Q. �� ���� A�� B�� �Է¹��� ����, A*B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//(��, 0 < A,B < 10)

public class Ex08_10998 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if((num1 > 0 && num1 < 10) && (num2 > 0 && num2 < 10)) {
				System.out.println(num1 * num2);
			}
		}
	}
}

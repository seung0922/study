package step01;

import java.util.Scanner;

//Q. �� ���� A�� B�� �Է¹��� ����, A/B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//(��, 0 < A,B < 10)

public class Ex09_1008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			double num1 = sc.nextDouble();
			double num2 = sc.nextDouble();
			
			if((num1 > 0 && num1 < 10) && (num2 > 0 && num2 < 10)) {
				System.out.println(num1 / num2);
			}
		}
	}
}

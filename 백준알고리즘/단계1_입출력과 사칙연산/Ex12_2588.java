package step01;

import java.util.Scanner;


public class Ex12_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			// 1. num2�� ���� �ڸ��� ���Ѵ�.
			int units = num2%10;
			// 2. num2�� ���� �ڸ��� ���Ѵ�.
			int tens = (num2 - (num2/100*100))/10;
			// 3. num3�� ���� �ڸ��� ���Ѵ�.
			int hundreds = num2 / 100;
			
			// 4. num1�� num2�� ���� �ڸ� ���Ѵ�.
			System.out.println(num1*units);
			// 5. num1�� num2�� ���� �ڸ� ���Ѵ�.
			System.out.println(num1*tens);
			// 5. num1�� num2�� ���� �ڸ� ���Ѵ�.
			System.out.println(num1*hundreds);
			// 6. num1�� num2 ���Ѵ�.
			System.out.println(num1 * num2);

		} // while
	} // main
}

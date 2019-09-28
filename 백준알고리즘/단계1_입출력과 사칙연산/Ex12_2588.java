package step01;

import java.util.Scanner;


public class Ex12_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			// 1. num2의 일의 자리를 구한다.
			int units = num2%10;
			// 2. num2의 십의 자리를 구한다.
			int tens = (num2 - (num2/100*100))/10;
			// 3. num3의 백의 자리를 구한다.
			int hundreds = num2 / 100;
			
			// 4. num1과 num2의 일의 자리 곱한다.
			System.out.println(num1*units);
			// 5. num1과 num2의 십의 자리 곱한다.
			System.out.println(num1*tens);
			// 5. num1과 num2의 백의 자리 곱한다.
			System.out.println(num1*hundreds);
			// 6. num1과 num2 곱한다.
			System.out.println(num1 * num2);

		} // while
	} // main
}

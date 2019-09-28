package step01;

import java.util.Scanner;

//Q. 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 
// (단, 1 ≤ A, B ≤ 10,000)

public class Ex10_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if((num1 > 0 && num1 < 10000) && (num2 > 0 && num2 < 10000)) {
				System.out.println(num1 + num2);
				System.out.println(num1 - num2);
				System.out.println(num1 * num2);
				System.out.println(num1 / num2);
				System.out.println(num1 % num2);
			}
		}
	}
}

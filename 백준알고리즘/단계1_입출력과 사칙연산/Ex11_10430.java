package step01;

import java.util.Scanner;

//Q. (A+B)%C는 (A%C + B%C)%C 와 같을까?
//   (A×B)%C는 (A%C × B%C)%C 와 같을까?
//   세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
//   (단, 2 ≤ A, B, C ≤ 10000)

public class Ex11_10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			int num3 = sc.nextInt();

			System.out.println( (num1+num2) % num3 );
			System.out.println( (num1%num3 + num2%num3)%num3 );
			System.out.println( (num1*num2)%num3 );
			System.out.println( (num1%num3 * num2%num3)%num3 );
			}
		}
}

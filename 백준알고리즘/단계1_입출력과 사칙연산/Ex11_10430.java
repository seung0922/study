package step01;

import java.util.Scanner;

//Q. (A+B)%C�� (A%C + B%C)%C �� ������?
//   (A��B)%C�� (A%C �� B%C)%C �� ������?
//   �� �� A, B, C�� �־����� ��, ���� �� ���� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//   (��, 2 �� A, B, C �� 10000)

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

package step02;

import java.util.Scanner;

// Q. �� ���� ��
public class Ex01_1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			// 1. A�� B���� ū ��쿡�� '>'�� ����Ѵ�.
			if(num1 > num2) System.out.println(">");
			// 2. A�� B���� ���� ��쿡�� '<'�� ����Ѵ�.
			else if(num1 < num2) System.out.println("<");
			// 3. A�� B�� ���� ��쿡�� '=='�� ����Ѵ�.
			else System.out.println("==");
		}
	}

}

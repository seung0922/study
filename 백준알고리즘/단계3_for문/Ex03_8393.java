
package step03;

import java.util.Scanner;

// Q. n�� �־����� ��, 1���� n���� ���� ���ϴ� ���α׷��� �ۼ�

public class Ex03_8393 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
}

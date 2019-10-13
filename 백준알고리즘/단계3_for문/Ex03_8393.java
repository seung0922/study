
package step03;

import java.util.Scanner;

// Q. n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성

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

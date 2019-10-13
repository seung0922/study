package step03;

import java.util.Scanner;

// Q. N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성

public class Ex01_10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			
			for(int i=1; i<=9; i++) {
				System.out.printf("%d * %d = %d%n", n, i, n*i);
			}
		}
	}

}

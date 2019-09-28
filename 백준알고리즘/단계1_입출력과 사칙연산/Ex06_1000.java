package step01;

import java.util.Scanner;

// Q. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
// (단, 0 < A,B < 10)

public class Ex06_1000 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if( (num1 > 0 && num1 < 10) && (num2 > 0 && num2 < 10) ) {
				System.out.println(num1 + num2);
			}
		}
	}

}

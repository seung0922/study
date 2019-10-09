package step02;

import java.util.Scanner;

// Q. 윤년이면 1 아니면 0을 출력하는 프로그램
// (윤년은 연도가 4의 배수이면서, 100의 배수가 아닐때,
//  또는 400의 배수일때) 
public class Ex03_2753 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int year = sc.nextInt();
			
			if((year%4==0 && year%100!=0) || year%400==0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

}

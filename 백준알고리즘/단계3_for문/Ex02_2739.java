package step03;

import java.util.Scanner;

// Q. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램 작성

public class Ex02_2739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();	// 테스트 케이스 개수 저장하는 변수
		
		for (int i = 0; i < cnt; i++) {	// 위에서 받은 테스트 케이스 개수 만큼 반복
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println(A + B);
		}
	}
}

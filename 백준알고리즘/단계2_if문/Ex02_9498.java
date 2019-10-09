package step02;

import java.util.Scanner;

// Q. 시험 점수를 입력받아 출력
public class Ex02_9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int score = sc.nextInt();
			score = score / 10;

			switch (score) {
				case 10: case 9:
					System.out.println("A");
					break;
				case 8:
					System.out.println("B");
					break;
				case 7:
					System.out.println("C");
					break;
				case 6:
					System.out.println("D");
					break;
				default:
					System.out.println("F");
					break;
			}

		}
	}

}

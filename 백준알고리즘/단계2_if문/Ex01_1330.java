package step02;

import java.util.Scanner;

// Q. 두 수를 비교
public class Ex01_1330 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			// 1. A가 B보다 큰 경우에는 '>'를 출력한다.
			if(num1 > num2) System.out.println(">");
			// 2. A가 B보다 작은 경우에는 '<'를 출력한다.
			else if(num1 < num2) System.out.println("<");
			// 3. A와 B가 같은 경우에는 '=='를 출력한다.
			else System.out.println("==");
		}
	}

}

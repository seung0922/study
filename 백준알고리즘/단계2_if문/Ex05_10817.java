package step02;

import java.util.Scanner;

// Q. �� ���� �־����� �� �ι�°�� ū ���� ���
public class Ex05_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			// 1. �� ���� �� �Է¹޴´�.
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			
			int mid = 0;
			
			if(n1 >= n2 && n2 >= n3) mid = n2;
			else if(n1 >= n3 && n3 >= n2) mid = n3;
			else if(n2 >= n1 && n1 >= n3) mid = n1;
			else if(n2 >= n3 && n3 >= n1) mid = n3;
			else if(n3 >= n1 && n1 >= n2) mid = n1;
			else if(n3 >= n2 && n2 >= n1) mid = n2;
			
			System.out.println(mid);
		}
	}

}

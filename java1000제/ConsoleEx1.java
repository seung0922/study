package java1000;

import java.util.Scanner;

// Q1. ������ �����ϸ� '>>'�� ���� ������Ʈ�� ��Ÿ���� ������� �Է��� ��ٸ���,
// ����ڰ� �Է��� ������ ȭ�鿡 ����Ѵ�. ���� ����ڰ� 'q' �Ǵ� 'Q'�� �Է��ϸ� ���α׷��� ����


class ConsoleEx1 {
	public static void main(String[] args) {
		while (true) {
			String prompt = ">>";
			System.out.print(prompt);
			
			// 1. ȭ�����κ��� ���δ����� �Է¹޴´�. - java.util.ScannerŬ���� ��� 
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			// 2. q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�.
			if(input.equals("q") || input.equals("Q")) {
				System.exit(0);
			}
			
			// ȭ�鿡 ���
			System.out.println(input);
			
		} // while(true)
		
	} // main
	
} // class

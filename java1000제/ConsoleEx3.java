package java1000;

import java.util.*;

// Q2. ����ڰ� �Է��� ��ɶ����� ������ �����ϴ� save(String input)�޼����
// ����ڰ� �Է��� ��ɶ����� �̷��� �����ִ� history()�޼��带 �ϼ��ϼ���.

class ConsoleEx3 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue)
	static final int MAX_SIZE = 5; // q(ť)�� ����� �� �ִ� ���� ����

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // �ѹ��� �����ؼ� �����ϸ� �ǹǷ� �ݺ��� ������ �̵�
		
		while (true) {
			String prompt = ">>";
			System.out.print(prompt);

			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			String input = s.nextLine();

			save(input);

			input = input.trim(); // �Է¹��� ������ ���ʿ��� �յ� ������ �����Ѵ�.
			argArr = input.split(" +");

			String command = argArr[0].trim();

			if ("".equals(command))
				continue;
			
			command = command.toLowerCase(); // ��ɾ �ҹ��ڷ� �ٲ۴�.

			if (command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�.
				System.exit(0);
			} else if (command.equals("history")) { // equalsIgnoreCase��� equals�� ���.
				history();
			} else {
				for (int i = 0; i < argArr.length; i++) {
					System.out.println(argArr[i]);
				}
			}
		} // while(true)
	} // main

	// ����ڰ� �Է��� ��ɶ����� ������ �����ϴ� �޼���
	public static void save(String input) {
		// ���� null�̰ų� �����̸� �������
		if (input == null || "".equals(input))
			return;

		// 1. queue�� �����Ѵ�.
		q.add(input);
		
		// 2. queue�� �ִ�ũ��(MAX_SIZE)�� ������ ���� ������ ���尪�� �����Ѵ�.
		// queue�� size�� MAX_SIZE ���� ũ�� �Ǹ� ù��° ��� ����
		if(q.size() > MAX_SIZE) {
			q.remove();
		}
	}

	// ����ڰ� �Է��� �ֱ� ����� �����ִ� �޼���
	public static void history() {
		int i = 0;

		// 1. LinkedList�� ����� ����(�ֱ� MAX_SIZE���� ��ɾ�)�� �����ش�.
		for(i=0; i<MAX_SIZE; i++) {
			System.out.println(q.get(i));
		}
	}
} // class

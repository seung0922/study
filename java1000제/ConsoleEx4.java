package java1000;

import java.util.*;
import java.io.*;

// Q4. ����� �Է��� �޴� ������Ʈ�� ���� �۾����� ����(���丮)�� ��θ� ǥ��
class ConsoleEx4 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue)
	static final int MAX_SIZE = 5; // Queue�� �ִ� 5�������� ����ǵ��� �Ѵ�.

	static File curDir; // ���� ���丮

	static {

		// 2. 1�� �ڵ带 ������ ����ó���ϼ���.
		try {
			// 1. �ý��ۼӼ� "user.dir"���� �о File��ü�� �����, curDir�� �Ҵ��ϼ���.
			curDir = new File(System.getProperty("user.dir"));
//			curDir = new File("C:\\Users\\5CLASS-184\\20190805\\java1000\\src\\java1000");
		} catch(Exception e) {
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); // �ѹ��� �����ؼ� �����ϸ� �ǹǷ� �ݺ��� ������ �̵�

		while (true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
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
				} else if (command.equals("history")) {
					history();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				System.out.println("�Է¿����Դϴ�.");
			}
		} // while(true)
	} // main

	public static void save(String input) {
		if (input == null || "".equals(input))
			return;

		q.add(input); // queue�� �����Ѵ�.

		// queue�� �ִ�ũ�⸦ ������ ���� ������ ���尪�� �����Ѵ�.
		if (((LinkedList) q).size() > MAX_SIZE)
			q.remove();
	}

	public static void history() {
		int i = 0;

		// LinkedList�� ������ �����ش�.
		ListIterator it = q.listIterator();

		while (it.hasNext()) {
			System.out.println(++i + "." + it.next());
		}
	}
} // class

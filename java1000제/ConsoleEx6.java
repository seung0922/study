package java1000;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ConsoleEx6 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue)
	static final int MAX_SIZE = 5; // Queue�� �ִ� 5�������� ����ǵ��� �Ѵ�.

	static File curDir;

	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
//			curDir = new File(System.getProperty("C:\\Users\\dltdl\\eclipse-workspace\\java1000\\src\\java1000"));
		} catch (Exception e) {
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
				} else if (command.equals("dir")) {
					dir();
				} else if (command.equals("type")) {
					type();
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
		/* ���� ���� */
	}

	public static void history() {
		/* ���� ���� */

	}

	public static void dir() {
		String pattern = "";

		switch (argArr.length) {
		case 1:
			for (File f : curDir.listFiles()) {
				if (f.isDirectory()) {
					System.out.println("[" + f.getName() + "]");
				} else {
					System.out.println(f.getName());
				}
			}
			break;
		case 2:
			pattern = argArr[1];
			pattern = pattern.toUpperCase();
			pattern = pattern.replace(".", "\\.");
			pattern = pattern.replace("*", ".*");
			pattern = pattern.replace("?", ".{1}");

			Pattern p = Pattern.compile(pattern);

			for (File f : curDir.listFiles()) {
				String tmp = f.getName().toUpperCase();
				Matcher m = p.matcher(tmp);

				if (m.matches()) {
					if (f.isDirectory()) {
						System.out.println("[" + f.getName() + "]");
					} else {
						System.out.println(f.getName());
					}
				}
			} // for

			break;
		default:
			System.out.println("USAGE : dir [FILENAME]");
		} // switch
	} // dir()

	public static void type() throws IOException {
		if (argArr.length != 2) {
			System.out.println("Usage : type FILE_NAME");
			return;
		}

		String fileName = argArr[1];

		File tmp = new File(fileName);

		// 1. ����(tmp)�� �����ϴ��� Ȯ���ϰ�,
		if(tmp.exists()) {
			// 1.1 �����ϸ�, ������ ������ ȭ�鿡 ����Ѵ�.
			// (FileReader�� BufferedReader�� ���)
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			for(int i=1; (line=br.readLine()) != null; i++) {
				System.out.println(line);
			}
		} else {
			// �������� ������, �������� �ʴ� �����̶�� ����Ѵ�.
			System.out.println("�������� �ʴ� �����Դϴ�.");
		}

		return;
	}
} // class

package java1000;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Q5. ���� ���丮�� ���ϰ� ���丮�� ����� �����ִ� ��ɾ� dir�� ����
// dir�� �Է��ϸ� ��� ���ϰ� ���丮��, dir *ex?.*�� ���� ������ �Է��ϸ�
// ���ϰ� ��ġ�ϴ� ���� �Ǵ� ���丮�� ����� ��������Ѵ�.
// (���Ͽ��� '*'�� '?'�� ���ϵ� ī��� '*'�� ������ ���� ���ڰ� �� �� ������, '?'�� ������ �ѱ��ڸ� �ǹ��Ѵ�.
// ����â���� dir��ɰ� ���ϵ�ī�带 �׽�Ʈ �غ��� �Ȱ��� ����� ������ ��������.)

class ConsoleEx5 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue)
	static final int MAX_SIZE = 5; // Queue�� �ִ� 5�������� ����ǵ��� �Ѵ�.

	static File curDir;

	static {
		try {
//			curDir = new File(System.getProperty("user.dir"));
			curDir = new File("C:\\Users\\5CLASS-184\\20190805\\java1000\\bin\\java1000");
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

		q.offer(input); // queue�� �����Ѵ�.

		// queue�� �ִ�ũ�⸦ ������ ���� ������ ���尪�� �����Ѵ�.
		if (((LinkedList) q).size() > MAX_SIZE)
			q.remove();
	}

	public static void history() {
		int i = 0;

		// LinkedList�� ������ �����ش�.
		LinkedList tmp = (LinkedList) q;
		ListIterator it = tmp.listIterator();

		while (it.hasNext()) {
			System.out.println(++i + "." + it.next());
		}
	}

	public static void dir() {
		String pattern = "";
		File[] fArr = curDir.listFiles();

		switch (argArr.length) {
			case 1: // dir�� �Է��� ��� ���� ���丮�� ��� ���ϰ� ���丮�� �����ش�.
	
				// 1. �ݺ����� �̿��ؼ� ������丮�� ��� ������ ����� ����Ѵ�. (FileŬ������ listFiles()���)
	
				for (int i = 0; i < fArr.length; i++) {
					// 2. ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.
					// (FileŬ������ isDirectory()�� ����ؼ� üũ)
					String fileName = fArr[i].getName();
					
					if(fArr[i].isDirectory()) {
						System.out.println("[" + fileName + "]");
					} else {
						System.out.println(fileName);
					}
				}
	
				break;
	
			case 2: // dir�� ������ ���� �Է��� ���, ���� ��� dir *.class

				pattern = argArr[1];
				pattern = pattern.toUpperCase(); // ���Ͽ��� ��ҹ��ڸ� �������� �ʵ��� �빮�ڷ� �����Ѵ�.
	
				// 1. �Էµ� ����(pattern)�� ���Խ� ǥ��(Regular Expression)�� �˸°� ġȯ�Ѵ�.
				// StringŬ������ String replace(CharSequence target, CharSequence replacement)�������.
				// ���� ���, pattern = pattern.replace("A","AA")�� pattern�� "A"�� "AA"�� ġȯ�Ѵ�.
				
				pattern = pattern.replace(".","\\."); 
				pattern = pattern.replace("*",".*"); 
                pattern = pattern.replace("?",".{1}");

				Pattern p = Pattern.compile(pattern); 
				
				// 2. �ݺ����� �̿��ؼ� ���� ���丮 ��, �Էµ� ���ϰ� ��ġ�ϴ� �͵鸸 ����Ѵ�.
				// �̶�, ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.
				// FileŬ������ isDirectory()�� ����ؼ� üũ)
				// ��ҹ��ڱ����� ���� �ʱ� ���ؼ�, ���ϰ� ���������� �����̳� ���丮���� �빮�ڷ� �����ؾ��Ѵ�.
				// String tmp = f.getName().toUpperCase();
				
				for (int i = 0; i < fArr.length; i++) {
					String fileName = fArr[i].getName();
					String tmp = fileName.toUpperCase();
					
					Matcher m = p.matcher(tmp);
					
					if(m.matches()) {
						if(fArr[i].isDirectory()) {
							System.out.println("[" + fileName + "]");
						} else {
							System.out.println(fileName);
						}
					}
				}
				
				break;

			default:
				System.out.println("USAGE : dir [FILENAME]");
		} // switch
	} // dir()
} // class

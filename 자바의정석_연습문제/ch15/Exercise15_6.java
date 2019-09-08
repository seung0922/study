package ch15;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Exercise15_6 {
	static String[] argArr; // �Է��� �Ű������� ������� ���ڿ��迭
	static File curDir; // ���� ���丮
	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		while (true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);

				// ȭ�����κ��� ���δ����� �Է¹޴´�.
				String input = s.nextLine();

				input = input.trim(); // �Է¹��� ������ ���ʿ��� �յ� ������ �����Ѵ�.
				argArr = input.split(" +");
				String command = argArr[0].trim();

				if ("".equals(command))
					continue;

				command = command.toLowerCase(); // ��ɾ �ҹ��ڷ� �ٲ۴�.

				if (command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�.
					System.exit(0);
				} else if (command.equals("cd")) {
					cd();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("�Է¿����Դϴ�.");
			}
		} // while(true)
	} // main

	public static void cd() {
		if (argArr.length == 1) {
			System.out.println(curDir);
			return;
		} else if (argArr.length > 2) {
			System.out.println("USAGE : cd directory");
			return;
		}
		
		String subDir = argArr[1];
		// 1. �Էµ� ���丮(subDir)�� ".."�̸�,
		if(subDir.equals("..")) {
			// 1.1 ���� ���丮�� ���� ���丮�� �� ���� ���丮�� �����Ѵ�.
			curDir = curDir.getParentFile();
			// 2. �Էµ� ���丮(subDir)�� "."�̸�, �ܼ��� ���� ���丮�� ��θ� ȭ�鿡 ���
		} else if(subDir.equals(".")) {
			System.out.println(curDir.toString());
			// 3. 1 �Ǵ� 2�� ��찡 �ƴϸ�,
		} else {
			// 3.1 �Էµ� ���丮(subDir)�� ���� ���丮�� �������丮���� Ȯ��
			// �������丮�� ��� ����?
			// subDir�� �ϳ� ������ -> ������ ���� ���丮 ��� + subDir �� ���ϸ����
			File pDir = curDir.getParentFile();	// ���� ���丮
			File ppDir = pDir.getParentFile();	// ������ ���� ���丮
			String str = ppDir.getPath() + "\\" + subDir;
			File sDir = new File(str);
			
			if(str.equals(pDir.getPath()))				
				// 3.2 Ȯ�ΰ���� true�̸�, ���� ���丮(curDir)�� �Էµ� ���丮(subDir)�� �����Ѵ�.
				curDir = sDir;
			else
				// 3.3 Ȯ�ΰ���� false�̸�, "��ȿ���� ���� ���丮�Դϴ�."�� ȭ�鿡 ����Ѵ�.
				System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
		}
		
		

	} // cd()
}
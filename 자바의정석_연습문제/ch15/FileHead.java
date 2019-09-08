package ch15;

import java.io.*;

// Ŀ�ǵ�������� ���� ���ϸ�� ���ڸ� �Է¹޾Ƽ�
// �Է¹��� ������ ������ ó������ �Է¹��� ���ڸ�ŭ�� ������ ���
// (BufferedReader�� readLine() ���)

public class FileHead {
	public static void main(String[] args) {
		// �Է¿�Ҵ� 1.���ϸ� 2.���� => �� 2��
		// �Է¿�Ұ� 2���� �ƴϸ� ����
		if(args.length != 2) {
			System.out.println("USAGE : java FileHead 10 FILENAME");
			System.exit(0);
		}
		
		// �Է¹��� ���ϸ�� ���ڸ� ������ ����
		File filename = new File(args[0]);
		int num = Integer.parseInt(args[1]);
		
		// �Է¹��� ������ �����ϴ���, ���丮�� �ƴ��� Ȯ��
		if(!filename.exists() || filename.isDirectory()) {
			System.out.println(filename + "��/�� ���丮�̰ų�, �������� �ʴ� �����Դϴ�.");
			System.exit(0);
		}
		
		try {
			
			// �Է¹��� ������ �о��
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			// ���پ� �а� �Է¹��� ���ڸ�ŭ�� ��� 
			String line = "";
			for(int i=1; i<=num; i++) {
				line = br.readLine();
				System.out.println(i + ":" + line);
			}
			
			br.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

package ch15;

import java.io.*;

// Ŀ�ǵ�������� ���� ���� ������ �̸��� �Է¹ް�
// �� ���ϵ��� ������� ���ļ� ���ο� ������ ����� ���� ���α׷�
// ��, ��ĥ ������ �������� ������ ���� �ʴ´�.

public class FileMergeTest {
	public static void main(String[] args) {
		// ���ϸ��� �ΰ� �̻� �޾ƾ� �ϹǷ� �ΰ� �̸��̸� �����޼���
		if (args.length < 2) {
			System.out.println("USAGE : java FileMerge filename");
			System.exit(0);
		}

		// ù��° ����(���ϸ�)�� ���ο� ���� �����ϰ�
		// �� ������ ���ο� ���Ͽ� ���� ���ϵ� ���� ���� ����
		// ex) result.txt 1.txt 2.txt => result�� 1�� 2 ��ģ ���� ����

		try {
			// 1. ������ �а� �����ְ� �ϴ� reader&writer ��Ʈ�� ����
			FileReader fr = null;
			FileWriter fw = new FileWriter(args[0]); // ���ο� ����
			BufferedWriter bw = new BufferedWriter(fw);

			// 2. �ι�° ���ں��� ��ġ�� ���� ����
			for (int i = 1; i < args.length; i++) {
				// 2-1. ���� ���� �о��
				String filename = args[i];
				fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);

				// 2-2. �о�� ���ϳ����� result�� ����
				String line = "";
				while ((line = br.readLine()) != null) {
					bw.write(line + "\n");
				}
				
				br.close();
				
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. ���������� for�� ������ Ǯ�� ���� �����ؾ� �� ���� �ִ�.
// ����� ����� ������ ���� ���� �Է¹ްų� ����� �� �ð��ʰ��� �� �� �ִٴ� ���̴�.
// Java�� ����ϰ� �ִٸ�, Scanner�� System.out.println ��� BufferedReader�� BufferedWriter�� ����� �� �ִ�.
// BufferedWriter.flush�� �� �������� �� ���� �ϸ� �ȴ�.
// ù �ٿ� �׽�Ʈ���̽��� ���� T�� �־�����.
// �� �׽�Ʈ���̽����� A+B�� �� �ٿ� �ϳ��� ������� ���

public class Ex04_15552 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int cnt = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽� ������ ������ �޾ƿ�

			for (int i = 0; i < cnt; i++) { // �޾ƿ� �׽�Ʈ ���̽� ����ŭ �ݺ�
				String s = br.readLine(); // �� ���� ���پ� �޾ƿ�
				StringTokenizer st = new StringTokenizer(s); // StringTokenizer���ڰ��� �Է� ���ڿ� ����
				int a = Integer.parseInt(st.nextToken()); // ù��° �� ������ ��������
				int b = Integer.parseInt(st.nextToken()); // �ι�° �� ������ ��������

				int sum = a + b; // �� �� ���� �� ����

				bw.write(sum + "\n"); // ��
			}
			bw.flush(); // �����ִ� ������ ��� ���

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

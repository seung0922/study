
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. �� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
// ù° �ٿ� �׽�Ʈ ���̽��� ���� T�� �־�����.
// �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� ������, �� �ٿ� A�� B�� �־�����.
// �� �׽�Ʈ ���̽����� "Case #x: "�� ����� ����, A+B�� ����Ѵ�. �׽�Ʈ ���̽� ��ȣ�� 1���� �����Ѵ�.
public class Ex07_11021 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine()); // n�� ������ ����

			for (int i = 1; i <= n; i++) { // �޾ƿ� �׽�Ʈ ���̽� ����ŭ �ݺ�
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s); // StringTokenizer���ڰ��� �Է� ���ڿ� ����

				int a = Integer.parseInt(st.nextToken()); // ù��° �� ������ ��������
				int b = Integer.parseInt(st.nextToken()); // �ι�° �� ������ ��������

				int sum = a + b;

				bw.write("Case #" + i + ": " + sum + "\n"); // ��
			}
			bw.flush(); // �����ִ� ������ ��� ���

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
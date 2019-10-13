
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. �� �׽�Ʈ ���̽����� "Case #x: A + B = C" �������� ����Ѵ�. 
// x�� �׽�Ʈ ���̽� ��ȣ�̰� 1���� �����ϸ�, C�� A+B�̴�.
public class Ex08_11022 {
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
				// Case #x: A + B = C
				bw.write("Case #" + i + ": "); // ��
				bw.write(a + " + " + b + " = " + sum + "\n");
			}
			bw.flush(); // �����ִ� ������ ��� ���

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
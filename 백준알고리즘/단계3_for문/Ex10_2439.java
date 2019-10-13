
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Q. ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ��� ����
// ������, �������� �������� ������ ��(���� ����)�� ����Ͻÿ�.
public class Ex10_2439 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine()); // n�� ������ ����

			for (int i=1; i<=n; i++) { // �޾ƿ� �׽�Ʈ ���̽� ����ŭ �ݺ�
				for(int j=n; j>=1; j--) {
					if(j<=i) {
						bw.write("*");
					} else {
						bw.write(" ");
					}
				}
				bw.write("\n");
			}
			bw.flush(); // �����ִ� ������ ��� ���

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
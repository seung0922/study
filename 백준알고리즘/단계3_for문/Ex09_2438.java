
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Q. ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ��� ����
public class Ex09_2438 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine()); // n�� ������ ����

			for (int i = 0; i < n; i++) { // �޾ƿ� �׽�Ʈ ���̽� ����ŭ �ݺ�
				for(int j=0; j<=i; j++) {
					bw.write("*");
				}
				bw.write("\n");
			}
			bw.flush(); // �����ִ� ������ ��� ���

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
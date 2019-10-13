
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. ���� N���� �̷���� ���� A�� ���� X�� �־�����. �̶�, A���� X���� ���� ���� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
public class Ex11_10871 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s); // StringTokenizer���ڰ��� �Է� ���ڿ� ����
			
			int A = Integer.parseInt(st.nextToken()); // ù��° �� ������ ��������
			int X = Integer.parseInt(st.nextToken()); // �ι�° �� ������ ��������
			
			s = br.readLine();
			String[] arr = s.split(" ");
			
			for(String a : arr) {
				if(Integer.parseInt(a) < X) {
					bw.write(a + " ");
				}
			}
			
			bw.flush(); // �����ִ� ������ ��� ���

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
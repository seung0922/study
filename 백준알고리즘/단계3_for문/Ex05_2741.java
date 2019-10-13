
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Q. �ڿ��� N�� �־����� ��, 1���� N���� �� �ٿ� �ϳ��� ����ϴ� ���α׷��� �ۼ�
public class Ex05_2741 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());	// n�� ������ ����  
			
			for(int i=1; i<=n; i++) {	// �޾ƿ� �׽�Ʈ ���̽� ����ŭ �ݺ�
				bw.write(i + "\n");	// ��
			}
			bw.flush();	// �����ִ� ������ ��� ���
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

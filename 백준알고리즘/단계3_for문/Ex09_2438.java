
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Q. 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
public class Ex09_2438 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine()); // n값 변수로 저장

			for (int i = 0; i < n; i++) { // 받아온 테스트 케이스 수만큼 반복
				for(int j=0; j<=i; j++) {
					bw.write("*");
				}
				bw.write("\n");
			}
			bw.flush(); // 남아있는 데이터 모두 출력

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
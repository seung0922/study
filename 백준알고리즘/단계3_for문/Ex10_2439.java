
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Q. 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
// 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
public class Ex10_2439 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine()); // n값 변수로 저장

			for (int i=1; i<=n; i++) { // 받아온 테스트 케이스 수만큼 반복
				for(int j=n; j>=1; j--) {
					if(j<=i) {
						bw.write("*");
					} else {
						bw.write(" ");
					}
				}
				bw.write("\n");
			}
			bw.flush(); // 남아있는 데이터 모두 출력

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
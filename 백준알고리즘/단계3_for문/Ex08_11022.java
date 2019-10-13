
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. 각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. 
// x는 테스트 케이스 번호이고 1부터 시작하며, C는 A+B이다.
public class Ex08_11022 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int n = Integer.parseInt(br.readLine()); // n값 변수로 저장

			for (int i = 1; i <= n; i++) { // 받아온 테스트 케이스 수만큼 반복
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s); // StringTokenizer인자값에 입력 문자열 넣음

				int a = Integer.parseInt(st.nextToken()); // 첫번째 값 정수로 변수저장
				int b = Integer.parseInt(st.nextToken()); // 두번째 값 정수로 변수저장

				int sum = a + b;
				// Case #x: A + B = C
				bw.write("Case #" + i + ": "); // 씀
				bw.write(a + " + " + b + " = " + sum + "\n");
			}
			bw.flush(); // 남아있는 데이터 모두 출력

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
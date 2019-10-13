
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
// 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
// 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.
// 각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.
public class Ex07_11021 {
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

				bw.write("Case #" + i + ": " + sum + "\n"); // 씀
			}
			bw.flush(); // 남아있는 데이터 모두 출력

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
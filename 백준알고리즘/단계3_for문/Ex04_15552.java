
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. 본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다.
// 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.
// Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다.
// BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
// 첫 줄에 테스트케이스의 개수 T가 주어진다.
// 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력

public class Ex04_15552 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int cnt = Integer.parseInt(br.readLine()); // 테스트 케이스 한줄을 정수로 받아옴

			for (int i = 0; i < cnt; i++) { // 받아온 테스트 케이스 수만큼 반복
				String s = br.readLine(); // 그 다음 한줄씩 받아옴
				StringTokenizer st = new StringTokenizer(s); // StringTokenizer인자값에 입력 문자열 넣음
				int a = Integer.parseInt(st.nextToken()); // 첫번째 값 정수로 변수저장
				int b = Integer.parseInt(st.nextToken()); // 두번째 값 정수로 변수저장

				int sum = a + b; // 두 수 더한 값 저장

				bw.write(sum + "\n"); // 씀
			}
			bw.flush(); // 남아있는 데이터 모두 출력

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

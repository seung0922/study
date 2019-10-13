
package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Q. 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
public class Ex11_10871 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s); // StringTokenizer인자값에 입력 문자열 넣음
			
			int A = Integer.parseInt(st.nextToken()); // 첫번째 값 정수로 변수저장
			int X = Integer.parseInt(st.nextToken()); // 두번째 값 정수로 변수저장
			
			s = br.readLine();
			String[] arr = s.split(" ");
			
			for(String a : arr) {
				if(Integer.parseInt(a) < X) {
					bw.write(a + " ");
				}
			}
			
			bw.flush(); // 남아있는 데이터 모두 출력

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package step03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Q. 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성
public class Ex05_2741 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());	// n값 변수로 저장  
			
			for(int i=1; i<=n; i++) {	// 받아온 테스트 케이스 수만큼 반복
				bw.write(i + "\n");	// 씀
			}
			bw.flush();	// 남아있는 데이터 모두 출력
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}

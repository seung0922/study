package step02;

import java.util.Scanner;

// Q. 주어진 시간에서 45분을 뺀 시간 나타내기
// (24시간 표현 사용)
public class Ex04_2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int h = sc.nextInt();
			// h 는 0~23, m은 0~59
			int m = sc.nextInt();
			
			// 1. m에서 45를 뺀다
			m = m - 45;
			
			// 2. m이 0보다 작으면 60에 더한다
			if(m<0) {
				if(h==0) { // 시간이 0시면 뺐을때 23시가 되도록해줌
					h = 23;
				} else { // 0시가 아니면 1만 빼줌
					h = h - 1;
				}
				m = 60 + m;
			}
			
			System.out.printf("%d %d", h, m);
			
		}
	}

}

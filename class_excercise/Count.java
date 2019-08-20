package day3;

public class Count {

	public static void main(String[] args) {
		int[] data = {4, 1, 7, 4, 1, 2, 1, 3, 6, 5, 8, 8};
		int[] cntArr = new int[10];
		
		// cntArr에 각 숫자 개수 카운팅 (0번째 자리엔 0개수, 1번째 자리엔 1 개수, ..., 9번째 자리엔 9개수)
		for(int i=0; i<data.length; i++) {
			cntArr[data[i]]++;
		}
		
		// cntArr 중복제거 출력
		for(int i=0; i<cntArr.length; i++) {
			// 해당 인덱스값이 0이상이면 해당 인덱스 출력
			if(cntArr[i] > 0) { 
				System.out.printf("%2d", i);
			}
		}
		System.out.println();
		
		// cntArr 정렬 출력
		// cntArr 해당 인덱스 자리에 있는 숫자개수만큼 해당 인덱스 값 출력
		for(int i=0; i<cntArr.length; i++) {
			for(int j=0; j<cntArr[i]; j++) {
				System.out.printf("%2d", i);
			}
		}
		
	}

}

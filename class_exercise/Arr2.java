package day2;

public class Arr2 {

	public static void main(String[] args) {
		// Q2. 두 배열에 같은 숫자가 몇개 있는지 출력하세요.
		int[] arr1 = {1,3,4};
		int[] arr2 = {2,3,4};
		
		// 두 배열에 같은 숫자가 몇개 있는지 세기 위한 변수
		int cnt = 0;
		
		// 작업처리
		// 어떻게 세어야 하는가?
		// arr1의 하나의 값과 arr2의 모든값을 검사하여 같은 숫자면 cnt++ (중복없이)
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					cnt++;
					break;
				}
			}
		}
		
		// 결과를 확인한다.
		System.out.println("같은 숫자의 갯수 :" + cnt);
		
	}

}

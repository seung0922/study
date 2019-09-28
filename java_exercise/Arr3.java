package day2;

public class Arr3 {

	public static void main(String[] args) {
		// Q3. 두 배열에 같은 숫자가 있을 때 위치가 같으면 S, 다르면 B
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,3,5};
		
		int s = 0;	// 숫자가 같고 위치가 같은 개수
		int b = 0;	// 숫자가 같고 위치가 다른 것의 개수
		
		// 작업처리
		// 어떻게 세어야 하는가?
		// arr1의 하나의 값과 arr2의 모든값을 검사하여 같은 숫자면 cnt++ (중복없이)
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1.length; j++) {
				// 두 값이 같으면
				if(arr1[i] == arr2[j]) {
					if(i==j) {	// 위치가 같으면
						s++;
					} else {	// 위치가 다르면
						b++;
					}
				}
			}
		}
		
		// 결과를 확인한다.
		System.out.println(s + "S" + b + "B");
		
	}

}

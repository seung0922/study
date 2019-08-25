package day2;

public class Arr1 {

	public static void main(String[] args) {
		// Q. 두 배열이 같은지 확인하세요.
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
		
		// 처리를 한다. - 두 배열이 같은지 확인한다.
		// 어떻때 두 배열이 같다고 하는가?
		int i = 0;
		
		// 숫자가 다르면 비교를 멈춘다.
		for(i=0; i<=2; i++) {
			if(arr1[i] != arr2[i]) {
				break;
			}
		}
		
		// 결과를 확인한다.
		// 같은 값의 갯수(cnt)가 배열의 길이(arr1.length)와 일치하면 같은것
		// i의 값이 arr1.length와 같다는 뜻은 모두 일치한다는 뜻
		if(i == arr1.length) {
			System.out.println("같습니다.");
		} else {
			System.out.println("다릅니다.");
		}
		
		
	}

}

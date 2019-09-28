package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Card {
	int num;	// 카드의 숫자
	String kind;	// 카드의 무늬
	
	Card(int num, String kind) {
		this.num = num;
		this.kind = kind;
	}
	
	// 객체의 iv를 문자열로 반환하는 메서드
	public String toString() {
		return num+kind;
	}
}

class PokerCheck {
	String rankCheck(Card[] arr) {
		
		String kind = arr[0].kind;	// kind에 첫번째 값 넣어서 모두 같은지 비교하기 위한 변수
		int num = arr[0].num;	// 연속된값인지 비교하기 위해 첫번째 인덱스값을 저장
		int cntKind = 0;	// 같은 무늬인지 확인하고 카운팅하기위한 변수
		int cntYeonsok = 0;	// 연속숫자인지 카운팅하기위한 변수
		
		int pair = 0;	// 같은 숫자2개 몇개인지
		boolean threeCard = false;	// 같은 숫자 3개
		boolean fourCard = false;	// 같은 숫자 4개
		
		// 숫자개수 카운트하여 배열에 저장
		int[] cntNum = new int[13];
		for(int i=0; i<arr.length; i++) {
			cntNum[arr[i].num]++;
		}
		
		// 1 PAIR, 2 PAIR, THREECARD, FOURCARD
		for(int i=0; i<cntNum.length; i++) {
			if(cntNum[i]==2) pair++;
			if(cntNum[i]==3) threeCard = true;
			if(cntNum[i]==4) fourCard = true;
		}
		
		
		// 합쳐보기
		for(int i=0; i<arr.length; i++) {
			// 첫번째값부터 +0 ~ +5 더해서 순차적으로 연속된 값인지 확인하고 맞으면 +1
			if(arr[i].num == num+i) cntYeonsok++;
			// 첫번째값부터 +0 ~ +5 더해서 순차적으로 연속된 값인지 확인
			if(arr[i].kind == kind) cntKind++;
		}
		
		if(cntKind==5 && cntYeonsok==5) return "STRAIGHT FLUSH";
		if(cntYeonsok==5) return "STRAIGHT";
		if(cntKind==5) return "FLUSH";
		if(fourCard) return "FOUR CARD";
		if(threeCard) return "THREE CARD";
		if(pair>0) return pair + "PAIR";
		return "NO RANK";
		
		
		
		
		

//////////////////////////////////////////////////////////////////////////////////////
/*		// STRAIGHT FLUSH - 다섯개 숫자 연속, 같은 무늬 5개
		for(int i=0; i<arr.length; i++) {
			// 첫번째값부터 +0 ~ +5 더해서 순차적으로 연속된 값인지 확인하고 맞으면 +1
			if(arr[i].num == num+i) cntYeonsok++;
			if(arr[i].kind == kind) cntKind++;
		}
		//if(cntKind==5 && cntYeonsok==5) return "STRAIGHT";
		
		
		
		
		// STRAIGHT - 다섯개 숫자 연속
//		 값을 비교하기 위해 num에 첫번째 객체의 숫자값을 넣는다
		for(int i=0; i<arr.length; i++) {
			// 첫번째값부터 +0 ~ +5 더해서 순차적으로 연속된 값인지 확인 
			if(arr[i].num == num+i) cntYeonsok++;
		}
		if(cntYeonsok==5) return "STRAIGHT";
		
		
		
		
		// FLUSH - 같은 무늬 5개
		// kind에 첫번째 값 넣어서 모두 같은지 비교
		for(int i=0; i<arr.length; i++) {
			// 첫번째무늬와 다음인덱스무늬가 같으면 +1;
			 if(arr[i].kind == kind) cntKind++;
		}
		if(cntKind==5) return "FLUSH";
		
		
		
		
		// 1 PAIR, 2 PAIR, THREECARD, FOURCARD - 같은 숫자 개수
		// 숫자개수 카운트하여 배열에 저장
//		int[] cntNum = new int[13];
//		for(int i=0; i<arr.length; i++) {
//			cntNum[arr[i].num]++;
//		}
		
		for(int i=0; i<cntNum.length; i++) {
			if(cntNum[i]==2) pair++;
			if(cntNum[i]==3) threeCard = true;
			if(cntNum[i]==4) fourCard = true;
		}

		if(fourCard) return "FOUR CARD";
		if(threeCard) return "THREE CARD";
		if(pair>0) return pair + "PAIR";
//		
//		
//		// 아무것도 해당없을 시 출력
		return "NO RANK";
		
		*/
		
	}

	@Test
	void test() {
		Card[] arr = { 	new Card(4, "H"),
						new Card(5, "H"),
						new Card(3, "H"),
						new Card(7, "H"),
						new Card(8, "H")
					};
		assertTrue(rankCheck(arr).equals("FLUSH"));
	}

}

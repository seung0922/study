package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Card {
	int num;	// ī���� ����
	String kind;	// ī���� ����
	
	Card(int num, String kind) {
		this.num = num;
		this.kind = kind;
	}
	
	// ��ü�� iv�� ���ڿ��� ��ȯ�ϴ� �޼���
	public String toString() {
		return num+kind;
	}
}

class PokerCheck {
	String rankCheck(Card[] arr) {
		
		String kind = arr[0].kind;	// kind�� ù��° �� �־ ��� ������ ���ϱ� ���� ����
		int num = arr[0].num;	// ���ӵȰ����� ���ϱ� ���� ù��° �ε������� ����
		int cntKind = 0;	// ���� �������� Ȯ���ϰ� ī�����ϱ����� ����
		int cntYeonsok = 0;	// ���Ӽ������� ī�����ϱ����� ����
		
		int pair = 0;	// ���� ����2�� �����
		boolean threeCard = false;	// ���� ���� 3��
		boolean fourCard = false;	// ���� ���� 4��
		
		// ���ڰ��� ī��Ʈ�Ͽ� �迭�� ����
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
		
		
		// ���ĺ���
		for(int i=0; i<arr.length; i++) {
			// ù��°������ +0 ~ +5 ���ؼ� ���������� ���ӵ� ������ Ȯ���ϰ� ������ +1
			if(arr[i].num == num+i) cntYeonsok++;
			// ù��°������ +0 ~ +5 ���ؼ� ���������� ���ӵ� ������ Ȯ��
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
/*		// STRAIGHT FLUSH - �ټ��� ���� ����, ���� ���� 5��
		for(int i=0; i<arr.length; i++) {
			// ù��°������ +0 ~ +5 ���ؼ� ���������� ���ӵ� ������ Ȯ���ϰ� ������ +1
			if(arr[i].num == num+i) cntYeonsok++;
			if(arr[i].kind == kind) cntKind++;
		}
		//if(cntKind==5 && cntYeonsok==5) return "STRAIGHT";
		
		
		
		
		// STRAIGHT - �ټ��� ���� ����
//		 ���� ���ϱ� ���� num�� ù��° ��ü�� ���ڰ��� �ִ´�
		for(int i=0; i<arr.length; i++) {
			// ù��°������ +0 ~ +5 ���ؼ� ���������� ���ӵ� ������ Ȯ�� 
			if(arr[i].num == num+i) cntYeonsok++;
		}
		if(cntYeonsok==5) return "STRAIGHT";
		
		
		
		
		// FLUSH - ���� ���� 5��
		// kind�� ù��° �� �־ ��� ������ ��
		for(int i=0; i<arr.length; i++) {
			// ù��°���̿� �����ε������̰� ������ +1;
			 if(arr[i].kind == kind) cntKind++;
		}
		if(cntKind==5) return "FLUSH";
		
		
		
		
		// 1 PAIR, 2 PAIR, THREECARD, FOURCARD - ���� ���� ����
		// ���ڰ��� ī��Ʈ�Ͽ� �迭�� ����
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
//		// �ƹ��͵� �ش���� �� ���
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

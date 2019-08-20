package ch07;

// ����ī�� 20���� �����ϴ� ����ī�� �� ���� ������ ���̴�.
// ����ī�� 20���� ��� SutaCard�迭�� �ʱ�ȭ�Ͻÿ�
// ��, ����ī��� 1���� 10������ ���ڰ� ���� ī�尡 �� �־� �ְ�
// ���ڰ� 1, 3, 8�� ��쿡�� �� ���� �� ���� ���̾�� �Ѵ�.

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		int i=0;
		for(int n=1; n<=CARD_NUM; n++) {
			if(n<=10) {	// 1~10
				if(n == 1 || n == 3 || n == 8) {	// ���ڰ� 1, 3, 8�� ��� ��
					cards[i++] = new SutdaCard(n, true);
				} else {	// �׷��� ������ �� x
					cards[i++] = new SutdaCard(n, false);
				}
			} else {	// 10 �ʰ��� -10 ���༭ 1~10�ǵ��� ����
				cards[i++] = new SutdaCard(n-10, false);
			}
		}
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info() ��� ObjectŬ������ toString()�� �������̵�
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
	}
}

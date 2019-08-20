package ch07;

// ����ī�� 20���� �����ϴ� ����ī�� �� ���� ������ ���̴�.
// ����ī�� 20���� ��� SutaCard�迭�� �ʱ�ȭ�Ͻÿ�
// ��, ����ī��� 1���� 10������ ���ڰ� ���� ī�尡 �� �־� �ְ�
// ���ڰ� 1, 3, 8�� ��쿡�� �� ���� �� ���� ���̾�� �Ѵ�.

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		int i = 0;
		for (int n = 1; n <= CARD_NUM; n++) {
			if (n <= 10) { // 1~10
				if (n == 1 || n == 3 || n == 8) { // ���ڰ� 1, 3, 8�� ��� ��
					cards[i++] = new SutdaCard(n, true);
				} else { // �׷��� ������ �� x
					cards[i++] = new SutdaCard(n, false);
				}
			} else { // 10 �ʰ��� -10 ���༭ 1~10�ǵ��� ����
				cards[i++] = new SutdaCard(n - 10, false);
			}
		}
	}

	// Q7-2-1) �迭 cards�� ��� ī���� ��ġ�� �ڼ��´�. (Math.random() ���)
	void shuffle() {
			// cards�� ù��° �ε������� �ݺ�
			// 1. ù��° ��ġ�� ���� tmp�� ����
			// 2. ������ ��ġ�� ���� ù��° ��ġ�� ����
			// 3. tmp�� ���� ������ ��ġ�� ����
			for (int i=0; i<cards.length; i++) {
				int x = (int)(Math.random()*cards.length);
				SutdaCard tmp;
				
				tmp = cards[i];
				cards[i] = cards[x];
				cards[x] = tmp;
			}
		}

	// Q7-2-2) �迭 cards�� ������ ��ġ�� SutdaCard�� ��ȯ
	SutdaCard pick(int index) {
		return cards[index];
	}

	// Q7-2-3) �迭 cards���� ������ ��ġ�� SutdaCard�� ��ȯ (Math.random() ���)
	SutdaCard pick() {
		int x = (int)(Math.random()*cards.length);
		return cards[x];
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

public class Exercise7_2 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
		
		System.out.println();
		System.out.println(deck.pick(0));
	}
}

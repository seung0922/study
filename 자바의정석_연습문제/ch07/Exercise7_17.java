package ch07;

// ����κ��� �̾Ƽ� Unit�̶�� Ŭ������ �����, �� Ŭ������ ��ӹ޵��� ����
class Unit {
	int x, y;	// ���� ��ġ
	void move(int x, int y) { /* ������ ��ġ�� �̵� */ }
	void stop() 			{ /* ���� ��ġ�� ���� */ }
}

class Marine extends Unit { // ����
	void stimPack() 		{ /* �������� ����Ѵ�.*/}
}

class Tank extends Unit { // ��ũ
	void changeMode() 		{ /* ���ݸ�带 ��ȯ�Ѵ�. */}
}

class Dropship extends Unit { // ���ۼ�
	void load() 			{ /* ���õ� ����� �¿��.*/ }
	void unload() 			{ /* ���õ� ����� ������.*/ }
}

public class Exercise7_17 {
	public static void main(String[] args) {
		
	}
}

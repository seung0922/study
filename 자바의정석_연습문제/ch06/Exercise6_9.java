package ch06;

/*[6-9] ������ ��ǻ�� ������ ����(marine)�� Ŭ������ ������ ���̴�. �� Ŭ������ ���
�߿� static�� �ٿ��� �ϴ� ���� � �͵��̰� �� ������ �����ΰ�?
(��, ��� ������ ���ݷ°� ������ ���ƾ� �Ѵ�.)
*/

// weapon, armor, weaponUp(), armorUp()
// Ŭ���� ������ ��� ��ü�� ��������̰� �ΰ��� �޼���� Ŭ���������� �����ϴ� �޼����̹Ƿ�.
// Ŭ���� ���� : ���� Ŭ������ ��� �ν��Ͻ����� �����ϴ� ����

class Marine {
	int x=0, y=0; // Marine�� ��ġ��ǥ(x,y)
	int hp = 60; // ���� ü��
	int weapon = 6; // ���ݷ�
	int armor = 0; // ����
	
	void weaponUp() {
		weapon++;
	}
	
	void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
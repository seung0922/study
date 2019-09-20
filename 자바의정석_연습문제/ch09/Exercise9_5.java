package dd;

class Exercise9_5 {
	public static int count(String src, String target) {
		int count = 0; // ã�� Ƚ��
		int pos = 0; // ã�� ������ ��ġ
		
		//�ݺ����� ����ؼ� �Ʒ��� ������ �ݺ��Ѵ�.
		boolean b = true;
		while(b) {
			//1. src���� target�� pos�� ��ġ���� ã�´�.
			int idx = src.indexOf(target, pos); 
			if(idx != -1) {
				//2. ã���� count�� ���� 1 ���� ��Ű��,
				count++;
				//pos�� ���� target.length��ŭ ������Ų��.
				pos = idx;
				pos += target.length();
			} else {
				//3. indexOf�� ����� -1�̸� �ݺ����� ���������� count�� ��ȯ�Ѵ�.
				b = false;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}
}
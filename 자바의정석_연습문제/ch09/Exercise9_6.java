package dd;

//�־��� ���ڿ�(����)�� �־��� ������ ���ڿ��� �����, ���� �� ������ '0'���� ä���.
//���� �־��� ���ڿ��� null�̰ų� ���ڿ��� ���̰� length�� ���� ������ �״�� ��ȯ�Ѵ�.
//���� �־��� length�� ���� 0���� ���ų� ���� ���̸�, �� ���ڿ�("")�� ��ȯ�Ѵ�.

class Exercise9_6 {
	public static String fillZero(String src, int length) {

		// 1. src�� ���̰ų� src.length()�� length�� ������ src�� �״�� ��ȯ�Ѵ�.
		if(src == null || src.length()==length) {
			return src;
			// 2. length�� ���� 0���� ���ų� ������ �� ���ڿ�("")�� ��ȯ�Ѵ�.
		} else if(length <= 0) {
			return "";
			// 3. src�� ���̰� length�� ������ ũ�� src�� length��ŭ �߶� ��ȯ�Ѵ�.
		} else if(src.length() > length){
			src = src.substring(0, length);
			return src;
		}
		
		// ���� ��쿡 �ش����� �ʴ� ����
		// 4. ���̰� length�� char�迭�� �����Ѵ�.
		char[] chArr = new char[length];
		
		// 5. 4���� ������ char�迭�� '0'���� ä���.
		for(int i=0; i<chArr.length; i++) {
			chArr[i] = '0';
		}
		
		// 6. src���� ���ڹ迭�� �̾Ƴ��� 4���� ������ �迭�� �����Ѵ�.
		char[] srcArr = src.toCharArray();
		int cnt = 0;
		for(int i=chArr.length-srcArr.length; i<chArr.length; i++) {
			chArr[i] = srcArr[cnt++];
		}
		
		// 7. 4���� ������ �迭�� String�� �����ؼ� ��ȯ�Ѵ�.
		return new String(chArr);



	}

	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
	}
}
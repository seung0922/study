package dd;

class Exercise9_9 {
	// �־��� ���ڿ����� ������ ���ڵ��� �����Ͽ� ��ȯ�ϴ� �Լ�
	static String delChar(String src, String delCh) {
		// StringBuffer�� CharAt(int i), indexOf(int ch) ���
		// 1. ������ ���ڵ��� ������ ���ڿ��� ������ StringBuffer ����
		// 2. src�� delCh�� �ϳ��� ���Ͽ� src�� delCh�� �ִ��� Ȯ��
		// ������, �Ѿ��
		// ������, StringBuffer�� ����
		
		return "";
	}

	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
	}
}
package ch06;

class Exercise6_22 {
	//(1) isNumber�޼��带 �ۼ��Ͻÿ�.
	
	static boolean isNumber(String str) {
		// �־��� ���ڿ��� ��� ���ڷθ� �̷���� �ִ��� Ȯ��
		// ��� ���� -> true, �׷��������� -> false
		// �־��� ���ڿ��� null �̰ų� ���ڿ� "" -> false
		boolean result = false;
		
		if(str==null || str=="") {
			result = false;
		} else {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)<'0' || str.charAt(i)>'9') {
					result = false;
					break;
				} else {
					result = true;
				}
			}
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"�� �����Դϱ�? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"�� �����Դϱ�? "+isNumber(str));
	}
}
package ch09;

class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		
		// 1. fullPath ���������� ã�� "//"�ִ� ��ġ ��ȯ
		int idx = 0;
		idx = fullPath.lastIndexOf("\\");
		
		// 2. ó������ "//" �ִ� �ڸ��� �ձ��� path�� ����
		path = fullPath.substring(0, idx);
		
		// 3. "//" �ִ� �� �������� ������ fileName�� ����
		fileName = fullPath.substring(idx+1);
		
		System.out.println("fullPath:" + fullPath);
		System.out.println("path:" + path);
		System.out.println("fileName:" + fileName);
	}
}
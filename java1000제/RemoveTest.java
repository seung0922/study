package java1000;

public class RemoveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String line = "a1b2c3d4f5g6";
		String pText1 = "0123456789";
		StringBuffer sb = new StringBuffer();
		
		// �ݺ������� ���ڸ� �ϳ��� �о ch�� �����Ѵ�.
		for(int i=0;i<line.length();i++) {
			char ch = line.charAt(i);

			if(pText1.indexOf(ch)==-1) { // ������ �ǳʶٰ�, ������ �����Ѵ�.
				sb.append(ch);
			}
			
		}
		
		System.out.println(sb);
		

	}

}

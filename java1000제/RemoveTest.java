package java1000;

public class RemoveTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String line = "a1b2c3d4f5g6";
		String pText1 = "0123456789";
		StringBuffer sb = new StringBuffer();
		
		// 반복문으로 문자를 하나씩 읽어서 ch에 저장한다.
		for(int i=0;i<line.length();i++) {
			char ch = line.charAt(i);

			if(pText1.indexOf(ch)==-1) { // 있으면 건너뛰고, 없으면 저장한다.
				sb.append(ch);
			}
			
		}
		
		System.out.println(sb);
		

	}

}

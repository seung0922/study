package java1000;

import java.io.File;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Q5. 현재 디렉토리의 파일과 디렉토리의 목록을 보여주는 명령어 dir을 구현
// dir만 입력하면 모든 파일과 디렉토리를, dir *ex?.*와 같이 패턴을 입력하면
// 패턴과 일치하는 파일 또는 디렉토리의 목록을 보여줘야한다.
// (패턴에서 '*'와 '?'는 와일드 카드로 '*'는 임의의 여러 글자가 올 수 있으며, '?'는 임의의 한글자를 의미한다.
// 도스창에서 dir명령과 와일드카드를 테스트 해보고 똑같은 기능을 갖도록 구현하자.)

class ConsoleEx5 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static LinkedList q = new LinkedList(); // 사용자가 입력한 내용을 저장할 큐(Queue)
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다.

	static File curDir;

	static {
		try {
//			curDir = new File(System.getProperty("user.dir"));
			curDir = new File("C:\\Users\\5CLASS-184\\20190805\\java1000\\bin\\java1000");
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in); // 한번만 생성해서 재사용하면 되므로 반복문 밖으로 이동

		while (true) {
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);

				// 화면으로부터 라인단위로 입력받는다.
				String input = s.nextLine();

				save(input);

				input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
				argArr = input.split(" +");

				String command = argArr[0].trim();

				if ("".equals(command))
					continue;

				command = command.toLowerCase(); // 명령어를 소문자로 바꾼다.

				if (command.equals("q")) { // q 또는 Q를 입력하면 실행종료한다.
					System.exit(0);
				} else if (command.equals("history")) {
					history();
				} else if (command.equals("dir")) {
					dir();
				} else {
					for (int i = 0; i < argArr.length; i++) {
						System.out.println(argArr[i]);
					}
				}
			} catch (Exception e) {
				System.out.println("입력오류입니다.");
			}
		} // while(true)
	} // main

	public static void save(String input) {
		if (input == null || "".equals(input))
			return;

		q.offer(input); // queue에 저장한다.

		// queue의 최대크기를 넣으면 제일 오래된 저장값을 삭제한다.
		if (((LinkedList) q).size() > MAX_SIZE)
			q.remove();
	}

	public static void history() {
		int i = 0;

		// LinkedList의 내용을 보여준다.
		LinkedList tmp = (LinkedList) q;
		ListIterator it = tmp.listIterator();

		while (it.hasNext()) {
			System.out.println(++i + "." + it.next());
		}
	}

	public static void dir() {
		String pattern = "";
		File[] fArr = curDir.listFiles();

		switch (argArr.length) {
			case 1: // dir만 입력한 경우 현재 디렉토리의 모든 파일과 디렉토리를 보여준다.
	
				// 1. 반복문을 이용해서 현재디렉토리의 모든 파일의 목록을 출력한다. (File클래스의 listFiles()사용)
	
				for (int i = 0; i < fArr.length; i++) {
					// 2. 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.
					// (File클래스의 isDirectory()를 사용해서 체크)
					String fileName = fArr[i].getName();
					
					if(fArr[i].isDirectory()) {
						System.out.println("[" + fileName + "]");
					} else {
						System.out.println(fileName);
					}
				}
	
				break;
	
			case 2: // dir과 패턴을 같이 입력한 경우, 예를 들면 dir *.class

				pattern = argArr[1];
				pattern = pattern.toUpperCase(); // 패턴에서 대소문자를 구별하지 않도록 대문자로 변경한다.
	
				// 1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.
				// String클래스의 String replace(CharSequence target, CharSequence replacement)사용하자.
				// 예를 들면, pattern = pattern.replace("A","AA")는 pattern의 "A"를 "AA"로 치환한다.
				
				pattern = pattern.replace(".","\\."); 
				pattern = pattern.replace("*",".*"); 
                pattern = pattern.replace("?",".{1}");

				Pattern p = Pattern.compile(pattern); 
				
				// 2. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들만 출력한다.
				// 이때, 조건문을 같이 사용해서 디렉토리(폴더)인 경우, 이름의 앞뒤에 '[' 와 ']'를 붙여서 출력한다.
				// File클래스의 isDirectory()를 사용해서 체크)
				// 대소문자구별을 하지 않기 위해서, 패턴과 마찬가지로 파일이나 디렉토리명을 대문자로 변경해야한다.
				// String tmp = f.getName().toUpperCase();
				
				for (int i = 0; i < fArr.length; i++) {
					String fileName = fArr[i].getName();
					String tmp = fileName.toUpperCase();
					
					Matcher m = p.matcher(tmp);
					
					if(m.matches()) {
						if(fArr[i].isDirectory()) {
							System.out.println("[" + fileName + "]");
						} else {
							System.out.println(fileName);
						}
					}
				}
				
				break;

			default:
				System.out.println("USAGE : dir [FILENAME]");
		} // switch
	} // dir()
} // class

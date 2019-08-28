package java1000;

// [문제8] 문제7에서 구현한 find에 패턴을 지원하도록 기능을 확장한 find2명령어를 구현하라.
// find는 하나의 파일에 대해서만 찾기가 가능했지만, find2는 'find2 if *.java'와 같이
// 패턴을 이용해서 여러파일에 대한 찾기가 가능해야한다.(실행결과 참고)
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ConsoleEx8 {
	static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
	static LinkedList q = new LinkedList(); // 사용자가 입력한 내용을 저장할 큐(Queue)
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다.

	static File curDir;

	static {
		try {
			curDir = new File(System.getProperty("user.dir"));
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
				} else if (command.equals("type")) {
					type();
				} else if (command.equals("find")) {
					find();
				} else if (command.equals("find2")) {
					find2();
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
		/* 내용 생략 */

	}

	public static void history() {
		/* 내용 생략 */

	}

	public static void dir() {
		/* 내용 생략 */

	} // dir()

	public static void type() throws IOException {
		/* 내용 생략 */

	}

	public static void find() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String fileName = argArr[2];

		File tmp = new File(fileName);

		if (tmp.exists()) {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line = "";

			for (int i = 1; (line = br.readLine()) != null; i++) {
				// keyword를 포함한 라인을 출력한다.
				if (line.indexOf(keyword) != -1)
					System.out.println(i + ":" + line);
			}
		} else {
			System.out.println(fileName + " 존재하지 않는 파일입니다.");
		}

		return;
	}

	public static void find2() throws IOException {
		if (argArr.length != 3) {
			System.out.println("USAGE : find2 KEYWORD FILE_NAME");
			return;
		}

		String keyword = argArr[1];
		String pattern = argArr[2];

		pattern = pattern.toUpperCase();
		
		// 1. 입력된 패턴(pattern)을 정규식 표현(Regular Expression)에 알맞게 치환한다.
		// String클래스의 String replace(CharSequence target, CharSequence replacement)를 사용하자.
		// 예를 들면, pattern = pattern.replace("A","AA")는 pattern의 "A"를 "AA"로 치환한다.
		pattern = pattern.replace(".", "\\.");
		pattern = pattern.replace("*", ".*");
		pattern = pattern.replace("?", ".{1}");
		
		Pattern p = Pattern.compile(pattern);
		
		File[] fArr = curDir.listFiles();
		
		// 2. 반복문을 이용해서 현재 디렉토리 중, 입력된 패턴과 일치하는 것들에 대해서,
		for(int i=0; i<fArr.length; i++) {
			String fileName = fArr[i].getName();
			String tmp = fileName.toUpperCase();
			
			Matcher m = p.matcher(tmp);
			
			// 입력한 패턴과 일치하는 파일이 있으면
			if(m.matches()) {
				// 해당 파일이름 출력
				System.out.println("-----------" + fileName);
				
				// 2.1 반복문을 이용해서 라인별로 읽어서 keyword가 포함되었는지 확인한다.
				// (BufferedReader의 readLine()사용)
				FileReader fr = new FileReader(fArr[i]);
				BufferedReader br = new BufferedReader(fr);
				
				String line ="";
				
				for(int j=1; (line=br.readLine())!=null; j++) {
					// 2.2 keyword가 포함된 라인을 발견하면, 라인번호와 함께 해당 라인을 화면에 출력한다.
					if(line.indexOf(keyword) != -1)
						System.out.println(j + ":" + line);
				}
				
			}
			
		}

		return;
	}

} // class

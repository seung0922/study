package java1000;

import java.util.Scanner;

// Q1. 에제를 실행하면 '>>'와 같은 프롬프트가 나타나서 사용자의 입력을 기다리고,
// 사용자가 입력한 내용을 화면에 출력한다. 만일 사용자가 'q' 또는 'Q'를 입력하면 프로그램을 종료


class ConsoleEx1 {
	public static void main(String[] args) {
		while (true) {
			String prompt = ">>";
			System.out.print(prompt);
			
			// 1. 화면으로부터 라인단위로 입력받는다. - java.util.Scanner클래스 사용 
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			
			// 2. q 또는 Q를 입력하면 실행종료한다.
			if(input.equals("q") || input.equals("Q")) {
				System.exit(0);
			}
			
			// 화면에 출력
			System.out.println(input);
			
		} // while(true)
		
	} // main
	
} // class

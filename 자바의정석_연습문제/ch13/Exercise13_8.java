package ch13;

import java.util.Scanner;
import java.util.Vector;

class Exercise13_8 {
	Vector words = new Vector();
	String[] data = { "�¿�", "����", "����", "ȿ��", "����", "����", "Ƽ�Ĵ�", "���", "����ī" };
	int interval = 2 * 1000; // 2��
	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) {
		Exercise13_9 game = new Exercise13_9();
		game.wg.start();
		Vector words = game.words;

		while (true) {
			System.out.println(words);
			String prompt = ">>";
			System.out.print(prompt);

			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			Scanner s = new Scanner(System.in);
			String input = s.nextLine().trim();
			int index = words.indexOf(input);

			if (index != -1) {
				words.remove(index);
			}
		}
	} // main

	class WordGenerator extends Thread {
		public void run() {
			// 1. interval(2��)���� �迭 data�� �� �� �ϳ��� ���Ƿ� �����ؼ�
			// 2. words�� �����Ѵ�.
			for(int i=0; i<data.length; i++) {
				int r = (int)(Math.random()*data.length);
				
				words.add(data[r]);
				
				try {
					Thread.sleep(interval);
				} catch(Exception e) {}
			}
			
		} // end of run()
	} // class WordGenerator
} // Exercise13_9
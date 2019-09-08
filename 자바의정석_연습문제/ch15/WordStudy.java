package ch15;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

class WordStudy extends Frame {
	Button first = new Button("<<");
	Button prev = new Button("<");
	Button next = new Button(">");
	Button last = new Button(">>");
	Panel buttons = new Panel();
	TextArea ta = new TextArea();
	ArrayList wordList = new ArrayList();
	
	final String WORD_FILE = "word_data.txt";
	final String CR_LF = System.getProperty("line.separator");
	
	int pos = 0;

	WordStudy(String title) {
		super(title);
		buttons.add(first);
		buttons.add(prev);
		buttons.add(next);
		buttons.add(last);
		add("South", buttons);
		add("Center", ta);
		
		EventHandler handler = new EventHandler();
		addWindowListener(handler);
		first.addActionListener(handler);
		prev.addActionListener(handler);
		next.addActionListener(handler);
		last.addActionListener(handler);
		
		loadFile(WORD_FILE);
		
		setBackground(Color.BLACK);
		setSize(300, 200);
		setLocation(200, 200);
		setResizable(true);
		setVisible(true);
		
		showFirst();
	}

	void showFirst() {
		pos = 0;
		display(pos);
	}

	void showPrevious() {
		pos = (pos > 0) ? --pos : 0;
		display(pos);
	}

	void showNext() {
		int size = wordList.size();
		pos = (pos < size - 1) ? ++pos : size - 1;
		display(pos);
	}

	void showLast() {
		pos = wordList.size() - 1;
		display(pos);
	}

	void display(int pos) { // pos��ġ�� �ִ� ������ ������ �����ش�.
		// 1. wordList���� pos��°�� ��ġ�� �ִ� �����͸� �о�´�.
		String data = (String)wordList.get(pos);
		StringBuffer sb = new StringBuffer();
		
		// 2. StringTokenizer�� �̿��ؼ� ��|���� �����ڷ� �ڸ���.
		StringTokenizer st = new StringTokenizer(data, "|");
		
		// 3. �߶��� Token�� ���๮��(CR_LF)�� �ٿ��� StringBuffer�� ���δ�.(append)
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken());
			sb.append(CR_LF);
		}
		
		// 4. StringBuffer�� ������ �̾Ƽ� TextArea�� �����ش�.
		ta.setText(sb.toString());

	}

	void loadFile(String fileName) {
		
		try {
			// 1. BuffredReader�� FileReader�� �̿��ؼ� ������ ������ ���� ������ �д´�.
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while((line=br.readLine())!=null) {
				// 2. �о�� ������ wordList�� �����Ѵ�.
				wordList.add(line);
			}
			
			br.close();
		} catch(IOException e) {
			// 3. ���� ���ܰ� �߻��ϸ� ���α׷��� �����Ѵ�.
			System.exit(0);
		}
		

	}

	public static void main(String args[]) {
		WordStudy mainWin = new WordStudy("Word Study");
	}

	class EventHandler extends WindowAdapter implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			Button b = (Button) ae.getSource();
			if (b == first) {
				showFirst();
			} else if (b == prev) {
				showPrevious();
			} else if (b == next) {
				showNext();
			} else if (b == last) {
				showLast();
			}
		}

		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	} // class EventHandler
}
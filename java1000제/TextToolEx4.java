package java1000;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

// [����4] TextArea�� �����Ϳ��� �� ������ �յ� ������ �����ϴ� ��ư 'trim'�� �� ���� �����ϴ� ����� '���ٻ���'��ư�� ���

public class TextToolEx4 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;

	String[] btnName = { "Undo", // �۾����� ���·� �ǵ���
			"¦���ٻ���", // ¦������ �����ϴ� ���
			"���ڻ���", // Param1�� ������ ���ڵ��� �����ϴ� ���
			"trim", // ������ �յ� ������ ����
			"���ٻ���", // �� �� ����
	};

	Button[] btn = new Button[btnName.length];

	private final String CR_LF = System.getProperty("line.separator"); // �ٹٲ޹���

	private String prevText = "";

	private void registerEventHandler() {
		addWindowListener(this);

		int n = 0; // ��ư����

		btn[n++].addActionListener(new ActionListener() { // Undo - �۾����� ���·� �ǵ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();

				if (!prevText.equals("")) {
					ta.setText(prevText);
				}

				prevText = curText;
			}
		});

		btn[n++].addActionListener(new ActionListener() { // ¦���ٻ��� - ¦������ �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���ڻ��� - Param1�� ������ ���ڸ� �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				String delText = tfParam1.getText();

				if ("".equals(delText))
					return;

				for (int i = 0; i < curText.length(); i++) {
					char ch = curText.charAt(i);

					if (delText.indexOf(ch) == -1)
						sb.append(ch);
				}

				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // trim - ������ �¿������ �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				// 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
				// (ScannerŬ������ hasNextLine(), nextLine()���)
				Scanner sc = new Scanner(curText);
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					
					// 2. �о�� ������ ���ʰ���� ������ ������ �����Ѵ�.(StringŬ������ trim()���)
					line = line.trim();
					sb.append(line).append(CR_LF);
				}

				// 3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
				ta.setText(sb.toString());

			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���ٻ��� - �� �� ����
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				// 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
				// (ScannerŬ������ hasNextLine(), nextLine()���)
				Scanner sc = new Scanner(curText);
				
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					
					// 2. �о�� ������ ������ ���� �� �����̸� sb�� �������� �ʴ´�.
					if(!line.equals("")) {
						sb.append(line).append(CR_LF);
					}
				}

				// 3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
				ta.setText(sb.toString());
			}
		});
	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx4 win = new TextToolEx4("Text Tool");
		win.show();
	}

	public TextToolEx4(String title) {
		super(title);
		lb1 = new Label("param1:", Label.RIGHT);
		lb2 = new Label("param2:", Label.RIGHT);
		tfParam1 = new TextField(15);
		tfParam2 = new TextField(15);

		ta = new TextArea();
		pNorth = new Panel();
		pSouth = new Panel();

		for (int i = 0; i < btn.length; i++) {

			btn[i] = new Button(btnName[i]);
		}

		pNorth.setLayout(new FlowLayout());
		pNorth.add(lb1);
		pNorth.add(tfParam1);
		pNorth.add(lb2);
		pNorth.add(tfParam2);

		pSouth.setLayout(new GridLayout(2, 10));

		for (int i = 0; i < btn.length; i++) { // ��ư�迭�� �ϴ� Panel�� �ִ´�.
			pSouth.add(btn[i]);
		}

		add(pNorth, "North");
		add(ta, "Center");
		add(pSouth, "South");

		setBounds(100, 100, 600, 300);
		ta.requestFocus();
		registerEventHandler();
		setVisible(true);
	} // public TextToolEx1(String title) {

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
} // end of class

package java1000;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

// [����7] TextArea�� �� ���ο��� param1�� �Էµ� ���ڿ��� param2�� �Էµ� ���ڿ��� ã�Ƽ�
// �� ���ڿ� ������ �ؽ�Ʈ�� ����� �����ϴ� ����� 'substring2'��ư�� �����ϼ���.

public class TextToolEx7 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;

	String[] btnName = { "Undo", // �۾����� ���·� �ǵ���
			"¦���ٻ���", // ¦������ �����ϴ� ���
			"���ڻ���", // Param1�� ������ ���ڵ��� �����ϴ� ���
			"trim", // ������ �յ� ������ ����
			"���ٻ���", // �� �� ����
			"���λ��߰�", // Param1�� Param2�� ���ڿ��� �� ������ �յڿ� ���̴� ���
			"substring", // Param1�� Param2�� ������ ���ڿ��� �� ���ο��� �����ϴ� ���
			"substring2", // Param1�� Param2�� ������ ���ڿ��� �ѷ����� �κ��� ����� �����ϴ� ���
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
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // trim - ������ �¿������ �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���ٻ��� - �� �� ����
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // ���λ� - �� ���ο� ���λ�, ���̻� ���̱�
			public void actionPerformed(ActionEvent ae) {
				/* ���� ���� */

			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring - ���ڿ� �ڸ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				int from = tfParam1.getText().length();
				int to = tfParam2.getText().length();

				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();

					if (line.length() < from + to)
						return;

					sb.append(line.substring(from, line.length() - to));
					sb.append(CR_LF);
				}

				ta.setText(sb.toString());
			}
		});

		btn[n++].addActionListener(new ActionListener() { // substring2 - ������ ���ڸ� ã�Ƽ� �� ��ġ���� �߶󳻱�
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				// 1. param1�� param2�� ���� �����´�.(getText()���)
				String pText1 = tfParam1.getText();
				String pText2 = tfParam2.getText();

				// 2. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
				Scanner sc = new Scanner(curText);

				while (sc.hasNextLine()) {
					String line = sc.nextLine();

					// 3. �� ���ο��� param1, param2�� ��ġ�ϴ� ���ڿ��� ��ġ�� ã�´�.
					// (param1�� ������ ���ʳ�����, param2�� ������ �����ʳ����� ã�� �����Ѵ�.)
					// param1�� param2�� �ѷ����� �κ��� sb�� �����Ѵ�.

					// param1�� ��ġ ã�� �� ���ĺ��� ����
					for (int i = 0; i < line.length(); i++) {
						// ���ο� ��ġ�ϴ� �� ������
						int idx1 = line.indexOf(pText1); // pText1�� �ִ� ��ġ

						if (idx1 != -1) { // line�� pText1 ��ġ�ϸ�
							// �ش� �ε��� + pText1�� ���� ���� ����
							line = line.substring(idx1 + pText1.length());
							
						}
						
					}
					
					// param2�� ��ġ ã�� �� �������� ����
					for (int j = line.length()-1; j >= 0 ; j--) {
						// ���ο� ��ġ�ϴ� �� ������
						int idx2 = line.indexOf(pText2); // pText2�� �ִ� ��ġ
						
						if (idx2 != -1) { // line�� pText2 ��ġ�ϸ�
							// �ش� �ε��� + pText2 - 2�� ���� ���� ����
							line = line.substring(0, idx2 + pText2.length()-2);
							sb.append(line);
							sb.append(CR_LF);
							
						}
					}
					

				}

				// 4. sb�� ������ TextArea�� �����ش�.
				ta.setText(sb.toString());

			}
		});
	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx7 win = new TextToolEx7("Text Tool");
		win.show();
	}

	public TextToolEx7(String title) {
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

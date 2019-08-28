package java1000;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

// [����1] ¦�� ���� �����ϴ� ��ư�� ����� �����ϼ���.

public class TextToolEx1 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;

	String[] btnName = { "¦���ٻ���", // btn[0] - ¦������ �����ϴ� ���
	};

	Button[] btn = new Button[btnName.length];

	private final String CR_LF = System.getProperty("line.separator"); // ���๮��(�ٹٲ޹���)

	private void registerEventHandler() {
		addWindowListener(this);

		btn[0].addActionListener(new ActionListener() { // ¦���ٻ��� - ¦������ �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				// 1. TextArea ta�� �ؽ�Ʈ�� �����´�.(getText()���)
				String taText = ta.getText();
				
				// 2. �۾��� ����� ������ StringBuffer sb�� �����Ѵ�.
				StringBuffer sb = new StringBuffer();
				
				// 3. ScannerŬ������ �ݺ����� �̿��ؼ� 1���� ������ �ؽ�Ʈ�� ���δ����� �д´�.
				// (ScannerŬ������ hasNextLine(), nextLine()���)
				Scanner sc = new Scanner(taText);
				
				// 4. ���ǹ��� ����ؼ� ¦������ ��쿡�� sb�� ��´�.
				int i = 0;	// ���� �� �������� ����
				
				while(sc.hasNextLine()) {
					String input = sc.nextLine();

					if(i%2 == 0)
						sb.append(input).append(CR_LF);
					i++;
				}
				
				// 5. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
				// setText() ��ȣ �ȿ��� String Ÿ���� �����ϹǷ� StringBufferŸ���� sb�� String���� ���
				ta.setText(sb.toString());
			}
		});
	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx1 win = new TextToolEx1("Text Tool");
		win.show();
	}

	public TextToolEx1(String title) {
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

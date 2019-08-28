package java1000;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

// [����2] �۾� ���� ���·� �ǵ����� Undo����� �����ϼ���.
// ���� ��� ¦���ٻ�����ư�� ���� ������ Undo��ư�� ������ TextArea�� ������ ¦���ٻ�����ư�� ������ ������ ���·� �ǵ��ư��� �մϴ�.

public class TextToolEx2 extends Frame implements WindowListener {
	TextArea ta;
	TextField tfParam1, tfParam2;
	Panel pNorth, pSouth;
	Label lb1, lb2;

	String[] btnName = { "Undo", // �۾����� ���·� �ǵ���
			"¦���ٻ���", // ¦������ �����ϴ� ���
	};

	Button[] btn = new Button[btnName.length];

	private final String CR_LF = System.getProperty("line.separator");

	private String prevText = ""; // TextArea ta�� ������ �����ϱ� ���� ����

	private void registerEventHandler() {
		addWindowListener(this);

		btn[0].addActionListener(new ActionListener() { // Undo - �۾����� ���·� �ǵ���
			public void actionPerformed(ActionEvent ae) {
				// ��ư �ѹ� ������ ���� ������ ���ư�
				String curText = ta.getText();	// ���� ���� ���� �ؽ�Ʈ ����
				
				// prevText�� ���
				StringBuffer sb = new StringBuffer(prevText.length());
				Scanner s = new Scanner(prevText);
				
				while(s.hasNextLine()) {
					String input = s.nextLine();
					sb.append(input).append(CR_LF);
				}
				ta.setText(sb.toString());
				
				// ������ �ۼ��� �ڵ带 ������ �Ʒ��� ���� ����
//				if(!prevText.equals(""))
//					ta.setText(prevText);
				
				// ��ư �ѹ� �� ������ ���� �ķ� ���ư�
				// prevText�� ���� ���� �ؽ�Ʈ�� curText �������� 
				prevText = curText;
				
			}
		});

		btn[1].addActionListener(new ActionListener() { // ¦���ٻ��� - ¦������ �����ϴ� ���
			public void actionPerformed(ActionEvent ae) {
				String curText = ta.getText();
				StringBuffer sb = new StringBuffer(curText.length());

				prevText = curText;

				Scanner s = new Scanner(curText);

				for (int i = 0; s.hasNextLine(); i++) {
					String line = s.nextLine();

					if (i % 2 == 0) {
						sb.append(line).append(CR_LF);
					}
				}

				ta.setText(sb.toString());
			}
		});
	} // end of registerEventHandler()

	public static void main(String[] args) {
		TextToolEx2 win = new TextToolEx2("Text Tool");
		win.show();
	}

	public TextToolEx2(String title) {
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

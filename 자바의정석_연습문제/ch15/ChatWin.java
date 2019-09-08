package ch15;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

class ChatWin extends Frame {
	String nickname = "";
	TextArea ta = new TextArea();
	Panel p = new Panel();
	TextField tf = new TextField(30);
	Button bSave = new Button("����");

	ChatWin(String nickname) {
		super("Chatting");
		this.nickname = nickname;
		setBounds(200, 100, 300, 200);
		p.setLayout(new FlowLayout());
		p.add(tf);
		p.add(bSave);
		add(ta, "Center");
		add(p, "South");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		bSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				FileDialog fileSave = new FileDialog(ChatWin.this, "��������", FileDialog.SAVE);
				fileSave.setVisible(true);
				String fileName = fileSave.getDirectory() + fileSave.getFile();
				saveAs(fileName);
			}
		});
		EventHandler handler = new EventHandler();
		ta.addFocusListener(handler);
		tf.addFocusListener(handler);
		tf.addActionListener(handler);
		ta.setText("#" + nickname + "�� ��ſ� ä�õǼ���.");
		ta.setEditable(false);
		setResizable(false);
		setVisible(true);
		tf.requestFocus();
	}

	void saveAs(String fileName) {
		
		try {
			FileWriter fw = new FileWriter(fileName);
			// ta�� ������ ������
			String str = ta.getText();
			
			// ������ ta�� ������ ���ο� ���Ͽ� ����
			fw.write(str);
			fw.close();
		} catch(IOException e) {}
		
	} // saveAs�޼����� ��

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java ChatWin NICKNAME");
			System.exit(0);
		}
		new ChatWin(args[0]);
	} // main

	class EventHandler extends FocusAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String msg = tf.getText();
			if ("".equals(msg))
				return;
			ta.append("\r\n" + nickname + ">" + msg);
			tf.setText("");
		}

		public void focusGained(FocusEvent e) {
			tf.requestFocus();
		}
	} // class EventHandler
} // class
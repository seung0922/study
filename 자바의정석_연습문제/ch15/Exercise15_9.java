package ch15;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Exercise15_9 extends Frame {
	String fileName;
	TextArea content;
	MenuBar mb;
	Menu mFile;
	MenuItem miNew, miOpen, miSaveAs, miExit;

	Exercise15_9(String title) {
		super(title);
		content = new TextArea();
		add(content);

		mb = new MenuBar();
		mFile = new Menu("File");

		miNew = new MenuItem("New");
		miOpen = new MenuItem("Open");
		miSaveAs = new MenuItem("Save As...");
		miExit = new MenuItem("Exit");

		mFile.add(miNew);
		mFile.add(miOpen);
		mFile.add(miSaveAs);
		mFile.addSeparator(); // �޴� �и���(separator)�� �ִ´�.
		mFile.add(miExit);

		mb.add(mFile); // MenuBar�� Menu�� �߰��Ѵ�.
		setMenuBar(mb); // Frame�� MenuBar�� ���Խ�Ų��.

		// �޴��� �̺�Ʈ �ڵ鷯�� ����Ѵ�.
		MyHandler handler = new MyHandler();
		miNew.addActionListener(handler);
		miOpen.addActionListener(handler);
		miSaveAs.addActionListener(handler);
		miExit.addActionListener(handler);

		setSize(300, 200);
		setVisible(true);
	}

	// ���õ� ������ ������ �о TextArea�� �����ִ� �޼���
	void fileOpen(String fileName) {
		try {
			// 1. BuffredReader�� FileReader�� �̿��ؼ� ������ ������ �д´�.
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			// 2.StringWriter�� ����Ѵ�.
			StringWriter sw = new StringWriter();

			String line = "";
			while ((line = br.readLine()) != null) {
				sw.write(line + "\n");
			}
			// 3. StringWriter�� ������ content(TextArea)�� �����ش�.
			content.setText(sw.toString());
			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // fileOpen�޼����� ��

	// TextArea�� ������ ������ ���Ͽ� �����ϴ� �޼���
	void saveAs(String fileName) {
		try {
			// 1. BuffredWriter�� FileWriter�� �����Ѵ�.
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			// 2. content�� �ִ� ������ �����ͼ� BufferedWriter�� ����Ѵ�.
			bw.write(content.getText());
			
			// 3. BufferedWriter�� �ݴ´�.
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // saveAs�޼����� ��

	public static void main(String args[]) {
		Exercise15_9 mainWin = new Exercise15_9("Text Editor");
	} // main�޼����� ��

	// �޴��� Ŭ������ �� �޴��� ó���ڵ�
	class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();

			if (command.equals("New")) {
				content.setText("");
			} else if (command.equals("Open")) {
				FileDialog fileOpen = new FileDialog(Exercise15_9.this, "���Ͽ���");

				fileOpen.setVisible(true);
				fileName = fileOpen.getDirectory() + fileOpen.getFile();
				System.out.println(fileName);
				// ���õ� ������ ������ TextArea�� �����ش�.
				fileOpen(fileName);
			} else if (command.equals("Save As...")) {
				FileDialog fileSave = new FileDialog(Exercise15_9.this, "��������", FileDialog.SAVE);

				fileSave.setVisible(true);
				fileName = fileSave.getDirectory() + fileSave.getFile();
				System.out.println(fileName);
				// ���� TextArea�� ������ ���õ� ���Ͽ� �����Ѵ�.
				saveAs(fileName);
			} else if (command.equals("Exit")) {
				System.exit(0); // ���α׷��� �����Ų��.
			}
		}
	} // class MyHandler
} // Exercise15_9Ŭ������ ��
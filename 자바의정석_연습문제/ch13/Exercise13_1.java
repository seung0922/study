

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exercise13_1 extends Frame {

	Button[][] btArr = new Button[5][5];	// ��ư �迭
	int[][] bingoArr = new int[5][5];	// ������ ��ư �����ϱ� ���� ���� �迭
	
	Exercise13_1(String title) {
		super(title);
		setSize(300, 300);
		setLayout(new GridLayout(5, 5));

		// 1. ����, ���� ũ�Ⱑ 5�� �������� ����ÿ�.
		// ��ư �迭 ����� �����ӿ� ��ư�迭 �߰�
		for (int i = 0; i < btArr.length; i++) {
			for (int j = 0; j < btArr[i].length; j++) {
				btArr[i][j] = new Button("��" + (i * 5 + j + 1));
				add(btArr[i][j]);
				EventHandler handle = new EventHandler();
				btArr[i][j].addActionListener(handle);
			}
		}
		
		addWindowListener(new EventHandler());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Exercise13_1 ex = new Exercise13_1("Bingo game");
		
	}
	
	int bingoCheck(int[][] arr) {	// ���� ��ִ��� �������� �޼���
		int result = 0;
		int cntW = 0; // ���� ī��Ʈ
		int cntH = 0; // ���� ī��Ʈ
		int cntDiagR = 0; // �����ʹ��� �밢�� ī��Ʈ
		int cntDiagL = 0; // ���ʹ��� �밢�� ī��Ʈ
		
		for (int i = 0; i < arr.length; i++) {
			cntW = 0; // ���� ī��Ʈ �ʱ�ȭ
			cntH = 0; // ���� ī��Ʈ �ʱ�ȭ
			
			for (int j = 0; j < arr[i].length; j++) {
				// ����
				if (arr[i][j] == 1) cntW++;
				
				// ����
				if (arr[j][i] == 1) cntH++;
				
				// ������ �밢��
				if (arr[i][j] == 1 && i == j) cntDiagR++;
				
				// ���� �밢��
				if (arr[i][j] == 1 && i + j == 4) cntDiagL++;
				
			}
			// ���� ����
			if (cntW == 5) result++;
			
			// ���� ����
			if (cntH == 5) result++;
			
			// ������ ���� �밢�� ����
			if (cntDiagR == 5) result++;
			
			// ���� ���� �밢�� ����
			if (cntDiagL == 5) result++;
		}
		return result;
	}

	class EventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			// 2. ��ư�� ������, ��ư�� ������ ���� ȸ��(Color.LIGHT_GRAY)�� �ٲ��
			Button b = (Button) ae.getSource();
			b.setBackground(Color.LIGHT_GRAY);

			// ���� ��ư�� ���ڰ� �ֿܼ� ��µǰ� �Ͻÿ�. -> �ܼ��ϰ� ����!!
			// �ֿܼ� ��µǰ� �ϴ� ���� System.out.println(); ���!
			// ��ư �̸��� �������� ���?
			System.out.println(b.getLabel());

			// ���� ��ư b�� ���� btArr�� �ش���ġ�� ������ bingoArr�� �ش���ġ�� 1����
			for (int i = 0; i < btArr.length; i++) {
				for (int j = 0; j < btArr[i].length; j++) {
					if (btArr[i][j] == b) {
						bingoArr[i][j] = 1;
						break;
					}
				}
			}
			
			// bingo ���� ��ȯ
			// bingo�� +1 �Ǵ� ������ ����Ҽ�������?
			System.out.println("������ = " + bingoCheck(bingoArr));
		} // public void actionPerformed(ActionEvent ae) {
		
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
		
	} // EventHandler �޼���
		
}
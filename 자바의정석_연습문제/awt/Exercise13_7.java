package ch13;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Exercise13_7 extends Frame implements MouseListener {
	final int LINE_NUM = 9; // ������ �� ��
	final int LINE_WIDTH = 30; // ������ �� ����
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM - 1); // �������� ũ��
	final int STONE_SIZE = (int) (LINE_WIDTH * 0.8); // ���� ũ��
	
	final int X0; // ������ ������ġ x��ǥ
	final int Y0; // ������ ������ġ y��ǥ
	
	final int FRAME_WIDTH; // Frame�� ��
	final int FRAME_HEIGHT; // Frame�� ����
	
	Image img = null;
	Graphics gImg = null;

	public Exercise13_7(String title) {
		super(title);
		
		// Event Handler�� ����Ѵ�.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setVisible(true); // Frame�� ȭ�鿡 ���̰� �Ѵ�.
		Insets insets = getInsets(); // ȭ�鿡 ���̱� ������ Insets�� ���� ���� �� ����.
		
		// ������ �׷��� ��ġ(LEFT, TOP)�� ��ǥ X0, Y0�� �����Ѵ�.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top + LINE_WIDTH;
		
		// Frame�� ũ�⸦ ����Ѵ�.
		FRAME_WIDTH = BOARD_SIZE + LINE_WIDTH * 2 + insets.left + insets.right;
		FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH * 2 + insets.top + insets.bottom;
		
		// Frame�� ȭ���� (100,100)�� ��ġ�� ���� ũ��� ���̰� �Ѵ�.
		setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
		
		setResizable(false); // Frame�� ũ�⸦ �������� ���ϰ� �Ѵ�.
		drawBoard(gImg);
		
	} // Exercise13_7(String title)

	public void drawBoard(Graphics g) {
		for (int i = 0; i < LINE_NUM; i++) {
			// drawLine(0, 0, 10, 10); // ���� (0,0)�� (10,10)�� �մ� �� �׸�
			g.drawLine(X0, Y0 + i * LINE_WIDTH, X0 + BOARD_SIZE, Y0 + i * LINE_WIDTH);
			g.drawLine(X0 + i * LINE_WIDTH, Y0, X0 + i * LINE_WIDTH, Y0 + BOARD_SIZE);
		}
	}

	public void paint(Graphics g) {
		if (img == null)
			return;
		// boolean drawImage(Image img, int x, int y, ImageObserver observer) - (x,y)�� ��ġ�� �̹����� �׸���.
		g.drawImage(img, 0, 0, this); // ����ȭ�鿡 �׷��� �׸��� Frame�� ����
	}

	public void mousePressed(MouseEvent e) { // MouseListener
		int x = e.getX(); // ���콺 �������� x��ǥ
		int y = e.getY(); // ���콺 �������� y��ǥ
		
		int r = STONE_SIZE / 2;	// ���� ������
		
		// 1. x�� y�� ���� �������� ���� ��� ���̸� ���� �׸��� �ʴ´�.
		// ���� ��(X0, Y0), ������ ��(X0+BOARD_SIZE, Y0)
		// ���� �Ʒ�(X0, Y0+BOARD_SIZE), ������ �Ʒ�(X0+BOARD_SIZE, Y0+BOARD_SIZE)
		// x�� x >= X0 && x <= X0+BOARD_SIZE
		// y�� y >= Y0 && y <= Y0+BOARD_SIZE
		// ����� ���������� �����ϴ� ������ �����Ƿ� ���� ��������ŭ �ۿ��� Ŭ��o -> ���������� �Ű����Ƿ�
		
		
		if(!((x >= X0-r && x <= X0+BOARD_SIZE+r) && ( y >= Y0-r && y <= Y0+BOARD_SIZE+r))) {
			// �� �׸��� �ʴ´�! ���� �׸��� �������� � �ڵ�?
			return;
		}
		
		// 2. x�� y�� ���� Ŭ���� ������ ���� ����� ���������� �����Ѵ�.(�ݿø�)
		x = LINE_WIDTH + X0 * (x-X0 + LINE_WIDTH/2)/LINE_WIDTH;
		y = LINE_WIDTH + Y0 * (y-Y0 + LINE_WIDTH/2)/LINE_WIDTH;
		
		// 3. x�� y�� ������ ���� ũ��(STONE_SIZE)�� ������ ���� Ŭ���� �������� �׷�����.
		x = x - r;
		y = y - r;
		
		if(e.getModifiers() == e.BUTTON3_MASK) {
			// 4. ������ ��ư�� ���콺 ������ ��ư�̸�, (x,y)�� ��ġ�� �� ���� �׸���.
			// (�� ���� �׸� �� ���� �� �׵θ��� ���� �׸���.)
			
			// ���� ���
			gImg.setColor(Color.WHITE);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);

			// �׵θ� ����
			gImg.setColor(Color.BLACK);
			gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
			
		}
		else {
			// ������ ��ư�� ���콺 ���� ��ư�̸�, (x,y)�� ��ġ�� ���� ���� �׸���
			gImg.setColor(Color.BLACK);
			gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
		}
		
		// 5. repaint()�� ȣ���Ѵ�.
		repaint();
	}
	

	// ���콺 ��ư�� �����ٰ� ������ ��
	public void mouseClicked(MouseEvent e) {
	} // MouseListener
	
	// ���콺 �����Ͱ� �̺�Ʈ �ҽ��� ���� ������ ������ ��
	public void mouseEntered(MouseEvent e) {
	} // MouseListener
	
	// ���콺 �����Ͱ� �̺�Ʈ �ҽ��� ���� �ȿ��� ������ �̵��� ��
	public void mouseExited(MouseEvent e) {
	} // MouseListener
	
	// ���콺 ��ư�� ������ ��
	public void mouseReleased(MouseEvent e) {
	} // MouseListener
	
	public static void main(String[] args) {
		new Exercise13_7("OmokTest");
	}
}

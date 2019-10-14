package org.zerock.server;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Fakelet2 extends Thread {	// ���� ����� ���ÿ� �����Ҽ��ְ� ������ ���
	// �������
	private Socket socket;		// ����
	private InputStream in;		// �б�
	private Scanner scanner;	// �Է¹ޱ�
	private OutputStream out;	// ����
	
	// ������
	public Fakelet2(Socket socket) throws Exception {
		this.socket = socket;
		in = socket.getInputStream();
		scanner = new Scanner(in);
		out = socket.getOutputStream();
	}
	
	@Override
	public void run() {
		try {
			String line = scanner.nextLine();
			
			String[] arr = line.split(" "); 	// �������� �ɰ�
			String target = arr[1].substring(1);	// aaa.jpg ����
			String app = target.substring(target.lastIndexOf(".")+1);	// .�ں��� �߶� ����
			String mimeType = FakeServer2.getMimeType(app);	// Ȯ���ڸ� ���� ������ ������ �ش� key�� value�� �����ͼ� ����
			
			// ���� �����������ϴ� ����Ÿ�Ծ����� ����
			if(mimeType == null) {
				AbstractLet let = new HelloLet();
				let.serve(in, out);
				return;
			}
			
			System.out.println("----------------------");
			System.out.println(target);
			System.out.println("----------------------");
			
			// input�� ���
			FileInputStream fin = new FileInputStream("C:\\zzz\\" + target);
			
			out.write(new String("HTTP/1.1 200 OK\r\n").getBytes()); 
		    out.write(new String("Cache-Control: private\r\n").getBytes()); 
//		    out.write(new String("Content-Length: "+ msg.getBytes().length+"\r\n")
//		    		.getBytes()); 
		    out.write(new String("Content-Type:" + mimeType + "\r\n\r\n")
		    		.getBytes());
		    
		    // ����� �������
		    byte[] buffer = new byte[1024*8];
		    
		    while(true) {
		    	int count = fin.read(buffer);
		    	
		    	if(count == -1) {
		    		break;
		    	}
		    	out.write(buffer, 0, count);
		    }
		    
		    out.flush();
			
		} catch(Exception e) {
			System.out.println(e);
		} finally {	// �� �ݾ� �����
			try { in.close(); } catch(Exception e) {}
			try { out.close(); } catch(Exception e) {}
			try { socket.close(); } catch(Exception e) {}
		}
	}
}

package org.zerock.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class FakeServer2 {
	
	// Ȯ���ڸ��� content-type �ٸ������ֱ����� Map����
	private static Map<String, String> mimeMap;
	
	static {
		mimeMap = new HashMap<>();
		mimeMap.put("jpg", "image/jpeg");
		mimeMap.put("mp4", "video/mp4");
		mimeMap.put("html", "text/html");
	}
	
	public static String getMimeType(String type) {
		return mimeMap.get(type);	// ���ڿ��� �ָ� map�� key�� �ش��ϴ� value ��ȯ
	}
	
	public void runServer() throws Exception {
		ServerSocket ss = new ServerSocket(7777);
		
		System.out.println("Server Ready....2");
		
		for(int i=0; i<100; i++) { // ������ ������ ������ַ��� for�� ��
			Socket socket = ss.accept();
			System.out.println(socket);
			
			Fakelet2 let = new Fakelet2(socket);
			let.start();	// ������ϱ� start����
		}
	}
	
	public static void main(String[] args) throws Exception {
		new FakeServer2().runServer();
	}
}

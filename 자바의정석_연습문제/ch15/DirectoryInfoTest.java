package ch15;

import java.io.*;

// ���丮 ������� �����ִ� ���α׷�
class DirectoryInfoTest {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("USAGE : java DirectoryInfoTest DIRECTORY");
			System.exit(0);
		}
		File dir = new File(args[0]);
		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		countFiles(dir);
		System.out.println();
		System.out.println(" ��" + totalFiles + "���� ����");
		System.out.println("�� " + totalDirs + "���� ���丮");
		System.out.println("ũ�� " + totalSize + " bytes");
	} // main

	// ���丮 ������� - ������ ����, ���丮�� ����, ������ �� ũ�⸦ ���
	public static void countFiles(File dir) {
		// 1. dir�� ���ϸ��(File[])�� ���´�.
		File[] fArr = dir.listFiles();
		
		// 2. ���� ���ϸ���� ���� �߿���...
		// ���丮�̸�, totalDirs�� ���� ������Ű�� countFiles()�� ���ȣ���Ѵ�.
		for(int i=0; i<fArr.length; i++) {
			if(fArr[i].isDirectory()) {
				totalDirs++;
				countFiles(fArr[i]);
			} else if(fArr[i].isFile()) {
				// 3. �����̸�, totalFiles�� ������Ű�� ������ ũ�⸦ totalSize�� ���Ѵ�.
				totalFiles++;
				totalSize += fArr[i].length();
			}
		}
		

	} // countFiles
}

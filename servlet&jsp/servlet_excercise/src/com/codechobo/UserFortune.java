package com.codechobo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UserFortune {
	HashMap<String, Integer> userMap = new HashMap();	// ����������(key)�� ������ ��(value) ������ map
	
	ArrayList<String> fortuneList() {
		ArrayList<String> resultList = new ArrayList<>();	// � ������ �迭
		try {
			// 1) BuffredReader�� FileReader�� �̿��ؼ� ������ ������ �д´�.
			// ( txt���Ͽ� ����� � ��������)
			FileReader fr = new FileReader("C:\\fortune.txt");
			BufferedReader br = new BufferedReader(fr);
			
			// 2) ���κ��� �о fortuneList�� �����Ѵ�.
			String line = "";
			while((line=br.readLine())!=null) {
				resultList.add(line);
			}
			
		} catch(IOException e) {
			System.exit(0);
		}
		return resultList;
	}
	
}


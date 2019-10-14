package com.codechobo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FortuneAction")
public class FortuneAction extends HttpServlet {
	// ���������Ϳ� ������� ������ collector �����س��� Ŭ���� �����Ѵ�.
	UserFortune cl = new UserFortune();
	// ���������Ϳ� ������ ������ userMap, ��迭 ����� fortuneList �����´�.
	HashMap<String, Integer> userMap = cl.userMap;
	ArrayList<String> fortuneList = cl.fortuneList();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ����ڿ��� �Է¹��� �� ���� �´�.
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String date = request.getParameter("date");
		
		// 2. �۾� �Ѵ�.
		// 2-1. ����� �Է¹��� ������ ���ļ� ���ڿ��� �����Ѵ�.
		String userData = name + age + date;
		
		// 2-2 Map�� �ش� ����� ������ �ִ��� Ȯ���Ѵ�. 
		if (!userMap.containsKey(userData)) { // 1) �ش� ����� ������ ������
			// 2) ������ �� ������ ����
			int r = (int) (Math.random() * fortuneList.size());

			// 3) key���� ����������, value���� ������ �ִ´�.
			userMap.put(userData, r);
		}
		
		// 2-3. result�� key�� �ش� ���� �����Ͱ��� ������ value(������ ������ ������ ����)��ȯ 
		int userIdx = userMap.get(userData);
		
		// 2-4. fortuneList���� ������ ���� ������ ������ ��ġ �� ��ȯ
		String result = fortuneList.get(userIdx);
		
		// 3. ȭ�鿡 ���
		// �ѱ����� �ȱ����� ���ִ� ����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("    <meta charset='UTF-8'>");
		out.println("    <title>Document</title>");
		out.println("<body>");
		out.println("    <h1>������ �</h1>");
		out.println("");
		out.println("    <div>");
		out.println("        <form>");
		out.println("            <label for='name'>�̸�</label>");
		out.println("            <input type='text' name='name' required><br>");
		out.println("            <label for='age'>����</label>");
		out.println("            <input type='text' name='age' required><br>");
		out.println("            <label for='date'>��¥</label>");
		out.println("            <input type='date' name='date' value='�����'>");
		out.println("            <input type='submit' id='btn'></input><br>");
		out.println("        </form>");
		out.println("            <textarea id='memo' cols='30' rows='10'>" + result + "</textarea>");
		out.println("            <p id='txt'></p>");
		out.println("    </div>");
		out.println("</body>");
		out.println("</html>");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

//package com.codechobo;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/TodayTestServlet")
//public class FortuneServlet extends HttpServlet {
//	static HashMap result = new HashMap();
//	static String[] arr = { "�1", "�2", "�3", "�4", "�5", "�6", "�7", "�8", "�9", "�10", "�11", "�12",
//			"�13", "�14", "�15", "�16", "�17", "�18", "�19", "�20", "�21", "�22", "�23", "�24", "�25",
//			"�26", "�27", "�28", "�29", "�30", "�31", "�32", "�33", "�34", "�35", "�36", "�37", "�38",
//			"�39", "�40", };
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// 1. ����ڿ��� �Է¹��� �� ���� �´�.
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String date = request.getParameter("date");
//
//		// 2. �۾� �Ѵ�.
//		// 1. ����� �Է¹��� ������ ���ļ� ���ڿ��� �����Ѵ�.
//		String userData = name + age + date;
//
//		// 2. Map�� �ش� ����� ������ �ִ��� Ȯ���Ѵ�. 
//		if (!result.containsKey(userData)) { // 2-1. �ش� ����� ������ ������
//			// � �������� �� �޾ƿͼ� 
//			int r = (int) (Math.random() * arr.length);
////			String unsaeRandom = arr[r];
//
//			// key���� ����������, value���� � ������ �ִ´�.
//			result.put(userData, unsaeRandom);
//
//		}
//		
//		
//		// �ؽ�Ʈ���� �о���°�
//		ArrayList wordList = new ArrayList();
//		try {
//			FileReader fr = new FileReader("fortune.txt");
//			BufferedReader br = new BufferedReader(fr);
//			
//			String line = "";
//			int i = 0;
//			while((line=br.readLine())!=null) {
//				// 2. �о�� ������ wordList�� �����Ѵ�.
//				wordList.add(line);
////				System.out.println(i + ":" + line);
//				i++;
//			}
//			
//			br.close();
//			
//		} catch(IOException e) {
//			// 3. ���� ���ܰ� �߻��ϸ� ���α׷��� �����Ѵ�.
//			System.out.println("����");
//			System.exit(0);
//		}
//
//		// 3. ȭ�鿡 ���
//		// �ѱ����� �ȱ����� ���ִ� ����
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//
//		PrintWriter out = response.getWriter();
//
//		out.println("<!DOCTYPE html>");
//		out.println("<html lang='en'>");
//		out.println("<head>");
//		out.println("    <meta charset='UTF-8'>");
//		out.println("    <title>Document</title>");
//		out.println("<body>");
//		out.println("    <h1>������ �</h1>");
//		out.println("");
//		out.println("    <div>");
//		out.println("        <form>");
//		out.println("            <label for='name'>�̸�</label>");
//		out.println("            <input type='text' name='name' ><br>");
//		out.println("            <label for='age'>����</label>");
//		out.println("            <input type='text' name='age'><br>");
//		out.println("            <label for='date'>��¥</label>");
//		out.println("            <input type='text' name='date' maxlength='8' placeholder='8�����̻� ex)19950922'>");
//		out.println("            <input type='submit' id='btn'></input><br>");
//		out.println("        </form>");
//		out.println("            <textarea id='memo' cols='30' rows='10'></textarea>");
//		out.println("            <p id='txt'></p>");
//		out.println("    </div>");
//		out.println("    <script src='https://code.jquery.com/jquery-1.11.3.js'></script>");
//		out.println("    <script>");
//		out.println("        $(document).ready(function() {");
//		out.println("            $('#btn').click(function() {");
////		out.println("                alert('dd')");
//		out.println("                $('#memo').val('" + result.get(userData) + "');");
////		out.println("                $('#txt').html('" + result.get(userData) + "');");
//		out.println("            });");
//		out.println("        });");
//		out.println("    </script>");
//		out.println("</body>");
//		out.println("</html>");
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}

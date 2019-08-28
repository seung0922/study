package java1000;

import java.io.*; 
import java.util.*; 
import java.util.regex.*; 

// Q. ������ Ű���带 ������ ���Ͽ��� ã�Ƽ� ȭ�鿡 �����ִ� find��ɾ �����϶�.
// (�ش� KEYWORD�� ���Ե� ���ΰ� ���ι�ȣ�� ȭ�鿡 ���, ������ ����)
// ��ɾ��� ������ 'find KEYWORD FILE_NAME'�̸�, ���Ŀ� ���� �������� ������ �����ش�

// KEYWORD - ������ ���Ͽ��� ã�� ���ϴ� ���ڿ�
// FILE_NAME - KEYWORD�� ���Ե� ������ ã�� ����(console*.*�� ���� ������������ ����)


class ConsoleEx7 { 
      static String[] argArr;       // �Է��� �Ű������� ������� ���ڿ��迭 
      static LinkedList q = new LinkedList(); // ����ڰ� �Է��� ������ ������ ť(Queue) 
      static final int MAX_SIZE = 5; // Queue�� �ִ� 5�������� ����ǵ��� �Ѵ�. 

      static File curDir; 

      static { 
            try { 
                  curDir = new File(System.getProperty("user.dir")); 
            } catch(Exception e) {} 
      }

      public static void main(String[] args) {

            Scanner s = new Scanner(System.in); // �ѹ��� �����ؼ� �����ϸ� �ǹǷ� �ݺ��� ������ �̵�

            while(true) { 
                  try { 
                        String prompt = curDir.getCanonicalPath() + ">>"; 
                        System.out.print(prompt); 
                  
                        // ȭ�����κ��� ���δ����� �Է¹޴´�. 
                        String input = s.nextLine(); 

                        save(input); 

                        input = input.trim(); // �Է¹��� ������ ���ʿ��� �յ� ������ �����Ѵ�. 
                        argArr = input.split(" +"); // ó���� " "�� �ߴٰ� �������� �����ϰ� ����������� ���� 

                        String command = argArr[0].trim(); 

                        if("".equals(command)) continue; 

                        command = command.toLowerCase(); // ��ɾ �ҹ��ڷ� �ٲ۴�. 

                        if(command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�. 
                              System.exit(0); 
                        } else if(command.equals("history")) { 
                              history(); 
                        } else if(command.equals("dir")) { 
                              dir(); 
                        } else if(command.equals("type")) { 
                              type(); 
                        } else if(command.equals("find")) { 
                              find(); 
                        } else { 
                              for(int i=0; i < argArr.length;i++) { 
                                    System.out.println(argArr[i]); 
                              } 
                        } 
                  } catch(Exception e) { 
                        System.out.println("�Է¿����Դϴ�."); 
                  }                   
            } // while(true) 
      } // main 

      public static void save(String input) { 
             /* ���� ���� */
      } 

      public static void history() { 
             /* ���� ���� */
      } 

      public static void dir() { 

             /* ���� ���� */
      } // dir() 

      public static void type() throws IOException { 
            if(argArr.length !=2) { 
                  System.out.println("Usage : type FILE_NAME"); 
                  return; 
            } 

            String fileName = argArr[1]; 

            File tmp = new File(curDir, fileName); 

            if(tmp.exists()) { 
                  FileReader fr = new FileReader(tmp); 
                  BufferedReader br = new BufferedReader(fr); 

                  String line = "";
                  for(int i=1;(line=br.readLine())!=null;i++) { 
                        System.out.println(line); 
                  } 
            } else { 
                  System.out.println(fileName + " �������� �ʴ� �����Դϴ�."); 
            } 

            return; 
      } 

      public static void find() throws IOException { 
            if(argArr.length!=3) { 
                  System.out.println("USAGE : find KEYWORD FILE_NAME"); 
                  return; 
            } 

            // KEYWORD - ������ ���Ͽ��� ã�� ���ϴ� ���ڿ�
            // FILE_NAME - KEYWORD�� ���Ե� ������ ã�� ����(console*.*�� ���� ������������ ����)
            String keyword = argArr[1]; 
            String fileName = argArr[2]; 

            File tmp = new File(fileName); 

            // 1. ����(tmp)�� �����ϸ�,
            if(tmp.exists()) {
            	FileReader fr = new FileReader(tmp);
    			BufferedReader br = new BufferedReader(fr);

    			String line = "";

    			// 1.1 �ݺ����� �̿��ؼ� ���κ��� �о keyword�� ���ԵǾ����� Ȯ���Ѵ�.
    			//(BufferedReader�� readLine()���)
    			for (int i = 1; (line = br.readLine()) != null; i++) {
    				// 1.2 keyword�� ���Ե� ������ �߰��ϸ�, ���ι�ȣ�� �Բ� �ش� ������ ȭ�鿡 ����Ѵ�.
    				// indexOf()�� ���ڿ����� �־��� ���ڿ��� ��ġ�� ��ȯ
    				// line ���� keyword�� ��ġ�� Ȯ���ϰ�, ������(-1�� �ƴϸ�) �ش���� ���
    				if(line.indexOf(keyword) != -1)
    					System.out.println(i + ":" + line);
    			}
            	
            } else {	//2. �������� ������, �������� �ʴ� �����̶�� ȭ�鿡 ����Ѵ�.
            	System.out.println("�������� �ʴ� �����Դϴ�.");
            }


 


          

 

            return; 
      } 
} // class

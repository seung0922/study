package java1000;

import java.util.*;

// [����6] �����͸� ������ ũ�⿡ ���� �����ϴ� format�޼��带 �ϼ��ϰ�,
// �� �޼��带 �̿��ؼ�ȭ�鿡 �����͸� �������� ���� �ٸ��� ����ϼ���.
// String format(String str, int length, int alignment)
// - �־��� ���ڿ�(str)�� ������ ����(length)�� �°�����(alignment)�Ѵ�.
// ���� ��� format("�̸�", 6, CENTER)�� ����� "  �̸�  "�� �ȴ�.

class SungJukEx6 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();

		// �̸�, ��, ��ȣ, ����, ����, ����
		list.add(new Student("���ü�", 3, 2, 100, 100, 100));
		list.add(new Student("���ڹ�", 3, 1, 90, 100, 80));
		list.add(new Student("�ڹٿ�", 3, 3, 70, 100, 100));
		list.add(new Student("ŷ��¯", 1, 2, 100, 60, 90));
		list.add(new Student("�ڹ�¯", 1, 1, 100, 100, 100));
		list.add(new Student("�ְ��", 1, 3, 100, 80, 60));
		list.add(new Student("ȫ�浿", 2, 1, 50, 80, 100));
		list.add(new Student("������", 2, 3, 70, 80, 100));
		list.add(new Student("������", 2, 4, 80, 80, 85));
		list.add(new Student("�̿���", 2, 2, 90, 90, 90));

		calculateSchoolRank(list); // ��������� ����Ѵ�.

		calculateClassRank(list); // �ݵ���� ����Ѵ�.
		printList(list);
	}

	public static void printList(List<Student> list) {
		System.out.println("�̸�     ��  ��ȣ  ����  ����  ����   ����  �������  �ݵ��");
		System.out.println("=============================================================");

		for (Student s : list) {
			System.out.println(s);
		}

		System.out.println("=============================================================");
	}

	public static void calculateSchoolRank(List<Student> list) {
		Collections.sort(list);

		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		for (int i = 0; i < length; i++) {
			Student s = list.get(i);

			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				s.schoolRank = i + 1;
			}

			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	} // public static void calculateSchoolRank(List<Student> list) {

	public static void calculateClassRank(List<Student> list) {
		Collections.sort(list, new ClassTotalComparator()); // ���� �ݺ� �������� ������������ �����Ѵ�.

		int prevClassNo = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();

		for (int i = 0, n = 0; i < length; i++, n++) {
			Student s = list.get(i);

			if (s.classNo != prevClassNo) {
				prevRank = -1;
				prevTotal = -1;
				n = 0;
			}

			if (s.total == prevTotal) {
				s.classRank = prevRank;
			} else {
				s.classRank = n + 1;
			}

			prevClassNo = s.classNo;
			prevRank = s.classRank;
			prevTotal = s.total;
		}
	} // public static void calculateClassRank(List<Student> list) {
}

class Student implements Comparable<Student> {

	final static int LEFT = 0;
	final static int CENTER = 1;
	final static int RIGHT = 2;

	String name = "";
	int classNo = 0;
	int studentNo = 0;
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;

	int total = 0;

	int schoolRank = 0; // �������

	int classRank = 0; // �ݵ��

	Student(String name, int classNo, int studentNo, int koreanScore, int mathScore, int englishScore) {
		this.name = name;
		this.classNo = classNo;
		this.studentNo = studentNo;
		this.koreanScore = koreanScore;
		this.mathScore = mathScore;
		this.englishScore = englishScore;

		total = koreanScore + mathScore + englishScore;
	}

	public String toString() {
		return format(name, 5, LEFT) + format("" + classNo, 4, RIGHT) + format("" + studentNo, 4, RIGHT)
				+ format("" + koreanScore, 6, RIGHT) + format("" + mathScore, 6, RIGHT)
				+ format("" + englishScore, 6, RIGHT) + format("" + total, 8, RIGHT) + format("" + schoolRank, 8, RIGHT)
				+ format("" + classRank, 8, RIGHT);
	}

	public int compareTo(Student obj) {
		return obj.total - this.total;
//  return this.name.compareTo(obj.name); // �̸��������� �������� ���� 
	}

	/* ���׸���(Generics) ������� ���� ���� 
	
	public int compareTo(Object obj) { 
		int result = -1;
	  
		if(obj instanceof Student) {
		 	Student tmp = (Student)obj;
	  
			result = tmp.total - this.total; 
		}
	  
	  		return result; 
	}
	 */

	public static String format(String str, int length, int alignment) {

		if (str == null)
			str = "";
		int diff = length - str.length();

		// �־��� ���ڿ�(str)�� ���̺��� length�� ���� ������ str�� length��ŭ�� ����� �߶󳽴�.
		// ���� ���, str�� "012345"�̰�, length�� 3�̸� ����� "012"�� �ȴ�.
		
		if (diff < 0)
			return str.substring(0, length);

		char[] source = str.toCharArray();
		char[] result = new char[length];

		// �迭 result�� �������� ä���.
		for (int i = 0; i < result.length; i++)
			result[i] = ' ';

		// 1. ���ǹ��� �̿��ؼ� alignment�� ���� ���� �ٸ��� ó���Ѵ�.
		// (�迭���� ���翡�� System.arraycopy()�� ����Ѵ�.)
		
		
		if(alignment == CENTER) {	// 1.1 alignment�� ���� CENTER�� ��,
			// source�� ������ result�� ��� ����ǵ��� �Ѵ�.
			System.arraycopy(source, 0, result, diff/2, source.length);
		} else if(alignment == RIGHT) {	// 1.2 alignment�� ���� RIGHT�� ��
			// source�� ������ ���� result�� ������ ���� �ٰ� ����ǵ��� �Ѵ�.
			System.arraycopy(source, 0, result, diff, source.length);
		} else {	// 1.3 alignment�� ���� LEFT �Ǵ� �� ���� �� �� ��
			// source�� ������ result�� ���ʳ� ���� ����ǵ��� �Ѵ�..
			System.arraycopy(source, 0, result, 0, source.length);
		}

		

		

		return new String(result);
	}

} // end of class Student

class ClassTotalComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		int result = s1.classNo - s2.classNo;

		if (result == 0)
			result = s2.total - s1.total;

		return result;
	}
}

class ClassStudentNoComparator implements Comparator<Student> {
	public int compare(Student s1, Student s2) {

		int result = s1.classNo - s2.classNo;

		if (result == 0)
			result = s1.studentNo - s2.studentNo;

		return result;
	}
}

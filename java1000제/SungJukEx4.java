package java1000;

import java.util.*;

// [����4] �������� ��������� ����ϰ� ������ ���� ������ ���� ��(��������)���� �����ؼ� list�� ����ϼ���.
// ��������� ������ �� �ֵ��� StudentŬ������ �ν��Ͻ����� schoolRank�� �߰��Ǿ� �ֽ��ϴ�.
// calculateSchoolRank(List<Student> list) - �������(schoolRank)�� ����Ѵ�.

class SungJukEx4 {
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
		printList(list);
	}

	public static void printList(List<Student> list) {
		System.out.println("�̸�\t��\t��ȣ\t����\t����\t����\t����\t������� ");
		System.out.println("=================================================================");

		for (Student s : list) {
			System.out.println(s);
		}

		System.out.println("=================================================================");
	}

	public static void calculateSchoolRank(List<Student> list) {
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.

		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();

		// list�� �̹� ���������� ���ĵǾ� �ֱ� ������... ���� �������ϰ� ������ ���ϸ� �ȴ�.

		// 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i=0; i<list.size(); i++) {
			Student s = list.get(i);
			
			if(s.total == prevTotal) { // 1.1 ����(total)�� ��������(prevTotal)�� ������
				// ���� ���(prevRank)�� ���(schoolRank)�� �Ѵ�.
				prevRank = s.schoolRank;
			} else { // 1.2 ������ ���� �ٸ���
				// ���(schoolRank)�� ���� �˸°� ����ؼ� �����Ѵ�.
				// ������ ������ ���ٸ�, �� ���� ����� �������� ���� ����ؼ� ���Ǿ���Ѵ�.
				s.schoolRank = i + 1;
			}
			// 1.3 ���� ������ ����� ��������(prevTotal)�� �������(prevRank)�� �����Ѵ�.
			
		}
		

	} // public static void calculateSchoolRank(List<STUDENT> list) {
}

class Student implements Comparable<Student> {
	String name = "";
	int classNo = 0;
	int studentNo = 0;
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;

	int total = 0;

	int schoolRank = 0; // �������

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
		return name + "\t" + classNo + "\t" + studentNo + "\t" + koreanScore + "\t" + mathScore + "\t" + englishScore
				+ "\t" + total + "\t" + schoolRank + "\t";
	}

	public int compareTo(Student obj) {
		return obj.total - this.total;
//     return this.name.compareTo(obj.name); // �̸��������� �������� ���� 
	}

	/*
	 * ���׸���(Generics) ������� ���� ���� public int compareTo(Object obj) { int result = -1;
	 * 
	 * if(obj instanceof Student) { Student tmp = (Student)obj;
	 * 
	 * result = tmp.total - this.total; }
	 * 
	 * return result; }
	 */
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

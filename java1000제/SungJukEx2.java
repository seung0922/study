package java1000;

import java.util.*; 

// [����2] StudentŬ������ Comparable�������̽��� �����ؼ�, list�� ����(total) ������������ ����

class SungJukEx2 {
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

		Collections.sort(list);
		printList(list);
	}

	public static void printList(List<Student> list) {
		System.out.println("�̸�\t�г�\t��\t����\t����\t����\t���� ");
		System.out.println("====================================================");

		for (Student s : list) {
			System.out.println(s);
		}

		System.out.println("====================================================");
	}
}

class Student implements Comparable<Student> {
	String name = "";
	int classNo = 0;
	int studentNo = 0;
	int koreanScore = 0;
	int mathScore = 0;
	int englishScore = 0;
	int total = 0;

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
				+ "\t" + total + "\t";
	}

	public int compareTo(Student obj) {
		// ������ �������� �������� ����
//		return this.total > obj.total ? -1 : (this.total < obj.total ? 1 : 0);
		return obj.total - this.total;
	}
} // end of class Student

package ch11;

import java.util.*;

class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank; // �������
	int classRank; // �ݵ��

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public int compareTo(Object o) {
		if (o instanceof Student) {
			Student tmp = (Student) o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}

	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage()
				+ "," + schoolRank + "," + classRank // �����߰�
		;
	}
} // class Student

class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		// �ݺ� �������� �������� ����
		if(!(o1 instanceof Student || o2 instanceof Student))
			return -1;
		
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		
		// �ݺ��� ������ ������
		if(s1.ban > s2.ban) {
			return 1;
		} else if(s1.ban < s2.ban) {
			return -1;
		} else {
			return s1.total > s2.total ? -1 : (s1.total < s2.total ? 1 : 0);
		}
		
		
	}
}

class Exercise11_9 {
	public static void calculateClassRank(List list) {
// ���� �ݺ� �������� ������������ �����Ѵ�.
		Collections.sort(list, new ClassTotalComparator());
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		// 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�. 
		for(int i=0, n=0; i<length; i++, n++) {
			Student s = (Student)list.get(i);
			// 1.1 ���� �޶�����,(ban�� prevBan�� �ٸ���)
			// ���� ���(prevRank)�� ���� ����(prevTotal)�� �ʱ�ȭ�Ѵ�. 
			if(s.ban != prevBan) {
				prevRank = -1;
				prevTotal = -1;
				n = 0;	// �ݺ� ��� �����ϱ����� ����
			}
			
			// 1.2 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(classRank)�� �Ѵ�. 
			if(s.total == prevTotal) {
				s.classRank = prevRank;
			} else {
				// 1.3 ������ ���� �ٸ���, ���(classRank)�� ���� �˸°� ����ؼ� �����Ѵ�.
				// ������ �����ڿ��ٸ�, �� ���� ����� �������� ���� ����ؾ��Ѵ�. (������ ����) 
				s.classRank = n + 1;
			}
			// 1.4 ���� �ݰ� ������ ����� ���� ��(prevBan), ���� ����(prevTotal), �������(prevRank)�� ����
			prevBan = s.ban;
			prevTotal = s.total;
			prevRank = s.classRank;
		}
		
	} // public static void calculateClassRank(List list) {

	public static void calculateSchoolRank(List list) {
		Collections.sort(list); // ���� list�� �������� ������������ �����Ѵ�.

		// prevRank�� -1�� �س��� ����� ���ü��ִ� ����� ������
		int prevRank = 0; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();

		// 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for (int i = 0; i < length; i++) {
			Student s = (Student) list.get(i);

			// 1.1 ����(total)�� ��������(prevTotal)�� ������ ���� ���(prevRank)�� ���(schoolRank)�� �Ѵ�.
			if (s.total == prevTotal) {
				s.schoolRank = prevRank;
			} else {
				// 1.2 ������ ���� �ٸ���, ���(schoolRank)�� ���� �˸°� ����ؼ� �����Ѵ�.
				// ������ ������ ���ٸ�, �� ���� ����� �������� ���� ����ؾ� �Ѵ�. (������ ����)
				s.schoolRank = i + 1;
			}
			// 1.3 ���� ������ ����� ��������(prevTotal)�� �������(prevRank)�� �����Ѵ�.
			prevRank = s.schoolRank;
			prevTotal = s.total;
		}
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("���ڹ�", 2, 1, 70, 90, 70));
		list.add(new Student("���ڹ�", 2, 2, 60, 100, 80));
		list.add(new Student("ȫ�浿", 1, 3, 100, 100, 100));
		list.add(new Student("���ü�", 1, 1, 90, 70, 80));
		list.add(new Student("���ڹ�", 1, 2, 80, 80, 90));
		calculateSchoolRank(list);
		calculateClassRank(list);
		Iterator it = list.iterator();
		while (it.hasNext())
			System.out.println(it.next());
	}
}
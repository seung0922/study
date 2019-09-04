package ch14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student {
	String name;
	boolean isMale; // ����
	int hak; // �г�
	int ban; // ��
	int score;

	Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	String getName() {
		return name;
	}

	boolean isMale() {
		return isMale;
	}

	int getHak() {
		return hak;
	}

	int getBan() {
		return ban;
	}

	int getScore() {
		return score;
	}

	public String toString() {
		return String.format("[%s, %s, %d�г� %d��, %3d��]", name, isMale ? "��" : "��", hak, ban, score);
	}

// groupingBy()���� ���
	enum Level {
		HIGH, MID, LOW
	} // ������ ��, ��, �� �� �ܰ�� �з�
}

class Exercise14_8 {
	public static void main(String[] args) {
		Student[] stuArr = { new Student("������", false, 1, 1, 250), 
				new Student("���ڹ�", true, 1, 1, 200),
				new Student("������", false, 1, 2, 150), 
				new Student("���ڹ�", true, 1, 2, 100),
				new Student("������", false, 1, 2, 50), 
				new Student("Ȳ����", false, 1, 3, 100),
				new Student("������", false, 1, 3, 150), 
				new Student("���ڹ�", true, 1, 3, 200),
				new Student("���ڹ�", true, 2, 1, 300), 
				new Student("������", false, 2, 1, 250),
				new Student("���ڹ�", true, 2, 1, 200), 
				new Student("������", false, 2, 2, 150),
				new Student("���ڹ�", true, 2, 2, 100), 
				new Student("������", false, 2, 2, 50),
				new Student("Ȳ����", false, 2, 3, 100), 
				new Student("������", false, 2, 3, 150),
				new Student("���ڹ�", true, 2, 3, 200) };
		
		Map<Boolean, Map<Boolean, Long>> failedStuBySex = Stream.of(stuArr)
				.collect(
						partitioningBy(Student::isMale, 
								partitioningBy(s->s.getScore() < 150, counting())
						)
				);
		
		long failedMaleStuNum = failedStuBySex.get(true).get(true);
		long failedFemaleStuNum = failedStuBySex.get(false).get(true);
		
		System.out.println("���հ�[����]:" + failedMaleStuNum + "��");
		System.out.println("���հ�[����]:" + failedFemaleStuNum + "��");
	}
}
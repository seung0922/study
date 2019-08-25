package ch11;

import java.util.*;

// �������� 1,2,3,4�� 3,4,5,6�� ������, ������, �������� ���ϴ� �ڵ�
class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList(); // ������
		ArrayList cha = new ArrayList(); // ������
		ArrayList hap = new ArrayList(); // ������
		
		// list1 = { 1, 2, 3, 4 }
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		// list2 = { 3, 4, 5, 6 }
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		// ArrayListŬ������ addAll() - �־��� �÷��� ��� ����
		// removeAll() - ���� �÷��ǿ� ����� �Ͱ� ������ ��ü�� ����
		// retianAll() - �־��� �÷��ǰ� ����� �͵鸸 ����� ����
		
		// 1. ������ - list1�� list2�� ����� ��
		kyo.addAll(list1);
		kyo.retainAll(list2);
		
		// 2. ������ - (list1 + list2) - list2
		cha.addAll(list1);
		cha.removeAll(list2);
		
		// 3. ������ - list1�� list2�� ��簪 (�ߺ�x)
		hap.addAll(cha);
		hap.addAll(list2);
		
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}
package test0813;

import java.util.Arrays;

//Q1.Object�迭 objArr�� iv�� ���� MyVectorŬ������ �����Ͻÿ�
public class MyVector {
	Object[] objArr = {};
	int size = 0;

// Q8. objArr�� ������ ��ü�� �����ϴ� boolean remove(Object obj)
	boolean remove(Object obj) {
// objArr���� indexOf()�� obj�� ��ġ�� ã�´�.
		int idx = indexOf(obj);
// 1. ã����, idx�� -1�� �ƴϸ� ã�� ����
		if (idx != -1) {
// 1. �ش� �ε��� �Ʒ��� ��Ҹ� ���� �̵�
// idx�� 2�� ���
//System.arraycopy(objArr, 3, objArr, 2, 2);
			System.arraycopy(objArr, idx + 1, objArr, idx, size - idx + 1);

// 2. ������ ��� objArr[size]�� null
			objArr[size - 1] = null;

// 3. size--
			size--;

			return true;
		}

// 2. ��ã����
		return false;
	}

// Q6. objArr�� ����� ��ü�� ���ڿ��� �̾ ��ȯ�ϵ���
// toString()�������̵� �Ͻÿ�.
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
//String tmp = "[";

		for (int i = 0; i < size; i++) {
			if (i != 0)
				sb.append(",");
//tmp += objArr[i]+",";
			sb.append(objArr[i]);
		}

		return sb.append("]").toString();
	}

// Q5. objArr�� ����� ��ü�� ��ȯ�ϴ� 
// Object get(index)�� �ۼ��Ͻÿ�.
	Object get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("������ �����");

		return objArr[index];
	}

// Q7. objArr���� ������ ��ü�� ����� ��ġ(index)�� ��ȯ�ϴ�
// int indexOf(Object obj)�� �ۼ��Ͻÿ�.
// obj�� objArr���� ã�Ƽ� ��ġ�� ��ȯ
	int indexOf(Object obj) {
		int idx = -1; // ��ü�� ��ġ�� �����ϱ� ���� ����

// objArr�� ��� ��Ҹ� ó������ �ϳ���
		for (int i = 0; i < size; i++) {
// ���� ��ġ�ϸ� i�� ��ȯ
			if (obj == objArr[i]) {
				return i;
			}

			if (obj != null && obj.equals(objArr[i])) {
				return i;
			}
		}

		return idx;
	}

// Q4. ��ü�迭 objArr�� ��ü�� �߰��ϴ� �޼���
// void add(Object obj)�� �ۼ�
// ������ ��ü(obj)�� ��ü �迭 objArr�� �߰�
	void add(Object obj) {
// ������ �����ϸ� capacity�� �÷���߰ڱ���.
		if (capacity() <= size) {
// 1. ������ 2��ũ�� ���ο� �迭 ����
			Object[] tmp = new Object[capacity() * 2];
// 2. ���� ���� ����
			System.arraycopy(objArr, 0, tmp, 0, size);
// 3. �������� ����
			objArr = tmp;
			System.out.println("capacity=" + capacity());
		}

// �迭�� ��ü�� �߰�
		objArr[size++] = obj;
	}

// Q3. ��ü �迭�� ����� ��ü�� ���� �����ϱ� ���� iv
// size�� �߰��ϰ�, �̺����� ���� ��ȯ�ϴ� size()
	int size() {
		return size;
	}

// objArr�� ����(objArr.length)�� ��ȯ�ϴ� capacity()
	int capacity() {
		return objArr.length;
	}

// ��ü �迭�� ������� Ȯ���ϴ� isEmpty()�� �ۼ�
// ��� �迭�� ����ִ°���? size�� 0�϶�
	boolean isEmpty() {
//if(size==0)
//return true;
//else
//return false;
		return size == 0;
	}

// Q2. MyVectorŬ������ ������ MyVector(int capacity)��
// �⺻ ������(capacity=16)�� �߰��Ͻÿ�.
	MyVector() {
		this(16); // MyVector(16);
	}

// ������ �뷮���� MyVector�� �ʱ�ȭ
// �� ��... capacity�� ����? �迭objArr�� ����
	MyVector(int capacity) {
		if (capacity < 0 || capacity > Integer.MAX_VALUE)
			throw new IllegalArgumentException("Illegal Capacity:" + capacity);

		objArr = new Object[capacity];
	}
}
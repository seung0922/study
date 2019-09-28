package test0813;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Q1. Object�迭 obj�� �ν��Ͻ� ������ ���� MyVectorŬ���� ����
class MyVector {
	
	Object[] objArr = {};	// iv
	int size;	// Q3. ��ü�迭�� ����� ��ü�� ���� �����ϱ� ���� iv size�߰�
	
	// Q2. MyVector�� ������ MyVector(int capacity), �⺻������(capacity=16)
	// ������ �뷮���� MyVector �ʱ�ȭ
	MyVector(int capacity) {
		if(capacity<0 || capacity>Integer.MAX_VALUE)
			throw new IllegalArgumentException("Illegal Capacity");
		objArr = new Object[capacity];
	}
	MyVector() {
		this(16);	// MyVector(16);
	}
	
	

	// Q3. size�� ��ȯ�ϴ� size()
	int size() {	
		// null�� ������ ���� size�� �� �� ����
		return size;
	}
	
	// Q3. �迭 objArr�� ���� ��ȯ�ϴ� capacity()
	int capacity() {	
		return objArr.length;
	}
	
	// Q3. ��ü �迭�� ������� Ȯ���ϴ� isEmpty()
	// size�� 0�϶� �����
	boolean isEmpty() {
		return size==0;
	}
	
	// Q4. objArr�� ��ü �߰��ϴ� add(Object obj)
	// ������ ��ü(obj)�� ��ü �迭 objArr�� �߰�
	void add(Object obj) {
		// ������ �����ϸ� capacity �÷�����
		if(capacity()<=size) {	
			// 1. ������ 2��ũ�� ���ο� �迭 ����
			Object[] tmp = new Object[capacity()*2];
			// 2. ���� ���� ����
			System.arraycopy(objArr, 0, tmp, 0, size);
			// 3. �������� ����
			objArr = tmp;
			System.out.println("capacity = " + capacity());
		}
		
		// �迭�� ��ü �߰�
		objArr[size++] = obj;
	}
	
	// Q5. objArr�� �ش� �ε���(index)�� ����� ��ü�� ��ȯ
	Object get(int index) {	
		// ���� index�� size �Ѿ�� ���� �����Ƿ� ��ȯ�Ұ�
		// index�� size�� �Ѿ�µ� null�� �ȳ�������...?
		if(index<0 || index >= size) 
			throw new ArrayIndexOutOfBoundsException("������ ������ϴ�.");
		return objArr[index];
	}
	
	// Q6. objArr�� ����� ��� ��ü�� ���ڿ��� �̾ ��ȯ
	public String toString() {
		String str = "";
		
		for(int i=0; i<size; i++) {
			str += objArr[i];
		}
		
		return str;
	}
	
	// Q7. objArr���� ������ ��ü�� ����Ǿ� �ִ� ��ġ�� ��ȯ
	int indexOf(Object obj) {	
		// �ε��� �ȿ� ������ -1
		int result = -1;	// ��ü�� ��ġ�� �����ϱ� ���� ����
		
		// objArr�� ��� ��Ҹ� ó������ �ϳ���
		for(int i=0; i<size; i++) {
			// ���� ��ġ�ϸ� i ��ȯ
			if(obj==objArr[i] || obj.equals(objArr[i])) {
				result = i;
			}
		}
		return result;
	}
	
	// Q8. objArr���� ������ ��ü ���� (indexOf()�̿�)
	boolean remove(Object obj) {
		// objArr�� obj�� ��ġ�� indexOf()�� ã�´�.
		int idx = indexOf(obj);
		// 1. ã����, idx�� -1�� �ƴϸ� ã����
		if(idx!=-1) {
			// 1. �ش� �ε��� �Ʒ��� ��Ҹ� ���� �̵�
			System.arraycopy(objArr, idx+1, objArr, idx, size-idx);
			// 2. ������ ��Ҹ� null
			objArr[size] = null;
			// 3. size--;
			size--;
			return true;
		} else {
			return false;
		}
	}
	
}

class MyVectorTest {

	@Test
	void capacityTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		System.out.println("new MyVector() �� capacity : " + v.capacity());
		assertTrue(v.objArr.length==16);
		assertTrue(v.capacity()==16);
		
		for(int i=0; i<=10; i++) {
			MyVector v2 = new MyVector(i);
			System.out.printf("new MyVector(%d) �� capacity : %d%n", i, v2.capacity());
			assertTrue(v2.capacity()==i);
		}
		
		System.out.println();
		
	}
	
	@Test
	void isEmptyTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		System.out.println("��ü ������ �� v.isEmpty = " + v.isEmpty());
		assertTrue(v.isEmpty()==true);
		
		v.add(1);
		System.out.println("v.add(1) �� v.isEmpty = " + v.isEmpty());
		assertTrue(v.isEmpty()==false);
		v.add(2);
		System.out.println("v.add(2) �� v.isEmpty = " + v.isEmpty());
		assertTrue(v.isEmpty()==false);
		
		System.out.println();
	}
	
//	@Test
	void sizeTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector(100);
		
		System.out.println("������ �� ��ü�� size : " + v.size());
		assertTrue(v.size()==0);
		
		for(int i=1; i<=100; i++) {
			v.add(i);
		}
		
		System.out.println("100�� ���� ���� size : " + v.size());
		assertTrue(v.size()==100);
		
		for(int i=1; i<=1000; i++) {
			v.add(i);
		}
		System.out.println("1000�� ���� ���� size : " + v.size());
		assertTrue(v.size()==1100);
		
		System.out.println();
	}
	
	@Test
	void addTest() {
//		Vector v = new Vector(5);
		MyVector v = new MyVector(10);
		
//		v.add(null);
//		assertTrue(v.size()==1);
		
		System.out.println("new MyVector(10)�� capacity = " + v.capacity());
		for(int i=1; i<=100; i++) {
			v.add(i);
		}
		
		System.out.println("100�� add�ݺ� �� capacity = " + v.capacity());
		assertTrue(v.capacity()==160);
		
		System.out.println();
		
	}
	
	@Test
	void toStringTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector(100);

		String str="";
		for(int i=1; i<=100; i++) {
			v.add(i);
			str += i;
		}
		
		System.out.println("���ڿ� 1~100�� ���� �� toString() = " + v.toString());
		assertTrue(v.toString().equals(str)==true);
		
		System.out.println();
		
	}
	
	@Test
	void indexOfTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		v.add("a");
		v.add("b");
		v.add("c");
		
		System.out.println("a���� �ε��� = " + v.indexOf("a"));
		System.out.println("b���� �ε��� = " + v.indexOf("b"));
		System.out.println("c���� �ε��� = " + v.indexOf("c"));
		System.out.println("d���� �ε��� = " + v.indexOf("d") + " (�ش� ���� ������ -1)");
		
		assertTrue(v.indexOf("a")==0);
		assertTrue(v.indexOf("b")==1);
		assertTrue(v.indexOf("c")==2);
		assertTrue(v.indexOf("d")==-1);
		
		System.out.println();
	}
	
	@Test
	void removeTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		v.add("a");
		v.add("b");
		v.add("c");
		
		assertTrue(v.indexOf("b")!=-1);
		assertTrue(v.remove("b")==true);
		
		
		System.out.println();
	}
	
	@Test
	void getTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		v.add(null);
		
		assertTrue(v.get(0)==null);
//		assertTrue(v.get(1)==null);
		
//		System.out.println(v.get(1));
		
		
		System.out.println();
	}

}

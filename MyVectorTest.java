package test0813;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

// Object�迭 obj�� �ν��Ͻ� ������ ���� MyVectorŬ���� ����
class MyVector {
	
	Object[] objArr;
	int capacity;
	int size;	// ��ü�迭�� ����� ��ü�� ���� ����
	
	
	// ������(int capacity), �⺻������(capacity=16)
	MyVector(int capacity) {
		this.capacity = capacity;
		objArr = new Object[this.capacity];
	}
	MyVector() {
		this(16);
	}
	
	

	// size�� ��ȯ
	int size() {	
		// null�� ������ ���� size�� �� �� ����
		return size;
	}
	
	// �迭 objArr�� ���� ��ȯ
	int capacity() {	
		return objArr.length;
	}
	
	// ��ü �迭�� ������� Ȯ��
	boolean isEmpty() {	
		return size()==0;
	}
	
	// objArr�� ��ü �߰�
	void add(Object obj) {	
		size++;
		// size�� capacity���� ũ��
		// capacity 2��� �� ���ο� �迭 ���� �� ����
		if(size>capacity) {	// size�� objArr�� ũ�⺸�� ũ��
			capacity = capacity*2;
			Object[] objArr2 = new Object[capacity];
			System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
			objArr = objArr2;
			objArr[size-1] = obj;
		} else {
			objArr[size-1] = obj;
		}
			
	}
	
	// objArr�� �ش� �ε����� ����� ��ü�� ��ȯ
	Object get(int index) {	
		// ���� index�� size �Ѿ�� ���� �����Ƿ� ��ȯ�Ұ�
		// index�� size�� �Ѿ�µ� null�� �ȳ�������...?
		return objArr[index];
	}
	
	// objArr�� ����� ��� ��ü�� ���ڿ��� �̾ ��ȯ
	public String toString() {	
		String str = "";
		for(int i=0; i<size; i++) {
			str += objArr[i];
		}
		return str;
	}
	
	// objArr���� ������ ��ü�� ����Ǿ� �ִ� ��ġ�� ��ȯ
	int indexOf(Object obj) {	
		// �ε��� �ȿ� ������ -1
		int result = -1;
		for(int i=0; i<objArr.length; i++) {
			if(obj.equals(objArr[i])) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	// objArr���� ������ ��ü ���� (indexOf()�̿�)
	boolean remove(Object obj) {
		// obj �ִ� ��ġ ã��, �ش� �ε��� ���� ���� �ش簪����
		if(indexOf(obj)==-1) {
			return false;
		} else {
			int num = indexOf(obj);
			for(int i=num; i<objArr.length-1; i++) {
				objArr[i] = objArr[i+1];
			}
			objArr[size-1] = null;
			size--;
			return true;
		}
	}
	
}

class MyVectorTest {

	@Test
	void capacityTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		System.out.println("new MyVector() �� capacity : " + v.capacity());
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
	
	@Test
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
		
		assertTrue(v.remove("b")==true);
		
		
		System.out.println();
	}

}

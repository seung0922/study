package test0813;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Q1. Object배열 obj을 인스턴스 변수로 갖는 MyVector클래스 선언
class MyVector {
	
	Object[] objArr = {};	// iv
	int size;	// Q3. 객체배열에 저장된 객체의 개수 저장하기 위한 iv size추가
	
	// Q2. MyVector에 생성자 MyVector(int capacity), 기본생성자(capacity=16)
	// 지정된 용량으로 MyVector 초기화
	MyVector(int capacity) {
		if(capacity<0 || capacity>Integer.MAX_VALUE)
			throw new IllegalArgumentException("Illegal Capacity");
		objArr = new Object[capacity];
	}
	MyVector() {
		this(16);	// MyVector(16);
	}
	
	

	// Q3. size값 반환하는 size()
	int size() {	
		// null도 값으로 들어가면 size로 될 수 있음
		return size;
	}
	
	// Q3. 배열 objArr의 길이 반환하는 capacity()
	int capacity() {	
		return objArr.length;
	}
	
	// Q3. 객체 배열이 비었는지 확인하는 isEmpty()
	// size가 0일때 비었음
	boolean isEmpty() {
		return size==0;
	}
	
	// Q4. objArr에 객체 추가하는 add(Object obj)
	// 지정된 객체(obj)를 객체 배열 objArr에 추가
	void add(Object obj) {
		// 공간이 부족하면 capacity 늘려야함
		if(capacity()<=size) {	
			// 1. 기존의 2배크기 새로운 배열 생성
			Object[] tmp = new Object[capacity()*2];
			// 2. 기존 내용 복사
			System.arraycopy(objArr, 0, tmp, 0, size);
			// 3. 참조변수 변경
			objArr = tmp;
			System.out.println("capacity = " + capacity());
		}
		
		// 배열에 객체 추가
		objArr[size++] = obj;
	}
	
	// Q5. objArr의 해당 인덱스(index)에 저장된 객체를 반환
	Object get(int index) {	
		// 만약 index가 size 넘어가면 값이 없으므로 반환불가
		// index가 size값 넘어갔는데 null값 안나오려면...?
		if(index<0 || index >= size) 
			throw new ArrayIndexOutOfBoundsException("범위를 벗어났습니다.");
		return objArr[index];
	}
	
	// Q6. objArr에 저장된 모든 객체를 문자열로 이어서 반환
	public String toString() {
		String str = "";
		
		for(int i=0; i<size; i++) {
			str += objArr[i];
		}
		
		return str;
	}
	
	// Q7. objArr에서 지정된 객체가 저장되어 있는 위치를 반환
	int indexOf(Object obj) {	
		// 인덱스 안에 없으면 -1
		int result = -1;	// 객체의 위치를 저장하기 위한 변수
		
		// objArr의 모든 요소를 처음부터 하나씩
		for(int i=0; i<size; i++) {
			// 만약 일치하면 i 반환
			if(obj==objArr[i] || obj.equals(objArr[i])) {
				result = i;
			}
		}
		return result;
	}
	
	// Q8. objArr에서 지정된 객체 삭제 (indexOf()이용)
	boolean remove(Object obj) {
		// objArr에 obj의 위치를 indexOf()로 찾는다.
		int idx = indexOf(obj);
		// 1. 찾으면, idx가 -1이 아니면 찾은것
		if(idx!=-1) {
			// 1. 해당 인덱스 아래의 요소를 위로 이동
			System.arraycopy(objArr, idx+1, objArr, idx, size-idx);
			// 2. 마지막 요소를 null
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
		System.out.println("new MyVector() 의 capacity : " + v.capacity());
		assertTrue(v.objArr.length==16);
		assertTrue(v.capacity()==16);
		
		for(int i=0; i<=10; i++) {
			MyVector v2 = new MyVector(i);
			System.out.printf("new MyVector(%d) 의 capacity : %d%n", i, v2.capacity());
			assertTrue(v2.capacity()==i);
		}
		
		System.out.println();
		
	}
	
	@Test
	void isEmptyTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector();
		System.out.println("객체 생성만 한 v.isEmpty = " + v.isEmpty());
		assertTrue(v.isEmpty()==true);
		
		v.add(1);
		System.out.println("v.add(1) 후 v.isEmpty = " + v.isEmpty());
		assertTrue(v.isEmpty()==false);
		v.add(2);
		System.out.println("v.add(2) 후 v.isEmpty = " + v.isEmpty());
		assertTrue(v.isEmpty()==false);
		
		System.out.println();
	}
	
//	@Test
	void sizeTest() {
//		Vector v = new Vector();
		MyVector v = new MyVector(100);
		
		System.out.println("생성만 한 객체의 size : " + v.size());
		assertTrue(v.size()==0);
		
		for(int i=1; i<=100; i++) {
			v.add(i);
		}
		
		System.out.println("100번 더한 후의 size : " + v.size());
		assertTrue(v.size()==100);
		
		for(int i=1; i<=1000; i++) {
			v.add(i);
		}
		System.out.println("1000번 더한 후의 size : " + v.size());
		assertTrue(v.size()==1100);
		
		System.out.println();
	}
	
	@Test
	void addTest() {
//		Vector v = new Vector(5);
		MyVector v = new MyVector(10);
		
//		v.add(null);
//		assertTrue(v.size()==1);
		
		System.out.println("new MyVector(10)의 capacity = " + v.capacity());
		for(int i=1; i<=100; i++) {
			v.add(i);
		}
		
		System.out.println("100번 add반복 후 capacity = " + v.capacity());
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
		
		System.out.println("문자열 1~100을 더한 후 toString() = " + v.toString());
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
		
		System.out.println("a값의 인덱스 = " + v.indexOf("a"));
		System.out.println("b값의 인덱스 = " + v.indexOf("b"));
		System.out.println("c값의 인덱스 = " + v.indexOf("c"));
		System.out.println("d값의 인덱스 = " + v.indexOf("d") + " (해당 값이 없으면 -1)");
		
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

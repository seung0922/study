package test0813;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import org.junit.jupiter.api.Test;

// Object배열 obj을 인스턴스 변수로 갖는 MyVector클래스 선언
class MyVector {
	
	Object[] objArr;
	int capacity;
	int size;	// 객체배열에 저장된 객체의 개수 저장
	
	
	// 생성자(int capacity), 기본생성자(capacity=16)
	MyVector(int capacity) {
		this.capacity = capacity;
		objArr = new Object[this.capacity];
	}
	MyVector() {
		this(16);
	}
	
	

	// size값 반환
	int size() {	
		// null도 값으로 들어가면 size로 될 수 있음
		return size;
	}
	
	// 배열 objArr의 길이 반환
	int capacity() {	
		return objArr.length;
	}
	
	// 객체 배열이 비었는지 확인
	boolean isEmpty() {	
		return size()==0;
	}
	
	// objArr에 객체 추가
	void add(Object obj) {	
		size++;
		// size가 capacity보다 크면
		// capacity 2배로 한 새로운 배열 생성 후 복사
		if(size>capacity) {	// size가 objArr의 크기보다 크면
			capacity = capacity*2;
			Object[] objArr2 = new Object[capacity];
			System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
			objArr = objArr2;
			objArr[size-1] = obj;
		} else {
			objArr[size-1] = obj;
		}
			
	}
	
	// objArr의 해당 인덱스에 저장된 객체를 반환
	Object get(int index) {	
		// 만약 index가 size 넘어가면 값이 없으므로 반환불가
		// index가 size값 넘어갔는데 null값 안나오려면...?
		return objArr[index];
	}
	
	// objArr에 저장된 모든 객체를 문자열로 이어서 반환
	public String toString() {	
		String str = "";
		for(int i=0; i<size; i++) {
			str += objArr[i];
		}
		return str;
	}
	
	// objArr에서 지정된 객체가 저장되어 있는 위치를 반환
	int indexOf(Object obj) {	
		// 인덱스 안에 없으면 -1
		int result = -1;
		for(int i=0; i<objArr.length; i++) {
			if(obj.equals(objArr[i])) {
				result = i;
				break;
			}
		}
		return result;
	}
	
	// objArr에서 지정된 객체 삭제 (indexOf()이용)
	boolean remove(Object obj) {
		// obj 있는 위치 찾고, 해당 인덱스 다음 값이 해당값으로
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
		System.out.println("new MyVector() 의 capacity : " + v.capacity());
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
	
	@Test
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
		
		assertTrue(v.remove("b")==true);
		
		
		System.out.println();
	}

}

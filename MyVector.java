package test0813;

import java.util.Arrays;

//Q1.Object배열 objArr을 iv로 갖는 MyVector클래스를 선언하시오
public class MyVector {
	Object[] objArr = {};
	int size = 0;

// Q8. objArr에 지정된 객체를 삭제하는 boolean remove(Object obj)
	boolean remove(Object obj) {
// objArr에서 indexOf()로 obj의 위치를 찾는다.
		int idx = indexOf(obj);
// 1. 찾으면, idx가 -1이 아니면 찾은 거임
		if (idx != -1) {
// 1. 해당 인덱스 아래의 요소를 위로 이동
// idx가 2인 경우
//System.arraycopy(objArr, 3, objArr, 2, 2);
			System.arraycopy(objArr, idx + 1, objArr, idx, size - idx + 1);

// 2. 마지막 요소 objArr[size]를 null
			objArr[size - 1] = null;

// 3. size--
			size--;

			return true;
		}

// 2. 못찾으면
		return false;
	}

// Q6. objArr에 저장된 객체를 문자열로 이어서 반환하도록
// toString()오버라이딩 하시오.
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

// Q5. objArr에 저장된 객체를 반환하는 
// Object get(index)를 작성하시오.
	Object get(int index) {
		if (index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException("범위를 벗어났슈");

		return objArr[index];
	}

// Q7. objArr에서 지정된 객체가 저장된 위치(index)를 반환하는
// int indexOf(Object obj)를 작성하시오.
// obj를 objArr에서 찾아서 위치를 반환
	int indexOf(Object obj) {
		int idx = -1; // 객체의 위치를 저장하기 위한 변수

// objArr의 모든 요소를 처음부터 하나씩
		for (int i = 0; i < size; i++) {
// 만일 일치하면 i를 반환
			if (obj == objArr[i]) {
				return i;
			}

			if (obj != null && obj.equals(objArr[i])) {
				return i;
			}
		}

		return idx;
	}

// Q4. 객체배열 objArr에 객체를 추가하는 메서드
// void add(Object obj)를 작성
// 지정된 객체(obj)를 객체 배열 objArr에 추가
	void add(Object obj) {
// 공간이 부족하면 capacity를 늘려줘야겠구나.
		if (capacity() <= size) {
// 1. 기존의 2배크기 새로운 배열 생성
			Object[] tmp = new Object[capacity() * 2];
// 2. 기존 내용 복사
			System.arraycopy(objArr, 0, tmp, 0, size);
// 3. 참조변수 변경
			objArr = tmp;
			System.out.println("capacity=" + capacity());
		}

// 배열에 객체를 추가
		objArr[size++] = obj;
	}

// Q3. 객체 배열에 저장된 객체의 수를 저장하기 위한 iv
// size를 추가하고, 이변수의 값을 반환하는 size()
	int size() {
		return size;
	}

// objArr의 길이(objArr.length)를 반환하는 capacity()
	int capacity() {
		return objArr.length;
	}

// 객체 배열이 비었는지 확인하는 isEmpty()를 작성
// 어떨때 배열이 비어있는건지? size가 0일때
	boolean isEmpty() {
//if(size==0)
//return true;
//else
//return false;
		return size == 0;
	}

// Q2. MyVector클래스에 생성자 MyVector(int capacity)와
// 기본 생성자(capacity=16)를 추가하시오.
	MyVector() {
		this(16); // MyVector(16);
	}

// 지정된 용량으로 MyVector를 초기화
// 아 씨... capacity가 뭐지? 배열objArr의 길이
	MyVector(int capacity) {
		if (capacity < 0 || capacity > Integer.MAX_VALUE)
			throw new IllegalArgumentException("Illegal Capacity:" + capacity);

		objArr = new Object[capacity];
	}
}
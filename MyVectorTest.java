package test0813;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyVectorTest {
	@Test
	void mainTest() {
//  MyVector v = new MyVector();
//  Vector v = new Vector(-1);

//  assertTrue(v.);

//  v = new MyVector(100);
//  assertTrue(v.objArr.length==100);
//
//  v = new MyVector(-1);
//  assertTrue(v.objArr.length==-1);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new MyVector(-1);
		});

	}

	@Test
	void removeTest() {
//  Vector v = new Vector();
		MyVector v = new MyVector();
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");

//  assertTrue(v.indexOf("3")!=-1);
		assertTrue(v.remove("3") == true);
//
//  assertTrue(v.indexOf("33")==-1);
		assertTrue(v.remove("33") == false);
	}

	@Test
	void indexOfTest() {
//  Vector v = new Vector();
		MyVector v = new MyVector();
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");
		v.add(null);
		v.add(new Integer(3));

		System.out.println(v);

		assertTrue(v.indexOf("1") == 0);
		System.out.println(v.indexOf("11"));
		assertTrue(v.indexOf("11") == -1);
		assertTrue(v.indexOf(null) != -1);
		assertTrue(v.indexOf(new Integer(3)) != -1);
	}

	@Test
	void getTest() {
//  Vector v = new Vector();
		MyVector v = new MyVector();
		v.add(null);

		assertTrue(v.get(0) == null);
//  System.out.println(v.get(1));
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			v.get(1);
		});

		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			v.get(-1);
		});
	}

	@Test
	void addTest() {
//  Vector v = new Vector();
		MyVector v = new MyVector();

		v.add(null);
		assertTrue(v.size() == 1);

//  v = new Vector();
		v = new MyVector();
		assertTrue(v.size() == 0);

		for (int i = 0; i < 100; i++) {
			v.add(new Integer(i));
		}
		assertTrue(v.size() == 100);
	}

	@Test
	void isEmptyTest() {
		Vector v = new Vector();
		assertTrue(v.isEmpty() == true);
		v.add("abc");
		assertTrue(v.isEmpty() == false);
//  assertTrue(!v.isEmpty());
	}

	@Test
	void constructorTest() {
		Vector v = new Vector();
//  MyVector v = new MyVector();

		System.out.println(v.capacity());
		assertTrue(v.size() == 0);
		assertTrue(v.capacity() == 10);

		v.add("aaa");
		assertTrue(v.size() == 1);
	}

	@Test
	void sizeTest() {
		Vector v = new Vector();
		System.out.println(v.capacity());
		assertTrue(v.size() == 0);
		assertTrue(v.capacity() == 10);

		v.add("aaa");
		assertTrue(v.size() == 1);
	}

}
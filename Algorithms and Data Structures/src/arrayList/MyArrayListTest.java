package arrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MyArrayListTest<T> {

	@Test
	void testClear() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		test.clear();
		assertEquals(test.size(), 0);
	}

	@Test
	void testGet() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		assertTrue(test.get(0).equals(1));
		assertTrue(test.get(1).equals(2));
		assertTrue(test.get(2).equals(3));
		assertTrue(test.get(3).equals(4));
		assertTrue(test.get(4).equals(5));
	}

	@Test
	void testSet() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		test.set(2, 9);
		assertTrue(test.get(2).equals(9));
	}

	@Test
	void testAddT() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		test.add(Integer.MAX_VALUE);

		assertTrue(test.get(5).equals(Integer.MAX_VALUE));
	}

	@Test
	void testAddIntT() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		test.add(3, Integer.MAX_VALUE);

		assertTrue(test.get(3).equals(Integer.MAX_VALUE));
	}

	@Test
	void testAddAllListOfT() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ArrayList<Integer> test2 = new ArrayList<>();
		test2.add(10);
		test2.add(11);
		test2.add(12);

		LinkedList<Integer> test3 = new LinkedList<>();
		test2.add(20);
		test2.add(21);
		test2.add(22);

		test.addAll(test2);
		test.addAll(test3);
		
		assertTrue(test.get(0).equals(1));
		assertTrue(test.get(1).equals(2));
		assertTrue(test.get(2).equals(3));
		assertTrue(test.get(3).equals(4));
		assertTrue(test.get(4).equals(5));
		assertTrue(test.get(5).equals(10));
		assertTrue(test.get(6).equals(11));
		assertTrue(test.get(7).equals(12));
		assertTrue(test.get(8).equals(20));
		assertTrue(test.get(9).equals(21));
		assertTrue(test.get(10).equals(22));

	}

	@Test
	void testAddAllIntListOfT() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ArrayList<Integer> test2 = new ArrayList<>();
		test2.add(10);
		test2.add(11);
		test2.add(12);

		LinkedList<Integer> test3 = new LinkedList<>();
		test2.add(20);
		test2.add(21);
		test2.add(22);

		test.addAll(2, test2);
		test.addAll(3, test3);
		
		assertTrue(test.get(0).equals(1));
		assertTrue(test.get(1).equals(2));
		assertTrue(test.get(2).equals(10));
		assertTrue(test.get(3).equals(11));
		assertTrue(test.get(4).equals(12));
		assertTrue(test.get(5).equals(20));
		assertTrue(test.get(6).equals(21));
		assertTrue(test.get(7).equals(22));
		assertTrue(test.get(8).equals(3));
		assertTrue(test.get(9).equals(4));
		assertTrue(test.get(10).equals(5));
	}

	@Test
	void testRemove() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		test.remove(2);
		
		assertTrue(test.get(0).equals(1));
		assertTrue(test.get(1).equals(2));
		assertTrue(test.get(2).equals(4));
		assertTrue(test.get(3).equals(5));
	}

	@Test
	void testIndexOf() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		
		assertEquals(test.IndexOf(2), 1);
		assertEquals(test.IndexOf(9), -1);
	}

	

}
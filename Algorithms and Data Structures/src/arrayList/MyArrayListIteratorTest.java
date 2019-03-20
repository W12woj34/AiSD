package arrayList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;

import org.junit.jupiter.api.Test;

class MyArrayListIteratorTest<T> extends MyArrayList<T> {

	@Test
	void testHasNext() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();

		assertTrue(testowy.hasNext());
		while (testowy.hasNext()) {
			testowy.next();
		}
		assertFalse(testowy.hasNext());

	}

	@Test
	void testHasPrevious() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();

		assertFalse(testowy.hasPrevious());
		while (testowy.hasNext()) {
			testowy.next();
			assertTrue(testowy.hasPrevious());
		}
		assertTrue(testowy.hasPrevious());

	}

	@Test
	void testNext() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();

		assertTrue(testowy.next().equals(1));
		assertTrue(testowy.next().equals(2));
		assertTrue(testowy.next().equals(3));
		assertTrue(testowy.next().equals(4));
		assertTrue(testowy.next().equals(5));

	}

	@Test
	void testPrevious() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();

		while (testowy.hasNext()) {
			testowy.next();
		}

		assertTrue(testowy.previous().equals(5));
		assertTrue(testowy.previous().equals(4));
		assertTrue(testowy.previous().equals(3));
		assertTrue(testowy.previous().equals(2));
		assertTrue(testowy.previous().equals(1));
	}

	@Test
	void testSet() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();
		int i = 10;
		while (testowy.hasNext()) {
			testowy.set(i);
			testowy.next();
			i++;
		}
		assertTrue(test.get(0).equals(10));
		assertTrue(test.get(1).equals(11));
		assertTrue(test.get(2).equals(12));
		assertTrue(test.get(3).equals(13));
		assertTrue(test.get(4).equals(14));

	}

	@Test
	void testRemove() {
		MyArrayList<Integer> test = new MyArrayList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();

		testowy.next();
		testowy.remove();

		assertTrue(test.get(0).equals(1));
		assertTrue(test.get(1).equals(3));
		assertTrue(test.get(2).equals(4));
		assertTrue(test.get(3).equals(5));

	}

}

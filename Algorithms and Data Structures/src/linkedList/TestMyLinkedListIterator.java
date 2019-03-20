package linkedList;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ListIterator;

import org.junit.jupiter.api.Test;

class TestMyLinkedListIterator<T> extends MyLinkedList<T> {

	@Test
	void testHasNext() {
		MyLinkedList<Integer> test = new MyLinkedList<>();
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
		MyLinkedList<Integer> test = new MyLinkedList<>();
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
		MyLinkedList<Integer> test = new MyLinkedList<>();
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
		MyLinkedList<Integer> test = new MyLinkedList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();

		testowy.next();
		testowy.next();
		testowy.next();
		testowy.next();

		testowy.previous();
		testowy.set(10);
		testowy.previous();
		testowy.set(11);
		testowy.previous();
		testowy.set(12);
		testowy.previous();
		testowy.set(13);

		assertTrue(test.get(4).equals(10));
		assertTrue(test.get(3).equals(11));
		assertTrue(test.get(2).equals(12));
		assertTrue(test.get(1).equals(13));

	}

	@Test
	void testSet() {
		MyLinkedList<Integer> test = new MyLinkedList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);

		ListIterator<Integer> testowy = test.iterator();
		int i = 10;
		while (testowy.hasNext()) {
			testowy.next();
			testowy.set(i);

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
		MyLinkedList<Integer> test = new MyLinkedList<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		test.add(7);

		ListIterator<Integer> testowy = test.iterator();

		testowy.next();
		testowy.remove();
		testowy.next();
		testowy.next();
		testowy.remove();
		testowy.next();
		testowy.next();
		testowy.next();
		testowy.previous();
		testowy.remove();

		assertTrue(test.get(0).equals(2));
		assertTrue(test.get(1).equals(4));
		assertTrue(test.get(2).equals(5));
		assertTrue(test.get(3).equals(6));

	}

}

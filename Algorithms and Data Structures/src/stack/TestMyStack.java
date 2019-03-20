package stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMyStack {


	@Test
	void testRemove() {
		MyStack<Integer> test = new MyStack<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		assertTrue(test.remove().equals(6));
		assertTrue(test.remove().equals(5));
		assertTrue(test.remove().equals(4));
		assertTrue(test.remove().equals(3));
		assertTrue(test.remove().equals(2));
		assertTrue(test.remove().equals(1));
	}

	@Test
	void testIsEmpty() {
		MyStack<Integer> test = new MyStack<>();

		assertTrue(test.isEmpty());

		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);

		assertFalse(test.isEmpty());

		test.clear();

		assertTrue(test.isEmpty());
	}

	@Test
	void testToArrayTArray() {
		MyStack<Integer> test = new MyStack<>();

		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);

		Integer[] array1 = new Integer[6];
		Integer[] array2 = new Integer[10];
		Integer[] array3 = new Integer[3];
		Object[] array4 = new Object[6];
		test.toArray(array1);
		test.toArray(array2);
		test.toArray(array3);

		assertTrue(array1[0].equals(1));
		assertTrue(array1[1].equals(2));
		assertTrue(array1[2].equals(3));
		assertTrue(array1[3].equals(4));
		assertTrue(array1[4].equals(5));
		assertTrue(array1[5].equals(6));

		assertTrue(array2[0].equals(1));
		assertTrue(array2[1].equals(2));
		assertTrue(array2[2].equals(3));
		assertTrue(array2[3].equals(4));
		assertTrue(array2[4].equals(5));
		assertTrue(array2[5].equals(6));
		assertEquals(array2[6], null);
		assertEquals(array2[7], null);
		assertEquals(array2[8], null);
		assertEquals(array2[9], null);
		
		array4 = test.toArray(array3);
		
		assertTrue(array4[0].equals(1));
		assertTrue(array4[1].equals(2));
		assertTrue(array4[2].equals(3));
		assertTrue(array4[3].equals(4));
		assertTrue(array4[4].equals(5));
		assertTrue(array4[5].equals(6));

	}

	@Test
	void testElement() {
		MyStack<Integer> test = new MyStack<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);

		assertTrue(test.element().equals(6));
	}

	@Test
	void testOffer() {
		MyStack<Integer> test = new MyStack<>();
		test.offer(1);
		test.offer(2);
		test.offer(3);
		test.offer(4);
		test.offer(5);
		test.offer(6);
		assertTrue(test.get(0).equals(1));
		assertTrue(test.get(1).equals(2));
		assertTrue(test.get(2).equals(3));
		assertTrue(test.get(3).equals(4));
		assertTrue(test.get(4).equals(5));
		assertTrue(test.get(5).equals(6));
	}

	@Test
	void testPeek() {
		MyStack<Integer> test = new MyStack<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);

		assertTrue(test.peek().equals(6));
		test.clear();
		assertEquals(test.peek(), null);
	}

	@Test
	void testPoll() {
		MyStack<Integer> test = new MyStack<>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		test.add(6);
		assertTrue(test.poll().equals(6));
		assertTrue(test.poll().equals(5));
		assertTrue(test.poll().equals(4));
		assertTrue(test.poll().equals(3));
		assertTrue(test.poll().equals(2));
		assertTrue(test.poll().equals(1));
		assertEquals(test.poll(), null);
	}

}

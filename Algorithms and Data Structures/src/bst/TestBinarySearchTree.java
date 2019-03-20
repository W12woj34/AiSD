package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBinarySearchTree {

	@Test
	void testSize() {

		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);

		assertTrue(test.size() == 13);

		test.put(22);
		test.put(19);

		assertTrue(test.size() == 13);

		test.delete(11);
		test.delete(60);

		assertTrue(test.size() == 12);

	}

	@Test
	void testFind() {

		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);

		assertTrue(test.find(5) == true);
		assertTrue(test.find(2) == true);
		assertTrue(test.find(60) == false);
		test.delete(2);
		assertTrue(test.find(2) == false);
	}
	
	@Test
	void testGet() {

		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);

		assertTrue(test.get(5) == 5);
		assertTrue(test.get(2) == 2);
		assertTrue(test.get(12) == 12);
		assertTrue(test.get(11) == 11);
		
	}

	@Test
	void testPut() {

		BinarySearchTree test = new BinarySearchTree();

		assertTrue(test.put(5) == true);
		assertTrue(test.put(7) == true);
		assertTrue(test.put(3) == true);
		assertTrue(test.put(1) == true);
		assertTrue(test.put(12) == true);
		assertTrue(test.put(11) == true);
		assertTrue(test.put(4) == true);
		assertTrue(test.put(6) == true);
		assertTrue(test.put(20) == true);
		assertTrue(test.put(17) == true);
		assertTrue(test.put(2) == true);
		assertTrue(test.put(22) == true);
		assertTrue(test.put(19) == true);
		assertTrue(test.put(2) == false);
		assertTrue(test.put(22) == false);
		assertTrue(test.put(19) == false);

	}

	@Test
	void testDelete() {

		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);
		
		assertTrue(test.size() == 13);
		assertTrue(test.delete(20) == true);
		assertTrue(test.delete(6) == true);
		assertTrue(test.size() == 11);
		assertTrue(test.delete(6) == false);
		assertTrue(test.size() == 11);

	}

	@Test
	void testMinValue() {
		
		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);
		
		assertTrue(test.minValue() == 1);
		test.delete(1);
		assertTrue(test.minValue() == 2);
		test.delete(2);
		assertTrue(test.minValue() == 3);
		
	}

	@Test
	void testMaxValue() {
		
		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);
		
		assertTrue(test.maxValue() == 22);
		test.delete(22);
		assertTrue(test.maxValue() == 20);
		test.delete(20);
		assertTrue(test.maxValue() == 19);
		
	}

	@Test
	void testLevels() {

		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);
		
		assertTrue(test.levels() == 6);
		test.delete(19);
		assertTrue(test.levels() == 5);
		test.delete(17);
		assertTrue(test.levels() == 5);
		test.delete(22);
		assertTrue(test.levels() == 4);
	}

	@Test
	void testLeaves() {
		
		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);
		
		assertTrue(test.leaves() == 6);
		test.delete(19);
		assertTrue(test.leaves() == 6);
		test.delete(17);
		assertTrue(test.leaves() == 5);
	}

	@Test
	void testRoots() {

		BinarySearchTree test = new BinarySearchTree();

		test.put(5);
		test.put(7);
		test.put(3);
		test.put(1);
		test.put(12);
		test.put(11);
		test.put(4);
		test.put(6);
		test.put(20);
		test.put(17);
		test.put(2);
		test.put(22);
		test.put(19);

		assertTrue(test.roots() == 6);
		test.delete(22);
		assertTrue(test.roots() == 6);
		test.delete(17);
		assertTrue(test.roots() == 5);
		test.delete(2);
		assertTrue(test.roots() == 4);
		
	}

}


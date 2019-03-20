package sortsAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestSimpleSorts {

	@Test
	void testBucketSort() {

		Integer[] test = new Integer[10];
		SimpleSorts sort = new SimpleSorts();
		test[0] = 1;
		test[1] = 8;
		test[2] = 6;
		test[3] = 7;
		test[4] = 9;
		test[5] = 3;
		test[6] = 0;
		test[7] = 5;
		test[8] = 2;
		test[9] = 4;
		sort.BucketSort(test);
		assertTrue(test[0] == 0);
		assertTrue(test[1] == 1);
		assertTrue(test[2] == 2);
		assertTrue(test[3] == 3);
		assertTrue(test[4] == 4);
		assertTrue(test[5] == 5);
		assertTrue(test[6] == 6);
		assertTrue(test[7] == 7);
		assertTrue(test[8] == 8);
		assertTrue(test[9] == 9);
		assertFalse(test[0] == 1);

	}

	@Test
	void testBubbleSort() {

		Integer[] test = new Integer[10];
		SimpleSorts sort = new SimpleSorts();
		test[0] = 1;
		test[1] = 8;
		test[2] = 6;
		test[3] = 7;
		test[4] = 9;
		test[5] = 3;
		test[6] = 0;
		test[7] = 5;
		test[8] = 2;
		test[9] = 4;
		sort.BubbleSort(test);
		assertTrue(test[0] == 0);
		assertTrue(test[1] == 1);
		assertTrue(test[2] == 2);
		assertTrue(test[3] == 3);
		assertTrue(test[4] == 4);
		assertTrue(test[5] == 5);
		assertTrue(test[6] == 6);
		assertTrue(test[7] == 7);
		assertTrue(test[8] == 8);
		assertTrue(test[9] == 9);
		assertFalse(test[0] == 1);

	}

	@Test
	void testInsertionSort() {

		Integer[] test = new Integer[10];
		SimpleSorts sort = new SimpleSorts();
		test[0] = 1;
		test[1] = 8;
		test[2] = 6;
		test[3] = 7;
		test[4] = 9;
		test[5] = 3;
		test[6] = 0;
		test[7] = 5;
		test[8] = 2;
		test[9] = 4;
		sort.InsertionSort(test);
		assertTrue(test[0] == 0);
		assertTrue(test[1] == 1);
		assertTrue(test[2] == 2);
		assertTrue(test[3] == 3);
		assertTrue(test[4] == 4);
		assertTrue(test[5] == 5);
		assertTrue(test[6] == 6);
		assertTrue(test[7] == 7);
		assertTrue(test[8] == 8);
		assertTrue(test[9] == 9);
		assertFalse(test[0] == 1);

	}

	@Test
	void testSelectionSort() {

		Integer[] test = new Integer[10];
		SimpleSorts sort = new SimpleSorts();
		test[0] = 1;
		test[1] = 8;
		test[2] = 6;
		test[3] = 7;
		test[4] = 9;
		test[5] = 3;
		test[6] = 0;
		test[7] = 5;
		test[8] = 2;
		test[9] = 4;
		sort.SelectionSort(test);
		assertTrue(test[0] == 0);
		assertTrue(test[1] == 1);
		assertTrue(test[2] == 2);
		assertTrue(test[3] == 3);
		assertTrue(test[4] == 4);
		assertTrue(test[5] == 5);
		assertTrue(test[6] == 6);
		assertTrue(test[7] == 7);
		assertTrue(test[8] == 8);
		assertTrue(test[9] == 9);
		assertFalse(test[0] == 1);

	}

}

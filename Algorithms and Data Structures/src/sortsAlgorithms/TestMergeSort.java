package sortsAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMergeSort {

	@Test
	void testSort() {
		Integer[] testowa = new Integer[20];
		testowa[0] = 1;
		testowa[1] = -6;
		testowa[2] = -1;
		testowa[3] = -8;
		testowa[4] = 2;
		testowa[5] = -7;
		testowa[6] = -2;
		testowa[7] = -3;
		testowa[8] = -5;
		testowa[9] = 3;
		testowa[10] = 7;
		testowa[11] = 9;
		testowa[12] = 6;
		testowa[13] = -10;
		testowa[14] = 10;
		testowa[15] = -4;
		testowa[16] = 4;
		testowa[17] = 8;
		testowa[18] = -9;
		testowa[19] = 5;

		MergeSort testowy = new MergeSort();

		testowy.sort(testowa, 0, testowa.length - 1);

		assertTrue(testowa[0].equals(-10));
		assertTrue(testowa[1].equals(-9));
		assertTrue(testowa[2].equals(-8));
		assertTrue(testowa[3].equals(-7));
		assertTrue(testowa[4].equals(-6));
		assertTrue(testowa[5].equals(-5));
		assertTrue(testowa[6].equals(-4));
		assertTrue(testowa[7].equals(-3));
		assertTrue(testowa[8].equals(-2));
		assertTrue(testowa[9].equals(-1));
		assertTrue(testowa[10].equals(1));
		assertTrue(testowa[11].equals(2));
		assertTrue(testowa[12].equals(3));
		assertTrue(testowa[13].equals(4));
		assertTrue(testowa[14].equals(5));
		assertTrue(testowa[15].equals(6));
		assertTrue(testowa[16].equals(7));
		assertTrue(testowa[17].equals(8));
		assertTrue(testowa[18].equals(9));
		assertTrue(testowa[19].equals(10));
	}

	@Test
	void testMerge() {
		Integer[] testowa = new Integer[20];
		testowa[0] = -8;
		testowa[1] = -7;
		testowa[2] = -6;
		testowa[3] = -5;
		testowa[4] = -3;
		testowa[5] = -2;
		testowa[6] = 1;
		testowa[7] = 3;
		testowa[8] = 5;
		testowa[9] = 8;
		
		testowa[10] = -10;
		testowa[11] = -9;
		testowa[12] = -4;
		testowa[13] = -1;
		testowa[14] = 2;
		testowa[15] = 4;
		testowa[16] = 6;
		testowa[17] = 7;
		testowa[18] = 9;
		testowa[19] = 10;

		MergeSort testowy = new MergeSort();

		testowy.merge(testowa, 0,(testowa.length - 1)/2, testowa.length - 1);

		assertTrue(testowa[0].equals(-10));
		assertTrue(testowa[1].equals(-9));
		assertTrue(testowa[2].equals(-8));
		assertTrue(testowa[3].equals(-7));
		assertTrue(testowa[4].equals(-6));
		assertTrue(testowa[5].equals(-5));
		assertTrue(testowa[6].equals(-4));
		assertTrue(testowa[7].equals(-3));
		assertTrue(testowa[8].equals(-2));
		assertTrue(testowa[9].equals(-1));
		assertTrue(testowa[10].equals(1));
		assertTrue(testowa[11].equals(2));
		assertTrue(testowa[12].equals(3));
		assertTrue(testowa[13].equals(4));
		assertTrue(testowa[14].equals(5));
		assertTrue(testowa[15].equals(6));
		assertTrue(testowa[16].equals(7));
		assertTrue(testowa[17].equals(8));
		assertTrue(testowa[18].equals(9));
		assertTrue(testowa[19].equals(10));
	}

}

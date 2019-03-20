package sortsAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHeapSort {

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
		
		HeapSort testowy = new HeapSort();
		
		testowy.sort(testowa);
		
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
	void testHeapify() {
		Integer[] testowa = new Integer[10];
		
		testowa[0] = -6;
		testowa[1] = 5;
		testowa[2] = -1;
		testowa[3] = -8;
		testowa[4] = 2;
		testowa[5] = 3;
		testowa[6] = -2;
		testowa[7] = -3;
		testowa[8] = -5;
		testowa[9] = 3;
	
		HeapSort testowy = new HeapSort();
		
		testowy.heapify(testowa, testowa.length, 1);
		assertTrue(testowa[1].equals(5));
		assertTrue(testowa[2].equals(-1));
		assertTrue(testowa[3].equals(-8));
		
		testowy.heapify(testowa, testowa.length, 3);
		assertTrue(testowa[3].equals(-3));
		assertTrue(testowa[7].equals(-8));
		assertTrue(testowa[8].equals(-5));
	}

}

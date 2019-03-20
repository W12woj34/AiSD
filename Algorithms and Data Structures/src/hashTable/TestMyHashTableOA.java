package hashTable;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

class TestMyHashTableOA {

	@Test
	void testClear() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);
		assertTrue(test.size() != 0);
		test.clear();
		assertTrue(test.size() == 0);

	}

	@Test
	void testContainsKey() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		assertTrue(test.containsKey("a") == true);
		assertTrue(test.containsKey("b") == true);
		assertTrue(test.containsKey("c") == true);
		assertTrue(test.containsKey("d") == true);
		assertFalse(test.containsKey("e") == true);

	}

	@Test
	void testContainsValue() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		assertFalse(test.containsValue(1) == true);
		assertTrue(test.containsValue(2) == true);
		assertTrue(test.containsValue(3) == true);
		assertTrue(test.containsValue(4) == true);
		assertTrue(test.containsValue(5) == true);
		assertFalse(test.containsValue(6) == true);

	}

	@Test
	void testEntrySet() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		Set<Entry<String, Integer>> testowa;

		testowa = test.entrySet();

		assertTrue(testowa.size() == 4);
		Entry<String, Integer> entry1 = new AbstractMap.SimpleEntry<String, Integer>("a", 4);
		Entry<String, Integer> entry2 = new AbstractMap.SimpleEntry<String, Integer>("b", 2);
		Entry<String, Integer> entry3 = new AbstractMap.SimpleEntry<String, Integer>("c", 3);
		Entry<String, Integer> entry4 = new AbstractMap.SimpleEntry<String, Integer>("d", 5);

		assertTrue(testowa.contains(entry1));
		assertTrue(testowa.contains(entry2));
		assertTrue(testowa.contains(entry3));
		assertTrue(testowa.contains(entry4));
		assertTrue(testowa.toString().equals("[b=2, c=3, d=5, a=4]"));

	}

	@Test
	void testGet() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		assertEquals(test.size(), 4);
		assertTrue(test.get("a") == 4);
		assertTrue(test.get("b") == 2);
		assertTrue(test.get("c") == 3);
		assertTrue(test.get("d") == 5);
		assertTrue(test.get("e") == null);
		assertTrue(test.size() == 4);

	}

	@Test
	void testIsEmpty() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();

		assertTrue(test.isEmpty() == true);

		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		assertFalse(test.isEmpty() == true);

	}

	@Test
	void testKeySet() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		Set<String> testowa;

		testowa = test.keySet();

		assertTrue(testowa.size() == 4);
		assertTrue(testowa.contains("a"));
		assertTrue(testowa.contains("b"));
		assertTrue(testowa.contains("c"));
		assertTrue(testowa.contains("d"));
		assertFalse(testowa.contains("e"));
		assertTrue(testowa.toString().equals("[a, b, c, d]"));

	}

	@Test
	void increaseSize() {
		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();

		assertTrue(test.getNumBuckets() == 100);
		test.increaseSize();
		assertTrue(test.getNumBuckets() == 200);

	}

	@Test
	void testPut() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();

		assertTrue(test.put("a", 1).equals(1));
		assertTrue(test.put("b", 2).equals(2));
		assertTrue(test.put("c", 3).equals(3));
		assertTrue(test.size() == 3);
		assertTrue(test.put("a", 4).equals(4));
		assertTrue(test.size() == 3);
		assertTrue(test.put("d", 5).equals(5));

	}

	@Test
	void testPutAll() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		Map<String, Integer> testowa = new Hashtable<String, Integer>();
		testowa.put("d", 6);
		testowa.put("e", 7);
		testowa.put("f", 8);
		testowa.put("g", 9);

		test.putAll(testowa);

		assertTrue(test.size() == 7);
		assertTrue(test.containsKey("a"));
		assertTrue(test.containsKey("b"));
		assertTrue(test.containsKey("c"));
		assertTrue(test.containsKey("d"));
		assertTrue(test.containsKey("e"));
		assertTrue(test.containsKey("f"));
		assertTrue(test.containsKey("g"));
		assertTrue(test.containsValue(2));
		assertTrue(test.containsValue(3));
		assertTrue(test.containsValue(4));
		assertTrue(test.containsValue(6));
		assertTrue(test.containsValue(7));
		assertTrue(test.containsValue(8));
		assertTrue(test.containsValue(9));

	}

	@Test
	void testRemove() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		assertTrue(test.size() == 4);
		assertTrue(test.remove("a") == 4);
		assertTrue(test.remove("b") == 2);
		assertTrue(test.remove("c") == 3);
		assertTrue(test.remove("d") == 5);
		assertTrue(test.remove("e") == null);
		assertTrue(test.size() == 0);

	}

	@Test
	void testSize() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();

		assertTrue(test.size() == 0);

		test.put("a", 1);
		assertTrue(test.size() == 1);

		test.put("b", 2);
		assertTrue(test.size() == 2);

		test.put("c", 3);
		assertTrue(test.size() == 3);

		test.put("a", 4);
		assertTrue(test.size() == 3);

		test.put("d", 5);
		assertTrue(test.size() == 4);

	}

	@Test
	void testValues() {

		MyHashTableOA<String, Integer> test = new MyHashTableOA<String, Integer>();
		test.put("a", 1);
		test.put("b", 2);
		test.put("c", 3);
		test.put("a", 4);
		test.put("d", 5);

		Collection<Integer> testowa;

		testowa = test.values();

		assertTrue(testowa.size() == 4);
		assertTrue(testowa.contains(2));
		assertTrue(testowa.contains(3));
		assertTrue(testowa.contains(4));
		assertTrue(testowa.contains(5));
		assertTrue(testowa.toString().equals("[5, 4, 2, 3]"));

	}
}

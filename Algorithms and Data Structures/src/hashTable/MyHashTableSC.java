package hashTable;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class HashEntrySC<K, V> {

	private K key;
	private V value;

	public HashEntrySC(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

}

public class MyHashTableSC<K, V> implements Map<K, V> {

	private ArrayList<LinkedList<HashEntrySC<K, V>>> bucketArray;
	private int numBuckets;
	private int size;

	public MyHashTableSC() {
		bucketArray = new ArrayList<>();
		numBuckets = 100;
		size = 0;

		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(new LinkedList<>());
		}
	}

	public int getNumBuckets() {
		return numBuckets;
	}

	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % numBuckets;
		return index;
	}

	@Override
	public void clear() {
		bucketArray.clear();
		size = 0;

		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(new LinkedList<>());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object key) {
		for (LinkedList<HashEntrySC<K, V>> list : bucketArray) {
			for (HashEntrySC<K, V> node : list) {
				if (node.getKey().equals(((K) key))) {
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsValue(Object value) {
		for (LinkedList<HashEntrySC<K, V>> list : bucketArray) {
			for (HashEntrySC<K, V> node : list) {
				if (node.getValue().equals(((V) value))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {

		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();

		for (LinkedList<HashEntrySC<K, V>> list : bucketArray) {
			for (HashEntrySC<K, V> node : list) {

				set.add((new AbstractMap.SimpleEntry<K, V>(node.getKey(), node.getValue())));

			}
		}

		return ((Set<Entry<K, V>>) set);

	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {

		int bucketIndex = getBucketIndex((K) key);
		for (HashEntrySC<K, V> node : bucketArray.get(bucketIndex)) {
			if (node.getKey().equals(((K) key))) {
				return node.getValue();
			}
		}

		return null;

	}

	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<>();

		for (LinkedList<HashEntrySC<K, V>> list : bucketArray) {
			for (HashEntrySC<K, V> node : list) {
				set.add(node.getKey());
			}
		}

		return ((Set<K>) set);
	}

	@Override
	public V put(K key, V value) {

		int bucketIndex = getBucketIndex(key);

		for (HashEntrySC<K, V> node : bucketArray.get(bucketIndex)) {
			if (node.getKey().equals(key) == true) {
				node.setValue(value);
				return value;
			}
		}
		HashEntrySC<K, V> node = new HashEntrySC<>(key, value);
		bucketArray.get(bucketIndex).add(node);
		size++;

		if (((double) size) / (double) numBuckets >= 0.8) {
			increaseSize();
		}
		return value;
	}

	public void increaseSize() {

		ArrayList<LinkedList<HashEntrySC<K, V>>> temp = bucketArray;
		bucketArray = new ArrayList<LinkedList<HashEntrySC<K, V>>>();
		numBuckets = 2 * numBuckets;
		size = 0;
		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(new LinkedList<>());
		}

		for (LinkedList<HashEntrySC<K, V>> list : temp) {
			for (HashEntrySC<K, V> nodeTmp : list) {
				put(nodeTmp.getKey(), nodeTmp.getValue());

			}
		}

	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {

		for (Map.Entry<? extends K, ? extends V> hashmap : map.entrySet()) {
			put(hashmap.getKey(), hashmap.getValue());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {

		int bucketIndex = getBucketIndex((K) key);

		for (HashEntrySC<K, V> node : bucketArray.get(bucketIndex)) {
			if (node.getKey().equals(key) == true) {
				bucketArray.get(bucketIndex).remove(node);
				size--;
				return node.getValue();
			}
		}
		return null;

	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<V> values() {

		Collection<V> col = new ArrayList<>();

		for (LinkedList<HashEntrySC<K, V>> list : bucketArray) {
			for (HashEntrySC<K, V> node : list) {
				col.add(node.getValue());
			}
		}

		return ((Collection<V>) col);
	}

}

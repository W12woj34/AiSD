package hashTable;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class HashEntryOA<K, V> {

	K key;
	V value;

	public HashEntryOA(K key, V value) {

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

public class MyHashTableOA<K, V> implements Map<K, V> {

	private ArrayList<HashEntryOA<K, V>> bucketArray;
	private int numBuckets;
	private int size;
	HashEntryOA<K, V> deleted;

	public MyHashTableOA() {
		bucketArray = new ArrayList<>();
		numBuckets = 100;
		size = 0;
		deleted = new HashEntryOA<K, V>(null, null);

		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
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
			bucketArray.add(null);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object key) {

		for (HashEntryOA<K, V> entry : bucketArray) {
			if (entry != null) {
				if (entry.getKey().equals(((K) key))) {
					return true;
				}
			}
		}
		return false;

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsValue(Object value) {

		for (HashEntryOA<K, V> entry : bucketArray) {
			if (entry != null) {
				if (entry.getValue().equals(((V) value))) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public Set<Entry<K, V>> entrySet() {

		Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();

		for (HashEntryOA<K, V> entry : bucketArray) {
			if (entry != null) {
				set.add((new AbstractMap.SimpleEntry<K, V>(entry.getKey(), entry.getValue())));
			}
		}

		return ((Set<Entry<K, V>>) set);

	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {

		int bucketIndex = getBucketIndex((K) key);

		for (int i = 0; i < numBuckets; i++) {

			if (bucketArray.get((bucketIndex + i) % numBuckets) == null) {
				return null;
			}

			if (bucketArray.get((bucketIndex + i) % numBuckets) != deleted) {
				if (bucketArray.get((bucketIndex + i) % numBuckets).getKey().equals(key)) {

					return bucketArray.get((bucketIndex + i) % numBuckets).getValue();
				}
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

		for (HashEntryOA<K, V> entry : bucketArray) {
			if (entry != null) {
				set.add(entry.getKey());
			}
		}

		return ((Set<K>) set);
	}

	@Override
	public V put(K key, V value) {

		int bucketIndex = getBucketIndex(key);

		outerloop: for (int i = 0; i < numBuckets; i++) {

			if (bucketArray.get((bucketIndex + i) % numBuckets) == null) {
				break outerloop;
			}

			if (bucketArray.get((bucketIndex + i) % numBuckets).getKey().equals(key)) {
				bucketArray.get((bucketIndex + i) % numBuckets).setValue(value);
				return value;
			}

		}

		outerloop: for (int i = 0; i < numBuckets; i++) {

			if (bucketArray.get((bucketIndex + i) % numBuckets) == null
					|| bucketArray.get((bucketIndex + i) % numBuckets) == deleted) {

				HashEntryOA<K, V> entry = new HashEntryOA<>(key, value);
				bucketArray.set(((bucketIndex + i) % numBuckets), entry);
				break outerloop;
			}

		}

		if (((double) size) / (double) numBuckets >= 0.8) {
			increaseSize();
		}

		size++;
		return value;

	}

	public void increaseSize() {

		ArrayList<HashEntryOA<K, V>> temp = bucketArray;
		bucketArray = new ArrayList<HashEntryOA<K, V>>();
		numBuckets = 2 * numBuckets;
		size = 0;

		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}

		for (HashEntryOA<K, V> entryTmp : temp) {
			if (entryTmp != null) {
				put(entryTmp.getKey(), entryTmp.getValue());
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

		for (int i = 0; i < numBuckets; i++) {

			if (bucketArray.get((bucketIndex + i) % numBuckets) == null) {
				return null;
			}

			if (bucketArray.get((bucketIndex + i) % numBuckets) != deleted) {
				if (bucketArray.get((bucketIndex + i) % numBuckets).getKey().equals(key)) {

					V val = bucketArray.get((bucketIndex + i) % numBuckets).getValue();
					bucketArray.set((bucketIndex + i) % numBuckets, deleted);
					size--;

					return val;
				}
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

		for (HashEntryOA<K, V> entry : bucketArray) {
			if (entry != null) {
				col.add(entry.getValue());
			}
		}

		return ((Collection<V>) col);
	}

}

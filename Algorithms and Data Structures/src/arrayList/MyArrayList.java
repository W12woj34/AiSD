package arrayList;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements Iterable<T> {

	private T[] array;
	private int actualSize = 0;

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[10];
	}

	public void clear() {
		Arrays.fill(array, null);
		actualSize = 0;
		array = Arrays.copyOf(array, 10);
	}

	public T get(int index) {
		if (index < actualSize) {
			return array[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void set(int index, T obj) {
		if (index < actualSize) {
			array[index] = obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void add(T obj) {

		array[actualSize++] = obj;

		if ((double) actualSize / (double) array.length >= 0.9) {
			increaseSize();
		}
	}

	public void add(int index, T obj) {

		actualSize++;
		for (int i = 1; i < actualSize - index; i++) {
			array[actualSize - i] = array[actualSize - i - 1];
		}
		array[index] = obj;

		if ((double) actualSize / (double) array.length >= 0.9) {
			increaseSize();
		}
	}

	public void addAll(List<T> list) {

		for (int i = 0; i < list.size(); i++) {
			array[actualSize++] = list.get(i);

			if ((double) actualSize / (double) array.length >= 0.9) {
				increaseSize();
			}
		}
	}

	public void addAll(int index, List<T> list) {

		for (int j = 0; j < list.size(); j++) {
			actualSize++;
			for (int i = 1; i < actualSize - index; i++) {
				array[actualSize - i] = array[actualSize - i - 1];
			}
			array[index] = list.get(j);
			;

			if ((double) actualSize / (double) array.length >= 0.9) {
				increaseSize();
			}
			index++;
		}
	}

	public void remove(int index) {
		if (index < actualSize) {
			array[index] = null;
			int tmp = index;
			while (tmp < actualSize) {
				array[tmp] = array[tmp + 1];
				array[tmp + 1] = null;
				tmp++;
			}
			actualSize--;
			if ((double) actualSize / (double) array.length <= 0.7) {
				decreaseSize();
			}

		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	public int IndexOf(T obj) {

		for (int i = 0; i < actualSize; i++) {
			System.out.println(array[i]);
			if (array[i].equals(obj)) {
				return i;
			}

		}
		return -1;

	}

	public int size() {
		return actualSize;
	}

	private void increaseSize() {
		array = Arrays.copyOf(array, (int) Math.ceil(array.length * 1.1));

	}

	private void decreaseSize() {
		array = Arrays.copyOf(array, (int) Math.ceil(array.length * 0.9));

	}

	@Override
	public ListIterator<T> iterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements ListIterator<T> {
		private int current = 0;

		@Override
		public void add(T element) {
			MyArrayList.this.add(current, element);
		}

		@Override
		public boolean hasNext() {
			return current < size();
		}

		@Override
		public boolean hasPrevious() {
			return current > 0;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			return array[current++];
		}

		@Override
		public int nextIndex() {
			return current;
		}

		@Override
		public T previous() {
			if (!hasPrevious())
				throw new java.util.NoSuchElementException();
			return array[--current];
		}

		@Override
		public int previousIndex() {
			return current - 1;
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(current);

		}

		@Override
		public void set(T e) {
			MyArrayList.this.set(current, e);

		}

	}

}

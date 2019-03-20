package queue;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;
import linkedList.MyLinkedList;

public class MyQueue<T> extends MyLinkedList<T> implements Queue<T> {

	@Override
	public T remove() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		} else {
			return MyQueue.this.remove(0);
		}
	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T[] toArray(T[] array) {
		if (array.length >= this.size()) {

			for (int i = 0; i < this.size(); i++) {
				array[i] = (T) this.get(i);
			}
			for (int i = this.size(); i < array.length; i++) {
				array[i] = null;
			}
			return array;

		} else {

			T[] newArray = (T[]) new Object[this.size()];
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = (T) this.get(i);
			}
			return newArray;
		}

	}

	@Override
	public T element() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		} else {
			return MyQueue.this.get(0);
		}
	}

	@Override
	public boolean offer(T element) {
		return MyQueue.this.add(element);
	}

	@Override
	public T peek() {
		if (isEmpty() == true) {
			return null;
		} else {
			return MyQueue.this.get(0);
		}
	}

	@Override
	public T poll() {
		if (isEmpty() == true) {
			return null;
		} else {
			return MyQueue.this.remove(0);
		}

	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();

	}

}

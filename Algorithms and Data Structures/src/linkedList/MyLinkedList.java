package linkedList;

import java.util.Collection;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

	private Node head;
	private Node tail;
	private int size;

	public MyLinkedList() {
		this.size = 0;
	}

	private class Node {

		private T data;
		Node next;
		Node prev;

		public Node(T data) {
			this.data = data;
		}
	}

	public boolean add(T element) {
		Node temp = new Node(element);
		if (head == null) {
			head = temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
		}
		tail = temp;
		size++;
		return true;
	}

	public boolean add(int index, T element) {
		Node temp = new Node(element);
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			if (head == null) {
				head = temp;
				tail = head;
			} else {
				temp.next = head;
				head.prev = temp;
				head = temp;
			}
			size++;
		} else if (index == size) {
			add(element);
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Node previous = current.prev;
			previous.next = temp;
			temp.prev = previous;
			temp.next = current;
			current.prev = temp;
			size++;
		}
		return true;
	}

	public boolean addAll(Collection<? extends T> list) {
		for (T element : list) {
			Node temp = new Node(element);
			if (head == null) {
				head = temp;
			} else {
				tail.next = temp;
				temp.prev = tail;
			}
			tail = temp;
			size++;
		}

		return true;
	}

	public boolean addAll(int index, Collection<? extends T> list) {
		for (T element : list) {
			Node temp = new Node(element);
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException();
			} else if (index == 0) {
				if (head == null) {
					head = temp;
					tail = head;
				} else {
					temp.next = head;
					head.prev = temp;
					head = temp;
				}
				size++;
			} else if (index == size) {
				add(element);
			} else {
				Node current = head;
				for (int j = 0; j < index; j++) {
					current = current.next;
				}
				Node previous = current.prev;
				previous.next = temp;
				temp.prev = previous;
				temp.next = current;
				current.prev = temp;
				size++;
			}
			index++;
		}
		return true;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == size - 1) {
			Node current = tail;
			return current.data;
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	public boolean set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.data = element;
		}
		return true;
	}

	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0 && size == 1) {
			Node current = head;
			head.next = null;
			head.prev = null;
			head = null;
			size--;
			return current.data;
		} else if (index == 0 && size != 1) {
			Node current = head;
			head = head.next;
			head.prev = null;
			size--;
			return current.data;
		} else if (index == size - 1) {
			Node current = tail;
			tail = tail.prev;
			tail.next = null;
			size--;
			return current.data;
		} else {
			Node current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			Node previous = current.prev;
			Node next = current.next;
			previous.next = current.next;
			next.prev = previous;
			size--;
			return current.data;
		}
	}

	public int indexOf(T element) {

		Node current = head;
		for (int i = 0; i < size; i++) {
			if (current.data.equals(element)) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	public int size() {
		return size;
	}

	public void clear() {
		head.next = null;
		head.prev = null;
		tail.next = null;
		tail.prev = null;
		head = null;
		tail = null;
		size = 0;

	}

	public ListIterator<T> iterator() {
		return new MyLinkedListIterator();
	}

	private class MyLinkedListIterator implements ListIterator<T> {
		private Node current = head;
		private Node lastAccessed = null;
		private int index = 0;

		public boolean hasNext() {
			return index < size;
		}

		public boolean hasPrevious() {
			return index > 0;
		}

		public int previousIndex() {
			return index - 1;
		}

		public int nextIndex() {
			return index;
		}

		public T next() {
			if (hasNext() != true) {
				throw new NoSuchElementException();
			}
			lastAccessed = current;
			T element = current.data;
			current = current.next;
			index++;
			return element;
		}

		public T previous() {
			if (hasPrevious() != true) {
				throw new NoSuchElementException();
			}
			lastAccessed = current;
			T element = current.data;
			current = current.prev;
			index--;
			return element;
		}

		public void set(T element) {
			if (lastAccessed == null) {
				throw new IllegalStateException();
			}
			lastAccessed.data = element;
		}

		public void remove() {
			if (lastAccessed == null) {
				throw new IndexOutOfBoundsException();
			} else {
				Node current = lastAccessed;
				if (current.prev != null && current.next != null) {

					Node previous = current.prev;
					Node next = current.next;
					previous.next = current.next;
					next.prev = previous;
					size--;
					index--;
				} else if (current.prev == null) {
					Node next = current.next;
					head = next;
					next.prev = null;
					size--;
					index--;
				} else if (current.next == null) {
					Node previous = current.prev;
					tail = previous;
					previous.next = null;
					size--;
					index--;
				}
			}
		}

		public void add(T element) {

			MyLinkedList.this.add(index, element);
			index++;

		}

	}

}
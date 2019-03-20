package bst;

import java.util.ArrayList;

public class RedBlackTree {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root;
	private int size;
	private int leaves;
	private int levels;

	private class Node {

		private int data;
		private Node left;
		private Node right;
		private boolean color;

		public Node(int data) {
			this.data = data;
			this.color = RED;

		}
	}

	public RedBlackTree() {

		this.root = null;
		this.size = 0;
		this.leaves = 0;
		this.levels = 0;
	}

	private boolean isRed(Node node) {

		if (node == null) {
			return false;

		}
		if (node.color == RED) {
			return true;

		} else {
			return false;

		}

	}

	public Node getRoot() {
		return this.root;
	}

	public int size() {
		return size;
	}

	public int get(int data) {

		Node temp = find(root, data);

		if (temp == null) {
			throw new NullPointerException();

		} else {
			return temp.data;

		}

	}

	public boolean put(int data) {

		if (find(data) == true) {
			return false;
		} else {

			root = put(root, data);
			root.color = BLACK;
			size++;
			return true;
		}
	}

	private Node put(Node root, int data) {

		if (root == null) {
			return new Node(data);
		}

		if (data < root.data) {
			root.left = put(root.left, data);

		} else if (data > root.data) {
			root.right = put(root.right, data);

		}

		if (isRed(root.right) == true && isRed(root.left) == false) {
			root = rotateLeft(root);
		}

		if (isRed(root.left) == true && isRed(root.left.left) == true) {
			root = rotateRight(root);
		}

		if (isRed(root.left) == true && isRed(root.right) == true) {
			flipColors(root);
		}

		return root;
	}

	private Node deleteMin(Node node) {

		if (node.left == null) {
			return null;
		}

		if (isRed(node.left) == false && isRed(node.left.left) == false) {
			node = moveRedLeft(node);
		}

		node.left = deleteMin(node.left);

		return balance(node);

	}

	public boolean delete(int data) {

		if (find(data) != true) {
			return false;

		} else {

			if (isRed(root.left) == false && isRed(root.right) == false) {
				root.color = RED;

			}

			root = delete(root, data);

			if (size() == 0) {
				root.color = BLACK;

			}

			size--;
			return true;
		}

	}

	private Node delete(Node root, int data) {

		if (data < root.data) {

			if (isRed(root.left) == false && isRed(root.left.left) == false) {
				root = moveRedLeft(root);

			}

			root.left = delete(root.left, data);

		} else {

			if (isRed(root.left) == true) {
				root = rotateRight(root);
			}

			if (data == root.data && (root.right == null)) {
				return null;
			}

			if (isRed(root.right) == false && isRed(root.right.left) == false) {
				root = moveRedRight(root);
			}

			if (data == root.data) {

				Node node = min(root.right);
				root.data = node.data;
				root.right = deleteMin(root.right);

			} else {
				root.right = delete(root.right, data);
			}

		}

		return balance(root);
	}

	private Node rotateRight(Node node) {

		Node rotated = node.left;
		node.left = rotated.right;
		rotated.right = node;
		rotated.color = rotated.right.color;
		rotated.right.color = RED;

		return rotated;

	}

	private Node rotateLeft(Node node) {

		Node rotated = node.right;
		node.right = rotated.left;
		rotated.left = node;
		rotated.color = rotated.left.color;
		rotated.left.color = RED;

		return rotated;

	}

	private void flipColors(Node node) {

		node.color = !node.color;
		node.left.color = !node.left.color;
		node.right.color = !node.right.color;

	}

	private Node moveRedLeft(Node node) {

		flipColors(node);

		if (isRed(node.right.left) == true) {

			node.right = rotateRight(node.right);
			node = rotateLeft(node);
			flipColors(node);

		}

		return node;
	}

	private Node moveRedRight(Node node) {

		flipColors(node);

		if (isRed(node.left.left) == true) {

			node = rotateRight(node);
			flipColors(node);

		}

		return node;
	}

	private Node balance(Node node) {

		if (isRed(node.right) == true) {
			node = rotateLeft(node);

		}

		if (isRed(node.left) == true && isRed(node.left.left) == true) {
			node = rotateRight(node);

		}

		if (isRed(node.left) == true && isRed(node.right) == true) {
			flipColors(node);

		}

		return node;
	}

	private Node min(Node node) {

		if (node.left == null) {
			return node;

		} else {
			return min(node.left);
		}
	}

	public boolean find(int data) {

		if (find(root, data) != null) {
			return true;
		} else {
			return false;
		}
	}

	private Node find(Node root, int data) {

		if (root == null || root.data == data) {
			return root;

		} else if (root.data > data) {
			return find(root.left, data);

		} else {
			return find(root.right, data);
		}
	}

	public Integer minValue() {

		if (root == null) {
			return null;
		} else {
			return minValue(root);
		}
	}

	private Integer minValue(Node root) {
		if (root.left != null) {
			return minValue(root.left);

		} else {
			return root.data;

		}

	}

	public Integer maxValue() {

		if (root == null) {
			return null;

		} else {
			return maxValue(root);

		}
	}

	private Integer maxValue(Node root) {

		if (root.right != null) {
			return maxValue(root.right);

		} else {
			return root.data;

		}

	}

	public int levels() {

		if (root == null) {
			return 0;

		} else {
			levels = 0;
			return levels(root, 1);

		}
	}

	private int levels(Node root, int currentLvl) {

		if (root.left == null && root.right == null) {

			if (levels < currentLvl) {
				levels = currentLvl;
			}

			return levels;

		} else if (root.left != null && root.right == null) {
			levels(root.left, currentLvl + 1);

		} else if (root.left == null && root.right != null) {
			levels(root.right, currentLvl + 1);

		} else {
			levels(root.left, currentLvl + 1);
			levels(root.right, currentLvl + 1);

		}

		return levels;

	}

	public int leaves() {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;

		}

		leaves = 0;
		return leaves(root);

	}

	private int leaves(Node root) {
		if (root.left == null && root.right == null) {
			return leaves++;

		} else if (root.left != null && root.right == null) {
			leaves(root.left);

		} else if (root.left == null && root.right != null) {
			leaves(root.right);

		} else {
			leaves(root.left);
			leaves(root.right);

		}

		return leaves;

	}

	public int roots() {

		if (root == null) {
			return 0;

		} else {
			return (size() - leaves() - 1);

		}

	}

	public void print() {

		ArrayList<ArrayList<String>> linie = new ArrayList<ArrayList<String>>();
		ArrayList<Node> level = new ArrayList<Node>();
		ArrayList<Node> next = new ArrayList<Node>();

		level.add(root);

		int iloscZnakow = 1;
		int szerokoscZnaku = 0;

		while (iloscZnakow != 0) {

			ArrayList<String> linia = new ArrayList<String>();

			iloscZnakow = 0;

			for (Node node : level) {

				if (node == null) {

					linia.add(null);
					next.add(null);
					next.add(null);

				} else {

					String znak = String.valueOf(node.data);
					linia.add(znak);

					if (znak.length() > szerokoscZnaku) {
						szerokoscZnaku = znak.length();
					}

					next.add(node.left);
					next.add(node.right);

					if (node.left != null) {
						iloscZnakow++;
					}

					if (node.right != null) {
						iloscZnakow++;
					}

				}
			}

			if (szerokoscZnaku % 2 == 1) {
				szerokoscZnaku++;
			}

			linie.add(linia);
			ArrayList<Node> tmp = level;
			level = next;
			next = tmp;
			next.clear();
		}

		int dlugoscKreski = linie.get(linie.size() - 1).size() * (szerokoscZnaku + 2);

		for (int i = 0; i < linie.size(); i++) {

			ArrayList<String> line = linie.get(i);

			int dlugoscKreskiPoJednejStronie = (int) Math.floor(dlugoscKreski / 2) - 1;

			if (i > 0) {

				for (int j = 0; j < line.size(); j++) {

					String kratka = " ";

					if (j % 2 == 1) {

						if (line.get(j - 1) != null) {

							kratka = "^";

						} else {

							if (line.get(j) != null) {

								kratka = "^";

							}

						}
					}

					System.out.print(kratka);

					if (line.get(j) == null) {

						for (int k = 0; k < dlugoscKreski - 1; k++) {

							System.out.print(" ");
						}

					} else {

						for (int k = 0; k < dlugoscKreskiPoJednejStronie; k++) { // lewa

							if (j % 2 == 0) {
								System.out.print(" ");
							} else {
								System.out.print("-");
							}

						}

						System.out.print("|");

						for (int k = 0; k < dlugoscKreskiPoJednejStronie; k++) { // prawa

							if (j % 2 == 0) {
								System.out.print("-");
							} else {
								System.out.print(" ");
							}

						}
					}
				}
				System.out.println();
			}

			for (int j = 0; j < line.size(); j++) {

				String liczba = line.get(j);

				if (liczba == null) {
					liczba = " ";

				}

				int luka1 = (int) Math.ceil(dlugoscKreski / 2 - liczba.length() / 2f);
				int luka2 = (int) Math.floor(dlugoscKreski / 2 - liczba.length() / 2f);

				// a number
				for (int k = 0; k < luka1; k++) {
					System.out.print(" ");
				}

				System.out.print(liczba);

				for (int k = 0; k < luka2; k++) {
					System.out.print(" ");

				}
			}

			System.out.println();

			dlugoscKreski = dlugoscKreski / 2;
		}

	}

	public static void main(String arg[]) {

		RedBlackTree test = new RedBlackTree();

		// test.put(5);
		// test.put(7);
		// test.put(3);
		// test.put(1);
		// test.put(12);
		// test.put(11);
		// test.put(4);
		// test.put(6);
		// test.put(20);
		// test.put(17);
		// test.put(2);
		// test.put(22);
		// test.put(19);
		// test.put(25);
		// test.put(26);
		// test.put(27);
		// test.put(28);
		// test.put(29);

		test.put(1);
		test.put(2);
		test.put(3);
		test.put(4);
		test.put(5);
		test.put(6);

		System.out.println();
		test.print();

	}

}
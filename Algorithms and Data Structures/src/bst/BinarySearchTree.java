package bst;

import java.util.ArrayList;


public class BinarySearchTree {

	private Node root;
	private int size;
	private int leaves;
	private int levels;

	public BinarySearchTree() {

		this.root = null;
		this.size = 0;
		this.leaves = 0;
		this.levels = 0;
	}

	class Node {

		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public Node getRoot() {
		return this.root;
	}

	public int size() {
		return size;
	}

	public boolean find(int data) {

		if (find(root, data) != null) {
			return true;
		} else {
			return false;
		}
	}

	public int get(int data) {

		Node temp = find(root, data);

		if (temp == null) {
			throw new NullPointerException();

		} else {
			return temp.data;

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

	public boolean delete(int data) {

		if (find(data) != true) {
			return false;
		} else {

			root = delete(root, data);
			size--;
			return true;
		}

	}

	private Node delete(Node root, int data) {

		if (root == null) {
			return root;
		}

		if (data < root.data) {
			root.left = delete(root.left, data);

		} else if (data > root.data) {
			root.right = delete(root.right, data);

		} else {

			if (root.left == null) {

				return root.right;
			} else if (root.right == null) {

				return root.left;
			}

			root.data = minValue(root.right);
			root.right = delete(root.right, root.data);
		}

		return root;
	}

	public boolean put(int data) {

		if (find(data) == true) {
			return false;
		} else {

			root = put(root, data);
			size++;
			return true;
		}

	}

	private Node put(Node root, int data) {

		if (root == null) {
			root = new Node(data);

			return root;
		}

		if (data < root.data) {
			root.left = put(root.left, data);

		} else if (data > root.data) {
			root.right = put(root.right, data);

		}

		return root;
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

							if (line.get(j) != null) {
								kratka = "^";

							} else {
								kratka = "^";

							}

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

						if (j % 2 == 0) {
							System.out.print("|");

						} else {
							System.out.print("|");
						}

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

		BinarySearchTree test = new BinarySearchTree();

	//	test.put(5);
	//	test.put(7);
	//	test.put(3);
	//	test.put(1);
	//	test.put(12);
	//	test.put(11);
	//	test.put(4);
	//	test.put(6);
	//	test.put(20);
	//	test.put(17);
	//	test.put(2);
	//	test.put(22);
	//	test.put(19);

		
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

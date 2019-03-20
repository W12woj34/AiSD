package graphs;

import java.io.Serializable;

public class MatrixGraph implements MyGraph, Serializable {

	private static final long serialVersionUID = 3627556718715435260L;
	private Integer tab[][];

	public MatrixGraph() {

		tab = new Integer[1][1];
		tab[0][0] = null;

	}

	public Integer[][] getTab() {
		return this.tab;
	}

	public boolean addVertex(int key) {

		for (int i = 1; i < tab.length; i++) {
			if (tab[0][i] == key) {
				return false;
			}
		}

		Integer[][] tabTmp = new Integer[tab.length + 1][tab.length + 1];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tabTmp[i][j] = tab[i][j];
			}
		}

		for (int i = 0; i < tab.length; i++) {
			tabTmp[i][tab.length] = 0;
		}
		for (int i = 0; i < tab.length; i++) {
			tabTmp[tab.length][i] = 0;
		}

		tabTmp[tab.length][tab.length] = 0;
		tabTmp[0][tab.length] = key;
		tabTmp[tab.length][0] = key;

		tab = tabTmp;
		return true;

	}

	public boolean addVertex() {

		int key = 0;
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			key = i;

			outerLoop: {
				for (int j = 1; j < tab.length; j++) {
					if (tab[0][j] == key) {
						break outerLoop;
					}
				}
				break;

			}
		}

		Integer[][] tabTmp = new Integer[tab.length + 1][tab.length + 1];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				tabTmp[i][j] = tab[i][j];
			}
		}

		for (int i = 0; i < tab.length; i++) {
			tabTmp[i][tab.length] = 0;
		}
		for (int i = 0; i < tab.length; i++) {
			tabTmp[tab.length][i] = 0;
		}

		tabTmp[tab.length][tab.length] = 0;
		tabTmp[0][tab.length] = key;
		tabTmp[tab.length][0] = key;

		tab = tabTmp;
		return true;

	}

	public boolean deleteVertex(int key) {

		int position;

		outerloop: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == key) {
					position = i;
					break outerloop;
				}
			}
			return false;
		}

		Integer[][] tabTmp = new Integer[tab.length - 1][tab.length - 1];

		for (int i = 0; i < position; i++) {

			for (int j = 0; j < position; j++) {
				tabTmp[i][j] = tab[i][j];
			}
		}

		for (int i = position + 1; i < tab.length; i++) {
			for (int j = 0; j < position; j++) {
				tabTmp[i - 1][j] = tab[i][j];
			}
		}

		for (int i = 0; i < tab.length - 1; i++) {
			for (int j = position + 1; j < tab[i].length; j++) {
				tabTmp[i][j - 1] = tab[i][j];
			}
		}

		for (int i = position + 1; i < tab.length; i++) {
			for (int j = position + 1; j < tab[i].length; j++) {
				tabTmp[i - 1][j - 1] = tab[i][j];
			}
		}

		tab = tabTmp;

		return true;
	}

	public boolean addEdge(int V1, int V2) {

		int position1;
		int position2;

		outerloop1: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V1) {
					position1 = i;
					break outerloop1;
				}
			}
			return false;
		}

		outerloop2: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V2) {
					position2 = i;
					break outerloop2;
				}
			}
			return false;
		}

		if (tab[position1][position2] > 0) {
			return false;
		}

		tab[position2][position1] = 1;
		tab[position1][position2] = 1;
		return true;

	}

	public boolean addEdge(int V1, int V2, int value) {

		int position1;
		int position2;

		outerloop1: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V1) {
					position1 = i;
					break outerloop1;
				}
			}
			return false;
		}

		outerloop2: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V2) {
					position2 = i;
					break outerloop2;
				}
			}
			return false;
		}

		if (tab[position1][position2] > 0) {
			return false;
		}

		if (value <= 0) {
			return false;
		}

		tab[position2][position1] = value;
		tab[position1][position2] = value;
		return true;

	}

	public boolean deleteEdge(int V1, int V2) {

		int position1;
		int position2;

		outerloop1: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V1) {
					position1 = i;
					break outerloop1;
				}
			}
			return false;
		}

		outerloop2: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V2) {
					position2 = i;
					break outerloop2;
				}
			}
			return false;
		}

		if (tab[position1][position2] == 0) {
			return false;
		}

		tab[position2][position1] = 0;
		tab[position1][position2] = 0;
		return true;

	}

	public boolean setEdgeValue(int V1, int V2, int value) {

		int position1;
		int position2;

		outerloop1: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V1) {
					position1 = i;
					break outerloop1;
				}
			}
			return false;
		}

		outerloop2: {
			for (int i = 1; i < tab.length; i++) {
				if (tab[0][i] == V2) {
					position2 = i;
					break outerloop2;
				}
			}
			return false;
		}

		if (tab[position1][position2] == 0) {
			return false;
		}

		if (value <= 0) {
			return false;
		}

		tab[position2][position1] = value;
		tab[position1][position2] = value;
		return true;

	}

	public void printEdges() {

		System.out.println();

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {

				System.out.print(tab[i][j] + "	");

			}
			System.out.print("\n");
		}

	}

}

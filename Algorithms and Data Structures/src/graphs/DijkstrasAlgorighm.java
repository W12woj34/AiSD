package graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import graphs.ListGraph;
import graphs.MatrixGraph;

public class DijkstrasAlgorighm {

	private static int[][] findTableOfShortest(ListGraph graph, int startingVertex) {
		int n = graph.size();
		int[][] results = new int[2][n];

		ArrayList<Integer> S, Q;
		int u;

		S = new ArrayList<>();
		Q = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Q.add(new Integer(i));
			results[0][i] = Integer.MAX_VALUE;
			results[1][i] = -1;
		}
		results[0][startingVertex] = 0;

		for (int i = 0; i < n; i++) {

			u = findMinD(results[0], Q);
			Q.remove(new Integer(u));
			S.add(u);

			ArrayList<Integer> neighbours = graph.getNeighbours(u);

			for (int w : neighbours) {
				if (Q.contains(w)) {

					if (results[0][w] > results[0][u] + graph.edgeValue(u, w)) {

						results[0][w] = results[0][u] + graph.edgeValue(u, w);
						results[1][w] = u;
					}

				} else {
					
				} 
			} 
		} 
		return results;
	}

	private static int[][] findTableOfShortest(MatrixGraph graph, int startingVertex) {

		Integer[][] matrix = Arrays.copyOf(graph.getTab(), graph.getTab().length);

		Integer[] names = Arrays.copyOf(matrix[0], matrix[0].length);
		names[0] = -1;

		for (int i = 1; i < matrix.length; i++) {
			matrix[i - 1] = Arrays.copyOfRange(matrix[i], 1, matrix[i].length);
		}
		int n = matrix[0].length;
		int[][] results = new int[2][n]; 

		ArrayList<Integer> S, Q;
		int u;

		S = new ArrayList<>();
		Q = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			Q.add(new Integer(i));

			results[0][i] = Integer.MAX_VALUE;
			results[1][i] = -1;
		}

		results[0][startingVertex] = 0;

		for (int i = 0; i < n; i++) {

			u = findMinD(results[0], Q);
			Q.remove(new Integer(u));
			S.add(u);

			for (int w = 0; w < n; w++) {
				if (Q.contains(w)) {
					if (results[0][w] > results[0][u] + matrix[u][w] && matrix[u][w] != 0) {

						results[0][w] = results[0][u] + matrix[u][w];
						results[1][w] = u;
					}

				} else {
					
				} 
			} 
		} 
		for (int i = 0; i < results[1].length; i++) {
			int index = results[1][i];
			results[1][i] = names[index + 1];
		}
		
		return results;
	}

	private static int findMinD(int[] d, ArrayList<Integer> Q) {
		int minIndeks = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < d.length; i++) {
			if (d[i] < min && Q.contains(new Integer(i))) {
				min = d[i];
				minIndeks = i;
			}
		}
		return minIndeks;
	}

	public static int[] findShortesPath(MyGraph graph, int startingVertex, int endingVertex) {
		LinkedList<Integer> path = new LinkedList<>();
		int[][] tab = null;
		if (graph instanceof ListGraph) {
			tab = findTableOfShortest((ListGraph) graph, startingVertex);
		} else if (graph instanceof MatrixGraph) {
			tab = findTableOfShortest((MatrixGraph) graph, startingVertex);
		}

		int vertex = endingVertex;

		while (vertex != -1) {
			path.addFirst(vertex);
			vertex = tab[1][vertex];
		}
		int[] tmp = new int[path.size()];
		int i = 0;
		for (int x : path) {
			tmp[i++] = x;
		}

		return tmp;
	}
}
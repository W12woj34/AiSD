package graphs;

import java.util.ArrayList;
import java.util.Collections;
import graphs.ListGraph.Element;

public class PrimsAlgorighms {

	public static ArrayList<Edge> findMinSpanningTree(ListGraph graph, int startVertex) {

		if (!graph.getAllVertices().contains(startVertex)) {
			System.out.println("Wierzcholek startowy nie nalezy do grafu");
			return new ArrayList<Edge>();
		}
		ArrayList<Edge> spanningEdges = new ArrayList<Edge>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		vertices.add(startVertex);
		int currentVertex = startVertex;
		Edge newEdge;
		Edge addedEdge;

		while (vertices.size() < graph.getAllVertices().size()) {
			for (Element e : graph.list.get(currentVertex)) {
				newEdge = new Edge(currentVertex, e.vertex, e.edge_value);
				if (spanningEdges.contains(newEdge) == false && edges.contains(newEdge) == false) {
					edges.add(newEdge);
				}
			}

			Collections.sort(edges);
			boolean added = false;
			while (added == false) {

				if (edges.size() > 0) {
					addedEdge = edges.remove(0);

					if (vertices.contains(addedEdge.getVertex2()) == false) {
						spanningEdges.add(addedEdge);
						currentVertex = addedEdge.getVertex2();
						vertices.add(addedEdge.getVertex2());
						added = true;
					}

				} else
					return new ArrayList<Edge>();
				;
			}

		}
		return spanningEdges;
	}

}

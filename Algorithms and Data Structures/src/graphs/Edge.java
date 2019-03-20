package graphs;

public class Edge implements Comparable<Edge> {

	private int vertex1;

	private int vertex2;
	private Integer value;

	public Edge(int vertex1, int vertex2, Integer value) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.value = value;
	}

	public int getVertex1() {
		return vertex1;
	}

	public int getVertex2() {
		return vertex2;
	}

	public Integer getValue() {
		return value;
	}

	@Override
	public int compareTo(Edge ob2) {
		return this.value.compareTo(ob2.value);

	}

	@Override
	public boolean equals(Object ob2) {
		Edge e2 = (Edge) ob2;
		if (this.value == e2.value) {
			if (this.vertex1 == e2.vertex1 && this.vertex2 == e2.vertex2) {
				return true;
			} else if (this.vertex1 == e2.vertex2 && this.vertex2 == e2.vertex1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Edge [vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", value=" + value + "]";
	}

}

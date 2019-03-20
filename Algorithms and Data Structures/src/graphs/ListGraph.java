package graphs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;


public class ListGraph implements MyGraph, Serializable {

	private static final long serialVersionUID = 923585812743467934L;
	ArrayList<LinkedList<Element>> list;

	class Element implements Serializable {
			private static final long serialVersionUID = 1L;
		int vertex;
		int edge_value;

		Element(int vertex) {
			this.vertex = vertex;
			this.edge_value = 1;
		}

		Element(int vertex, int val) {
			this.vertex = vertex;
			this.edge_value = val;
		}

		void setVal(int newVal) {
			this.edge_value = newVal;
		}
	}

	public ListGraph() {
		list = new ArrayList<LinkedList<Element>>();
	}

	public int size() {
		return list.size();
	}

	public ArrayList<Integer> getNeighbours(int vertax) {
		ArrayList<Integer> results = new ArrayList<>();

		LinkedList<Element> neighbours = list.get(vertax);

		for (Element el : neighbours) {
			results.add(el.vertex);
		}

		return results;
	}


	public boolean addVertex() {
		list.add(new LinkedList<Element>());

		return true;
	}


	public boolean deleteVertex(int nr) {
		if (nr >= list.size())
			return false;
		else {
			list.set(nr, null); 


			for (LinkedList<Element> l : list) {
				if (l != null) {
					for (Element el : l) {
						if (el.vertex == nr) {
							l.remove(el);
						}
					}
				}
			} 
			return true;
		}
	}
	public boolean addEdge(int a, int b) {
		if (a < list.size() && list.get(a) != null) {
			if (b < list.size() && list.get(b) != null) {
				list.get(a).add(new Element(b));
				if (a != b)
					list.get(b).add(new Element(a));
				return true;
			}
		}
		return false;
	}

	public boolean addEdge(int a, int b, int value) {
		if (a < list.size() && list.get(a) != null) {
			if (b < list.size() && list.get(b) != null) {
				list.get(a).add(new Element(b, value));
				if (a != b)
					list.get(b).add(new Element(a, value));
				return true;
			}
		}
		return false;
	}

	public boolean deleteEdge(int a, int b) {
		if (a < list.size()) {
			for (Element el : list.get(a)) {
				if (el.vertex == b) {
					list.get(a).remove(el);
					return true; 
				}
			}
		}
		return false; 
	}

	public boolean setEdgeValue(int a, int b, int newVal) {
		if (a < list.size() && b < list.size()) { 
			LinkedList<Element> listA = list.get(a);
			if (listA != null) {
				for (Element el : listA) { 
					if (el.vertex == b) {
						el.setVal(newVal); 
					}
				}
			}
			LinkedList<Element> listB = list.get(b);
			if (listB != null) {
				for (Element el : listB) { 
					if (el.vertex == a) {
						el.setVal(newVal);
						return true;
					}
				}
			}
		}
		return false; 
	}

	public String printAllEdges() {
		String s = "Lista kraw�dzi:\n";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null)
				for (Element el : list.get(i)) {
					if (el.vertex <= i) {
						s += i + " - " + el.vertex + " (" + el.edge_value + ")\n";
					}
				}
		}
		return s;
	}

	public void printEdges() {

		System.out.println(this.printAllEdges());
	}

	public boolean containsVertex(int nr) {
		if (nr < list.size()) {
			if (list.get(nr) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean containsEdge(int v1, int v2) {
		if (v1 < list.size()) {
			if (v2 < list.size()) {
				for (Element el : list.get(v1)) {
					if (el.vertex == v2) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public Integer edgeValue(int v1, int v2) {
		if (v1 < list.size()) {
			if (v2 < list.size()) {
				for (Element el : list.get(v1)) {
					if (el.vertex == v2) {
						return el.edge_value;
					}
				}
			}
		}
		return null;
	}

	public ArrayList<Integer> getAllVertices() {
		ArrayList<Integer> vertices = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				vertices.add(i);
			}
		}
		return vertices;
	}


}
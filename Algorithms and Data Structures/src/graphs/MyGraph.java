package graphs;

public interface MyGraph {

	public boolean addVertex(); 
	public boolean deleteVertex(int key);

	public boolean addEdge(int V1, int V2);

	public boolean addEdge(int V1, int V2, int value); 

	public boolean deleteEdge(int V1, int V2);

	public boolean setEdgeValue(int V1, int V2, int value);

	public void printEdges();

}

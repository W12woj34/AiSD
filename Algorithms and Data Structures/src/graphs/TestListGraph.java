package graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import graphs.ListGraph;

class ListGraphTest {
	
	ListGraph g1;
	ListGraph g2;
	
	@BeforeEach
	void setUp() {
		g1=new ListGraph();
		g1.addVertex(); g1.addVertex();
		g1.addEdge(0, 1);
		
		g2=new ListGraph();
		g2.addVertex();
		g2.addVertex();
		g2.addVertex();
		g2.addVertex();
		g2.addEdge(1, 2, 2);
		g2.addEdge(0, 3);
	}
	
	@Test
	void testContainsVertex() {
		assertEquals(true, g1.containsVertex(0));
		assertEquals(true, g1.containsVertex(1));
		assertEquals(false, g1.containsVertex(2));
		
		assertEquals(true, g2.containsVertex(0));
		assertEquals(true, g2.containsVertex(1));
		assertEquals(true, g2.containsVertex(2));
		assertEquals(true, g2.containsVertex(3));
		assertEquals(false, g1.containsVertex(4));		
	}

	@Test
	void testContainsEdge() {
		assertEquals(true, g1.containsEdge(0, 1));
		assertEquals(true, g1.containsEdge(1, 0));
		assertEquals(false, g1.containsEdge(0, 2));
		assertEquals(false, g1.containsEdge(10, 1));
		
		assertEquals(true, g2.containsEdge(1, 2));
		assertEquals(true, g2.containsEdge(0, 3));
		assertEquals(false, g2.containsEdge(10, 2));
	}

	@Test
	void testEdgeValue() {
		assertEquals(Integer.valueOf(1), g1.edgeValue(0, 1));
		assertEquals(Integer.valueOf(1), g1.edgeValue(1, 0));
		assertEquals(null, g1.edgeValue(1, 2));
		
		assertEquals(Integer.valueOf(1), g2.edgeValue(0, 3));
		assertEquals(Integer.valueOf(2), g2.edgeValue(2, 1));
		assertEquals(null, g2.edgeValue(1, 1));
	}
	
	@Test
	void testDeleteVertex() {
		assertEquals(false, g1.deleteVertex(3));
		assertEquals(true, g1.deleteVertex(0));
		assertEquals(false, g1.containsVertex(0));
		
		assertEquals(true, g2.containsVertex(2));
		assertEquals(true, g2.deleteVertex(2));
		assertEquals(false, g2.containsVertex(2));
	}

	@Test
	void testAddEdgeIntInt() {
		assertEquals(false, g1.addEdge(1, 5));
		
		assertEquals(false, g1.containsEdge(0, 0));
		assertEquals(true, g1.addEdge(0, 0));
		assertEquals(true, g1.containsEdge(0, 0));
		
		assertEquals(false, g2.addEdge(1, 5));
		
		assertEquals(false, g2.containsEdge(0, 2));
		assertEquals(true, g2.addEdge(0, 2));
		assertEquals(true, g2.containsEdge(0, 2));
	}

	@Test
	void testAddEdgeIntIntInt() {
		assertEquals(false, g1.addEdge(1, 5, 2));
		
		assertEquals(null, g1.edgeValue(0, 0));
		assertEquals(true, g1.addEdge(0, 0, 5));
		assertEquals(Integer.valueOf(5), g1.edgeValue(0, 0));
		
		assertEquals(false, g2.addEdge(1, 5, 3));
		
		assertEquals(null, g2.edgeValue(0, 1));
		assertEquals(true, g2.addEdge(0, 1, 5));
		assertEquals(Integer.valueOf(5), g2.edgeValue(0, 1));
	}

	@Test
	void testDeleteEdge() {
		assertEquals(false, g1.deleteEdge(0, 3));
		assertEquals(true, g1.deleteEdge(0, 1));
		assertEquals(false, g1.containsEdge(0, 1));
		
		assertEquals(false, g2.deleteEdge(0, 10));
		assertEquals(true, g2.deleteEdge(2, 1));
		assertEquals(false, g2.containsEdge(2, 1));
	}

	@Test
	void testSetEdgeValue() {
		assertEquals(false, g1.setEdgeValue(0, 3, 2));
		assertEquals(true, g1.setEdgeValue(0, 1, 3));
		assertEquals(Integer.valueOf(3), g1.edgeValue(0, 1));
		
		assertEquals(false, g2.setEdgeValue(0, 10, 2));
		
		assertEquals(Integer.valueOf(2), g2.edgeValue(2, 1));
		assertEquals(true, g2.setEdgeValue(2, 1, 3));
		assertEquals(Integer.valueOf(3), g2.edgeValue(2, 1));
	}

	@Test
	void testPrintAllEdges() {
		String exp1= "Lista kraw�dzi:\n1 - 0 (1)\n";
		assertEquals(exp1, g1.printAllEdges());
		String exp2= "Lista kraw�dzi:\n2 - 1 (2)\n3 - 0 (1)\n";
		assertEquals(exp2, g2.printAllEdges());
	}


}

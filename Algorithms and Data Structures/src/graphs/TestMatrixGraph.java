package graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphs.MatrixGraph;

class MatrixGraphTest {

	@Test
	void testAddVertexInt() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex(1));
		assertTrue(test.addVertex(2));
		assertTrue(test.addVertex(3));
		assertTrue(test.addVertex(4));
		assertTrue(test.addVertex(5));
		assertFalse(test.addVertex(1));
		assertFalse(test.addVertex(5));
		assertTrue(test.deleteVertex(2));
		assertTrue(test.addVertex(2));

	}

	@Test
	void testAddVertex() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex());
		assertTrue(test.addVertex());
		assertTrue(test.addVertex());
		assertTrue(test.addVertex());
		assertTrue(test.addVertex());
		assertTrue(test.addVertex());
		assertTrue(test.addVertex());
		assertFalse(test.addVertex(1));
		assertFalse(test.addVertex(5));
		assertTrue(test.deleteVertex(2));
		assertTrue(test.addVertex());
		assertTrue(test.deleteVertex(2));

	}

	@Test
	void testDeleteVertex() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex(1));
		assertTrue(test.addVertex(2));
		assertTrue(test.addVertex(3));
		assertTrue(test.addVertex(4));
		assertTrue(test.addVertex(5));
		assertTrue(test.deleteVertex(2));
		assertTrue(test.deleteVertex(3));
		assertTrue(test.deleteVertex(4));
		assertFalse(test.deleteVertex(3));
		assertFalse(test.deleteVertex(6));
		assertTrue(test.addVertex(2));
		assertTrue(test.deleteVertex(2));

	}

	@Test
	void testAddEdgeIntInt() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex(1));
		assertTrue(test.addVertex(2));
		assertTrue(test.addVertex(3));
		assertTrue(test.addVertex(4));
		assertTrue(test.addVertex(5));

		assertTrue(test.addEdge(1, 2));
		assertFalse(test.addEdge(1, 2));
		assertTrue(test.addEdge(1, 3));
		assertTrue(test.addEdge(2, 4));
		assertTrue(test.addEdge(4, 5));
		assertTrue(test.addEdge(5, 5));
		assertTrue(test.getTab()[1][2] == 1);
		assertTrue(test.getTab()[1][3] == 1);
		assertTrue(test.getTab()[2][4] == 1);
		assertTrue(test.getTab()[4][5] == 1);
		assertTrue(test.getTab()[5][5] == 1);
		assertFalse(test.getTab()[1][4] == 1);
		assertFalse(test.addEdge(6, 7));

	}

	@Test
	void testAddEdgeIntIntInt() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex(1));
		assertTrue(test.addVertex(2));
		assertTrue(test.addVertex(3));
		assertTrue(test.addVertex(4));
		assertTrue(test.addVertex(5));

		assertTrue(test.addEdge(1, 2, 4));
		assertTrue(test.addEdge(1, 3, 5));
		assertTrue(test.addEdge(2, 4, 6));
		assertTrue(test.addEdge(4, 5, 7));
		assertFalse(test.addEdge(3, 5, -3));
		assertTrue(test.addEdge(5, 5, 8));
		assertFalse(test.addEdge(5, 5));
		assertFalse(test.addEdge(5, 5, 8));
		assertTrue(test.getTab()[1][2] == 4);
		assertTrue(test.getTab()[1][3] == 5);
		assertTrue(test.getTab()[2][4] == 6);
		assertTrue(test.getTab()[4][5] == 7);
		assertTrue(test.getTab()[5][5] == 8);
		assertFalse(test.getTab()[1][4] == 4);
		assertFalse(test.addEdge(6, 7, 9));

	}

	@Test
	void testDeleteEdge() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex(1));
		assertTrue(test.addVertex(2));
		assertTrue(test.addVertex(3));
		assertTrue(test.addVertex(4));
		assertTrue(test.addVertex(5));
		assertTrue(test.addEdge(1, 5));
		assertTrue(test.addEdge(1, 4));
		assertTrue(test.addEdge(2, 3));
		assertTrue(test.addEdge(3, 5));
		assertTrue(test.addEdge(5, 5));
		assertTrue(test.addEdge(1, 2, 4));
		assertTrue(test.addEdge(1, 3, 5));
		assertTrue(test.addEdge(2, 4, 6));
		assertTrue(test.addEdge(4, 5, 7));
		assertTrue(test.deleteEdge(1, 5));
		assertTrue(test.deleteEdge(1, 4));
		assertTrue(test.deleteEdge(1, 2));
		assertTrue(test.deleteEdge(2, 4));
		assertFalse(test.deleteEdge(2, 4));
		assertTrue(test.getTab()[1][5] == 0);
		assertTrue(test.getTab()[1][4] == 0);
		assertTrue(test.getTab()[1][2] == 0);
		assertTrue(test.getTab()[2][4] == 0);
		assertFalse(test.getTab()[5][5] == 9);
		assertFalse(test.getTab()[1][4] == 1);
		assertFalse(test.getTab()[1][2] == 4);
		assertFalse(test.getTab()[2][4] == 6);
		assertFalse(test.getTab()[1][5] == 1);
	}

	@Test
	void testSetEdgeValue() {

		MatrixGraph test = new MatrixGraph();

		assertTrue(test.addVertex(1));
		assertTrue(test.addVertex(2));
		assertTrue(test.addVertex(3));
		assertTrue(test.addVertex(4));
		assertTrue(test.addVertex(5));

		assertTrue(test.addEdge(1, 2, 4));
		assertTrue(test.addEdge(1, 3, 5));
		assertTrue(test.addEdge(2, 4, 6));
		assertTrue(test.addEdge(4, 5, 7));
		assertTrue(test.addEdge(5, 5, 8));
		assertFalse(test.addEdge(5, 5));
		assertFalse(test.addEdge(5, 5, 8));
		assertTrue(test.setEdgeValue(1, 2, 9));
		assertTrue(test.setEdgeValue(1, 3, 9));
		assertTrue(test.setEdgeValue(2, 4, 9));
		assertTrue(test.setEdgeValue(4, 5, 9));
		assertTrue(test.setEdgeValue(5, 5, 9));
		assertFalse(test.setEdgeValue(6, 7, 9));
		assertFalse(test.setEdgeValue(4, 5, -1));

		assertTrue(test.getTab()[1][2] == 9);
		assertTrue(test.getTab()[1][3] == 9);
		assertTrue(test.getTab()[2][4] == 9);
		assertTrue(test.getTab()[4][5] == 9);
		assertFalse(test.getTab()[5][5] == 8);
		assertTrue(test.getTab()[5][5] == 9);
		assertFalse(test.getTab()[1][4] == 4);
		assertFalse(test.getTab()[1][2] == 4);
		assertFalse(test.getTab()[1][3] == 5);
		assertFalse(test.getTab()[2][4] == 6);
		assertFalse(test.getTab()[4][5] == 7);

	}

}

package com.hcs.depthFirst;

public class DepthFirstSearchTest {

	public static void main(String[] args) {
		/*GraphGUI graph = new GraphGUI();
		GraphBuilder graphBuilder = graph.getGraphBuilder();*/
		GraphBuilder graphBuilder = new GraphBuilder();
		graphBuilder.DijkstraShortestPath("A", "F");
		graphBuilder.DepthFirstSearch("A", "F");
	}
	
}

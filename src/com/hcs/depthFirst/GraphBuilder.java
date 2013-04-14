package com.hcs.depthFirst;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GraphBuilder {
	
	private DirectedGraph<CustomVertex, CustomEdge> graph;
	private HashMap<String, CustomVertex> vertexHashMap;
	
	public GraphBuilder() {
		graph = new DirectedSparseGraph<CustomVertex, CustomEdge>();
		vertexHashMap = new HashMap<String, CustomVertex>();		
		buildGraph();		
	}	

	private void addVertices() {
		
		vertexHashMap.put("A", new CustomVertex("A"));
		vertexHashMap.put("B", new CustomVertex("B"));	
		vertexHashMap.put("C", new CustomVertex("C"));
		vertexHashMap.put("D", new CustomVertex("D"));
		vertexHashMap.put("E", new CustomVertex("E"));
		vertexHashMap.put("F", new CustomVertex("F"));
		vertexHashMap.put("G", new CustomVertex("G"));
		vertexHashMap.put("H", new CustomVertex("H"));
		vertexHashMap.put("I", new CustomVertex("I"));
		//vertexHashMap.put("J", new CustomVertex("J"));
		vertexHashMap.put("K", new CustomVertex("K"));
		vertexHashMap.put("L", new CustomVertex("L"));
		vertexHashMap.put("M", new CustomVertex("M"));
		vertexHashMap.put("N", new CustomVertex("N"));
		//vertexHashMap.put("O", new CustomVertex("O"));
		vertexHashMap.put("P", new CustomVertex("P"));
		vertexHashMap.put("Q", new CustomVertex("Q"));
		vertexHashMap.put("R", new CustomVertex("R"));
		vertexHashMap.put("S", new CustomVertex("S"));
		vertexHashMap.put("T", new CustomVertex("T"));
		vertexHashMap.put("U", new CustomVertex("U"));
		vertexHashMap.put("V", new CustomVertex("V"));
		vertexHashMap.put("W", new CustomVertex("W"));
		
		for (CustomVertex vertex : vertexHashMap.values()) {
			graph.addVertex(vertex);
		}	
		
	}
	
	private void addEdge(String vertexName1, String vertexName2, int distance) {
		graph.addEdge(new CustomEdge(vertexName1, vertexName2, distance), vertexHashMap.get(vertexName1), vertexHashMap.get(vertexName2));
	}
	
	private void addEdges() {
		//('A',['B':3]) 
		addEdge("A", "B", 3);

		//('B',['C':4,'T':11])
		addEdge("B", "C", 4);
		addEdge("B", "T", 11);

		//('C',['D':3,'E':3])
		addEdge("C", "D", 3);
		addEdge("C", "E", 13);

		//('D',['E':2])
		addEdge("D", "E", 2);

		//('E',['G':3])
		addEdge("E", "G", 3); 

		//('F',['W':8,'M':8])
		addEdge("F", "W", 8);
		addEdge("F", "M", 8);		

		//('G',['H':3,'K':3])
		addEdge("G", "H", 3);
		addEdge("G", "K", 3);

		//('H',['K':2])
		addEdge("H", "K", 2);

		//('I', ['A':3,'B':4,'N':12,'L':5]) 
		addEdge("I", "A", 3); 
		addEdge("I", "B", 4);
		addEdge("I", "N", 12);
		addEdge("I", "L", 5);		
		
		//('K',['F':8])
		addEdge("K", "F", 8);

		//('L',['M':27]) 
		addEdge("L", "M", 27); 		
	
		//('P',['N':3,'U':3])
		addEdge("P", "N", 3);
		addEdge("P", "U", 3);

		//('Q',['P':2])
		addEdge("Q", "P", 2);		
		
		//('R',['Q':2])
		addEdge("R", "Q", 2); 		
		
		//('S',['R':2])
		addEdge("S", "R", 2);

		//('T',['S':4,'V':7])
		addEdge("T", "S", 4);
		addEdge("T", "V", 7);
						
		//('U',['V':2])
		addEdge("U", "V", 2);

		//('W',['T':3])
		addEdge("W", "T", 3);
				
	}
	
	private void buildGraph() {
		addVertices();
		addEdges();
		System.out.println("Graph info:\n" + graph.toString());		
	}
	
	public DirectedGraph<CustomVertex, CustomEdge> getGraph() {
		return graph;
	}
	
	private CustomVertex getVertexByName(String vertexName) {
		if (vertexHashMap.containsKey(vertexName)) {
			return vertexHashMap.get(vertexName);
		}
		return null;
	}
	
	public double calculateDistance(ArrayList<CustomEdge> edgeList) {
		double distance = 0;
		for (CustomEdge edge : edgeList) {
			distance += edge.getDistance();
		}
		return distance;
	}	
	
	public double calculateDistance(List<CustomEdge> edgeList) {
		double distance = 0;
		for (CustomEdge edge : edgeList) {
			distance += edge.getDistance();
		}
		return distance;
	}		
	
	public void DijkstraShortestPath(String vertex1, String vertex2) {
		DijkstraShortestPath<CustomVertex, CustomEdge> alg = new DijkstraShortestPath(graph);
		List<CustomEdge> l = alg.getPath(getVertexByName(vertex1), getVertexByName(vertex2));		
		System.out.println("# [Dijkstra algorithm] The shortest unweighted path from " + getVertexByName(vertex1) + 
				" to " + getVertexByName(vertex2) + " is: \n" + l.toString());
		System.out.println("# [Dijkstra algorithm] Distance = "+calculateDistance(l));
	}
	
	public void DepthFirstSearch(String vertex1, String vertex2) {
		DepthFirstSearch DFS = new DepthFirstSearch(graph);
		ArrayList<CustomEdge> l = DFS.getPath(getVertexByName(vertex1), getVertexByName(vertex2));
		System.out.println("# [Depth-first search] The path from " + getVertexByName(vertex1) + 
				" to " + getVertexByName(vertex2) + " is: \n"+l.toString());
		System.out.println("# [Depth-first search] Distance = "+calculateDistance(l));		
	}	
	
}
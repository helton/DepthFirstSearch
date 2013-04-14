package com.hcs.depthFirst;

import java.util.ArrayList;
import java.util.Stack;
import edu.uci.ics.jung.graph.DirectedGraph;

public class DepthFirstSearch {

	private Stack<CustomVertex> stack;
	private ArrayList<CustomEdge> edgeList;
	private DirectedGraph<CustomVertex, CustomEdge> graph;
	private boolean printInfoDuringSearch = false;
	
	public DepthFirstSearch(DirectedGraph<CustomVertex, CustomEdge> graph) {
		this.graph    = graph;		
		this.stack    = new Stack<CustomVertex>();
		this.edgeList = new ArrayList<CustomEdge>();
	}
	
	private void doSearch(CustomVertex vertex, CustomVertex destVertex) {
		stack.clear();
		edgeList.clear();
		DFS(vertex, destVertex);
	}
	
	public ArrayList<CustomEdge> getPath(CustomVertex vertex, CustomVertex destVertex) {
		doSearch(vertex, destVertex);
		return edgeList;
	}
			
	private void DFS(CustomVertex vertex, CustomVertex destVertex) {
		if (printInfoDuringSearch) {
			System.out.println("Visiting "+vertex+" vertex...");
		}
		if (!vertex.equals(destVertex)) {
			stack.push(vertex);
			for (CustomVertex currentVertex : graph.getNeighbors(vertex)) {			
				if ((graph.findEdge(vertex, currentVertex) != null) && (!stack.contains(currentVertex))) {
					edgeList.add(graph.findEdge(vertex, currentVertex));
					DFS(currentVertex, destVertex);
				}
			}
			stack.pop();
		}
	}
	
	public void setPrintInfoDuringSearch(boolean printInfoDuringSearch) {
		this.printInfoDuringSearch = printInfoDuringSearch;
	}
	
}

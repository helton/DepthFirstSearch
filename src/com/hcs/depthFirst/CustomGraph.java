package com.hcs.depthFirst;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.DAGLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout2;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import java.util.HashMap;
import java.awt.Dimension;

import javax.swing.JFrame;

public class CustomGraph {
	
	DirectedGraph<CustomVertex, CustomEdge> g;
	HashMap<String, CustomVertex> vertexHashMap;

	public static void main(String[] args) {
			CustomGraph currentGraph = new CustomGraph(); //We create our graph in here
			currentGraph.constructGraph();
			
	        Layout<Integer, String> layout = new CircleLayout(currentGraph.g);
			//Layout<Integer, String> layout = new DAGLayout(currentGraph.g);
			//Layout<Integer, String> layout = new FRLayout(currentGraph.g);
			//Layout<Integer, String> layout = new FRLayout2(currentGraph.g);
			//Layout<Integer, String> layout = new ISOMLayout(currentGraph.g);
			//Layout<Integer, String> layout = new KKLayout(currentGraph.g);
			//Layout<Integer, String> layout = new StaticLayout(currentGraph.g);
			
			
	        layout.setSize(new Dimension(600, 600)); // sets the initial size of the layout space
	        // The BasicVisualizationServer<V,E> is parameterized by the vertex and edge types
	        BasicVisualizationServer<Integer,String> vv = new BasicVisualizationServer<Integer,String>(layout);
	        vv.setPreferredSize(new Dimension(700,700)); //Sets the viewing area size

	        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
	        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());	        
	        
	        JFrame frame = new JFrame("IA - Exercise - Depth-first search algorithm");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().add(vv); 
	        frame.pack();
	        frame.setVisible(true);       		
	        //new CustomGraph().constructGraph();
	}	
	
	public void constructGraph() {		
		g = new DirectedSparseMultigraph<CustomVertex, CustomEdge>();
		vertexHashMap = new HashMap<String, CustomVertex>();
		
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
			g.addVertex(vertex);
		}
		
		//('I',['A':3,'B':4,'N':12,'L':5]) 
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("I"), vertexHashMap.get("A"));		
		g.addEdge(new CustomEdge(4),  vertexHashMap.get("I"), vertexHashMap.get("B"));
		g.addEdge(new CustomEdge(12), vertexHashMap.get("I"), vertexHashMap.get("N"));
		g.addEdge(new CustomEdge(5),  vertexHashMap.get("I"), vertexHashMap.get("L"));
		
		//('A',['B':3]) 
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("A"), vertexHashMap.get("B"));
		
		//('B',['C':4,'T':11])
		g.addEdge(new CustomEdge(4),  vertexHashMap.get("B"), vertexHashMap.get("C"));
		g.addEdge(new CustomEdge(11), vertexHashMap.get("B"), vertexHashMap.get("T"));
		
		//('C',['D':3,'E':3])
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("C"), vertexHashMap.get("D"));
		g.addEdge(new CustomEdge(13), vertexHashMap.get("C"), vertexHashMap.get("E"));
		
		//('D',['E':2])
		g.addEdge(new CustomEdge(2),  vertexHashMap.get("D"), vertexHashMap.get("E"));
		
		//('E',['G':3])
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("E"), vertexHashMap.get("G"));		
		
		//('G',['H':3,'K':3])
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("G"), vertexHashMap.get("H"));
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("G"), vertexHashMap.get("K"));
		
		//('H',['K':2])
		g.addEdge(new CustomEdge(2),  vertexHashMap.get("H"), vertexHashMap.get("K"));
		
		//('K',['F':8])
		g.addEdge(new CustomEdge(8),  vertexHashMap.get("K"), vertexHashMap.get("F"));
		
		//('F',['W':8,'M':8])
		g.addEdge(new CustomEdge(8),  vertexHashMap.get("F"), vertexHashMap.get("W"));
		g.addEdge(new CustomEdge(8),  vertexHashMap.get("F"), vertexHashMap.get("M"));
		
		//('W',['T':3])
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("W"), vertexHashMap.get("T"));
		
		//('T',['S':4,'V':7])
		g.addEdge(new CustomEdge(4),  vertexHashMap.get("T"), vertexHashMap.get("S"));
		g.addEdge(new CustomEdge(7),  vertexHashMap.get("T"), vertexHashMap.get("V"));
		
		//('S',['R':2])
		g.addEdge(new CustomEdge(2),  vertexHashMap.get("S"), vertexHashMap.get("R"));
		
		//('R',['Q':2])
		g.addEdge(new CustomEdge(2),  vertexHashMap.get("R"), vertexHashMap.get("Q"));		
		
		//('Q',['P':2])
		g.addEdge(new CustomEdge(2),  vertexHashMap.get("Q"), vertexHashMap.get("P"));
		
		//('P',['N':3,'U':3])
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("P"), vertexHashMap.get("N"));
		g.addEdge(new CustomEdge(3),  vertexHashMap.get("P"), vertexHashMap.get("U"));
		
		//('U',['V':2])
		g.addEdge(new CustomEdge(2),  vertexHashMap.get("U"), vertexHashMap.get("V"));
		
		//('L',['M':27])		
		g.addEdge(new CustomEdge(27), vertexHashMap.get("L"), vertexHashMap.get("M"));
		
		System.out.println("Graph info:\n" + g.toString());
	}
	
}

class CustomVertex {
	
    private String vertexName;
    
    public CustomVertex(String vertexName) {
        this.vertexName = vertexName;
    }
    
    public String toString() {
        return vertexName;
    }
    
}

class CustomEdge {
	
    private int distance;
    private int id;
    private static int edgeCount = 0;
    
    public CustomEdge(int distance) {
    	this.id = ++edgeCount;
    	this.distance = distance;
    } 
    
    public int getDistance() {
    	return this.distance;
    }
    
    @Override
    public String toString() {
    	return new Integer(distance).toString();
    }
    
}
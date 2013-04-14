package com.hcs.depthFirst;

import java.awt.Dimension;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class GraphGUI extends JFrame {
	
	private GraphBuilder graph;
	private BasicVisualizationServer<Integer,String> vv;
	private Layout<Integer, String> layout;
	
	public GraphBuilder getGraphBuilder() {
		return graph;
	}	
	
	private void buildGraphGUI() {
		graph = new GraphBuilder();			
		layout = new CircleLayout(graph.getGraph());
		vv = new BasicVisualizationServer<Integer,String>(layout);
		vv.setPreferredSize(new Dimension(700,700));
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());		
	}
	
	public GraphGUI() {		
		buildGraphGUI();       	        
		setName("IA - Exercise - Depth-first search algorithm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(vv); 
		pack();
		setVisible(true);   		
	}
	
}

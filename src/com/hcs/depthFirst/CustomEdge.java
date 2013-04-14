package com.hcs.depthFirst;

public class CustomEdge {

	private String leftVertex;
	private String rightVertex;
    private int distance;
    private int id;
    private static int edgeCount = 0;
    
    public CustomEdge(String leftVertex, String rightVertex, int distance) {
    	this.leftVertex = leftVertex;
    	this.rightVertex = rightVertex;
    	this.id = ++edgeCount;
    	this.distance = distance;
    } 
    
    public int getDistance() {
    	return this.distance;
    }
    
    @Override
    public String toString() {
    	return leftVertex+"-"+rightVertex+"("+new Integer(distance).toString()+")";
    }    	
	
}

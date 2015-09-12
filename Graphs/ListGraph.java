package Graphs;

public class ListGraph implements Graph {
	
	/**
	 * An edge node to use as an item in the list
	 *
	 * Doubly linked node
	 */
	private class Edge {
		public int vertex, weight;
		public Edge prev, next;

		public Edge(int v, int w, Edge p, Edge n) {
			vertex = v;
			weight = w;
			next = n;
			prev = p;
		}
	}

	private Edge[] nodes;
	private Object[] values;
	private int numEdge;

	public ListGraph() {
		//nothing
	}

	//initialize with n vertices
	public void init (int n);

	//return the number of vertices
	public int nodeCount();

	//return the number of edges
	public int edgeCount();

	//Get the value of a node with index v
	public Object getValue(int v);

	//set the value of a node with index v
	public void setValue(int v, Object val);

	//Add a new edge from node v to node w with weight wgt
	public void addEdge(int v, int w, int wgt);

	//get the weight of an edge
	public int weight(int v, int w);

	//remove an edge
	public void removeEdge(int v, int w);

	//return true iff the graph has the edge
	public boolean hasEdge(int v, int w);

	//return an array with indices of the neighbors of v
	public int[] neighbors(int v);

}
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
	public void init (int n) {
		nodes = new Edge[n];
		values = new Object[n];
		numEdge = 0;

		for (int i = 0; i < n; i++) {
			nodes[i] = new Edge(-1, -1, null, null);
		}
	}

	//return the number of vertices
	public int nodeCount() {
		return nodes.length;
	}

	//return the number of edges
	public int edgeCount() {
		return numEdge;
	}

	//Get the value of a node with index v
	public Object getValue(int v) {
		return values[v];
	}

	//set the value of a node with index v
	public void setValue(int v, Object val) {
		values[v] = val;
	}

	//find the Edge in v's list that precedes w
	private Edge find(int v, int w) {
		Edge curr = nodes[v];
		while (curr.next != null && curr.next.vertex < w) {
			curr = curr.next;
		}
		return curr;
	}

	//Add a new edge from node v to node w with weight wgt
	public void addEdge(int v, int w, int wgt) {
		if (wgt == 0) return;

		Edge curr = find(v, w);
		if (curr.next != null && curr.next.vertex == w) {
			curr.next.weight = wgt;
		}
		else {
			curr.next = new Edge(w, wgt, curr, curr.next);
			if (curr.next.next != null) {
				curr.next.next.prev = curr.next;
			}
			numEdge++;
		}
	}

	//get the weight of an edge
	public int weight(int v, int w) {
		Edge curr = find(v, w);
		if (curr.next == null || curr.next.vertex != w) {
			return 0;
		}

		return curr.next.weight;
	}

	//remove an edge
	public void removeEdge(int v, int w) {
		Edge curr = find(v, w);
		if (curr.next == null || curr.next.vertex != w) {
			return;
		}

		curr.next = curr.next.next;
		if (curr.next != null) {
			curr.next.prev = curr;
		}
		numEdge--;
	}

	//return true iff the graph has the edge
	public boolean hasEdge(int v, int w) {
		return weight(v, w) != 0;
	}

	//return an array with indices of the neighbors of v
	public int[] neighbors(int v) {
		int count = 0;
		for (Edge curr = nodes[v].next; curr != null; curr = curr.next) {
			count++;
		}

		int[] temp = new int[count];
		count = 0;
		for (Edge curr = nodes[v].next; curr != null; curr = curr.next) {
			temp[count++] = curr.vertex;
		}

		return temp;
	}

}
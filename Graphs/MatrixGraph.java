package Graphs;

public class MatrixGraph implements Graph {
	private int[][] matrix;
	private Object[] values;
	private int numEdge;

	public MatrixGraph() {
		//nothing
	}

	//initialize with n vertices
	public void init (int n) {
		matrix = new int[n][n];
		values = new Object[n];
		numEdge = 0;
	}

	//return the number of vertices
	public int nodeCount() {
		return values.length;
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

	//Add a new edge from node v to node w with weight wgt
	public void addEdge(int v, int w, int wgt) {
		if (wgt == 0) return;

		if (!hasEdge(v, w)) {
			numEdge++;
		}

		matrix[v][w] = wgt;
	}

	//get the weight of an edge
	public int weight(int v, int w) {
		return matrix[v][w];
	}

	//remove an edge
	public void removeEdge(int v, int w) {
		if (hasEdge(v, w)) {
			matrix[v][w] = 0;
			numEdge--;
		}
	}

	//return true iff the graph has the edge
	public boolean hasEdge(int v, int w) {
		return matrix[v][w] != 0;
	}

	//return an array with indices of the neighbors of v
	public int[] neighbors(int v) {
		int count = 0;
		int[] temp;

		//count how many neightbors there are
		for (int i = 0; i < values.length; i++) {
			if (matrix[v][i] != 0) {
				count++;
			}
		}

		//fill the int[] to return with indices
		temp = new int[count];
		count = 0;
		for (int i = 0; i < values.length; i++) {
			if (matrix[v][i] != 0) {
				temp[count++] = i;
			}
		}

		return temp;
	}
}
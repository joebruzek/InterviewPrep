package Graphs;

import java.util.ArrayList;

public class Traversals {

	private enum Traversal {
		DEPTH, BREADTH
	}

	
	public static void main(String[] args) {
		//TODO: tese these algorithms somehow?
		//maybe print stuff on postVisit

		//TODO: make something to build a graph
	}

	//traverse the graph, either depth-first search or breadth first search
	public void traverse(Graph g, Traversal t) {
		for (int i = 0; i < g.nodeCount(); i++) {
			g.setValue(i, null);
		}

		for (int i = 0; i < g.nodeCount(); i++) {
			if (!g.getValue(i).equals("VISITED")) {
				switch (t) {
					case DEPTH:
						DFS(g, i);
						break;
					case BREADTH:
						BFS(g, i);
						break;
					default:
				}
			}
		}
	}

	private void preVisit(Graph g, int v) {
		//do something before you process a vertex
	}

	private void postVisit(Graph g, int v) {
		//do something after you visit a vertex
	}

	//Depth First Search algorithm.
	//Total time cost Theta(|V| + |E|)
	private void DFS(Graph g, int v) {
		preVisit(g, v);

		g.setValue(v, "VISITED");
		int[] list = g.neighbors(v);
		for (int i = 0; i < list.length; i++) {
			if (!g.getValue(list[i]).equals("VISITED")) {
				DFS(g, list[i]);
			}
		}

		postVisit(g, v);
	}

	private void BFS(Graph g, int v) {
		Queue q = new Queue();
		q.enqueue(v);
		g.setValue(v, "VISITED");

		while(q.length() > 0) {
			v = (Integer)q.dequeue();

			preVisit(g, v);

			int[] list = g.neighbors(v);
			for (int i = 0; i < list.length; i++) {
				if (!g.getValue(list[i]).equals("VISITED")) {
					g.setValue(list[i], "VISITED");
					q.enqueue(list[i]);
				}
			}

			postVisit(g, v);
		}
	}

	//Private Queue class used for the BFS algorithm
	private class Queue {
		ArrayList<Object> list;

		public Queue() {
			list = new ArrayList<Object>();
		}

		public void enqueue(Object val) {
			list.add(val);
		} 

		public Object dequeue() {
			return list.remove(0);
		}

		public int length() {
			return list.size();
		}
	}

}
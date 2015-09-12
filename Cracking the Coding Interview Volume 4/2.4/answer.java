public class answer {
	public static void main(String [] args)
	{
		Node a = new Node(3);
		Node b = new Node(1);
		Node c = new Node(5);
		a.next = b;
		b.next = c;

		Node d = new Node(5);
		Node e = new Node(9);
		Node f = new Node(2);
		d.next = e;
		e.next = f;

		// (3)->(1)->(5) + (5)->(9)->(2)
		// = (8)->(0)->(8)

		Node one = a;
		Node two = d;
		int carry = 0;
		LinkedList result = new LinkedList();

		while(one != null || two != null) {
			int comb;
			if (one == null) {
				comb = two.val + carry;
				two = two.next;
			}
			else if (two == null) {
				comb = one.val + carry;
				one = one.next;
			}
			else {
				comb = one.val + two.val + carry;
				one = one.next;
				two = two.next;
			}

			result.add(new Node(comb % 10));
			carry = comb / 10;
		}
		if (carry != 0) {
			result.add(new Node(carry));
		}

		result.print();
	}

	//hella simple node
	private static class Node {
		public int val;
		public Node next;

		public Node(int data) {
			val = data;
			next = null;
		}

		public Node() {
			next = null;
		}
	}

	public static class LinkedList {
		Node head;
		Node current;
		int size;

		public LinkedList() {
			head = new Node();
			current = head;
			size = 0;
		}

		public void add(Node n) {
			current.next = n;
			current = n;
			size++;
		}

		public void print() {
			Node temp = head;
			StringBuilder sb = new StringBuilder();
			while(temp.next != null) {
				sb.append("(");
				sb.append(temp.next.val);
				sb.append(")->");
				temp = temp.next;
			}
			if (size != 0) {
				sb.deleteCharAt(sb.length() - 1);
				sb.deleteCharAt(sb.length() - 1);
			}

			System.out.println(sb.toString());
		}
	}
}
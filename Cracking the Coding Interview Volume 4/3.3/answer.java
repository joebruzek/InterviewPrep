import java.util.Stack;

public class answer {

	private static Stack[] stacks;
	private static int stackIndex = 0;
	private static final int MAX_STACK_SIZE = 3;

	public static void main(String[] args) {
		stacks = new Stack[2];
		stacks[0] = new Stack<Integer>();

		for (int i = 0; i < 10; i++) {
			push(i);
		}

		printStacks();
	}

	public static void push(int val) {
		if (stacks[stackIndex].size() == MAX_STACK_SIZE) {
			reStack();
		}

		stacks[stackIndex].push(val);
	}

	public static int pop() {
		if (stacks[stackIndex].size() == 0 && stackIndex != 0) {
			stackIndex--;
		}

		return (Integer)stacks[stackIndex].pop();
	}

	private static void reStack() {
		if (stackIndex == stacks.length - 1) {
			Stack[] temp = new Stack[stacks.length + 1];

			for (int i = 0; i < stacks.length; i++) {
				temp[i] = stacks[i];
			}
			stacks = temp;
		}

		if (stacks[stackIndex + 1] == null) {
			stacks[stackIndex + 1] = new Stack<Integer>();
		}

		stackIndex++;
	}

	/*******************
		Test Methods
	********************/

	private static void printStacks() {
		System.out.println("*****************************\nPrinting Stack Information\n*****************************");
		System.out.println("Number of stacks: " + (stacks.length));
		for (int i = 0; i < stacks.length; i++) {
			System.out.println("----------\n\tStack " + i);
			if (stacks[i] == null)
				System.out.println("null");
			else 
				System.out.println("\tSize: " + stacks[i].size());
			System.out.println("----------");
		}
	}
}
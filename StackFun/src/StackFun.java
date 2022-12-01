import java.util.Scanner;

public class StackFun {
	static Stack<Integer> stack = new Stack<Integer>(100);

	public static void main(String[] args) throws Exception {
		int base =2;
		System.out.print("Enter a number: ");
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.print("Enter the base to convert to: ");
		base = kb.nextInt();
		do {
			int r = n%base;
			n = n/base;
			stack.push(r);
		} while(n!=0);
		int sign = (int)stack.peek();
		if (sign<0) 
		{ 
			sign = -1;
			System.out.print("-");
		}
		else sign = +1;
		while (!stack.empty()) {
			int r = sign*(int)stack.pop();
			System.out.print(r);
		}
		System.out.println();
		/*	stack.push(3.14);
		stack.push(2.718);
		stack.push(6.022E23);

		System.out.println("Current size: "+stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		 */
	}

}

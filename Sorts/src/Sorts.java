
public class Sorts {
	public static int[] list1,list2,list3;

	public static void main(String[] args) throws Exception {
		long startTime,runTime;
		Tree bst = new Tree();
		AVLtree avlTree = new AVLtree();
		list1 = randomList(1000);
		list2 = copyList(list1);
		list3 = copyList(list1);

		System.out.println("Radix Sort");
		startTime = System.currentTimeMillis();
		RadixSort radix = new RadixSort();
		radix.sort(list1);
		
		for (int n:list1)
			System.out.println(n);
		
		for (int i=0; i<list1.length; i++)
			System.out.println(list1[i]);
		
		
		if (inOrder(list1))
			System.out.println("List is in order");
		else
			System.out.println("List is out of order");
		
		runTime = System.currentTimeMillis()-startTime;
		System.out.println("Radix Sort "+runTime);
		System.out.println("\n\n");
		
		//Binary Search Tree Sort - no rotations or reballanceing
		startTime = System.currentTimeMillis();
		for (int i=0; i<list2.length; i++)
			bst.add(list2[i]);
		list2=bst.toArray();
		System.out.println("Height of tree: "+bst.height());
		if (inOrder(list2))
			System.out.println("List is in order");
		else
			System.out.println("List is out of order");
		
		runTime = System.currentTimeMillis()-startTime;
		System.out.println("\n\nBinary Search Tree "+runTime);
		//bst.print();
		
		//AVL Tree Sort
		startTime = System.currentTimeMillis();		
		for (int i=0; i<list2.length; i++)
			avl.add(list2[i]);
		list2=avlTree.toArray();
		System.out.println("Height of tree: "+best.height());
		if (inOrder(list2))
			System.out.println("List is in order");
		else
			System.out.println("List is out of order");
		
		runTime = System.currentTimeMillis()-startTime;
		System.out.println("\n\nAVL Binary Search Tree "+runTime);
		//best.print();
	
	/*	
		selectionSort(list1);
		
		//printList(list1,0,15);
		if (inOrder(list1))
			System.out.println("List is in order");
		else
			System.out.println("List is out of order");
		
		bubbleSort(list2);
		
		//printList(list2,0,15);
		if (inOrder(list2))
			System.out.println("List is in order");
		else
			System.out.println("List is out of order");
	
		pingPongSort(list3);
		
		//printList(list2,0,15);
		if (inOrder(list3))
			System.out.println("List is in order");
		else
			System.out.println("List is out of order");
*/
	}

	public static void selectionSort(int[] list) {
		int i,j,s,t;
		int passes= 0;
		int iftests = 0;
		for (i=0; i<list.length-1; i++) {
			
			// Search for smallest value
			s=i;		// assume i is where the smallest value is
			for (j=i+1; j<list.length; j++) {
				if (list[j]<list[s]) s = j;
				iftests++;
			}
			// Move smallest value to position i
			t = list[i];
			list[i] = list[s];
			list[s] = t;
			passes++;
		}
		System.out.println("Passes = "+passes+ "   if tests= "+iftests);
	}
	
	public static void bubbleSort(int[] unsorted) {
		int i, j, pass = 0;
		int temp;
		boolean inOrder = false;
		while(!inOrder) {
			inOrder = true;
			pass++; 
			for (i = 0; i < unsorted.length - pass; i++)
				if (unsorted[i] > unsorted[i + 1]) {   //If the current number is greater than swap those two
					temp = unsorted[i];
					unsorted[i] = unsorted[i + 1];
					unsorted[i + 1] = temp;
					inOrder = false;
				}
		}
		System.out.println("Bubble sort took "+ pass +" passes"); // Print number of passes
	}
	
	public static void pingPongSort(int[] unsorted) {
		int i, j, pass = 0;
		int temp;
		boolean inOrder = false;
		while(!inOrder) {
			inOrder = true;
			pass++; 
			for (i = pass-1; i < unsorted.length - pass; i++)
				if (unsorted[i] > unsorted[i + 1]) {   //If the current number is greater than swap those two
					temp = unsorted[i];
					unsorted[i] = unsorted[i + 1];
					unsorted[i + 1] = temp;
					inOrder = false;
				}
			
			for (i = unsorted.length-pass; i>=pass; i--)
				if (unsorted[i] < unsorted[i - 1]) {   //If the current number is greater than swap those two
					temp = unsorted[i];
					unsorted[i] = unsorted[i - 1];
					unsorted[i - 1] = temp;
					inOrder = false;
				}
	
		}
		System.out.println("Ping pong sort took "+ pass +" passes"); // Print number of passes
	}
	
	
	public static void bogoSort(int[] list) {
		int i, r, temp;
		int passes=0;

		while (!inOrder(list)) {
			// Randomize the list
			for (i=0; i<list.length; i++) {
				r = (int)(Math.random()*list.length);
				temp = list[i];
				list[i] = list[r];
				list[r] = temp;
			}
			passes++;
		}
		System.out.println("Bogo sort took "+passes+" passes");
	}

	public static boolean inOrder(int[] list) {
		int i;
		for (i=0; i<list.length-1; i++)
			if (list[i]>list[i+1]) return false;
		return true;
	}

	public static int[] randomList(int size) {
		int[] array = new int[size];
		int i;
		for (i=0; i<array.length; i++) {
			array[i] = (int)(Math.random() *size);
		}
		return array;
	}

	public static int[] copyList(int[] list) {
		int[] array = new int[list.length];
		int i;
		for (i=0; i<list.length; i++)
			array[i] = list[i];
		return array;
	}
	
	public static void printList(int[] list, int start, int end) {
		int i;
		if (start>end) {
			i = end;
			end = start;
			start = i;
		}
		if (start<0) start = 0;
		if (end>=list.length) end = list.length-1;
		for (i=start; i<=end; i++) {
			System.out.println(""+i+": "+list[i]);
		}
		System.out.println();
	}
}

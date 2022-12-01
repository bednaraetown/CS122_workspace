
public class ListFun {
	public static DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
	public static DoublyLinkedList<String> list2= new DoublyLinkedList<String>();

	public static void main(String[] args) throws Exception {
		int i;
		/*		list.insertRear(67);
		System.out.println(list.removeRear());
		list.insertFront(42);
		list.insertFront(35);
		 */
		String s,p=null;

		for (i=1; i<=10; i++) {
			s="Val="+i;
			if (i==3) p=s;
			list.insertRear(i);
		}

		while (!list.empty()) {
			i=list.removeRear();
			System.out.println("You removed: "+i);
		}
		i=list.removeRear();
		System.out.println("Removing from an empty list: "+i);

		for (i=100; i<=105; i++)
			list2.insertRear("Num="+i);
		//		list.reverse2();
		System.out.println(list);
		System.out.println("Appending the two lists");
		//		list.append(list2);
		System.out.println(list);

	}

}

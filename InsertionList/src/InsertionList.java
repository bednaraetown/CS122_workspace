import java.util.Scanner;

public class InsertionList {
	public static DoublyLinkedList<String> list= new DoublyLinkedList<String>();
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String text;
		while (true) {
			System.out.print("Enter a name: ");
			text = kb.nextLine();
			if (text.equals("exit")) break;
			list.insertInOrder(text);
		}
		System.out.println("\nList Contents");
		System.out.println(list);
	}

}

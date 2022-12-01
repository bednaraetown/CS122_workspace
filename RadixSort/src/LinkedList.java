
public class LinkedList {
	Node head=null;
	Node tail=null;

	public void insertRear(int n) {
		Node p = new Node(n);
		insertLast(p);
	}
	
	public Node removeFirst() {
		Node t;
		if (head==null)return null;
		t=head;
		head=head.next;
		if(head==null)tail=null;
		return t;
		
	}
	
	public void insertLast(Node p) {
		if( head==null)
			head = p;
		else
			tail.next = p;
		tail=p;
		p.next=null;
	}
	
	public boolean empty() {
		return head==null;
	}

	public void append(LinkedList list) {
		if(list.head==null)return;
		if(head==null)
			head = list.head;
		else 
			tail.next=list.head;
		tail = list.tail;
		list.head=list.tail=null;
	}

	public static class Node{
		int value;
		Node next=null;

		public Node(int n) {
			value=n;
		}
	}
}

public class DoublyLinkedList<Type> {
	Node head=null;

	public DoublyLinkedList() {
		head = new Node();
		head.next = head;	
		head.prev = head;	
	}						
	
	public void insertFront(Type info) {
		Node p = new Node();
		p.data = info;
		p.next = head.next;
		p.prev = head;
		head.next.prev = p;
		head.next = p;
	}
	
	public void insertRear(Type info) {
		Node p = new Node();
		p.data = info;
		p.next = head;
		p.prev = head.prev;
		head.prev.next = p;
		head.prev = p;
	}
	
	public void insertInOrder(Type info) {
		Node p = head.next;
		while (p!=head) {
			if (((String)info).compareTo((String)p.data) <0) break;
			p = p.next;
		}
		Node t = new Node();
		t.data = info;
		t.next = p;
		t.prev = p.prev;
		p.prev.next = t;
		p.prev = t;
	}
	
	public Type removeFront() {
		if (head.next == head) return null;
		Node p = head.next;
		p.next.prev = p.prev;
		p.prev.next = p.next;
		p.next = p.prev = null;
		return p.data;
	}
	
	public Type removeRear() {
		if (head.next==head) return null;
		Node p = head.prev;
		p.next.prev = p.prev;
		p.prev.next = p.next;
		p.next = p.prev = null;
		return p.data;
	}
	
	public boolean empty() {
		return head.next==head;
	}
	
	public String toString() {
		Node t;
		String output="String:\n";
		t = head.next;
		while (t!=head) {
			output += ""+t.data+"\n";
			t = t.next;
		}
		return output;
	}

	
	private class Node{
		Type data;
		Node prev,next;
	}
}

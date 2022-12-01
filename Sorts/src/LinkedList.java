import java.util.Iterator;

public class LinkedList implements Iterable{
	private Node head = null;
	private Node tail = null;
	private int length = 0;

	public void insertFront(int info) {
		Node t = new Node();
		t.data = info;

		t.next = head;
		if (head==null)
			tail = t;
		head = t;
		length++;
	}

	public void insertRear(Node t) {
		if (head==null)
			head = t;
		else
			tail.next = t;
		t.next = null;
		tail = t;
		length++;
	}

	public void insertRear(int info) {
		Node t = new Node();
		t.data = info;
		if (head==null)
			head = t;
		else
			tail.next = t;
		t.next = null;
		tail = t;
		length++;
	}

	public int removeFront() throws Exception {
		Node t;
		if (head==null) throw(new Exception("List is empty"));
		t = head;
		head = head.next;
		if (head==null) tail = null;
		length--;
		return t.data;
	}
	public Node removeNodeFront() throws Exception {
		Node t;
		if (head==null) throw(new Exception("List is empty"));
		t = head;
		head = head.next;
		if (head==null) tail = null;
		length--;
		return t;
	}

	public int removeRear() throws Exception {
		int value;
		Node t;
		if (head==null) throw(new Exception("List is empty"));
		value = tail.data;
		t = head;
		if (t.next==null) {		// Check for special case of only one node
			head = tail = null;	//     make this an empty list
		}
		else {
			while (t.next!=tail) // General case of 2 or more nodes on the list
				t = t.next;
			tail = t;
		}
		t.next = null;
		length--;
		return value;
	}

	public void removeValue(int n) {
		Node t = head;
		if (head==null) return;
		if (head.data == n) {
			head = head.next;
			if (head==null) tail = null;
			return;
		}
		while (t.next!=null && t.next.data!=n)
			t = t.next;
		if (t.next==null) return;
		if (t.next.data==n)
			t.next = t.next.next;
		if (t.next==null) tail = t;

	}

	public boolean empty() {
		return head==null;
	}

	public int getLength() {
		return length;
	}

	public int size() {
		int count=0;
		for (Node t=head; t!=null; t = t.next)
			count++;
		return count;
	}

	public void reverse() throws Exception {
		LinkedList temp = new LinkedList();
		while (!this.empty()) {
			temp.insertFront(this.removeFront());
		}
		head = temp.head;
		tail = temp.tail;
		temp.head = null;
		temp.tail = null;
	}

	public void reverse2() {
		if (head==tail) return;
		Node pv = head;
		Node cr = pv.next;
		Node nx = cr.next;
		while (cr!=null) {
			cr.next = pv;
			pv = cr;
			cr = nx;
			if (nx!=null)
				nx = nx.next;
		}
		tail = head;
		head = pv;
		tail.next = null;	
	}

	public void append(LinkedList list2) {
		if (list2.empty()) return;  // Nothing to do if list 2 is empty
		if (this.empty()) {		// if list1 is empty it becomes list2
			this.head = list2.head;
			this.tail = list2.tail;
		} else {				// Append list 2 to end of list 1
			tail.next = list2.head;
			tail = list2.tail;
		}
		list2.head = list2.tail = null;

		/*		Quick but inefficient method using a loop
 		while (!list2.empty())
			this.insertRear(list2.removeFront());
		 */
	}

	public String toString() {
		Node t;
		String output="String:\n";
		t = head;
		while (t!=null) {
			output += ""+t.data+"\n";
			t = t.next;
		}
		return output;
	}

	public class Node {
		int data;
		Node next;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}

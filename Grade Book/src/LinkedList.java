
public class LinkedList {
	private Student head=null, tail=null;
	private Student current=null;
	private int size=0;
	
	public int getSize() {
		return size;
	}
	public void insertRear(Student p) {
		if (head==null)
			head = p;
		else
			tail.next = p;
		tail = p;
		p.next = null;
		size++;
	}
	
	public void insertFront(Student p) {
		if (head==null)
			tail = p;
		p.next = head;
		head = p;
		size++;
	}
	
	public Student removeFront() {
		Student t;
		t = head;
		if (head==null) return t;
		head = head.next;
		if (head==null)
			tail = null;
		else 
			t.next = null;
		size--;
		return t;
	}
	
	public Student removeLast() {
		Student t=head;
		if (head==null) return null;  	// Special case of an empty list
		if (t.next==null) {				// Special case of only one node on list
			head = tail = null;
			size--;
			return t;
		}
		while (t.next!=tail)			// General case with 2 or more nodes
			t = t.next;
		tail = t;
		t = t.next;
		tail.next = null;
		size--;
		return t;
	}
	
	public Student first() {
		current = head;
		return current;
	}
	
	public Student advance() {
		if (current!=null)
			current = current.next;
		return current;
	}
	
	public boolean isInList(Student p) {
		Student t = head;
		while (t!=null) {
			if (t==p) return true;
			t = t.next;
		}
		return false;
	}
	
	public void setCurrent(Student p) {
		if (isInList(p))
			current = p;
	}
	public void saveCurrent() {
		current.save();
	}
	public Student deleteCurrent() {
		Student t = current;
		Student p = head;
		if(current==null) return null;
		if(current==p) {
			head = current.next;
		} else {
			while(p.next!=current)
				p=p.next;
			p.next = current.next;
		}
		if(p.next == null)
			tail = p;
		current = p;
		t.setEnabled(false);
		return current;
	}
}

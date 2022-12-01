
public class HashTable {
	Node[] table;
	int size=0;
	int collisions=0;
	int utilization=0;
	
	public HashTable(int tablesize) {
		table = new Node[tablesize];
		for (int i=0; i<table.length; i++)
			table[i]=null;
	}
	
	public void put(int key) {
		int idx;
		Node entry = new Node(key);
		size++;
		idx = hashKey(key);
		if (table[idx]!=null) 
			collisions++;
		else
			utilization++;
		entry.next = table[idx];
		table[idx] = entry;
	}
	
	public double utilization() {
		return ((((double)utilization)/table.length)*100);
	}
	
	public String collisionRate() {
		return (""+((collisions*100)/size)+"%");
	}	
	
	public boolean containsKey(int key) {
		Node t = table[hashKey(key)];
		while (t!=null)
			if (t.key == key)
				return true;
			else
				t = t.next;
		return false;
	}
	
	public Node findKey(int key) {
		Node t = table[hashKey(key)];
		while (t!=null)
			if (t.key == key)
				return t;
			else
				t = t.next;
		return null;

	}
	public int hashKey(int key) {
		return key%table.length;
	}
	
	public static class Node {
		int key;
		int value;
		Node next=null;
		
		public Node(int key) {
			this.key = key;
		}
	}
}

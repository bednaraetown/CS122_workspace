
public class Tree {
	private Node root=null;
	private int size=0;
	private int[] list;
	private int idx;
	
	public void add(int key) {
		Node t = new Node(key);
		root = insert(t,root);
		size++;
	}
	
	public void addItteratively(int key) {
		Node t = new Node(key);
		insert(t);
		size++;
	}
	
	private Node insert(Node t,Node root) { //Recursive Insert Method
		if (root==null) {
			root = t;
			return root;
		}
		if (t.key<root.key) 
			root.left = insert(t,root.left);
		else
			root.right = insert(t,root.right);
		return root;
	}
	
	private void insert(Node t) { //Iterative Insert Method
		Node p = root;
		if (root==null) {
			root = t;
			return;
		}
		while (p!=null) {
			if (t.key<p.key) {
				if (p.left==null) {
					p.left = t;
					return;
				}
				p = p.left;
			}
			else {
				if (p.right==null) {
					p.right = t;
					return;
				}
				p = p.right;
			}
		}
	}
	
	public int height() {
		return hi(root);
	}
	
	private int hi(Node r) {
		int lh, rh;
		if (r==null) return -1;
		lh = hi(r.left);
		rh = hi(r.right);
		if (lh>rh)
			return lh+1;
		else
			return rh+1;
	}
	
	public void print() {
		printTree(root);
	}
	
	public int[] toArray() {
		list = new int[size];
		idx =0;
		addToArray(root);
		return list;
	}
	
	private void addToArray(Node r) {
		if (r==null) return;
		addToArray(r.left);
		list[idx++] = r.key;
		addToArray(r.right);
	}
	
	private void printTree(Node root) {
		if (root==null) return;

		printTree(root.left);
		System.out.println(root.key);
		printTree(root.right);
	}
	
	private class Node {
		int key;
		Node left=null;
		Node right=null;
		
		public Node(int value) {
			key = value;
		}
	}
}

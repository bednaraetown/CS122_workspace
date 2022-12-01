
public class Stack<MyType> {
	MyType[] data;
	int sp = -1;
	
	public Stack(int size) {
		data = (MyType[]) new Object[size];
	}
	
	public void push(MyType value) throws Exception{
		if (sp>=data.length-1) {
			throw(new StackError("Stack Overflow"));
		}
		data[++sp] = value;
	}
	
	public MyType pop() throws StackError {
		if (sp<0) {
			throw(new StackError("Stack Underflow"));
		}
		return data[sp--];
	}
	
	public MyType peek() throws Exception {
		if (sp<0) {
			throw(new StackError());
		}
		return data[sp];
	}
	public boolean empty() {
		return sp==-1;
	}
	
	public boolean full() {
		return sp==data.length-1;
	}
	
	public int size() {
		return sp+1;
	}
}


public class testSpace {

	public static void main(String[] args) {
		int i = 0;
		i++;
		System.out.print(i);
		i = 0;
		
		i = i++; //legal but crazy
		System.out.print(i);

		i = 0;
		i = ++i; //legal, crazy, different result
		System.out.print(i);
		
	}

}

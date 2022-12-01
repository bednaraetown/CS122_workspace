
public class Palindrome {

	public static Stack<Character> letters = new Stack<Character>(50);
	
	public static void main(String[] args) throws Exception {
		String word, drow;
		int i;
		word = "52800825";
		
		for (i=0; i<word.length(); i++)
			letters.push(word.charAt(i));
		drow = "";
		while(!letters.empty())
			drow += letters.pop();
		System.out.println("Word forwards:" + word);
		System.out.println("Word Backwards:" + drow);
		if(word.equals(drow))
			System.out.println("This is a palindrome");
		else
			System.out.println("This is NOT a plaindrome");
	}

}

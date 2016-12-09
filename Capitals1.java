import java.util.*;

public class Capitals1 {
	
	public static WordArray2 arr;
	
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("");
		System.out.print("Possible letters? (no spaces) ");
		String poss = in.next();
		String lett = " ";
		while (!lett.equals("-1")) {
			System.out.print("Desired letters? (-1 to quit) ");
			lett = in.next();
			arr = new WordArray2();
			outOf(poss);	
			withLetters(lett);
		}
	}
	
	public static void outOf(String poss) {
		arr.wordsOutOf(poss);
	}
	
	public static void withLetters(String lett) {
		if (!lett.equals(" ")){
			ArrayList<String> words = arr.wordsWithLetters(lett);
			for (int i = 0; i < words.size(); i++) {
				System.out.println(words.get(i));
			}
			System.out.println("");
		}
		
	}
}
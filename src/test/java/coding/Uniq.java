package coding;

import java.util.HashSet;
import java.util.Set;

public class Uniq {

	public static void main(String[] args) {
		String input = "masum";
		Set<Character> uniq = new HashSet<>();
		for (char c : input.toCharArray())
			if (Character.isLetter(c)) {
				uniq.add(c);
			}
		System.out.println(uniq);
	}
}

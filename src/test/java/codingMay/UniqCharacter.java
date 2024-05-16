package codingMay;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word: ");
		String input = sc.nextLine();
		Set<Character> uniq = new HashSet<>();
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c)) {
				uniq.add(c);
			}
		}
		System.out.println(uniq);
	}
}
